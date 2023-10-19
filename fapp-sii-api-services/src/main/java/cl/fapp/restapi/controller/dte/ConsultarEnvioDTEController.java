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
import cl.fapp.siiclient.axis.domain.consultas.EstadoDteRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "CONSULTA-ENVIO-DTE", description = "Consulta estados de un EnvioDTE")
public class ConsultarEnvioDTEController {
	
	@Autowired
	SOAPClientSIIConsultas soapService;

	/**
	 * Consulta estado del DTE
	 * 
	 * @param payload entrada del servicio
	 * @return estructura JSend simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/estadoenviodte2", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> consultaEstadoEnvioDTE2(@RequestBody EstadoDteRequest payload) {
		try {
			log.debug("Request procesado correctamente");
			
			String response = soapService.invokeEstadoDteService(null, payload);

			return ResponseEntity.ok().body(JSend.success(response));

		} catch (Exception ex) {
			log.error("Error mientras se procesaba la peticion de consulta. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

}
