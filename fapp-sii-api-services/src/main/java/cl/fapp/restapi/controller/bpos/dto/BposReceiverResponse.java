package cl.fapp.restapi.controller.bpos.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BposReceiverResponse {
    private String status;
    private String message;
    private int totalDtes;
    private int cantidadProcesados;
    private int cantidadNoProcesados;
    private List<DteStatus> dtesProcesados;
    private List<DteStatus> dtesNoProcesados;

    @Getter
    @Setter
    public static class DteStatus {
        private Long folio;
        private Integer tipoDocumento;  // Cambiado a Integer para coincidir con el tipo en el request
        private BigInteger monto;
        private String estado;

        public DteStatus(Long folio, String estado, Integer tipoDocumento, BigInteger monto) {
            this.folio = folio;
            this.tipoDocumento = tipoDocumento;
            this.monto = monto;
            this.estado = estado;
        }
    }
}
