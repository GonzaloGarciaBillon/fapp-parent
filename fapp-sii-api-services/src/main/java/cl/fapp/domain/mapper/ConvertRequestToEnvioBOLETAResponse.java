package cl.fapp.domain.mapper;

import java.util.List;

import cl.fapp.sii.jaxb.EnvioBOLETA;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Respuesta de la creacion del setdte a partir del request
 */
@Getter
@Setter
@NoArgsConstructor
public class ConvertRequestToEnvioBOLETAResponse {

	/**
	 * jaxb de tipo {@link EnvioBOLETA.SetdDTE}
	 */
	EnvioBOLETA.SetDTE jaxbsetdte;
	
	/**
	 * Lista de identificadores de dte que fueron agregados al set
	 */
	List<Long> dteList;
	
	/**
	 * XML firmado de todas las boletas que forman un set
	 */
	String xmlboletas;
}
