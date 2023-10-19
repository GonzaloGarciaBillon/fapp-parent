package cl.fapp.restapi.controller.consultas.dto;

import java.math.BigInteger;
import java.util.Date;

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
	private Date createdat;
	private String documentoXml;
	private String estado;
	private Long folioAsignado;
	private String idDocumento;
	private BigInteger monto;
	private Integer tipoDocumento;
	private Date updatedat;
	private Long idSetdte;
}
