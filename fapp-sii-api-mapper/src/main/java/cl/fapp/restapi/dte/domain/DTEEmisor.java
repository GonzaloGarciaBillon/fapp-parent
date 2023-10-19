package cl.fapp.restapi.dte.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DTEEmisor {
	@Schema(description = "RUT del Emisor del DTE", example = "66666666-6", required = true, minLength = 3, maxLength = 10)
	private String rutEmisor;

	@Schema(description = "Nombre o Razon social emisor", example = "Razon Social Emisor", required = true, minLength = 3, maxLength = 10)
	private String razonSocialEmisor;

	@Schema(description = "Giro comercial del Emisor relevante para el DTE", example = "Giro del Emisor", required = true, minLength = 1, maxLength = 80)
	private String giroEmisor;

	@Schema(description = "Telefono Emisor", example = "5629677788777", required = false, maxLength = 20)
	private String telefonoEmisor;

	@Schema(description = "Correo Emisor", example = "correo@emisor.corr", required = false, maxLength = 80)
	private String correoEmisor;

	@Schema(description = "Codigo de actividad economica", example = "correo@emisor.corr" )
	@ArraySchema(minItems = 1, maxItems = 4, uniqueItems = true )
	private List<BigInteger> actecos = new ArrayList<BigInteger>();

	@Schema(description = "Sucursal que emite el DTE", required = false, maxLength = 20)
	private String codigoSucursalEmisor;

	@Schema(description = "Codigo de sucursal entregado por el SII", required = false, maxLength = 9)
	private String codigoSii;

	@Schema(description = "Direccion de Origen", required = false, maxLength = 70)
	private String direccionEmisor;

	@Schema(description = "Comuna de Origen", required = false, maxLength = 20)
	private String comunaEmisor;

	@Schema(description = "Ciudad de Origen", required = false, maxLength = 20)
	private String ciudadEmisor;

	@Schema(description = "Codigo del vendedor", required = false, maxLength = 60)
	private String codigoVendedor;

	@Schema(description = "Identificador adicional del Emisor", required = false, minLength = 1, maxLength = 20)
	private String idAdicEmisor;

}
