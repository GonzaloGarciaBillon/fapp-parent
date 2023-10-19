package cl.fapp.restapi.controller.dte.notacredito;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import cl.fapp.SIIDocumentFactoryProvider;
import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.common.domain.statuses.EntitySetDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.docs.DocumentoEnvioDTE;
import cl.fapp.domain.mapper.ConvertRequestToEnvioDTEResponse;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.model.Setdte;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.SetDTERepository;
import cl.fapp.restapi.controller.boleta.dto.GenerarSetDTERequest;
import cl.fapp.restapi.controller.dte.notacredito.mapper.set.GenerarDtesSetDTEControllerMapper;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import cl.fapp.sii.jaxb.EnvioDTE;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="${fapp.api.controller.base-path}")
@Tag(name = "GENERAR-NC", description = "API para generacion de documentos de tipo Nota de Credito")
public class GenerarNotaCreditoSetDTEController {

	@Autowired
	SetDTERepository repoSetdte;

	@Autowired
	DteRepository repoDte;

	@Autowired
	EmisoresRepository repoEmisores;

	@Autowired
	KeystoreFirmanteUtils ksfirmanteUtils;

	@Autowired
	GenerarDtesSetDTEControllerMapper mapperToDTESetDTE;

	/**
	 * Genera un set de DTE jaxb a partir de los datos de dte almacenados en la base de datos
	 * 
	 * @param payload request para generar el set
	 * @return objeto {@link JSend} simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/generarncsetdte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> generarDtesSetDTE(@RequestBody GenerarSetDTERequest payload) {
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
			}

			// obtiene los documentos jaxb a partir del request a la api
			List<Integer> tiposDocumentoEnSet = new ArrayList<Integer>();
			tiposDocumentoEnSet.add(ConstantesTipoDocumento.NOTA_CREDITO.getValue());
			
			ConvertRequestToEnvioDTEResponse response = mapperToDTESetDTE.toEnvioDTESetDTE(emisor.get(), rutfirmante, payload, tiposDocumentoEnSet);
			if (response == null) {
				log.error("No fue posible realizar el mapping entre request-api y EnvioDTE.SetDTE");
				throw new Exception("No fue posible mapear datos de entrada");
			}

			// la lista de dte incluidos en el set esta vacia
			if (response.getDteList().size() <= 0) {
				log.error("No hay dte's para crear el set");
				throw new Exception("No hay dte's para crear el set");
			}

			// recupera el objeto jaxb resultante del mapeo
			EnvioDTE.SetDTE documento = response.getJaxbsetdte();
			if (documento == null) {
				log.error("No fue posible generar documento EnvioDTE.SetDTE.");
				return ResponseEntity.badRequest().body(JSend.error("No fue posible generar documentos."));
			}

			// guarda los documentos jaxb en la base de datos
			Setdte newsetdte = generateEntityFromJaxbEnvioDTESetDTE(response.getXmldtes(), documento, rutemisor, rutfirmante, response.getDteList());

			log.debug("Se crea el setdte en la base de datos con id=" + newsetdte.getIdSetdte());
			log.debug("Request procesado correctamente");

			return ResponseEntity.ok().body(JSend.success("NotaCredito-setDTE generado con id=" + newsetdte.getIdSetdte()));

		} catch (Exception ex) {
			log.error("Ocurrio un error mientras se generaba el EnvioDTE.SetDTE. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Crea la instancia en la base de datos y obtiene el xml del set
	 * 
	 * @param xmldtes  el string xml de todos los DTE
	 * @param documento   documento {@link EnvioDTE.SetDTE}
	 * @param rutemisor   rut del emisor
	 * @param rutfirmante rut del firmante
	 * @return
	 */
	@Transactional
	private Setdte generateEntityFromJaxbEnvioDTESetDTE(String xmldtes, EnvioDTE.SetDTE documento, String rutemisor, String rutfirmante, List<Long> dteList) {
		try {
			if (rutemisor == null) {
				// no se indica el rut del emisor => no es posible construir un dte
				throw new Exception("No se indica rut del emisor");
			}

			// nuevo estado del dte, dependiendo si se encuentra con datos para firmar
			Date ahora = new Date();

			// nueva instancia jaxb
			EnvioDTE envDTE = new EnvioDTE();
			envDTE.setSetDTE(documento); // <--aqui se traspasa la lista de dtes
			envDTE.setVersion(BigDecimal.valueOf(1.0));

			// repository
			Setdte newSetDte = new Setdte();
			newSetDte.setCreatedat(ahora);
			newSetDte.setUpdatedat(ahora);
			newSetDte.setIdDocumento(envDTE.getSetDTE().getID());

			// obtiene el string xml del objeto
			SIIDocumentFactoryProvider provider = new SIIDocumentFactoryProvider();
			DocumentoEnvioDTE docxml = (DocumentoEnvioDTE) provider.getInstance("ENVIODTE");
			if (docxml == null) {
				log.error("No fue posible crear instancia de DocumentoEnvioDTE");
				throw new Exception("No es posible crear instancia de DocumentoEnvioDTE");
			}

			// se pasa a xml todo el set
			String xmlcontent = docxml.toXml(envDTE, "http://www.sii.cl/SiiDte EnvioDTE_v10.xsd");
			log.debug("xmlcontent (inicial)=" + xmlcontent);
			
			String encabezadoReemplazarPor = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "<EnvioDTE version=\"1.0\" xmlns=\"http://www.sii.cl/SiiDte\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.sii.cl/SiiDte EnvioDTE_v10.xsd\">" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN;
			xmlcontent = xmlcontent.replaceFirst(".*?" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN, encabezadoReemplazarPor);
			
			String startString = "<\\/Caratula>";
			String endString = "<\\/SetDTE>";

			xmlcontent = xmlcontent.replaceAll(startString + "[\\s\\S]*" + endString, startString + xmldtes + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + endString);
			log.debug("xmlcontent (sin saltos de linea extra)=" + xmlcontent);

			Document xmlcontent2 = docxml.marshallToW3CDocument(envDTE);

			log.debug("xmlcontent2=" + xmlcontent2.toString());

			// si es posible, lo firma
			KeyinfoFindResponse kinfo;
			if (rutfirmante == null) {
				// no se indica rutfirmante => se puede generar DTE, pero no firmar
				log.info("No se indica rut firmante, solo se creara el documento del DTE");
				newSetDte.setEstado(EntitySetDTEStatuses.FIRMAPENDIENTE.toString());
				newSetDte.setDocumentoXml(xmlcontent);
				kinfo = null;
			} else {
				// si se indica rutfirmante => obtiene datos con los cuales firmar
				log.debug("Se indica relacion Emisor/Firmante, se recuperan datos para firmar");
				kinfo = ksfirmanteUtils.getKeystoreInfo(rutemisor, rutfirmante);
				if (kinfo == null) {
					log.error("Se indica firmante, pero no es posible acceder a los datos del keystore.");
					throw new Exception("No se encuentran datos del keystore");

				} else {

					log.info("Se firma SetDTE");
					newSetDte.setEstado(EntitySetDTEStatuses.ENVIOPENDIENTE.toString());
					String ID = envDTE.getSetDTE().getID();
					String setdteURI = "#" + ID;

					String xmlsetdteSigned = docxml.sign(new ByteArrayInputStream(xmlcontent.getBytes("ISO-8859-1")), "EnvioDTE", "SetDTE", documento.getID(), kinfo.getCertificate(), kinfo.getPrivatekey());
					if (xmlsetdteSigned == null) {
						log.error("Ocurrio un error firmando URI=" + setdteURI);
						throw new Exception("No fue posible generar DTE ID=" + ID);
					}
					
					xmlsetdteSigned = xmlsetdteSigned.replace("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>", "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN);
					
					log.debug("XML DTE ID=" + ID + ", firmada y almacenada. XML-resultante=\n" + xmlsetdteSigned);

					newSetDte.setDocumentoXml(xmlsetdteSigned);
				}
			}

			// escribe la nueva instancia en la base de datos
			Setdte newrecord = repoSetdte.save(newSetDte);

			// actualiza lista de dtes que forman parte de este set
			repoDte.updateByIds(newrecord.getIdSetdte(), dteList, EntityDTEStatuses.SETDTEASIGNADO.toString());

			// recupera y muestra el id
			log.info("SetDte creado con id=" + newrecord.getIdSetdte());

			// retorna el registro recien insertado
			return newrecord;

		} catch (Exception ex) {
			log.error("No fue posible crear el registro en SetDTE. Error=" + ex.getMessage());
			return null;
		}
	}
}
