package cl.fapp.common.domain;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Tipos de set. Se utiliza para determinar que servicio del sii utilizar (soap
 * o rest)
 *
 */
@Schema(enumAsRef = true, description = "Tipo de set")
public enum EntitySetDteTipoSet {
	BOLETA("BOLETA"),
	BOLETA_EXENTA("BOLETA_EXENTA"),
	NOTA_CREDITO("NOTA_CREDITO"),
	NOTA_DEBITO("NOTA_DEBITO"),
	DTE("DTE"),
	GUIA_DESPACHO("GUIA_DESPACHO"),
	FACTURA_EXENTA("FACTURA_EXENTA"),
	FACTURA_AFECTA("FACTURA_AFECTA");
	

	private final String text;

	EntitySetDteTipoSet(final String text) {
		this.text = text;
	}

	public String getValue() {
		return text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return text;
	}
}
