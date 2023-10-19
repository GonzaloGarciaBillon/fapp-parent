package cl.fapp.siiclient.axis.domain.envio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Respuesta del servicio de EnvioDTE del SII.
 * Utilizado para documentos que no son de tipo Boleta. 
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DTEEnvioResponse {
	private String rut_emisor;
	private String rut_envia;
	private Integer trackid;
	private String fecha_recepcion;
	private String estado;
	private String file;
}
