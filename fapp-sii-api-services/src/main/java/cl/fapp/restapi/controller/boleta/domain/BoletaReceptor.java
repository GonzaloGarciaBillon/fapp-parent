package cl.fapp.restapi.controller.boleta.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoletaReceptor {

	@Schema(description = "RUT receptor (cliente)", example = "66666666-6", required = true)
	private String rut; // por dte

	@Schema(description = "Codigo interno del receptor", example = "RH-009988", required = false)
	private String codigoInterno; // por dte

	@Schema(description = "Nombre o Razon social receptor (nombre legal)", example = "Nombre Apellido", required = false)
	private String razonsocial; // por dte

	@Schema(description = "Telefono/Email de contacto", example = "contacto@correo.corr", required = false)
	private String contacto; // por dte

	@Schema(description = "Direccion en la cual se envian los productos o se prestan los servicios", example = "DIRECCION", required = false)
	private String direccion; // por dte

	@Schema(description = "Comuna de recepcion", example = "COMUNA recepcion", required = false)
	private String comuna; // por dte

	@Schema(description = "Ciudad de recepcion", example = "CIUDAD recepcion", required = false)
	private String ciudad; // por dte

	@Schema(description = "Direccion Postal", example = "55667788", required = false)
	private String direccionPostal; // por dte

	@Schema(description = "Comuna Postal", example = "5566", required = false)
	private String comunaPostal; // por dte

	@Schema(description = "Ciudad Postal", example = "556677", required = false)
	private String ciudadPostal; // por dte

}
