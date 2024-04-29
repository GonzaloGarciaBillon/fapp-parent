package cl.fapp.common.domain.statuses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true, description = "Estados de un DTE")
public enum EntityDTEStatuses {
	// Estados de un DTE internos
	CREADOFIRMADO("CREADOFIRMADO"),
	CREADONOFIRMADO("CREADONOFIRMADO"),
	SETDTENOASIGNADO("SETDTENOASIGNADO"),
	SETDTEASIGNADO("SETDTEASIGNADO"),
	// Estados de un DTE en el SII
	DOC_OK("DOK"),
	DOC_NO_COINCIDE("DNK"),
	DOC_NO_RECIBIDO_POR_SII("FAU"),
	DOCUMENTO_NO_AUTORIZADO("FNA"),
	DOCUMENTO_ANULADO("FAN"),
	EMPRESA_NO_AUTORIZADA("EMP"),
	NOTA_DEBITO_MODIF_TEXTO("TMD"),
	NOTA_CREDITO_MODIF_TEXTO("TMC"),
	NOTA_DEBITO_MODIF_MONTO("MMD"),
	NOTA_CREDITO_MODIF_MONTO("MMC"),
	NOTA_DEBITO_ANULA_DOC("AND"),
	NOTA_CREDITO_ANULA_DOC("ANC");

	private final String text;

	EntityDTEStatuses(final String text) {
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
