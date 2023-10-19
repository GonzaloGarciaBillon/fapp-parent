package cl.fapp.siiclient.axis.domain.consultas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EstadoUploadRequest {
	private String dvCompania;
	private String rutCompania;
	private String trackId;
}
