package cl.fapp.siiclient.axis.domain.envio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Request al servicio de EnvioDTE del SII.
 * Utilizado para documentos que no son de tipo Boleta. 
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DTEEnvioRequest {
	private String rutSender;
	private String dvSender;
	private String rutCompany;
	private String dvCompany;
	private String archivo;
}
