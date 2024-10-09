package cl.fapp.restapi.controller.recepciones.dto;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RecepcionesRequest {
    @Schema(description = "ID Recepcion", example = "1")
    private Long idRecepcion;
    @Schema(description = "From", example = "from")
    private String from;
    @Schema(description = "To", example = "to")
    private String to;
    @Schema(description = "Subject", example = "subject")
    private String subject;
    @Schema(description = "Date", example = "date")
    private Date date;
    @Schema(description = "CC", example = "cc")
    private String cc;
    @Schema(description = "ReplyTo", example = "replyTo")
    private String replyTo;
    @Schema(description = "MessageId", example = "messageId")
    private String messageId;
    @Schema(description = "Received", example = "received")
    private String received;
    @Schema(description = "DkimSignature", example = "dkimSignature")
    private String dkimSignature;
    @Schema(description = "ContentType", example = "contentType")
    private String contentType;
    @Schema(description = "ReturnPath", example = "returnPath")
    private String returnPath;
    @Schema(description = "AutoSubmitted", example = "autoSubmitted")
    private String autoSubmitted;
    @Schema(description = "RutEnvia", example = "rutEnvia")
    private String rutEnvia;
    @Schema(description = "RutReceptor", example = "rutReceptor")
    private String rutReceptor;
    @Schema(description = "TpoDTE", example = "tpoDTE")
    private String tpoDTE;
    @Schema(description = "NroDTE", example = "nroDTE")
    private String nroDTE;
    @Schema(description = "TmstFirmaEnv", example = "tmstFirmaEnv")
    private String tmstFirmaEnv;
    @Schema(description = "XML", example = "xml")
    private String xml;
    @Schema(description = "Emisor", example = "emisor")
    private String emisor;
    @Schema(description = "CreateDate", example = "createDate")
    private Date createDate;
    @Schema(description = "UpdateDate", example = "updateDate")
    private Date updateDate;
}
