package cl.fapp.siiclient.axis.domain.reclamo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Request para registrar eventos asociados a un DTE
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DteListarEventosHistDocRequest {
	/**
	 * Cuerpo numérico del Rut del contribuyente emisor del documento
	 */
	private String rutEmisor;

	/**
	 * Digito verificador del cuerpo del RUT de campo RUT Emisor
	 */
	private String dvEmisor;

	/**
	 * Rut+dv dueño del certificado que se utilizara para firmar el documento y token
	 */
	private String rutFirmante;

	/**
	 * Indica que el documento informado es (33)factura, (34)factura no afecta o (43)liquidacion factura electronica
	 */
	private String tipoDoc;

	/**
	 * Número de folio que identifica el documento generado por el emisor
	 */
	private String folio;
}
