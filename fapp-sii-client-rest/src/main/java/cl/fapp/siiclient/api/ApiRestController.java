package cl.fapp.siiclient.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cl.fapp.siiclient.api.domain.BoletaStatusEnvioRequest;
import cl.fapp.siiclient.api.domain.BoletaStatusRequest;
import cl.fapp.siiclient.api.jsend.JSend;
import cl.fapp.siiclient.boletas.SiiClientServiceRestImp;
import cl.fapp.siiclient.boletas.domain.envio.status.BoletaEnvioStatusResponse;
import cl.fapp.siiclient.boletas.domain.status.BoletaStatusResponse;
import cl.fapp.siiclient.boletas.exception.SiiClientNotAuthorizeException;
import cl.fapp.siiclient.boletas.exception.SiiClientWebClientException;

import javax.validation.Valid;

@RestController
@RequestMapping("/sii-client-api/v1")
public class ApiRestController {

	private static final Logger logger = LoggerFactory.getLogger(ApiRestController.class);

	@Autowired
	SiiClientServiceRestImp siiClientServiceRestImp;


	
	@PostMapping(value = "/boletaStatusEnvio/{token}", produces = "application/json")
	public JSend boletaStatusEnvio(@Valid @RequestBody BoletaStatusEnvioRequest boletaStatusEnvioRequest,
			@PathVariable String token) {
		

		if (token == null || token == "") {
			return JSend.error(-1, "El token es obligatorio", null);
		}
		BoletaEnvioStatusResponse boletaEnvioStatusResponse;
		try {
			boletaEnvioStatusResponse = siiClientServiceRestImp.envioStatus(boletaStatusEnvioRequest.getRut(), boletaStatusEnvioRequest.getDv(), boletaStatusEnvioRequest.getTrackId(), token);
			
			if (boletaEnvioStatusResponse == null) {
				return JSend.error(-1, "Error en la invocación", null);
			}
			
			
		} catch (SiiClientNotAuthorizeException e) {
			return JSend.error(-1, "Error autorización. Token inválido", "Status 401");
		}
		catch (SiiClientWebClientException e) {
			return JSend.error(-1, "Error en el cliente", e.getMessage());
		} 
		catch (Exception e) {
			return JSend.error(-1, "Error", e.getMessage());
		} 

		logger.debug("boletaEnvioStatusResponse " + boletaEnvioStatusResponse);
		JSend response = JSend.success(boletaEnvioStatusResponse);
		return response;
	}

	
	@PostMapping(value = "/boletaStatus/{token}", produces = "application/json")
	public JSend boletaStatus(@Valid @RequestBody BoletaStatusRequest boletaStatusRequest,
			@PathVariable String token) {
		

		if (token == null || token == "") {
			return JSend.error(-1, "El token es obligatorio", null);
		}
				
		BoletaStatusResponse boletaStatusResponse;
		try {
			boletaStatusResponse = siiClientServiceRestImp.boletaStatus(boletaStatusRequest.getRut(), boletaStatusRequest.getDv(), 
					boletaStatusRequest.getTipo(), boletaStatusRequest.getFolio(), boletaStatusRequest.getRut_receptor(), boletaStatusRequest.getDv_receptor(),
					boletaStatusRequest.getMonto(), boletaStatusRequest.getFechaEmision(), token);
			
			if (boletaStatusResponse == null) {
				return JSend.error(-1, "Error en la invocación", null);
			}
			
			
		} catch (SiiClientWebClientException e) {
			return JSend.error(-1, "Error en el cliente", e.getMessage());
		}
		catch (SiiClientNotAuthorizeException e) {
			return JSend.error(-1, "Error autorización. Token inválido", e.getMessage());

		} 
		catch (Exception e) {
			return JSend.error(-1, "Error", e.getMessage());
		} 

		logger.debug("boletaStatusResponse " + boletaStatusResponse);
		JSend response = JSend.success(boletaStatusResponse);
		return response;
	}

	


}