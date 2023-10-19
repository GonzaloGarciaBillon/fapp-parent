package cl.fapp.restapi.dte.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Schema(description = "Items de la boleta")
public class DTEDetalle { // detalle por dte
	
	@Schema(description = "Numero de linea del item", example = "Descripcion breve", accessMode = AccessMode.READ_ONLY )
	private Integer nrolineadetalle;

	@Schema(description = "Nombre producto", example = "Nombre del producto")
	private String nombreproducto;

	@Schema(description = "Cantidad de producto", example = "1")
	private Integer cantidadproducto = 0;
	
	@Schema(description = "Unidad de medida", example = "kg")
	private String umproducto;
	
	@Schema(description = "Precio item", example = "110,1")
	private BigDecimal precioItem = BigDecimal.ZERO;
	
	@Schema(description = "Monto por linea de detalle. Corresponde al monto bruto, a menos que indMntNeto indique lo contrario", example = "100,1")
	private BigDecimal montoitem = BigDecimal.ZERO;
	
	@Schema(description = "Indica si el item esta afecto (1) o exento (0)")
	private Integer indicadorExencion;
	
	@Schema(description = "Porcentaje de descuento")
	private BigDecimal descuentoPct;
	
	@Schema(description = "Monto de descuento")
	private BigInteger descuentoMonto;
	
	@Schema(description = "Descripcion del item")
	private String descripcionItem;
	
	@Schema(description = "Monto de recargo")
	private BigInteger recargoMonto;

	@Schema(description = "Porcentaje de recargo")
	private BigDecimal recargoPct;
	
	@Schema(description = "Rut de la empresa mandante de la boleta")
	private String rutMandante;;
	
}
