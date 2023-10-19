package cl.fapp.restapi.controller.boleta;

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

import cl.fapp.SIIDocumentFactoryProvider;
import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.domain.EntitySetDteTipoSet;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.common.domain.statuses.EntitySetDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.docs.DocumentoEnvioBOLETA;
import cl.fapp.domain.mapper.ConvertRequestToEnvioBOLETAResponse;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.model.Setdte;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.SetDTERepository;
import cl.fapp.restapi.controller.boleta.dto.GenerarSetDTERequest;
import cl.fapp.restapi.controller.boleta.dto.GenerarSetDTEResponse;
import cl.fapp.restapi.controller.boleta.mapper.set.GenerarBoletasSetDTEControllerMapper;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import cl.fapp.sii.jaxb.EnvioBOLETA;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "GENERAR", description = "API para generacion de documentos")
public class GenerarBoletasSetDTEController {
	@Autowired
	SetDTERepository repoSetdte;

	@Autowired
	DteRepository repoDte;

	@Autowired
	EmisoresRepository repoEmisores;

	@Autowired
	KeystoreFirmanteUtils ksfirmanteUtils;

	@Autowired
	GenerarBoletasSetDTEControllerMapper mapperToBOLETASetDTE;

	/**
	 * Capa REST para la generacion de un set de boletas jaxb a partir de los datos de boleta almacenados en la base de datos.
	 * Utiliza datos del emisor y firmante indicados en el payload.
	 * 
	 * @param payload request para generar el set
	 * @return objeto {@link JSend} simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/generarboletassetdte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> generarBoletasSetDTE(@RequestBody GenerarSetDTERequest payload) {
		
		try {
			GenerarSetDTEResponse resp = internalGenerarBoletasSetDte(payload);
			if (resp.getIdSetBoletas() != null) {
				log.debug("[Invocacion rest endpoint]-Se ha generado el set de boletas correctamente. IdSetDte=" + resp.getIdSetBoletas());
				return ResponseEntity.ok().body(JSend.success("Id setDTE generado con id=" + resp.getIdSetBoletas()));

			} else {
				log.debug("[Invocacion rest endpoint]-No se ha generado el set de boletas. Message=" + resp.getErrorMessage());
				return ResponseEntity.ok().body(JSend.error("Ocurrio un error durante el proceso de generacion." + resp.getErrorMessage()));
			}
			/*
						
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
						tiposDocumentoEnSet.add(ConstantesTipoDocumento.BOLETA_AFECTA.getValue());
						tiposDocumentoEnSet.add(ConstantesTipoDocumento.BOLETA_EXENTA.getValue());
						
						// numero maximo de dte a incluir en el set en null, para que las incluya todas
						ConvertRequestToEnvioBOLETAResponse response = mapperToBOLETASetDTE.toEnvioBOLETASetDTE(emisor.get(), rutfirmante, payload, tiposDocumentoEnSet);
						if (response == null) {
							log.error("No fue posible realizar el mapping entre request-api y EnvioBOLETA.SetDTE");
							throw new Exception("No fue posible mapear datos de entrada");
						}
			/*
						// la lista de dte incluidos en el set esta vacia
						if (response.getDteList().size() <= 0) {
							log.error("No hay boletas para crear el set");
							throw new Exception("No hay boletas para crear el set");
						}
			
						// recupera el objeto jaxb resultante del mapeo
						EnvioBOLETA.SetDTE documento = response.getJaxbsetdte();
						if (documento == null) {
							log.error("No fue posible generar documento setDTE.");
							return ResponseEntity.badRequest().body(JSend.error("No fue posible generar documentos."));
						}
			
						// firma y guarda el set de documentos en la base de datos
						Setdte newsetdte = generateEntityFromJaxbEnvioBOLETASetDTE(response.getXmlboletas(), documento, rutemisor, rutfirmante, response.getDteList());
			
						log.debug("Se crea el setdte en la base de datos con id=" + newsetdte.getIdSetdte());
						log.debug("Request procesado correctamente");
			
						return ResponseEntity.ok().body(JSend.success("Id setDTE generado con id=" + newsetdte.getIdSetdte()));
			* /
			*/
			//-->			return ResponseEntity.ok().body(JSend.success("Id setDTE generado con id=XXXXX"));
		} catch (Exception ex) {
			log.error("Ocurrio un error mientras se generaba el setDTE. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Genera y firma el documento setBoletas
	 * 
	 * @param payload datos de emisor y firmante a utilizar
	 * @return datos del nuevo setBoletas creado
	 */
	public GenerarSetDTEResponse internalGenerarBoletasSetDte(GenerarSetDTERequest payload) {

		try {
			// completo la parte emisor del mensaje. Si no se indica firmante, se intenta con el rut del emisor
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
			tiposDocumentoEnSet.add(ConstantesTipoDocumento.BOLETA_AFECTA.getValue());
			tiposDocumentoEnSet.add(ConstantesTipoDocumento.BOLETA_EXENTA.getValue());

			// numero maximo de dte a incluir en el set en null, para que las incluya todas
			ConvertRequestToEnvioBOLETAResponse mapperResponse = mapperToBOLETASetDTE.toEnvioBOLETASetDTE(emisor.get(), rutfirmante, payload, tiposDocumentoEnSet);
			if (mapperResponse == null) {
				log.error("No fue posible realizar el mapping entre request-api y EnvioBOLETA.SetDTE");
				throw new Exception("No fue posible mapear datos de entrada");
			}

			// la lista de dte incluidos en el set esta vacia
			if (mapperResponse.getDteList().size() <= 0) {
				log.error("No hay boletas para crear el set");
				throw new Exception("No hay boletas para crear el set");
			}

			// recupera el objeto jaxb resultante del mapeo
			EnvioBOLETA.SetDTE documento = mapperResponse.getJaxbsetdte();
			if (documento == null) {
				log.error("No fue posible obtener documento SetDTE");
				throw new Exception("No fue posible obtener documento SetDTE");
			}

			// firma y guarda el set de documentos en la base de datos
			Setdte newsetdte = generateEntityFromJaxbEnvioBOLETASetDTE(mapperResponse.getXmlboletas(), documento, rutemisor, rutfirmante, mapperResponse.getDteList());
			log.debug("Se crea el setdte en la base de datos con id=" + newsetdte.getIdSetdte());
			log.debug("Request procesado correctamente");

			// establece el identificador del set recien creado
			GenerarSetDTEResponse response = new GenerarSetDTEResponse();
			response.setRutEmisor(rutemisor);
			response.setIdSetBoletas(newsetdte.getIdSetdte());
			response.setNroBoletas(mapperResponse.getDteList().size());

			// responde al caller
			return response;

		} catch (Exception ex) {
			log.error("Se produjo un error creando el set de boletas. Error=" + ex.getMessage());
			GenerarSetDTEResponse response = new GenerarSetDTEResponse();
			response.setErrorMessage("Se produjo un error creando el set de boletas. Error=" + ex.getMessage());
			response.setIdSetBoletas(null);
			
			// responde al caller
			return response;
		}
	}

	/**
	 * Crea la instancia en la base de datos y obtiene el xml del set
	 * 
	 * @param xmlboletas  el string xml de todas las boletas
	 * @param documento   documento {@link EnvioBOLETA.SetDTE}
	 * @param rutemisor   rut del emisor
	 * @param rutfirmante rut del firmante
	 * @return
	 */
	@Transactional
	private Setdte generateEntityFromJaxbEnvioBOLETASetDTE(String xmlboletas, EnvioBOLETA.SetDTE documento, String rutemisor, String rutfirmante, List<Long> dteList) {
		try {
			if (rutemisor == null) {
				// no se indica el rut del emisor => no es posible construir una boleta
				throw new Exception("No se indica rut del emisor");
			}

			// nuevo estado del dte, dependiendo si se encuentra con datos para firmar
			Date ahora = new Date();

			// nueva instancia jaxb
			EnvioBOLETA envBoleta = new EnvioBOLETA();
			envBoleta.setSetDTE(documento); // <-- aqui se traspasa la lista de boletas
			envBoleta.setVersion(BigDecimal.valueOf(1.0));

			// repository
			Setdte newSetDte = new Setdte();
			newSetDte.setCreatedat(ahora);
			newSetDte.setUpdatedat(ahora);
			newSetDte.setIdDocumento(envBoleta.getSetDTE().getID());
			newSetDte.setNroDtes(dteList.size());
			newSetDte.setRutemisor(rutemisor);
			newSetDte.setRutfirmante(rutfirmante);
			newSetDte.setTipoSet(EntitySetDteTipoSet.BOLETA.getValue()); // tipo de set=BOLETA (incluye afecta/exenta)
			newSetDte.setIntentosEnvio(0);

			// obtiene el string xml del objeto
			SIIDocumentFactoryProvider provider = new SIIDocumentFactoryProvider();
			DocumentoEnvioBOLETA docxml = (DocumentoEnvioBOLETA) provider.getInstance("ENVIOBOLETA");
			if (docxml == null) {
				log.error("No fue posible crear instancia de DocumentoEnvioBOLETA");
				throw new Exception("No es posible crear instancia de DocumentoEnvioBOLETA");
			}

			// se pasa a xml todo el set
			String xmlcontent = docxml.toXml(envBoleta, "http://www.sii.cl/SiiDte EnvioBOLETA_v11.xsd");
			//log.debug("xmlcontent (inicial)=" + xmlcontent);

			String encabezadoReemplazarPor = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "<EnvioBOLETA version=\"1.0\" xmlns=\"http://www.sii.cl/SiiDte\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.sii.cl/SiiDte EnvioBOLETA_v11.xsd\">" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN;
			xmlcontent = xmlcontent.replaceFirst(".*?" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN, encabezadoReemplazarPor);

			String startString = "<\\/Caratula>";
			String endString = "<\\/SetDTE>";

			xmlcontent = xmlcontent.replaceAll(startString + "[\\s\\S]*" + endString, startString + xmlboletas + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + endString);
			//log.debug("xmlcontent (sin saltos de linea extra)=" + xmlcontent);

			//-->Document xmlcontent2 = docxml.marshallToW3CDocument(envBoleta);
			//-->log.debug("xmlcontent2=" + xmlcontent2.toString());

			// TODO: parche para regularizar las firmas de los documentos (cuando se lee desde el jaxb)
			// xmlcontent = xmlcontent.replace("<ns2:Signature>", "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">").replace("ns2:", "");

			// si es posible, lo firma
			KeyinfoFindResponse kinfo;
			if (rutfirmante == null) {
				// no se indica rutfirmante => se puede generar la boleta, pero no firmar
				log.info("No se indica rut firmante, solo se creara el documento de la boleta");
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
					/*
					// La siguiente, es otra forma de crear el documento setdte, pero no fue comprendida por los servicios del SII.
					// recorre la lista de boletas del set y firma cada una
					NodeList nodelistDTE = xmlcontent2.getElementsByTagName("DTE");
					log.debug("Numero de elementos: " + String.valueOf(nodelistDTE.getLength()));
					
					XPath xPath = XPathFactory.newInstance().newXPath();
					
					for(int i=0; i<nodelistDTE.getLength();i++) {
						Node currentDTE = nodelistDTE.item(i);
					    String ID = (String)xPath.evaluate("//Documento/@ID", currentDTE, XPathConstants.STRING);
						String documentUri = "#" + ID;
					    log.debug("Generando datos para firmar URI=" + documentUri);
						String xmlboletaSigned = XmlEmbeddedSigner.signBoletaEmbeded(currentDTE, documentUri, kinfo.getPrivatekey(), kinfo.getCertificate());
						if( xmlboletaSigned == null ) {
							log.error("Ocurrio un error firmando URI=" + documentUri);
							throw new Exception("No fue posible generar boleta ID=" + ID);
						}
						log.debug("[SIGNED]-XML Boleta ID=" + ID + "=" + xmlboletaSigned);
					}
					*/

					// @formatter:off
					log.info("Se firma SetDTE...");
					String ID = envBoleta.getSetDTE().getID();
					String setdteURI = "#" + ID;
					
					// FIRMA el xml del set
					//-->String xmlsetdteSigned = XmlEmbeddedSigner.signSetDteEmbeded(xmlcontent2.getFirstChild(), setdteURI, kinfo.getPrivatekey(), kinfo.getCertificate());
					String xmlsetdteSigned = docxml.sign(
							new ByteArrayInputStream(xmlcontent.getBytes("ISO-8859-1")), 
							"EnvioBOLETA", 
							"SetDTE", 
							documento.getID(), 
							kinfo.getCertificate(), 
							kinfo.getPrivatekey());
					if (xmlsetdteSigned == null) {
						log.error("Ocurrio un error firmando URI=" + setdteURI + ". No fue posible firmar SetBoleta ID=" + ID);
						throw new Exception("No fue posible firmar SetBoleta ID=" + ID);
					}

					// agrega salto de linea a la declaracion del xml
					xmlsetdteSigned = xmlsetdteSigned.replace(
							"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>", 
							"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN);
					
					// establece el valor en la nueva instancia de setdte que se guardara en la base de datos
					newSetDte.setEstado(EntitySetDTEStatuses.ENVIOPENDIENTE.toString());
					newSetDte.setDocumentoXml(xmlsetdteSigned);

					// muestra el xml resultante
					log.debug("XML Boleta ID=" + ID + ", firmada y almacenada."); // XML-resultante=\n" + xmlsetdteSigned);
					// @formatter:on
				}
			}

			// escribe la nueva instancia en la base de datos
			Setdte newrecord = repoSetdte.save(newSetDte);

			// actualiza lista de dtes que forman parte de este set
			repoDte.updateByIds(newrecord.getIdSetdte(), dteList, EntityDTEStatuses.SETDTEASIGNADO.toString());

			// recupera y muestra el id
			log.info("Set Dte creado con id=" + newrecord.getIdSetdte());

			// retorna el registro recien insertado
			return newrecord;

		} catch (Exception ex) {
			log.error("No fue posible crear el registro en SetDTE. Error=" + ex.getMessage());
			return null;
		}
	}
}
