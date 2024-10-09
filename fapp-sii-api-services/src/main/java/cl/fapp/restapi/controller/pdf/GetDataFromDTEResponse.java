package cl.fapp.restapi.controller.pdf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetDataFromDTEResponse {
	// solo es posible inhibir los que estan definidos en el padre
	@JsonIgnoreProperties({ "signature" })
	Object dte;
	
	String ted;
	
	String logo;

	String xml;

	String trackid;
}
