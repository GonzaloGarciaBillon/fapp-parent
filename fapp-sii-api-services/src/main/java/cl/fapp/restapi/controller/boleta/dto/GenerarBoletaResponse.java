package cl.fapp.restapi.controller.boleta.dto;

import java.math.BigInteger;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Respuesta del servicio de generacion de boletas
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(description = "Respuesta del servicio de generacion de boletas")
public class GenerarBoletaResponse {
	
	/**
	 * Identificador (uuid) asignado al DTE. Siempre posee un valor.
	 */
	@Schema(description = "Identificador asignado al DTE")
	private String uuid = null;
	
	/**
	 * Folio asignado al documento. Puede ser <b>null</b>, cuando no es posible asignar uno.
	 */
	@Schema(description = "Folio asignado al DTE")
	private Long folio = null;
	
	/**
	 * Porcion TED del DTE generado
	 */
	@Schema(description = "Porcion TED del DTE generado")
	private String ted = null;
	
	/**
	 * Monto total del DTE generado
	 */
	@Schema(description = "Monto total del DTE generado")
	private BigInteger montoTotal = null;
	
	/**
	 * Tipo de documento segun codificacion del SII
	 */
	@Schema(description = "Tipo de documento")
	private BigInteger tipoDocumento = null;
}
