package cl.fapp.siiclient.api.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @NoArgsConstructor @ToString
public class BoletaStatusEnvioRequest {
	
	@NotBlank(message = "El [rut] es obligatorio")
	@NotNull(message = "El [rut] es obligatorio")
    String rut;
	
	@NotBlank(message = "El [dv] es obligatorio")
	@NotNull(message = "El [dv] es obligatorio")
    String dv;
	
	@NotBlank(message = "El [trackId] es obligatorio")
	@NotNull(message = "El [trackId] es obligatorio")
    String trackId;
}
