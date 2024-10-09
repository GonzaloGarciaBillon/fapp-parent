package cl.fapp.restapi.controller.consultas.dto;

import java.math.BigInteger;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Respuesta del servicio consulta DTE
 */
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Respuesta del servicio consulta DTE")
public class ConsultaDTEResponse {
	private Long idDte;
	private String documentoXml;
	private String estado;
	private Long folioAsignado;
	private String idDocumento;
	private BigInteger monto;
	private Integer tipoDocumento;
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "America/Santiago")
	private Date createdat;
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "America/Santiago")
	private Date updatedat;
	private Long idSetdte;
}
