package cl.fapp.restapi.controller.pdf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetDataFromDTEResponse {
	// solo es posible inhibir los que estan definidos en el padre
	@JsonIgnoreProperties({ "signature" })
	Object dte;
	
	String ted;
	
	String logo;
}
