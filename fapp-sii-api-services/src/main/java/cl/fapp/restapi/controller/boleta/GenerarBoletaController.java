package cl.fapp.restapi.controller.boleta;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.SIIDocumentFactoryProvider;
import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.BuilderXmlID;
import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.docs.DocumentoBOLETADefType;
import cl.fapp.repository.model.Dte;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.restapi.controller.boleta.domain.BoletaDocumento;
import cl.fapp.restapi.controller.boleta.domain.BoletaEmisor;
import cl.fapp.restapi.controller.boleta.dto.BOLETADefTypeAndVerbatimCAF;
import cl.fapp.restapi.controller.boleta.dto.GenerarBoletaRequest;
import cl.fapp.restapi.controller.boleta.dto.GenerarBoletaResponse;
import cl.fapp.restapi.controller.boleta.mapper.GenerarBoletaControllerMapper;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import cl.fapp.sii.jaxb.BOLETADefType;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="${fapp.api.controller.base-path}")
@Tag(name = "GENERAR", description = "API para generacion de documentos")
public class GenerarBoletaController {

	@Autowired
	DteRepository repoDte;

	@Autowired
	EmisoresRepository repoEmisores;

	@Autowired
	KeystoreFirmanteUtils ksfirmanteUtils;

	@Autowired
	GenerarBoletaControllerMapper mapperToBOLETADefType;

