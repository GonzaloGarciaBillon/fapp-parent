package cl.fapp.restapi.controller.boleta.dto;

import cl.fapp.sii.jaxb.BOLETADefType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BOLETADefTypeAndVerbatimCAF {

	private BOLETADefType boleta;
	private String verbatimcaf;

}
