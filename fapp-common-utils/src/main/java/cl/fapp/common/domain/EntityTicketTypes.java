package cl.fapp.common.domain;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Tipos de ticket
 *
 */
@Schema(enumAsRef = true, description = "Tipos de ticket")
public enum EntityTicketTypes {
	TYPE_FOLIO("folio"),
	TYPE_CERTIFICADO("certificado");

	private final String text;

	EntityTicketTypes(final String text) {
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
