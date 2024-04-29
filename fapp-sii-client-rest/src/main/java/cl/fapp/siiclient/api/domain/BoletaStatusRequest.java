package cl.fapp.siiclient.api.domain;

import java.math.BigInteger;
import javax.validation.constraints.Pattern;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoletaStatusRequest {
	@NotBlank(message = "El [rut] es obligatorio")
	@NotNull(message = "El [rut] es obligatorio")
	String rut;
	
	@NotBlank(message = "El [dv] es obligatorio")
	@NotNull(message = "El [dv] es obligatorio")
	String dv;
	
	@NotNull(message = "El [tipo] es obligatorio")
	Integer tipo;
	
	@NotNull(message = "El [folio] es obligatorio")
	@Min(value=1, message="El [folio] debe ser un número")
	Long folio;
	
	
	@NotBlank(message = "El [rut_receptor] es obligatorio")
	@NotNull(message = "El [rut_receptor] es obligatorio")
	String rut_receptor;
	
	@NotBlank(message = "El [dv_receptor] es obligatorio")
	@NotNull(message = "El [dv_receptor] es obligatorio")
	String dv_receptor;
	
	@NotNull(message = "El [monto] es obligatorio")
	@Min(value=1, message="El [monto] debe ser un número")
	BigInteger monto;
	
	@NotBlank(message = "El [fechaEmision] es obligatorio")
	@NotNull(message = "El [fechaEmision] es obligatorio")
	@Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$" , message="[fechaEmision] debe ser DD-MM-AAAA")
	String fechaEmision;


}
