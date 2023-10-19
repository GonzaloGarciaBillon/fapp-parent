package cl.fapp.common.domain;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Nombre predefinido de tareas
 *
 */
@Schema(enumAsRef = true, description = "Nombre predefinido de tareas")
public enum EntityTaskNames {
	MONITOR_FOLIOS("Monitor.Folios"),
	MONITOR_CERTIFICADOS("Monitor.Certificados"),
	TASK_SETBOLETAS_CREATOR("Task.SetBoletas.Creator"),
	TASK_SETBOLETAS_SENDER("Task.SetBoletas.Sender");

	private final String text;

	EntityTaskNames(final String text) {
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
