package cl.fapp.siiclient.axis.domain.envio;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Detalle de ERROR en respuesta del servicio EnvioDTE
 *
 */
@Getter
@Setter
@ToString
public class DETAIL {
	@JsonProperty("ERROR")
	private String[] ERROR;
}
