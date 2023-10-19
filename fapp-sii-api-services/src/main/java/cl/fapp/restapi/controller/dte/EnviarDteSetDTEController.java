package cl.fapp.restapi.controller.dte;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.statuses.EntitySetDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.model.Setdte;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.SetDTERepository;
import cl.fapp.restapi.controller.dte.dto.EnviarDTERequest;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import cl.fapp.siiclient.axis.SOAPClientSIIAuthentication;
import cl.fapp.siiclient.axis.SOAPClientSIIEnvioDTE;
import cl.fapp.siiclient.axis.domain.envio.DTEEnvioRequest;
import cl.fapp.siiclient.axis.domain.envio.RECEPCIONDTE;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "ENVIODTE", description = "API para envio de documentos")
public class EnviarDteSetDTEController {

	@Autowired
	EmisoresRepository repoEmisores;

	@Autowired
	KeystoreFirmanteUtils ksfirmanteUtils;

	@Autowired
	SOAPClientSIIAuthentication soapAuthClient;

	@Autowired
	SOAPClientSIIEnvioDTE soapEnvioDTEClient;

	@Autowired
	DteRepository repoDTE;

	@Autowired
	SetDTERepository repoSetDTE;

	/**
	 * Envia un setdte especifico, que se encuentre en estado con envio pendiente empleando la api SOAP de SII
	 * 
	 * @param payload request para enviar el dte
	 * @return objeto {@link JSend} simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/enviarncsetdte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> enviarNotaCreditoSetDTE(@RequestBody EnviarDTERequest payload) {
		try {
			// completo la parte emisor del mensaje
			String trackid = "sin-trackid";
			String rutemisor = payload.getRutEmisor();
			String rutfirmante = payload.getRutFirmante() == null ? rutemisor : payload.getRutFirmante();
			Long idsetdte = payload.getIdSetDte();

			if (idsetdte == null) {
				log.error("No se especifica el idDte que enviar");
				throw new Exception("No se indica idDte");
			}

			String token = "sin-token";
			Optional<Emisores> emisor = repoEmisores.findById(rutemisor);
			if (!emisor.isPresent()) {
				log.error("El Emisor rut=" + rutemisor + " no existe en la base de datos");
				throw new Exception("El Emisor no existe");

			} else {
				log.debug("El emisor rut=" + rutemisor + " existe");

				// recupera el setdte a enviar
				//Optional<Dte> dteEntity = repoDTE.findByIdDteAndEstado(idDte, EntityDTEStatuses.SETDTEASIGNADO.toString());
				Optional<Setdte> setdteEntity = repoSetDTE.findByIdSetdteAndEstado(idsetdte, EntitySetDTEStatuses.ENVIOPENDIENTE.toString());
				if (!setdteEntity.isPresent()) {
					log.error("El idSetDte=" + idsetdte + ", no encuentra en estado: " + EntitySetDTEStatuses.ENVIOPENDIENTE);
					throw new Exception("No se encuentra dte con los criterios de busqueda");
				}

				// recupera los datos para firmas
				KeyinfoFindResponse kinfo = ksfirmanteUtils.getKeystoreInfo(rutemisor, rutfirmante);
				if (kinfo == null) {
					log.error("No fue posible obtener informacion del keystore");
					throw new Exception("No es posible obtener KeyStoreInfo");
				}

				// recupera un token para enviar las boletas
				token = soapAuthClient.getToken(kinfo.getCertificate(), kinfo.getPrivatekey());
				if (token == null) {
					log.error("No se pudo obtener un token para operar");
					throw new Exception("No se pudo obtener token");
				} else {
					log.debug("Se obtiene token para operar TOKEN=" + token);
				}

				// recupera el xml del set de boletas que se enviara
				String xmlcontent = setdteEntity.get().getDocumentoXml();

				// request para el cliente rest que envia boletas
				String filename = "SETDTE-" + setdteEntity.get().getIdSetdte() + ".xml";
				log.debug("Enviando dte's con set-name=" + filename);

				// @param usuario RUN del usuario que envía el DTE
				// @param empresa RUT de la empresa emisora del DTE
				String sender = rutfirmante;
				String company = rutemisor;

				String[] parts = sender.split("-");
				String senderRut = parts[0];
				String senderDV = parts[1];

				parts = company.split("-");
				String companyRut = parts[0];
				String companyDV = parts[1];

				DTEEnvioRequest request = new DTEEnvioRequest();
				request.setRutSender(senderRut);
				request.setRutCompany(companyRut);
				request.setDvCompany(companyDV);
				request.setDvSender(senderDV);

				String xmlResponse = soapEnvioDTEClient.sendDTE(request, xmlcontent.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING), filename, token);
				if (xmlResponse == null) {
					log.error("Respuesta nula del cliente de envioDTE..");
					throw new Exception("No se obtuvo respuesta esperada del servicio de envio de DTE");
				}

				// parsea la respuesta xml a un pojo
				RECEPCIONDTE response = xmlToPojo(xmlResponse);
				if( response == null ) {
					log.error("Ocurrio un error obteniendo POJO a partir del XML=" + xmlResponse);
					throw new Exception("No fue posible parsear la respuesta XML-RECEPCIONDTE");
				}

				// verifica el estado de retorno. Solo status=0 => almacenar respuesta en la base de datos
				if (response.getSTATUS().trim().equalsIgnoreCase("0")) {
					trackid = String.valueOf(response.getTRACKID());
					log.info("DTE enviado correctamente. TrackID=" + trackid);

					// se actualiza la base de datos
					Date ahora = new Date();
					Setdte entity = setdteEntity.get();
					entity.setUpdatedat(ahora);
					entity.setEstado(EntitySetDTEStatuses.ENVIADO.toString());
					entity.setRespuestaSii(response.toString());
					entity.setTrackid(trackid);
					repoSetDTE.save(entity);

				} else {
					log.error("El envio de DTE's resulto con error. Status=" + response.getSTATUS() + ", DETAIL=" + response.getDETAIL().getERROR());
					throw new Exception("No fue posible realizar el envio");
				}
			}

			log.debug("Request procesado correctamente");

			return ResponseEntity.ok().body(JSend.success("Token obtenido=" + token + ", Trackid=" + trackid));

		} catch (Exception ex) {
			log.error("Error mientras se procesaba la peticion de envio. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Convierte un string xml simple a un POJO
	 * 
	 * @param xml string xml simple
	 * @return POJO de respuesta al envio del DTE
	 */
	private RECEPCIONDTE xmlToPojo(String xml) {
		try {
			JacksonXmlModule module = new JacksonXmlModule();
			module.setDefaultUseWrapper(false);
			XmlMapper xmlMapper = new XmlMapper(module);

			RECEPCIONDTE pojo = xmlMapper.readValue(xml, RECEPCIONDTE.class);
			return pojo;

		} catch (Exception ex) {
			log.error("Ocurrio un error convirtiendo xml a objeto. Error=" + ex.getMessage());
			return null;
		}
	}
}
