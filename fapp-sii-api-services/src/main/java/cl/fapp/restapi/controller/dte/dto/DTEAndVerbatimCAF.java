package cl.fapp.restapi.controller.dte.dto;

import cl.fapp.sii.jaxb.DTE;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DTEAndVerbatimCAF {

	private DTE dte;
	private String verbatimcaf;

}
