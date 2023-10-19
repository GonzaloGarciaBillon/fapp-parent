package cl.fapp.restapi.controller.repos.dto;

import javax.validation.constraints.NotNull;

import cl.fapp.domain.validator.OneOf;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Informacion del Keystore para un determinado emisor/firmante")
public class UploadKeystoreRequest {

	@Schema(description = "RUT (con digito verificador) del Emisor", example = "11111111-1", required = true)
	@NotNull(message = "Rut Emisor no debe ser nulo")
	private String rutEmisor;

	@Schema(description = "RUT (con digito verificador) del Firmante", example = "22222222-2", required = true)
	@NotNull(message = "Rut Firmante no debe ser nulo")
	private String rutFirmante;

	@Schema(description = "Tipo de keystore (JKS|PFX)", example = "JKS", required = true)
	@OneOf(attribute = "Tipo de certificado", strValues={"JKS","PFX"})
	@NotNull(message = "Tipo de certificado no debe ser nulo")
	private String tipoCertificado;

	@Schema(description = "Si tipo es JKS, especificar el alias en el keystore", example = "entry-alias", required = false)
	private String aliasKeystore;

	@Schema(description = "Password para acceder al keystore", example = "password-keystore", required = false)
	private String passwordKeystore;

	@Schema(description = "Password del certificado", example = "password-certificate", required = true)
	@NotNull(message = "Password del certificado no debe ser nulo")
	private String passwordCertificate;

}
