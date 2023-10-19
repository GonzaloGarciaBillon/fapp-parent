package cl.fapp.restapi.controller.dte.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Entrada para el servicio de envio de DTE")
/**
 * Entrada para el servicio de envio de DTE para un Emisor
 */
public class EnviarDTERequest {
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
	 * Identificador del SetDTE a enviar
	 */
	@Schema(description = "Identificador del setDte a enviar")
	private Long idSetDte = null;
}