	/**
	 * Genera boletas jaxb a partir del request a la api, y las escribe en la base de datos.
	 * 
	 * @param payload request para generar boletas. Utiliza objetos de tipo {@link BOLETADefType}
	 * @return objeto {@link JSend} simple de tipo {@link GenerarBoletaResponse}
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/generarboleta", produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(value = "generate.boleta.time", description = "Tiempo que toma en responder a un request para generar una boleta")
	public ResponseEntity<JSend> generarBoleta(@Valid @RequestBody GenerarBoletaRequest payload) {
		try {
			// completo la parte emisor del mensaje
			String rutemisor = payload.getRutEmisor();
			String rutfirmante = payload.getRutFirmante() == null ? rutemisor : payload.getRutFirmante();

			Optional<Emisores> emisor = repoEmisores.findById(rutemisor);
			if (!emisor.isPresent()) {
				log.error("El Emisor rut=" + rutemisor + " no existe en la base de datos");
				throw new Exception("El Emisor no existe");

			} else {
				log.debug("El emisor rut=" + rutemisor + " existe");
				Emisores record = emisor.get();
				BoletaEmisor emisorBoleta = new BoletaEmisor();
				emisorBoleta.setCiudadEmisor(record.getCiudad());
				emisorBoleta.setComunaEmisor(record.getComuna());

				emisorBoleta.setCorreoEmisor(record.getEmail());
				emisorBoleta.setCodigoSucursalEmisor(record.getCodigoSucursal());
				emisorBoleta.setTelefonoEmisor(record.getTelefono());
				emisorBoleta.setCodigoResolucion(record.getCodigoResolucion());
				emisorBoleta.setFechaResolucion(record.getFechaResolucion());
				emisorBoleta.setCodigoSii(record.getCodigoSii());
				emisorBoleta.setCorreoEmisor(record.getEmail());

				emisorBoleta.setDireccionEmisor(record.getDireccion());
				emisorBoleta.setGiroEmisor(record.getGiro());
				emisorBoleta.setRazonSocialEmisor(record.getRazonSocial());
				emisorBoleta.setRutEmisor(record.getRutemisor());
				//-->emisorBoleta.setLogo(record.getLogoboleta());

				payload.setEmisor(emisorBoleta);
			}
			
			// verifica que todos los tipos de documentos esten soportados
			// @formatter:off
 			int idx = 0;
			List<String> errores = new ArrayList<String>();
			for(BoletaDocumento item:payload.getDtes()) {
				Integer tipodoc = item.getTipodocumento().getValue();
				if( tipodoc != ConstantesTipoDocumento.BOLETA_AFECTA.getValue() 
				 && tipodoc != ConstantesTipoDocumento.BOLETA_EXENTA.getValue() ) {
					errores.add("Tipo documento=" + tipodoc + ", no soportado en este endpoint. IdDocumento=" + item.getCodigointerno() + ", idx=" + idx);
				}
				idx++;
			}
			// @formatter:on
			
			if( errores.size()>0 ) {
				log.error("No fue posible generar documentos. Errores=" + errores);
				return ResponseEntity.badRequest().body(JSend.error("Errores en atributos de documentos.", errores));
			}

			// obtiene los documentos jaxb a partir del request a la api
			List<BOLETADefTypeAndVerbatimCAF> documentos = mapperToBOLETADefType.toBOLETADefTypeDocumento(payload);
			if (documentos == null) {
				log.error("No fue posible generar documentos.");
				return ResponseEntity.badRequest().body(JSend.error("No fue posible generar documentos."));
			}

			// patron de busqueda que se aplica en el string xml para obtener el ted
	        Pattern tedPattern = Pattern.compile("<TED version=\"1.0\">(.*?)<\\/TED>", Pattern.DOTALL);
			
			// guarda los documentos jaxb en la base de datos
			List<GenerarBoletaResponse> response = new ArrayList<GenerarBoletaResponse>();
			for (BOLETADefTypeAndVerbatimCAF jaxbBOLETADefType : documentos) {
				Dte newdte = signAndStoreJaxbBOLETADefType(emisor.get(), jaxbBOLETADefType, rutemisor, rutfirmante);
				BOLETADefType datosBoleta = jaxbBOLETADefType.getBoleta();
				BigInteger montoBoleta = datosBoleta.getDocumento().getEncabezado().getTotales().getMntTotal();
				BigInteger tipoDte = datosBoleta.getDocumento().getEncabezado().getIdDoc().getTipoDTE();
				
				log.debug("Se crea el dte en la base de datos con id=" + newdte.getIdDte());
				
				GenerarBoletaResponse item = new GenerarBoletaResponse();
				item.setUuid(newdte.getDteUuid());
				item.setFolio(newdte.getFolioAsignado());
				item.setMontoTotal(montoBoleta);
				item.setTipoDocumento(tipoDte);
		        
		        // busca coincidencias del tag <TED></TED>
				Matcher matcher = tedPattern.matcher(newdte.getDocumentoXml());
				if (matcher.find()) {
					log.debug("¡¡ Match <TED> !!");
					// log.debug( "!! Match TED = [" + matcher.group() + "]" );
					item.setTed(Base64.getEncoder().encodeToString(matcher.group().getBytes()));
				}

		        // agrega el documento a la respuesta
		        response.add(item);
			}
			log.debug("Request procesado correctamente. DocumentosGenerados=" + documentos.size() + ", dte en respuesta=" + response.size());
			
			return ResponseEntity.ok().body(JSend.success(response));

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(JSend.error(e.getMessage()));
		}
	}

	/**
	 * Crea una instancia de la entidad {@link Dte}<br>
	 * Almacena el dte con datos de tipo {@link BOLETADefType}, lo firma y guarda en el repositorio
	 * 
	 * @param emisor datos del emisor
	 * @param jaxbDTEAndVerbatimCAF objeto con los datos de la boleta y el caf <b>tal como</b> lo entrego el sii
	 * @param rutemisor rut del emisor
	 * @param rutfirmante rut del firmante
	 * @return una instancia de la entidad {@link Dte}
	 */
	private Dte signAndStoreJaxbBOLETADefType(Emisores emisor, BOLETADefTypeAndVerbatimCAF jaxbDTEAndVerbatimCAF, String rutemisor, String rutfirmante) {
		try {
			if (rutemisor == null) {
				// no se indica el rut del emisor => no es posible construir una boleta
				throw new Exception("No se indica rut del emisor");
			}

			// recupera el dte sobre el que se trabajara
			BOLETADefType jaxbDTE = jaxbDTEAndVerbatimCAF.getBoleta();

			// nuevo estado del dte, dependiendo si se encuentra con datos para firmar
			Date ahora = new Date();

			// nueva instancia
			Dte newdte = new Dte();
			newdte.setCreatedat(ahora);
			newdte.setUpdatedat(ahora);
			newdte.setEmisore(emisor);
			newdte.setRutfirmante(rutfirmante);
			newdte.setIdDocumento(jaxbDTE.getDocumento().getID());
			newdte.setMonto(jaxbDTE.getDocumento().getEncabezado().getTotales().getMntTotal());
			newdte.setDteUuid(BuilderXmlID.genDTEUUIDv4());

			// obtiene el folio
			newdte.setFolioAsignado(jaxbDTE.getDocumento().getEncabezado().getIdDoc().getFolio().longValue());

			// establece el tipo de documento
			newdte.setTipoDocumento(jaxbDTE.getDocumento().getEncabezado().getIdDoc().getTipoDTE().intValue());

			// obtiene el string xml del objeto
			SIIDocumentFactoryProvider provider = new SIIDocumentFactoryProvider();
			DocumentoBOLETADefType docxml = (DocumentoBOLETADefType) provider.getInstance("BOLETADEFTYPE");
			if (docxml == null) {
				log.error("No fue posible crear instancia de DocumentoBOLETADefType");
				throw new Exception("No es posible crear instancia de DocumentoBOLETADefType");
			}

			// hace el marshall
			String xmlcontent = docxml.toXml(jaxbDTE, null);

			// TODO: quita declaracion xmldsig que esta demas en BOLETADefType
			xmlcontent = xmlcontent.replace(" xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\"", "");

			// TODO: reemplaza cada ocurrencia del caf, por el texto 'como es' entregado por el sii
			// se reemplaza el caf en el xml, con la copia verbatim del caf almacenado en la base
			String emptyTagCAF = "<CAF/>";
			String replaceByCAF = jaxbDTEAndVerbatimCAF.getVerbatimcaf();
			xmlcontent = xmlcontent.replace(emptyTagCAF, replaceByCAF);
			log.debug("xmlcontent despues de agregar CAF a la boleta...");
			//-->log.debug("xmlcontent despues de agregar CAF a la boleta=" + xmlcontent);

			// si es posible, lo firma. En caso contrario lo guarda no firmado
			KeyinfoFindResponse kinfo;
			if (rutfirmante == null) {
				// no se indica rutfirmante => se puede generar la boleta, pero no firmar
				log.info("No se indica rut firmante, solo se creara el documento de la boleta");
				newdte.setEstado(EntityDTEStatuses.CREADONOFIRMADO.toString());
				newdte.setDocumentoXml(xmlcontent);
				kinfo = null;
			} else {
				// si se indica rutfirmante => obtiene datos con los cuales firmar
				log.debug("Se indica relacion Emisor/Firmante, se recuperan datos para firmar");
				kinfo = ksfirmanteUtils.getKeystoreInfo(rutemisor, rutfirmante);
				if (kinfo == null) {
					log.error("Se indica firmante, pero no es posible acceder a los datos del keystore.");
					throw new Exception("No se encuentran datos del keystore");

				} else {
					log.info("Se firma el documento. Se almacena xml firmado");
					newdte.setEstado(EntityDTEStatuses.CREADOFIRMADO.toString());

					// firma la boleta
					String xmlboletaSigned = docxml.sign(new ByteArrayInputStream(xmlcontent.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING)), "BOLETADefType", "Documento", jaxbDTE.getDocumento().getID(), kinfo.getCertificate(), kinfo.getPrivatekey());

					// se establece en la instancia de la entidad
					newdte.setDocumentoXml(xmlboletaSigned);
					
					// establecer campo signature_value para usarlo en servicio de consulta avanzada de dte
					// patron de busqueda que se aplica en el string xml para obtener el ted
			        Pattern tedPattern = Pattern.compile("<SignatureValue>(.*?)<\\/SignatureValue>" , Pattern.DOTALL);
			        
			        // busca coincidencias del tag <SignatureValue></SignatureValue>
					Matcher matcher = tedPattern.matcher(newdte.getDocumentoXml());
					if (matcher.find()) {
						log.debug("¡¡ Match <SignatureValue> !!");
						// log.debug( "!! Match <SignatureValue> = [" + matcher.group() + "]" );
						newdte.setSignatureValue(matcher.group());
					}else {
						log.warn("¡¡NO hay match <SignatureValue> !!");
						newdte.setSignatureValue(null);
					}
				}
			}

			// escribe la nueva instancia en la base de datos
			Dte newrecord = repoDte.save(newdte);

			// recupera y muestra el id
			log.info("Dte creado con id=" + newrecord.getIdDte());

			// retorna el registro recien insertado
			return newrecord;

		} catch (Exception ex) {
			log.error("No fue posible crear el registro en DTE. Error=" + ex.getMessage());
			return null;
		}
	}
}
