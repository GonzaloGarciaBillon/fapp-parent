package cl.fapp.restapi.controller.dte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.common.jsend.JSend;
import cl.fapp.common.rut.RUTUtils;
import cl.fapp.siiclient.axis.SOAPClientSIIRegistroReclamoDTE;
import cl.fapp.siiclient.axis.domain.reclamo.DteIngresarAceptacionReclamoRequest;
import cl.fapp.siiclient.axis.domain.reclamo.DteListarEventosHistDocRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "ACEPTACION-RECLAMO-DTE", description = "API para Web Service de Consulta y Registro de Aceptacion/Reclamo a DTE recibido")
public class IngresarAceptacionReclamo {

	@Autowired
	SOAPClientSIIRegistroReclamoDTE clienteWs;

	@Autowired
	SIITokenServiceUtils tokenUtils;

	/**
	 * Registra la aceptacion o rechazo de un DTE.
	 * 
	 * @param payload mensaje de entrada
	 *                {@link DteIngresarAceptacionReclamoRequest}. Entre otros, se
	 *                indica accion a registrar sobre el documento
	 * @return codigo y mensaje de respuesta indicando resultado de la accion
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/ingresaraceptacionreclamo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> ingresarAceptacionReclamo(
			@Validated @RequestBody DteIngresarAceptacionReclamoRequest payload) {
		try {
			String rutemisor = RUTUtils.format(payload.getRutEmisor());
			payload.setRutEmisor(RUTUtils.getNumber(rutemisor));
			payload.setDvEmisor(RUTUtils.getDV(rutemisor));

			String rutfirmante = RUTUtils
					.format(payload.getRutFirmante() == null ? rutemisor : payload.getRutFirmante());
			payload.setRutFirmante(rutfirmante);

			// solicita un token para utilizar el servicio
			String token = tokenUtils.getToken(rutemisor, rutfirmante);

			// invoca al servicio
			log.debug("Invocando IngresarAceptacionReclamo utilizando TOKEN=[" + token + "]");
			String resp = clienteWs.invokeIngresarAceptacionReclamoDocService(token, payload);

			return ResponseEntity.ok().body(JSend.success("RESP=[" + resp + "]"));

		} catch (Exception ex) {
			log.error("Se produjo un error invocando servicio. Error=" + ex.getMessage());
			log.debug("Stacktrace:", ex);
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Lista los eventos historicos asociados a un DTE
	 * 
	 * @param payload mensaje de entrada con datos que identifican al DTE
	 * @return codigo y mensaje de respuesta indicando resultado de la accion. Lista
	 *         los eventos {@link DteList
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/listareventoshistdoc", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> listarEventosHistDoc(@RequestBody DteListarEventosHistDocRequest payload) {
		try {
			String rutemisor = RUTUtils.format(payload.getRutEmisor());
			payload.setRutEmisor(RUTUtils.getNumber(rutemisor));
			payload.setDvEmisor(RUTUtils.getDV(rutemisor));

			String rutfirmante = RUTUtils
					.format(payload.getRutFirmante() == null ? rutemisor : payload.getRutFirmante());
			payload.setRutFirmante(rutfirmante);

			// solicita un token para utilizar el servicio
			String token = tokenUtils.getToken(rutemisor, rutfirmante);

			// invoca el servicio
			log.debug("Invocando ListarEventosHistDoc utilizando TOKEN=[" + token + "]");
			String resp = clienteWs.invokeListarEventosHistDocService(token, payload);

			return ResponseEntity.ok().body(JSend.success("RESP=[" + resp + "]"));

		} catch (Exception ex) {
			log.error("Se produjo un error invocando servicio. Error=" + ex.getMessage());
			log.debug("Stacktrace:", ex);
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}
}
