package cl.fapp.restapi.controller.boleta;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.statuses.EntitySetDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.model.Setdte;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.SetDTERepository;
import cl.fapp.restapi.controller.boleta.dto.EnviarBoletaSetDTERequest;
import cl.fapp.restapi.controller.boleta.dto.EnviarBoletaSetDTEResponse;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import cl.fapp.siiclient.boletas.SiiClientServiceRestImp;
import cl.fapp.siiclient.boletas.domain.envio.BoletaEnvioRequest;
import cl.fapp.siiclient.boletas.domain.envio.BoletaEnvioResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="${fapp.api.controller.base-path}")
@Tag(name = "GENERAR", description = "API para generacion de documentos")
public class EnviarBoletaSetDTEController {
	@Autowired
	EmisoresRepository repoEmisores;

	@Autowired
	KeystoreFirmanteUtils ksfirmanteUtils;

	@Autowired
	SiiClientServiceRestImp restClient;

	@Autowired
	SetDTERepository repoSetDTE;

	/**
	 * Envia un set dte especifico, que se encuentre en estado con envio pendiente empleando la api REST del SII
	 * 
	 * @param payload request para enviar el setdte
	 * @return objeto {@link JSend} simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/enviarboletasetdte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> enviarBoletaSetDTE(@RequestBody EnviarBoletaSetDTERequest payload) {
		try {
			EnviarBoletaSetDTEResponse resp = internalEnviarBoletaSetDte(payload);
			if (resp.getTrackid() != null) {
				log.debug("[Invocacion rest endpoint]-Se ha solicitado el envio del set de boletas correctamente. Resp=" + resp);
				return ResponseEntity.ok().body(JSend.success("Token obtenido=" + resp.getToken() + ", Trackid=" + resp.getTrackid()));

			} else {
				log.debug("[Invocacion rest endpoint]-No se ha podido enviar el set de boletas. Message=" + resp.getErrorMessage());
				throw new Exception("Ocurrio un error durante la solicitud de envio. Message=" + resp.getErrorMessage());
			}
	/*
			// completo la parte emisor del mensaje
			String trackid = "sin-trackid";
			String rutemisor = payload.getRutEmisor();
			String rutfirmante = payload.getRutFirmante() == null ? rutemisor : payload.getRutFirmante();
			Long idsetdte = payload.getIdSetDte();

			if (idsetdte == null) {
				log.error("No se especifica el idSetDte que enviar");
				throw new Exception("No se indica idSetDte");
			}

			String token = "sin-token";
			Optional<Emisores> emisor = repoEmisores.findById(rutemisor);
			if (!emisor.isPresent()) {
				log.error("El Emisor rut=" + rutemisor + " no existe en la base de datos");
				throw new Exception("El Emisor no existe");

			} else {
				log.debug("El emisor rut=" + rutemisor + " existe");

				// recupera el setdte a enviar
				Optional<Setdte> setdteEntity = repoSetDTE.findByIdSetdteAndEstado(idsetdte, EntitySetDTEStatuses.ENVIOPENDIENTE.toString());
				if (!setdteEntity.isPresent()) {
					log.error("El idSetDte=" + idsetdte + ", no se encuentra en estado: " + EntitySetDTEStatuses.ENVIOPENDIENTE);
					throw new Exception("No se encuentran sets con envios pendientes");
				}
				
				// recupera los datos para firmas
				KeyinfoFindResponse kinfo = ksfirmanteUtils.getKeystoreInfo(rutemisor, rutfirmante);
				if (kinfo == null) {
					log.error("No fue posible obtener informacion del keystore");
					throw new Exception("No es posible obtener KeyStoreInfo");
				}

				// recupera un token para enviar las boletas
				token = restClient.getToken(kinfo.getCertificate(), kinfo.getPrivatekey());
				if (token == null) {
					log.error("No se pudo obtener un token para operar");
					throw new Exception("No se pudo obtener token");
				} else {
					log.debug("Se obtiene token para operar TOKEN=" + token);
				}
				
				// recupera el xml del set de boletas que se enviara
				String xmlcontent = setdteEntity.get().getDocumentoXml();
				
				// request para el cliente rest que envia boletas
				String filename = "set-" + setdteEntity.get().getIdSetdte() + ".xml";
				log.debug("Enviando boletas con set-name=" + filename);
				
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
				
				BoletaEnvioRequest request = new BoletaEnvioRequest();
				request.setRutSender(senderRut);
				request.setRutCompany(companyRut);
				request.setDvCompany(companyDV);
				request.setDvSender(senderDV);
				
				//BoletaEnvioResponse response = restClient.sendBoletas(request, xmlcontent.getBytes("ISO-8859-1"), filename, token);
				//BoletaEnvioResponse response = restClient.sendBoletasTls12(request, xmlcontent.getBytes("ISO-8859-1"), filename, token);
				//BoletaEnvioResponse response = null; // restClient.uploadRestTemplate(xmlcontent.getBytes("ISO-8859-1"), request, filename, token);
				
				BoletaEnvioResponse response = restClient.sendBoletas(request, xmlcontent.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING), filename, token);
				if( response == null ) {
					log.error("Respuesta nula del cliente de envioBoleta..");
					throw new Exception("No se obtuvo respuesta esperada del servicio de envio de boletas");
				}
				
				if (response.getEstado().trim().equalsIgnoreCase("REC")) {
					trackid = String.valueOf(response.getTrackid());
					log.info("Boletas enviadas correctamente. TrackID=" + trackid);

					// se actualiza la base de datos
					Date ahora = new Date();
					Setdte entity = setdteEntity.get();
					Integer intentosEnvio = entity.getIntentosEnvio();

					entity.setUpdatedat(ahora);
					entity.setEstado(EntitySetDTEStatuses.ENVIADO.toString());
					entity.setRespuestaSii(response.toString());
					entity.setTrackid(trackid);
					entity.setIntentosEnvio(intentosEnvio + 1);
					
					repoSetDTE.save(entity);

				} else {
					log.error("El envio de boletas resulto con error. Status=" + response.getEstado());
					
					// se actualiza la base de datos
					Date ahora = new Date();
					
					Setdte entity = setdteEntity.get();
					Integer intentosEnvio = entity.getIntentosEnvio();
					
					entity.setUpdatedat(ahora);
					//entity.setEstado(EntitySetDTEStatuses.ENVIOPENDIENTE.toString());
					entity.setIntentosEnvio(intentosEnvio + 1);
					
					repoSetDTE.save(entity);
					
					throw new Exception("No fue posible realizar el envio idSetdte=" + entity.getIdSetdte());
				}
			}

			log.debug("Request procesado correctamente");

			return ResponseEntity.ok().body(JSend.success("Token obtenido=" + token + ", Trackid=" + trackid));
	*/

		} catch (Exception ex) {
			log.error("Error mientras se procesaba la peticion de envio. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}
	
	public EnviarBoletaSetDTEResponse internalEnviarBoletaSetDte(EnviarBoletaSetDTERequest payload) {
		// estructura de respuesta
		EnviarBoletaSetDTEResponse resp = new EnviarBoletaSetDTEResponse();

		// completo la parte emisor del mensaje
		String token = "sin-token";
		String trackid = "sin-trackid";
		String rutemisor = payload.getRutEmisor();
		String rutfirmante = payload.getRutFirmante() == null ? rutemisor : payload.getRutFirmante();
		Long idsetdte = payload.getIdSetDte();
		Optional<Setdte> setdteEntity = null;
		try {
			if (idsetdte == null) {
				log.error("No se especifica el idSetDte que enviar");
				throw new Exception("No se indica idSetDte");
			}

			Optional<Emisores> emisor = repoEmisores.findById(rutemisor);
			if (!emisor.isPresent()) {
				log.error("El Emisor rut=" + rutemisor + " no existe en la base de datos");
				throw new Exception("El Emisor no existe");

			} else {
				log.debug("El emisor rut=" + rutemisor + " existe");

				// recupera el setdte a enviar
				setdteEntity = repoSetDTE.findByIdSetdteAndEstado(idsetdte, EntitySetDTEStatuses.ENVIOPENDIENTE.toString());
				if (!setdteEntity.isPresent()) {
					log.error("El idSetDte=" + idsetdte + ", no se encuentra en estado: " + EntitySetDTEStatuses.ENVIOPENDIENTE);
					throw new Exception("No se encuentran sets con envios pendientes");
				}

				if( payload.getToken()==null ) {
					// recupera los datos para firmas
					KeyinfoFindResponse kinfo = ksfirmanteUtils.getKeystoreInfo(rutemisor, rutfirmante);
					if (kinfo == null) {
						log.error("No fue posible obtener informacion del keystore");
						throw new Exception("No es posible obtener KeyStoreInfo");
					}

					// recupera un token para enviar las boletas
					token = restClient.getToken(kinfo.getCertificate(), kinfo.getPrivatekey());
					if (token == null) {
						log.error("No se pudo obtener un token para operar");
						throw new Exception("No se pudo obtener token");
					} else {
						log.debug("Se obtiene token para operar TOKEN=" + token);
					}					
				}else {
					token = payload.getToken();
				}

				// recupera el xml del set de boletas que se enviara
				String xmlcontent = setdteEntity.get().getDocumentoXml();

				// request para el cliente rest que envia boletas
				String filename = "set-" + setdteEntity.get().getIdSetdte() + ".xml";
				log.debug("Enviando boletas con set-name=" + filename);

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

				BoletaEnvioRequest request = new BoletaEnvioRequest();
				request.setRutSender(senderRut);
				request.setRutCompany(companyRut);
				request.setDvCompany(companyDV);
				request.setDvSender(senderDV);

				//BoletaEnvioResponse response = restClient.sendBoletas(request, xmlcontent.getBytes("ISO-8859-1"), filename, token);
				//BoletaEnvioResponse response = restClient.sendBoletasTls12(request, xmlcontent.getBytes("ISO-8859-1"), filename, token);
				//BoletaEnvioResponse response = null; // restClient.uploadRestTemplate(xmlcontent.getBytes("ISO-8859-1"), request, filename, token);

				BoletaEnvioResponse response = restClient.sendBoletas(request, xmlcontent.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING), filename, token);
				if (response == null) {
					log.error("Respuesta nula del cliente de envioBoleta..");
					throw new Exception("No se obtuvo respuesta esperada del servicio de envio de boletas");
				}

				if (response.getEstado().trim().equalsIgnoreCase("REC")) {
					trackid = String.valueOf(response.getTrackid());
					log.info("Boletas enviadas correctamente. TrackID=" + trackid);

					// se actualiza la base de datos
					Date ahora = new Date();
					Setdte entity = setdteEntity.get();
					entity.setUpdatedat(ahora);
					entity.setEstado(EntitySetDTEStatuses.ENVIADO.toString());
					entity.setRespuestaSii(response.toString());
					entity.setTrackid(trackid);
					entity.setIntentosEnvio(entity.getIntentosEnvio() + 1);

					// actualiza el registro del setdte
					repoSetDTE.save(entity);
					
					// arma la respuesta al caller
					resp.setIdSetDte(idsetdte);
					resp.setRutEmisor(rutemisor);
					resp.setRutFirmante(rutfirmante);
					resp.setTrackid(trackid);
					resp.setToken(token);
					
					// responde al caller
					log.debug("Request procesado correctamente");
					return resp;

				} else {
					log.error("El envio de boletas resulto con error. Status=" + response.getEstado());

					// se actualiza la base de datos
					Date ahora = new Date();

					Setdte entity = setdteEntity.get();
					entity.setUpdatedat(ahora);
					entity.setIntentosEnvio(entity.getIntentosEnvio() + 1);
					//entity.setEstado(EntitySetDTEStatuses.ENVIOPENDIENTE.toString());

					// actualiza el registro del setdte
					repoSetDTE.save(entity);

					throw new Exception("No fue posible realizar el envio idSetdte=" + entity.getIdSetdte());
				}
			}
			// return ResponseEntity.ok().body(JSend.success("Token obtenido=" + token + ", Trackid=" + trackid));

		} catch (Exception ex) {
			log.error("Ocurrio un error enviando el set de boletas. Error=" + ex.getMessage());
			resp.setIdSetDte(idsetdte);
			resp.setRutEmisor(rutemisor);
			resp.setRutFirmante(rutfirmante);
			resp.setTrackid(null);
			resp.setErrorMessage(ex.getMessage());
			resp.setToken(token);
			
			if( setdteEntity != null ) {
				Date ahora = new Date();
				Setdte entity = setdteEntity.get();
				entity.setUpdatedat(ahora);
				entity.setIntentosEnvio(entity.getIntentosEnvio() + 1);
				//entity.setEstado(EntitySetDTEStatuses.ENVIOPENDIENTE.toString());

				// actualiza el registro del setdte
				repoSetDTE.save(entity);
			}
			return resp;
		}
	}
}
