package cl.fapp.services.dtelocator.dto;

import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Estructura de datos para realizar la busqueda de un DTE.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ServiceDTELocatorSimpleRequest {
	private String dteRutEmisor;
	private Long dteFolioAsignado;
	private BigInteger dteMonto;
	private Integer dteTipoDocumento;
	private String dteUUID;
	private String dteEmailReceptor;
}
