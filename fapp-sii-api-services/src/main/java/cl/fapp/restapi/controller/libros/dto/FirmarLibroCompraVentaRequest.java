package cl.fapp.restapi.controller.libros.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Entrada para el servicio de firma de liro de compra/venta de un Emisor")
/**
 * Entrada para el servicio de firma de liro de compra/venta de un Emisor
 */
public class FirmarLibroCompraVentaRequest {
	/**
	 * Rut del emisor
	 */
	@Schema(description = "Rut del emisor.", required = true)
	@NotNull
	@Size(min=1, max=20)
	private String rutEmisor = null;	

	/**
	 * Rut del firmante. Si es null, se intenta con el mismo rut de emisor
	 */
	@Schema(description = "Rut del firmante. Si no se indica, se intenta rut del Emisor")
	private String rutFirmante = null;
}
