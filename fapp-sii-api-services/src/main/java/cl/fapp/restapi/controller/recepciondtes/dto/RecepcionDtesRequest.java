package cl.fapp.restapi.controller.recepciondtes.dto;

import java.math.BigInteger;
import java.util.Date;

import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.model.Recepcion;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RecepcionDtesRequest {
    @Schema(description = "ID Recepcion Dte", example = "1")
    private Long idRecepcionDte;
    @Schema(description = "idRecepcion", example = "1")
    private Long idRecepcion;
    @Schema(description = "Rut Emisor", example = "12345678-9")
    private String rutEmisor;
    @Schema(description = "Rut Receptor", example = "rutReceptor")
    private String rutReceptor;
    @Schema(description = "Estado", example = "estado")
    private String estado;
    @Schema(description = "Folio Asignado", example = "1")
    private Long folioAsignado;
    @Schema(description = "Tipo Documento", example = "1")
    private Integer tipoDocumento;
    @Schema(description = "Monto", example = "1")
    private BigInteger monto;
    @Schema(description = "Documento XML", example = "documentoXml")
    private String documentoXml;
    @Schema(description = "Fecha Emision", example = "fchEmis")
    private Date fchEmis;
    @Schema(description = "Fecha Firma", example = "fchFirma")
    private Date fchFirma;
    @Schema(description = "Created At", example = "createdat")
    private Date createdat;
    @Schema(description = "Updated At", example = "updatedat")
    private Date updatedat;
}
