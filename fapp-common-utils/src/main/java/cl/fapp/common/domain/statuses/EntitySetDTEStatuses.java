package cl.fapp.common.domain.statuses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true, description = "Estados de un SetDTE")
public enum EntitySetDTEStatuses {
	ENVIOPENDIENTE("ENVIOPENDIENTE"), ENVIADO("ENVIADO"), FIRMAPENDIENTE("FIRMAPENDIENTE");

	private final String text;

	EntitySetDTEStatuses(final String text) {
		this.text = text;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return text;
	}

	/**
	 * Retorna el valor de la enumeracion dado su nombre (forma: ENUM_NOMBRE.getValue())
	 * 
	 * @return el valor asignado al nombre de la enumeracion
	 */
	public String getValue() {
		return text;
	}
}
