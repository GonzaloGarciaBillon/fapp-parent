package cl.fapp.restapi.controller.boleta.domain;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoletaEmisor {
	@Schema(description = "RUT emisor")
	private String rutEmisor; // por setdte
	
	@Schema(description = "Razon social emisor")
	private String razonSocialEmisor; // por setdte
	
	@Schema(description = "Giro emisor")
	private String giroEmisor; // por setdte
	
	@Schema(description = "Codigo de sucursal")
	private String codigoSucursalEmisor; // por setdte
	
	@Schema(description = "Direccion")
	private String direccionEmisor; // por setdte
	
	@Schema(description = "Comuna")
	private String comunaEmisor; // por setdte
	
	@Schema(description = "Ciudad")
	private String ciudadEmisor; // por setdte

	@Schema(description = "Telefono")
	private String telefonoEmisor; // por setdte

	@Schema(description = "Correo electronico")
	private String correoEmisor; // por setdte
	
	@Schema(description = "Codigo SII")
	private String codigoSii; // por setdte
	
	@Schema(description = "Codigo Resolucion")
	private String codigoResolucion; // por setdte
	
	@Schema(description = "Fecha resolucion")
	private Date fechaResolucion; // por setdte

}
