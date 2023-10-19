package cl.fapp.restapi.controller.boleta.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Referencias de la boleta")
public class BoletaReferencia {
	@Schema(description = "Numero secuencial de linea de Referencia", example = "1", required = false, accessMode = AccessMode.READ_ONLY )
	private Integer nrolinref;
	
	@Schema(description = "Codigo Interno del Tipo de Referencia", example = "SET", required = false)
	private String codref;

	@Schema(description = "Razon explicita por la que se referencia el Documento", example = "CASO-1", required = false)
	private String razonref;
	
	@Schema(description = "Codigo del Vendedor establecido por la Empresa.<br>Puede estar asociado a INTERNET", example = "V001", required = false)
	private String codvndor;

	@Schema(description = "Codigo de la caja establecido por la Empresa", example = "C001", required = false)
	private String codcaja;
	
	@Schema(description = "Tipo documento de referencia", example = "39", required = false)
	private String tpodocref;
	
	@Schema(description = "Folio de referencia", example = "12345", required = false)
	private String folioref;
}
