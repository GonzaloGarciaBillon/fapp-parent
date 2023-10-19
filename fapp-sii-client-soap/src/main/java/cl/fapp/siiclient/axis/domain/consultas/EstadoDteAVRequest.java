package cl.fapp.siiclient.axis.domain.consultas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EstadoDteAVRequest {
	private String dvEmpresa;
	private String dvReceptor;
	private String fechaEmisionDte;
	private String firmaDte;
	private String folioDte;
	private String montoDte;
	private String rutEmpresa;
	private String rutReceptor;
	private String tipoDte;
}
