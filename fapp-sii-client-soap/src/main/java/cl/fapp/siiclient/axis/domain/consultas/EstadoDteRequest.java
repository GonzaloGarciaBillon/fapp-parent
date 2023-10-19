package cl.fapp.siiclient.axis.domain.consultas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EstadoDteRequest {
	private String dvCompania;
	private String dvConsultante;
	private String dvReceptor;
	private String fechaEmisionDte;
	private String folioDte;
	private String montoDte;
	private String rutCompania;
	private String rutConsultante;
	private String rutReceptor;
	private String tipoDte;
}
