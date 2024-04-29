package cl.fapp.restapi.controller.boleta.dto;

public enum ErrorCode {
    
    MISSING_DOCUMENTS(001, "No fue posible generar documentos."),
    INVALID_DATA(002, "Datos inválidos proporcionados."),
    SIN_FOLIOS(003, "Sin folios disponibles.");
    // otros códigos de error...

    private final Integer code;
    private final String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
