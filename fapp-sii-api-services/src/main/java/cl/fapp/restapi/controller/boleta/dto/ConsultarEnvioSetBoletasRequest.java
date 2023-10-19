package cl.fapp.restapi.controller.boleta.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Schema(description = "Entrada para el servicio de consulta de envio de set de boletas")
/**
 * Entrada para el servicio de consulta de envio de boletas para un Emisor y trackid
 */
public class ConsultarEnvioSetBoletasRequest {
	/**
	 * Rut del emisor
	 */
	@Getter
	@Setter
	@Schema(description = "Rut del emisor.", required = true)
	private String rutEmisor = null;	

	/**
	 * Rut del firmante. Si es null, se intenta con el mismo rut de emisor
	 */
	@Getter
	@Setter
	@Schema(description = "Rut del firmante. Si no se indica, se intenta con el rut del Emisor")
	private String rutFirmante = null;
	
	/**
	 * Trackid.
	 */
	@Getter
	@Setter
	@Schema(description = "Trackid correspondiente al envio del set (retornado por el SII)")
	private String trackid = null;
}
