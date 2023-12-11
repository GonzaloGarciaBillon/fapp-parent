package cl.fapp.restapi.controller.caf.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import cl.fapp.domain.validator.OneOf;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Request para crear informacion del CAF para un determinado Emisor")
public class UploadCAFRequest {
	@Schema(description = "RUT (con digito verificador) del Emisor al cual pertenece el CAF", example = "11111111-1", required = true)
	@NotNull(message = "Rut Emisor no debe ser nulo")
	private String rutEmisor;

	@Schema(description = "Tipo de documento para los que esta asignado el CAF", allowableValues = {"33","34","39","41","56","61"})
	@NotNull(message = "Tipo de documento no debe ser nulo")
	@OneOf(attribute = "Tipo de documento", intValues={33, 34, 39, 41, 56, 61})
	private Integer tipoDocumento;

	@Schema(description = "Folio limite inferior contenido en el CAF", required = false, example = "1")
	private Integer folioMin;

	@Schema(description = "Folio limite superior", required = false, example = "100")
	private Integer folioMax;

	@Schema(description = "Fecha/Hora en que se sube el CAF", accessMode = AccessMode.READ_ONLY)
	private Date fechaUpload;

	@Schema(description = "Contenido del CAF en bytes", accessMode = AccessMode.READ_ONLY)
	private String cafContent;
}
