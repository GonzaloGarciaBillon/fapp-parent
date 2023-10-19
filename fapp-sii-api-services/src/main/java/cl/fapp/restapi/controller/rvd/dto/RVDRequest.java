package cl.fapp.restapi.controller.rvd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Entrada para el servicio de generacion/envio RVD")
/**
 * Entrada para el servicio de generacion/envio RVD
 */
public class RVDRequest {
	/**
	 * Rut del emisor
	 */
	@Schema(description = "Rut del emisor.", required = true)
	private String rutEmisor = null;	

	/**
	 * Rut del firmante. Si es null, se intenta con el mismo rut de emisor
	 */
	@Schema(description = "Rut del firmante. Si no se indica, se intenta rut del Emisor")
	private String rutFirmante = null;
	
	/**
	 * Fecha de proceso. String indicando fecha de proceso en formato DD-MM-YYYY
	 */
	@Schema(description = "Fecha de proceso. String indicando fecha de proceso en formato DD-MM-YYYY")
	private String fechaProceso = null;

	/**
	 * Secuencia de envio. Comienza en 1. Repeticiones, deben incrementar en 1
	 */
	@Schema(description = "Secuencia de envio. Comienza en 1. Repeticiones, deben incrementar en 1")
	private Integer secuenciaEnvio = null;
	
	/**
	 * Opcion para indicar si se debe o no enviar al SII el RVD generado
	 */
	@Schema(description = "Indica si debe o no enviar al SII el RVD generado. false por defecto")
	private Boolean enviar = false;
}
