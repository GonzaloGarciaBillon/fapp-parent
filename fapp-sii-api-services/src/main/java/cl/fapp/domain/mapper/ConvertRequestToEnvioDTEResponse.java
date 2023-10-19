package cl.fapp.domain.mapper;

import java.util.List;

import cl.fapp.sii.jaxb.EnvioBOLETA;
import cl.fapp.sii.jaxb.EnvioDTE;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Respuesta de la creacion del setdte a partir del request
 */
@Getter
@Setter
@NoArgsConstructor
public class ConvertRequestToEnvioDTEResponse {

	/**
	 * jaxb de tipo {@link EnvioBOLETA.SetdDTE}
	 */
	EnvioDTE.SetDTE jaxbsetdte;
	
	/**
	 * Lista de identificadores de dte que fueron agregados al set
	 */
	List<Long> dteList;
	
	/**
	 * XML firmado de todos los DTE que forman un set
	 */
	String xmldtes;
}
