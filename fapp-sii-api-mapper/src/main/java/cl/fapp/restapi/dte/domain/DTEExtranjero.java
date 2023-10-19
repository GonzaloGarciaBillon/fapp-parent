package cl.fapp.restapi.dte.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DTEExtranjero {
	@Schema(description = "Numero de identificacion del receptor Extranjero", example = "222222222-2", required = true, minLength = 1, maxLength = 20 )
	private String numId;

	@Schema(description = "Nombre o Razon social receptor (nombre legal)", example = "Nombre Apellido", required = true, minLength = 1, maxLength = 3 )
	private String nacionalidad;

}
