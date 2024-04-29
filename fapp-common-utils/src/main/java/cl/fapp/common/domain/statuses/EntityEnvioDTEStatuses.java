package cl.fapp.common.domain.statuses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true, description = "Estados de los envíos de Boleta")
public enum  EntityEnvioDTEStatuses {
    RECIBIDO("REC"),
    ESQUEMA_VALIDADO("SOK"),
    FIRMA_ENVIO_VALIDADA("FOK"),
    EN_PROCESO("PRD"),
    CARATULA_OK("CRT"),
    ENVIO_PROCESADO("EPR"),
    RECHAZADO_POR_SCHEMA("RPT"),
    RECHAZADO_POR_ERROR_FIRMA("RFR"),
    ERROR_INTERNO_SII("VOF"),
    RECHAZADO_POR_ERROR_CARATULA("RCT"),
    ACEPTADO_CON_REPAROS("RPR");

    private final String text;

    EntityEnvioDTEStatuses(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public String getValue() {
        return text;
    }

    public boolean esAceptado() {
        return this == ENVIO_PROCESADO || this == ACEPTADO_CON_REPAROS;
    }

    public boolean esRechazado() {
        return this == RECHAZADO_POR_SCHEMA || this == RECHAZADO_POR_ERROR_FIRMA || 
        this == RECHAZADO_POR_ERROR_CARATULA || this == ERROR_INTERNO_SII;
    }

    public boolean esErrorSii() {
        return this == ERROR_INTERNO_SII;
    }
}
