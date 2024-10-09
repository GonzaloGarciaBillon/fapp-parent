package cl.fapp.common.domain.statuses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true, description = "Estados de un SetDTE")
public enum EntitySetDTEStatuses {
	// Estados de un SetDTE Interno
	ENVIOPENDIENTE("ENVIOPENDIENTE"),
	ENVIADO("ENVIADO"),
	FIRMAPENDIENTE("FIRMAPENDIENTE"),
	// Estados de una Boleta en el SII
	BOLETA_RECIBIDA("REC"),
	BOLETA_SCHEMA_VALIDADO("SOK"),
	BOLETA_FIRMA_ENVIO_VALIDADA("FOK"),
	BOLETA_EN_PROCESO("PRD"),
	BOLETA_CARATULA_OK("CRT"),
	BOLETA_ENVIO_PROCESADO("EPR"),
	BOLETA_RECHAZADO_POR_SCHEMA("RPT"),
	BOLETA_RECHAZADO_POR_ERROR_FIRMA("RFR"),
	BOLETA_ERROR_INTERNO_SII("VOF"),
	BOLETA_RECHAZADO_POR_ERROR_CARATULA("RCT"),
	BOLETA_ACEPTADO_CON_REPAROS("RPR"),
	// Estados de un DTE en el SII
	DTE_RECHAZADO_POR_SCHEMA("RSC"),
	DTE_SCHEMA_VALIDADO("SOK"),
	DTE_CARATULA_OK("CRT"),
	DTE_RECHAZADO_POR_ERROR_FIRMA("RFR"),
	DTE_FIRMA_ENVIO_VALIDADA("FOK"),
	DTE_ENVIO_EN_PROCESADO("PDR"),
	DTE_RECHAZADO_POR_ERROR_CARATULA("RCT"),
	DTE_ENVIO_PROCESADO("EPR");

	private final String text;

	EntitySetDTEStatuses(final String text) {
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

	/**
	 * Retorna el valor de la enumeracion dado su nombre (forma:
	 * ENUM_NOMBRE.getValue())
	 * 
	 * @return el valor asignado al nombre de la enumeracion
	 */
	public String getValue() {
		return text;
	}
}
