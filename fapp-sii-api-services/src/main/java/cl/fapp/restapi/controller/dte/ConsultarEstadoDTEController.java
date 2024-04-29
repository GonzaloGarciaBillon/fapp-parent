package cl.fapp.restapi.controller.dte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.common.jsend.JSend;
import cl.fapp.siiclient.axis.SOAPClientSIIConsultas;
import cl.fapp.siiclient.axis.domain.consultas.EstadoDteAVRequest;
import cl.fapp.siiclient.axis.domain.consultas.EstadoDteRequest;
import cl.fapp.siiclient.axis.domain.consultas.EstadoUploadRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "CONSULTA-DTE", description = "Consulta estados de un DTE y su envio")
public class ConsultarEstadoDTEController {

	@Autowired
	SOAPClientSIIConsultas soapService;

	/**
	 * Consulta estado del DTE
	 * 
	 * @param payload entrada del servicio
	 * @return estructura JSend simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/estadodte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> consultaEstadoDTE(@RequestBody EstadoDteRequest payload) {
		try {
			log.debug("Request procesado correctamente");

			String response = soapService.invokeEstadoDteService(null, payload);

			return ResponseEntity.ok().body(JSend.success(response));

		} catch (Exception ex) {
			log.error("Error mientras se procesaba la peticion de consulta. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Consulta estado avanzada del DTE
	 * 
	 * @param payload
	 * @return estructura JSend simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/estadoavanzadadte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> consultaAvanzadaEstadoDTE(@RequestBody EstadoDteAVRequest payload) {
		try {
			log.debug("Request procesado correctamente");

			String response = soapService.invokeEstadoDteAVService(null, payload);

			return ResponseEntity.ok().body(JSend.success(response));

		} catch (Exception ex) {
			log.error("Error mientras se procesaba la peticion de consulta avanzada. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Consulta estado del EnvioDTE
	 * 
	 * @param payload entrada servicio
	 * @return estructura JSend simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/estadoenviodte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> consultaEstadoEnvioDTE(@RequestBody EstadoUploadRequest payload) {
		String token = "sin-token";
		try {
			/*
			String rutemisor = payload.getRutEmisor();
			String rutfirmante = payload.getRutFirmante() == null ? rutemisor : payload.getRutFirmante();
			// recupera los datos para firmas
			KeyinfoFindResponse kinfo = ksfirmanteUtils.getKeystoreInfo(rutemisor, rutfirmante);
			if (kinfo == null) {
				log.error("No fue posible obtener informacion del keystore");
				throw new Exception("No es posible obtener KeyStoreInfo");
			}
			token = soapAuthClient.getToken(kinfo.getCertificate(), kinfo.getPrivatekey());*/
			String response = soapService.invokeEstadoUploadService(null, payload);

			return ResponseEntity.ok().body(JSend.success(response));

		} catch (Exception ex) {
			log.error("Error mientras se procesaba la peticion de consulta EnvioDte. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}
}
