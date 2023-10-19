package cl.fapp.siiclient.axis.domain.envio;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Estructura para almacenar String XML RECEPCIONDTE del servicio de EnvioDTE
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class RECEPCIONDTE {
	@JsonProperty("STATUS")
	private String STATUS;
	
	@JsonProperty("TIMESTAMP")
	private String TIMESTAMP;
	
	@JsonProperty("RUTCOMPANY")
	private String RUTCOMPANY;
	
	@JsonProperty("TRACKID")
	private String TRACKID;
	
	@JsonProperty("RUTSENDER")
	private String RUTSENDER;
	
	@JsonProperty("FILE")
	private String FILE;
	
	@JsonProperty("DETAIL")
	private DETAIL DETAIL;
}
