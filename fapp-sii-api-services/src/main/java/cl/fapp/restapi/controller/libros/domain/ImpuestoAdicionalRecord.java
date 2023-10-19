package cl.fapp.restapi.controller.libros.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ImpuestoAdicionalRecord {

	private String tipo;
	private String glosa;
	private Float tasa;

}
