package cl.fapp.restapi.controller.pdf;

import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Estructura de datos para realizar la busqueda de datos de un DTE.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class GetDataFromDTERequest {
	private String dteRutEmisor;
	private Long dteFolioAsignado;
	private BigInteger dteMonto;
	private Integer dteTipoDocumento;
	private String dteUUID;
	private Long idDte;
	private String idDocumento;
}
