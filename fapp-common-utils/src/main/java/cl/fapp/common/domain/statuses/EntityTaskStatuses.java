package cl.fapp.common.domain.statuses;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Estados de una tarea
 *
 */
@Schema(enumAsRef = true, description = "Estados de una tarea definida en la entidad Task")
public enum EntityTaskStatuses {
	HABILITADA("HABILITADA"),
	DESHABILITADA("DESHABILITADA"),
	PAUSADA("PAUSADA");

	private final String text;

	EntityTaskStatuses(final String text) {
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
