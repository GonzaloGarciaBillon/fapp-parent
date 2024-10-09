package cl.fapp.restapi.controller.boleta.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cl.fapp.restapi.controller.boleta.domain.BoletaDocumento;
import cl.fapp.restapi.controller.boleta.domain.BoletaEmisor;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Entrada para el servicio de generacion de boletas para un mismo Emisor")
/**
 * Entrada para el servicio de generacion de boletas para un mismo Emisor
 */
public class GenerarBoletaRequest {
	
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
	
	/**
	 * Emisor de las boletas
	 */
	@Schema(description = "Emisor. Los datos se completan a partir de un entity", accessMode = AccessMode.READ_ONLY)
	private BoletaEmisor emisor = new BoletaEmisor();

	/**
	 * Datos de las boletas a generar
	 */
	@Schema(description = "Lista de Boletas a generar", required = true)
	private List<BoletaDocumento> dtes = new ArrayList<BoletaDocumento>();

	 /**
     * Usuario que genera la boleta. Campo opcional.
     */
    @Schema(description = "Usuario que genera la boleta. Campo opcional.")
    private String usuario;

}
