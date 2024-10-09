package cl.fapp.restapi.dte.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import cl.fapp.restapi.dte.domain.DTEDocumento;
import cl.fapp.restapi.dte.domain.DTEEmisor;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(description = "Entrada para el servicio de generacion de DTE de diferente tipo")
/**
 * Entrada para el servicio de generacion de DTE (de diferente tipo)
 */
public class GenerarDTERequest extends DTEDocumento {

	/**
	 * Rut del emisor
	 */
	@Schema(description = "Rut del emisor.", required = true)
	private String rutEmisor = null;
	
	/**
	 * Codigos de actividad economica
	 */
	@Schema(description = "Codigos actividad economica", required = true)
	@ArraySchema(minItems = 1, maxItems = 4 )
	@Size(min = 1 , max = 4, message = "Debe indicar entre 1 y 4 codigos de actividad economica")
	private List<Integer> actividadEconomica = new ArrayList<Integer>();

	/**
	 * Rut del firmante. Si es null, se intenta con el mismo rut de emisor
	 */
	@Schema(description = "Rut del firmante. Si no se indica, se intenta rut del Emisor")
	private String rutFirmante = null;
	
	/**
	 * Emisor de las boletas
	 */
	@Schema(description = "Emisor. Los datos se completan a partir de un entity", accessMode = AccessMode.READ_ONLY)
	private DTEEmisor emisor = new DTEEmisor();

	/**
	 * Datos de las boletas a generar
	 */
	@Schema(description = "Lista de dtes a generar", required = true)
	private List<DTEDocumento> dtes = new ArrayList<DTEDocumento>();
	
	/**
     * Usuario que genera el DTE. Campo opcional.
     */
    @Schema(description = "Usuario que genera el DTE. Campo opcional.")
    private String usuario;
}
