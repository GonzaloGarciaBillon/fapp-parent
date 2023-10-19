package cl.fapp.common.domain;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Tipos de set. Se utiliza para determinar que servicio del sii utilizar (soap o rest)
 *
 */
@Schema(enumAsRef = true, description = "Tipo de set")
public enum EntitySetDteTipoSet {
	BOLETA("BOLETA"),
	NC("NC"),
	DTE("DTE");

	private final String text;

	EntitySetDteTipoSet(final String text) {
		this.text = text;
	}

	public String getValue() {
		return text;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return text;
	}
}
