package cl.fapp.common.domain.statuses;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Estados de un conjunto de folios (CAF)
 *
 */
@Schema(enumAsRef = true, description = "Estados de un conjunto de folios (CAF)")
public enum EntityCAFStatuses {
	UTILIZADO("UTILIZADO"),
	ACTIVO("ACTIVO"),
	DISPONIBLE("DISPONIBLE");

	private final String text;

	EntityCAFStatuses(final String text) {
		this.text = text;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return text;
	}
}
