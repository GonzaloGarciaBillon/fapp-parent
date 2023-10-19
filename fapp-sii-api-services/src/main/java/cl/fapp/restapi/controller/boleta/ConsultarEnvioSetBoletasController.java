package cl.fapp.restapi.controller.boleta;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.common.jsend.JSend;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.SetDTERepository;
import cl.fapp.restapi.controller.boleta.dto.ConsultarEnvioSetBoletasRequest;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import cl.fapp.siiclient.boletas.SiiClientServiceRestImp;
import cl.fapp.siiclient.boletas.domain.envio.BoletaEnvioRequest;
import cl.fapp.siiclient.boletas.domain.envio.status.BoletaEnvioStatusResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "GENERAR", description = "API para generacion de documentos")
public class ConsultarEnvioSetBoletasController {
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
	@RequestMapping(method = RequestMethod.POST, value = "/consultaenviosetboletas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> enviarBoletaSetDTE(@RequestBody ConsultarEnvioSetBoletasRequest payload) {
		try {
			// completo la parte emisor del mensaje
			String rutemisor = payload.getRutEmisor();
			String rutfirmante = payload.getRutFirmante() == null ? rutemisor : payload.getRutFirmante();
			String trackid = payload.getTrackid();

			if (trackid == null) {
				log.error("No se especifica el trackid por el cual consultar");
				throw new Exception("No se indico trackid por el cual consultar");
			}

			String token = "sin-token";
			Optional<Emisores> emisor = repoEmisores.findById(rutemisor);
			if (!emisor.isPresent()) {
				log.error("El Emisor rut=" + rutemisor + " no existe en la base de datos");
				throw new Exception("El Emisor no existe");

			} else {
				log.debug("El emisor rut=" + rutemisor + " existe");

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

				// separa rut en su parte numerica y su dv, tanto para el emisor como para el firmante
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

				BoletaEnvioStatusResponse response = restClient.envioStatus(companyRut, companyDV, trackid, token);
				if (response == null) {
					log.error("Respuesta nula del cliente de envioStatus.");
					throw new Exception("No se obtuvo respuesta esperada del servicio de envio de boletas");
				} else {
					log.debug("Request procesado correctamente");

					return ResponseEntity.ok().body(JSend.success(response));
				}
			}

		} catch (Exception ex) {
			log.error("Error mientras se procesaba la peticion de consulta estado envio de set de boletas. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}
}
