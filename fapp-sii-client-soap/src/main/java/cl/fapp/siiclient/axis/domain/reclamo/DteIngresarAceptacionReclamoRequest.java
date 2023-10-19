package cl.fapp.siiclient.axis.domain.reclamo;

import javax.validation.constraints.NotNull;

import cl.fapp.domain.validator.OneOf;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Request para registrar una aceptacion/rechazo de DTE
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DteIngresarAceptacionReclamoRequest {

	// @formatter:off
	/**
	 * Accion a registrar sobre el documento
	 * <li>ACD: Acepta Contenido del Documento
	 * <li>RCD: Rechaza Contenido del Documento
	 * <li>ERM: Otorga Recibo de Mercaderias o Servicios
	 * <li>RFP: Reclamo por Falta Parcial de Mercaderias
	 * <li>RFT: Reclamo por Falta Total de Mercaderias
	 */
	@NotNull(message = "Accion a registrar no debe ser nulo")
	@OneOf(attribute = "accionDoc:", strValues={"ACD","RCD","ERM","RFP","RFT"}, message="Valores posibles=")
	private String accionDoc;
	// @formatter:on

	/**
	 * Digito verificador del cuerpo del RUT de campo RUT Emisor
	 */
	private String dvEmisor;

	/**
	 * Número de folio que identifica el documento generado por el emisor
	 */
	private String folio;

	/**
	 * Cuerpo numérico del Rut del contribuyente emisor del documento
	 */
	private String rutEmisor;

	/**
	 * Rut+dv dueño del certificado que se utilizara para firmar el documento y token
	 */
	private String rutFirmante;

	/**
	 * Indica que el documento informado es (33)factura, (34)factura no afecta o (43)liquidacion factura electronica
	 */
	@NotNull(message = "Tipo documento no debe ser nulo")
	@OneOf(attribute = "tipoDoc:", strValues={"33","34","43"}, message="Valores posibles=")
	private String tipoDoc;
}
