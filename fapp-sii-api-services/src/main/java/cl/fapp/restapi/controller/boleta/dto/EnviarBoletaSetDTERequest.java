package cl.fapp.restapi.controller.boleta.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Entrada para el servicio de envio de set de boletas")
/**
 * Entrada para el servicio de generacion de boletas para un mismo Emisor
 */
public class EnviarBoletaSetDTERequest {
	/**
	 * Rut del emisor
	 */
	@Schema(description = "Rut del emisor.", required = true)
	private String rutEmisor = null;	

	/**
	 * Rut del firmante. Si es null, se intenta con el mismo rut de emisor
	 */
	@Schema(description = "Rut del firmante. Si no se indica, se intenta rut del Emisor")
	private String rutFirmante = null;
	
	/**
	 * Rut del firmante. Si es null, se intenta con el mismo rut de emisor
	 */
	@Schema(description = "Identificador del set dte a enviar")
	private Long idSetDte = null;
	
	
	/**
	 * Token para realizar el request. Si se indica, se utiliza. En caso contrario, se pedira uno nuevo
	 */
	@Schema(description = "Token para realizar el request. Si se indica, se utiliza. En caso contrario, se pedira uno nuevo")
	private String token = null;
}
