package cl.fapp.restapi.dte.domain;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(description = "Descuentos y/o Recargos que afectan al total del Documento")
public class DTEDescuentoRecargo {
	@Schema(description = "Numero secuencial de linea", example = "1", required = false, accessMode = AccessMode.READ_ONLY )
	private Integer nrolinDR;

	@Schema(description = "Tipo de Movimiento (D)escuento (R)ecargo", example = "1", required = true)
	@Size(max = 1)
	private String tpomov;

	@Schema(description = "Descripcion del Descuento o Recargo", example = "1", required = false)
	@Size(max = 45)
	private String glosaDR;

	@Schema(description = "Unidad en que se Expresa el Valor (%) o ($)", example = "%", required = true)
	@Size(max = 1)
	private String tpovalor;

	@Schema(description = "Valor del Descuento o Recargo", example = "1", required = true)
	private BigDecimal valorDR = BigDecimal.ZERO;

	@Schema(description = "Indica si el Descuento o Recargo Afecta a Itemes Exentos (1) o No Facturables (2)", example = "1", required = false, allowableValues = {"1", "2"})	
	private Integer indicadorExencionDR;

}
