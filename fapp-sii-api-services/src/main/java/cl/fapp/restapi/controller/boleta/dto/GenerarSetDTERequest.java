package cl.fapp.restapi.controller.boleta.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Entrada para el servicio de generacion de set de boletas para un mismo Emisor")
/**
 * Entrada para el servicio de generacion de boletas para un mismo Emisor
 */
public class GenerarSetDTERequest {
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
	 * Numero maximo de dte's a incluir en el set. Si es null, se incluyen todas
	 */
	@Schema(description = "Numero maximo de dte's a incluir en el set. Si no se indica, las incluye todas")
	private Integer nroMaxDteEnSet = null;


	@Schema(description = "Tipo de documentos a incluir en el set. Si no se indica, los incluye todos")
	private List<Integer> tipoDocumentos = null;
}
