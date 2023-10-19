package cl.fapp.siiclient.axis.domain.correo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DteCorreoRequest {
	private String dvEmpresa;
	private String rutEmpresa;
	private String trackId;
}
