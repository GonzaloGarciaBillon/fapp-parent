package cl.fapp.restapi.dte.domain;

import java.util.Date;

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
@Schema(description = "Referencias del DTE")
public class DTEReferencia {
	@Schema(description = "Numero secuencial de linea de Referencia", example = "1", required = false, accessMode = AccessMode.READ_ONLY )
	private Integer nrolinref;
	
	@Schema(description = "Tipo de documento de referencia", example = "39", required = true, accessMode = AccessMode.READ_ONLY )
	private String tipoDocRef;
	
	@Schema(description = "Indica que se esta referenciando un conjunto de documentos. 1:El documento hace referencia a un conjunto de documentos del mismo tipo", example = "1", required = false )
	private Integer indGlobal;
	
	@Schema(description = "Folio de documento de referencia", example = "1", required = false, accessMode = AccessMode.READ_ONLY )
	private Integer folioRef;
	
	@Schema(description = "RUT otro contribuyente", example = "11111111-1", required = false )
	private String rutOtro;
	
	@Schema(description = "Fecha del documento de referencia", example = "2022-01-01", required = true )
	private Date fchRef;
	
	@Schema(description = "Tipo de uso de la Referencia. 1:Anula documento de referencia, 2:Corrige texto del documento de referencia, 3:Corrige montos del documento de referencia", example = "1", required = true)
	private String codref;

	@Schema(description = "Razon explicita por la que se referencia el Documento", example = "CASO-1", required = false)
	private String razonref;
}

/*
Tipo de documento de referencia:
Indica si el documento de referencia es:
30: factura
32: factura de venta bienes y servicios
no afectos o exentos de IVA 35: Boleta
35: Boleta
38: Boleta exenta
45: factura de compra
55: nota de débito
60: nota de crédito
103: Liquidación
40: Liquidación Factura
43: Liquidación-Factura Electrónica
33: Factura Electrónica
34: Factura No Afecta o Exenta Electrónica
39: Boleta Electrónica
41: Boleta Exenta Electrónica
46: Factura de Compra Electrónica.
56: Nota de Débito Electrónica
61: Nota de Crédito Electrónica
50 Guía de Despacho.
52:Guía de Despacho Electrónica
110: Factura de Exportación Electrónica
111: Nota de Débito de Exportación Electrónica
112: Nota de Crédito de Exportación Electrónica
801 Orden de Compra
802 Nota de pedido
803 Contrato
804 Resolución
805 Proceso ChileCompra
806 Ficha ChileCompra
807 DUS
808 B/L (Conocimiento de embarque)
809 AWB (Air Will Bill)
810 MIC/DTA
811 Carta de Porte
812 Resolución del SNA donde califica Servicios de Exportación
813 Pasaporte
814 Certificado de Depósito Bolsa Prod. Chile.
815 Vale de Prenda Bolsa Prod. Chile
820 Código de Inscripción en el Registro de Acuerdos con Plazo de Pago Excepcional


*/