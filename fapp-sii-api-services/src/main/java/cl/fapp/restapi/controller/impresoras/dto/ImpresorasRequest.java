package cl.fapp.restapi.controller.impresoras.dto;

import java.util.Date;

// import cl.fapp.repository.model.Emisores;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ImpresorasRequest {
	@Schema(description = "Id auto-incremento", required = false, example = "1")
	private Long idImpresora;
	@Schema(description = "Nombre que el usuario le da a la impresora", required = true, example = "Impresora 1")
	private String nombre;
	@Schema(description = "IP de la impresora", required = true, example = "10.0.146.1")
	private String ip;
	@Schema(description = "Puerto que requiere la impresora", required = false, example = "3445")
	private Integer puerto;
	@Schema(description = "Tipo de impresora", required = false, example = "TERMICA")
	private String tipo;
	@Schema(description = "Estado de la impresora", required = false, example = "ACTIVA")
	private String estado;
	@Schema(description = "Cliente asociado a la impresora", required = true, example = "77571105-1")
	private String cliente;
	@Schema(description = "Fecha de creacion", required = false, example = "2021-06-01T00:00:00.000Z")
	private Date createdate;
	@Schema(description = "fecha de actualizacion", required = false, example = "2021-06-01T00:00:00.000Z")
	private Date updateDate;
}