package cl.fapp.restapi.controller.libros.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Respuesta del servicio firmar Libro Compra/Venta
 */
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Respuesta del servicio firmar Libro Compra/Venta")
public class FirmarLibroCompraVentaResponse {
	private Integer estado;
	private String description;
	private String libroCompraVentaFirmado = null;
}
