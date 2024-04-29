package cl.fapp.restapi.controller.caf;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.domain.statuses.EntityCAFStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.common.xml.XMLUtils;
import cl.fapp.repository.model.Caf;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.CAFRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.restapi.controller.caf.dto.UploadCAFRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="${fapp.api.controller.base-path}")
@Tag(name="CAF", description="API para operaciones relacionadas al CAF")
public class UploadCAFController {
	static final String tag_AUTORIZACION = "//AUTORIZACION";
	static final String tag_CAF = "//AUTORIZACION/CAF";
	static final String tag_RSASK = "//AUTORIZACION/RSASK";
	static final String tag_TD = "//AUTORIZACION/CAF/DA/TD/text()";
	static final String tag_RE = "//AUTORIZACION/CAF/DA/RE/text()";
	static final String tag_RNG_D = "//AUTORIZACION/CAF/DA/RNG/D/text()";
	static final String tag_RNG_H = "//AUTORIZACION/CAF/DA/RNG/H/text()";

	@Autowired
	CAFRepository repository;
	
	@Autowired
	EmisoresRepository emisoresRepo;

	/**
	 * Carga datos del CAF para un Emisor y Tipo de documento especifico
	 * @param payload request al servicio
	 * @param file archivo con el contenido del CAF (tal como es entregado por el SII)
	 * @return estructura JSend simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/uploadcaf", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> uploadCAF(@Validated @ModelAttribute @RequestBody UploadCAFRequest payload, @RequestParam MultipartFile file) {
		payload.setFechaUpload(new Date());
		try {
			Document cafdocument = XMLUtils.readXml(file.getInputStream());

			// verifica que el rut emisor informado en el caf, coincida con el rut informado en el request
			String RE = XMLUtils.getText(cafdocument, tag_RE);
			if( !RE.equalsIgnoreCase(payload.getRutEmisor()) ) {
				log.error("El rut informado en el request=" + payload.getRutEmisor() + ", no coincide con el rut informado en el CAF=" + RE);
				throw new Exception("El rut informado no coincide");
			}

			// verifica que el tipo de documento informado en el CAF sea BOLETA_AFECTA, o NOTA_CREDITO
			Integer TD = Integer.parseInt(XMLUtils.getText(cafdocument, tag_TD));
			if( TD != ConstantesTipoDocumento.FACTURA_AFECTA.getValue() && TD != ConstantesTipoDocumento.FACTURA_EXENTA.getValue() && TD != ConstantesTipoDocumento.BOLETA_AFECTA.getValue() && TD != ConstantesTipoDocumento.BOLETA_EXENTA.getValue() && TD!= ConstantesTipoDocumento.NOTA_CREDITO.getValue() && TD!= ConstantesTipoDocumento.NOTA_DEBITO.getValue()) {
				log.error("El tipo de documento informado en el CAF=" + TD + " es diferente a los aceptados en esta version=" + ", " + ConstantesTipoDocumento.FACTURA_AFECTA.getValue()+ ", " + ConstantesTipoDocumento.FACTURA_EXENTA.getValue()+ ", " +ConstantesTipoDocumento.BOLETA_AFECTA.getValue() + ", " +ConstantesTipoDocumento.BOLETA_EXENTA.getValue() + ", " + ConstantesTipoDocumento.NOTA_CREDITO.getValue()+ ", " + ConstantesTipoDocumento.NOTA_DEBITO.getValue());
				throw new Exception("El tipo de documento no esta soportado");
			}
			
			// verifica que el rango de folios indicado en el CAF sean enteros. Si la conversion no es posible, gatillara una excepcion
			Long DESDE = Long.parseLong(XMLUtils.getText(cafdocument, tag_RNG_D));
			Long HASTA = Long.parseLong(XMLUtils.getText(cafdocument, tag_RNG_H));
			if( DESDE == null || HASTA == null || (DESDE > HASTA) ) {
				log.error("El rango de folios no es valido. DESDE=" + DESDE + ", HASTA=" + HASTA);
				throw new Exception("El rango de folios no es valido");
			}
			
			// calcula el numero de folios disponibles
			Long foliosDisponibles = HASTA - DESDE + 1;
			
			// verifica que el emisor informado en el CAF existe en la base de datos
			Optional<Emisores> emisor = emisoresRepo.findById(RE);
			if( !emisor.isPresent() ) {
				log.error("El emisor rut=" + RE + " no existe en la base de datos");
				throw new Exception("El emisor no existe");
			}else {
				log.debug("El emisor rut=" + RE + " existe");
			}

			// recupera porciones xml del CAF que se almacenan en la base de datos
			StringWriter autorizacionContent = new StringWriter();
			XMLUtils.processFilteredXml(cafdocument, tag_AUTORIZACION, (node) -> {
				XMLUtils.getContent(node, autorizacionContent);
	        });
			autorizacionContent.close();

			StringWriter cafContent = new StringWriter();
			XMLUtils.processFilteredXml(cafdocument, tag_CAF, (node) -> {
				XMLUtils.getContent(node, cafContent);
	        });
			cafContent.close();
			
			StringWriter rsaskContent = new StringWriter();
			XMLUtils.processFilteredXml(cafdocument, tag_RSASK, (node) -> {
	            XMLUtils.getContent(node, rsaskContent);
	        });
			rsaskContent.close();
			
			// crea una instancia de la entidad Caf
			Caf newcaf = new Caf();
			Date ahora = new Date();
			newcaf.setCreatedat(ahora);
			newcaf.setUpdatedat(ahora);
			newcaf.setEmisore(emisor.get());
			newcaf.setDisponibles(foliosDisponibles.intValue());
			newcaf.setEstado(EntityCAFStatuses.DISPONIBLE.toString());
			newcaf.setFolioMax(HASTA);
			newcaf.setFolioMin(DESDE);
			newcaf.setTagAutorizacion(autorizacionContent.toString());
			newcaf.setTagCaf(cafContent.toString());
			newcaf.setTagRsask(rsaskContent.toString());
			newcaf.setTipoDocumento(TD);
			
			// almacena el CAF en la base de datos
			Caf savedcaf = repository.save(newcaf);

			// TODO: ELIMINAR ESTA SENTENCIA
			payload.setCafContent(new String(file.getBytes(), StandardCharsets.ISO_8859_1));
			
			// TODO: NO ES POSIBLE VALIDAR EL CAF PORQUE NO REFERENCIA NINGUN ESQUEMA
			// TODO: SOLO ES POSIBLE PARSEARLO
			// DocumentoCAFBoleta instance = (DocumentoCAFBoleta) new SIIDocumentFactoryProvider().getInstance("CAFBOLETA");
			// String validateResult = instance.validateXml(payload.getCafContent());
			// 
			// if( validateResult.equalsIgnoreCase("success") ) {
			// 	log.info("El xml del caf es valido");
			// }else {
			// 	log.error("El xml del caf no es valido");
			// }
			
			log.debug("CAF almacenado con id=" + savedcaf.getIdCaf());
			return ResponseEntity.ok().body(JSend.success(payload));

		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(e.getMessage()));
		}
	}

}
