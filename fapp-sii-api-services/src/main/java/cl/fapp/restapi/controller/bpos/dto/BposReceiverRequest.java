package cl.fapp.restapi.controller.bpos.dto;

import java.math.BigInteger;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BposReceiverRequest {
    private String nombre;
    private String rutEmisor;
    private List<DteDto> dtes;
    private String serieBpos;

    @Getter
    @Setter
    public static class DteDto {
        private String documentoXml;
        private String dteUuid;
        private Long folioAsignado;
        private String idDocumento;
        private BigInteger monto;
        private String rutFirmante;
        private Integer tipoDocumento;
        private String signatureValue;
    }
}
