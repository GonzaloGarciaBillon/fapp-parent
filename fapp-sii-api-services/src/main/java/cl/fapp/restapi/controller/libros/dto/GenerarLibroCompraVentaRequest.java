package cl.fapp.restapi.controller.libros.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GenerarLibroCompraVentaRequest {
	private String rutEmisor;
	private String rutFirmante;
	private String fechaDesde;
	private String fechaHasta;
	private String tipoOperacionLibro;	
}
