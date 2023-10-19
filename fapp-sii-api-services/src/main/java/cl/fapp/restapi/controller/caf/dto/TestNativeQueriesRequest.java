package cl.fapp.restapi.controller.caf.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TestNativeQueriesRequest {
	private String rutEmisor;
	private String estadoEmisor;
	private String estadoCaf;
	private String estadoDte;
	private Integer minDisponibles;
	private Integer tipoDocumento;
	private Integer tamanoParticion;
	
}
