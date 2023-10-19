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
@Schema(description = "Salida del metodo que realiza el envio de set de boletas")
/**
 * Salida del metodo que realiza el envio del set de boletas
 */
public class EnviarBoletaSetDTEResponse {
	/**
	 * Rut del emisor
	 */
	@Schema(description = "Rut del emisor")
	private String rutEmisor = null;	

	/**
	 * Rut del firmante
	 */
	@Schema(description = "Rut del firmante")
	private String rutFirmante = null;
	
	/**
	 * Identificador del set de boletas que se intento enviar
	 */
	@Schema(description = "Identificador del set de boletas que se intento enviar")
	private Long idSetDte = null;
	
	/**
	 * Trackid asignado por el sii. Se utiliza para consultar por el estado del envio
	 */
	@Schema(description = "Trackid asignado por el SII")
	private String trackid = null;
	
	/**
	 * Mensaje en caso de error
	 */
	@Schema(description = "Mensaje en caso de error")
	private String errorMessage = null;
	
	
	/**
	 * Token utilizado durante el envio
	 */
	@Schema(description = "Token utilizado para el envio")
	private String token = null;
}
