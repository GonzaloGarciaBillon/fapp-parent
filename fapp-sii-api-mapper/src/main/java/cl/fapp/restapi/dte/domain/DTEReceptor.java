package cl.fapp.restapi.dte.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DTEReceptor {

	@Schema(description = "RUT receptor (cliente)", example = "66666666-6", required = true, minLength=3, maxLength = 10 )
	private String rut;

	@Schema(description = "Codigo interno del receptor", example = "RH-009988", required = false, maxLength = 20 )
	private String codigoInterno; // por dte

	@Schema(description = "Nombre o Razon social receptor (nombre legal)", example = "Nombre Apellido", required = false, maxLength = 100)
	private String razonsocial; // por dte

	@Schema(description = "Receptor extranjero", required = false)
	private DTEExtranjero extranjero;

	@Schema(description = "Giro comercial del receptor", example = "Nombre Apellido", required = false, maxLength = 40 )
	private String giro; // por dte

	@Schema(description = "Telefono/Email de contacto", example = "contacto@correo.corr", required = false, maxLength = 80 )
	private String contacto; // por dte

	@Schema(description = "E-mail de contacto en la empresa del receptor", example = "Nombre Apellido", required = false, maxLength = 80 )
	private String correo; // por dte

	@Schema(description = "Direccion en la cual se envian los productos o se prestan los servicios", example = "DIRECCION", required = false, maxLength = 70 )
	private String direccion; // por dte

	@Schema(description = "Comuna de recepcion", example = "Comuna recepcion", required = false, maxLength = 20 )
	private String comuna; // por dte

	@Schema(description = "Ciudad de recepcion", example = "Ciudad recepcion", required = false, maxLength = 20 )
	private String ciudad; // por dte

	@Schema(description = "Direccion Postal", example = "Direccion Postal", required = false, maxLength = 70 )
	private String direccionPostal; // por dte

	@Schema(description = "Comuna Postal", example = "Comuna Postal", required = false, maxLength = 20 )
	private String comunaPostal; // por dte

	@Schema(description = "Ciudad Postal", example = "Ciudad Postal", required = false, maxLength = 20 )
	private String ciudadPostal; // por dte

}
