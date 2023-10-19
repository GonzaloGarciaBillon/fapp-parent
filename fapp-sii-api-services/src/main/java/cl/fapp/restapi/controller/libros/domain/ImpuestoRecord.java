package cl.fapp.restapi.controller.libros.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ImpuestoRecord {
	private String codigoImpuesto;
	private BigDecimal montoImpuesto;
}
