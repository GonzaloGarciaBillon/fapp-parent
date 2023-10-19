package cl.fapp.restapi.dte.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import cl.fapp.common.domain.ConstantesIndicadorServicio;
import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.domain.validator.DateTimeType;
import cl.fapp.domain.validator.LocalDateTimeFormat;
import cl.fapp.domain.validator.OneOf;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Schema(description = "Describe metadata de un DTE")
public class DTEDocumento {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Schema(implementation = ConstantesTipoDocumento.class, accessMode = AccessMode.READ_ONLY)
	private Integer tipodocumento; // por dte
	
	@Schema(description = "Valor '2' indica el uso de montos netos en lineas de detalle")
	private Integer indMontoNeto = 1; // 1 indica que los montos de las lineas de detalle son brutos
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Schema(implementation = ConstantesIndicadorServicio.class, accessMode = AccessMode.READ_ONLY)
	private Integer indicadorservicio = ConstantesIndicadorServicio.VENTA_Y_SERVICIOS.getValue();
	
	@Schema(description = "Fecha de emision contable del documento", example = "2022-02-02", required = true)
	@LocalDateTimeFormat(pattern = "yyyy-MM-dd", dateTimeType = DateTimeType.Date, message = "El formato de la fecha no es valido. Utilice: yyyy-MM-dd")
	private String fechaemision; // por dte
	
	@Schema(description = "Indica en que modalidad se pagara", required = false)
	@OneOf(strValues = {"CH","CF","LT","EF","PE","TC","OT"})
	private String medioPago;

	@Schema(description = "Indica en que forma se pagara", required = false)
	@OneOf(intValues= {1, 2, 3})
	private Integer formaPago;
	
	@Schema(description = "Receptor del documento")
	private DTEReceptor receptor = new DTEReceptor();

	/*
	@Schema(description = "Monto total", example = "10,1", required = false)
	private BigDecimal montototal = BigDecimal.ZERO;

	@Schema(description = "Monto neto del dte", example = "20,2", required = false)
	private BigDecimal montoneto = BigDecimal.ZERO;

	@Schema(description = "IVA", example = "19", required = false)
	private BigDecimal iva = BigDecimal.ZERO;
	
	@Schema(description = "Monto exento del dte", example = "30,2", required = false)
	private BigDecimal montoexento = BigDecimal.ZERO;

	@Schema(description = "Tasa IVA", example = "19", required = false)
	private BigDecimal tasaiva = BigDecimal.ZERO;
	*/

	@Schema(description = "Codigo interno", example = "RFG111")
	private String codigointerno; // por dte

	@Schema(required = true)
	@ArraySchema(minItems = 1, maxItems = 1000 )
	private List<DTEDetalle> detalle = new ArrayList<DTEDetalle>();
	
	@ArraySchema(minItems = 0, maxItems = 20 )
	private List<DTEDescuentoRecargo> descuentosRecargos = new ArrayList<DTEDescuentoRecargo>();
	
	@ArraySchema(minItems = 0, maxItems = 40 )
	private List<DTEReferencia> referencias = new ArrayList<DTEReferencia>();

}
