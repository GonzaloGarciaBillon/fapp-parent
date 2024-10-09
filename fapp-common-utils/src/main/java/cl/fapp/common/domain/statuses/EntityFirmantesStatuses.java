package cl.fapp.common.domain.statuses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true, description = "Estados de un FIRMANTE")
public enum EntityFirmantesStatuses {
	ACTIVO("ACTIVO"),
	SUSPENDIDO("SUSPENDIDO"),
	SINVALIDAR("SINVALIDAR"),
	ELIMINADO("ELIMINADO");

	private final String text;

	EntityFirmantesStatuses(final String text) {
		this.text = text;
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
