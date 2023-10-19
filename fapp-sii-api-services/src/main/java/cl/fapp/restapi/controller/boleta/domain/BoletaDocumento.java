package cl.fapp.restapi.controller.boleta.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import cl.fapp.common.domain.ConstantesIndicadorServicio;
import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.domain.validator.DateTimeType;
import cl.fapp.domain.validator.LocalDateTimeFormat;
import cl.fapp.domain.validator.TipoDocumentoSubset;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Schema(description = "Describe metadata de una boleta")
public class BoletaDocumento {

	@Schema(description = "Indica el tipo de documento a generar", required = true)
	@TipoDocumentoSubset(anyOf = {ConstantesTipoDocumento.BOLETA_AFECTA, ConstantesTipoDocumento.BOLETA_EXENTA}, message = "Error gil!!!")
	private ConstantesTipoDocumento tipodocumento; // por dte
	
	@Schema(description = "Valor '2' indica el uso de montos netos en lineas de detalle")
	private Integer indMontoNeto = 1; // 1 indica que los montos de las lineas de detalle son brutos
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Schema(implementation = ConstantesIndicadorServicio.class, accessMode = AccessMode.READ_ONLY)
	private Integer indicadorservicio = ConstantesIndicadorServicio.VENTA_Y_SERVICIOS.getValue();
	
	@Schema(description = "Fecha de emision contable del documento", example = "2022-02-02", required = true)
	@LocalDateTimeFormat(pattern = "yyyy-MM-dd", dateTimeType = DateTimeType.Date, message = "El formato de la fecha no es valido. Debiera ser: yyyy-MM-dd")
	private String fechaemision; // por dte
	
	@Schema(description = "Receptor del documento", required = true)
	private BoletaReceptor receptor = new BoletaReceptor();
	/*
	@Schema(description = "Monto total", example = "10,1")
	private BigDecimal montototal = BigDecimal.ZERO; // por dte

	@Schema(description = "Monto neto de la boleta", example = "20,2")
	private BigDecimal montoneto = BigDecimal.ZERO; // por dte

	@Schema(description = "IVA", example = "19")
	private BigDecimal iva = BigDecimal.ZERO; // por dte
	*/
	@Schema(description = "Codigo interno", example = "RFG111")
	private String codigointerno; // por dte

	@Schema(required = true)
	@ArraySchema(minItems = 1, maxItems = 1000 )
	private List<BoletaDetalle> detalle = new ArrayList<BoletaDetalle>();
	
	@ArraySchema(minItems = 0, maxItems = 20 )
	private List<BoletaDescuentoRecargo> descuentosRecargos = new ArrayList<BoletaDescuentoRecargo>();
	
	@ArraySchema(minItems = 0, maxItems = 40 )
	private List<BoletaReferencia> referencias = new ArrayList<BoletaReferencia>();

}
