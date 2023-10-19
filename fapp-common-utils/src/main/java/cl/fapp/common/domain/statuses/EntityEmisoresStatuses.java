package cl.fapp.common.domain.statuses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true, description = "Estados de un EMISOR")
public enum EntityEmisoresStatuses {
	ACTIVO("ACTIVO"),
	SUSPENDIDO("SUSPENDIDO"),
	SINVALIDAR("SINVALIDAR"),
	ELIMINADO("ELIMINADO");

	private final String text;

	EntityEmisoresStatuses(final String text) {
		this.text = text;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return text;
	}
	
	public String getValue() {
		return text;
	}
}
