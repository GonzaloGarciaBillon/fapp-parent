package cl.fapp.services.dtelocator.dto;

import cl.fapp.repository.model.Dte;
import cl.fapp.repository.model.Emisores;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Estructura de retorno de datos del DTE. 
 * Incluye informacion del DTE y del Emisor.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ServiceDTELocatorSimpleResponse {
	private Dte dte;
	private Emisores emisor;
}
