package cl.fapp.restapi.controller.boleta.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(description = "Respuesta de la clase que utiliza el servicio de generacion de set de boletas")
/**
 * Respuesta de la clase que utiliza el servicio de generacion de boletas
 */
public class GenerarSetDTEResponse {
	
	/**
	 * Rut del Emisor asociado al set de boletas
	 */
	@Schema(description = "Rut del Emisor asociado al set de boletas")
	private String rutEmisor = null;
	
	/**
	 * Identificador del set de boletas
	 */
	@Schema(description = "Identificador del set de boletas")
	private Long idSetBoletas = null;
	
	/**
	 * Numero de boletas que contiene el set
	 */
	@Schema(description = "Numero de boletas en el set")
	private Integer nroBoletas = null;
	
	/**
	 * Mensaje en caso de error
	 */
	@Schema(description = "Mensaje en caso de error")
	private String errorMessage = null;
	
	
	
}
