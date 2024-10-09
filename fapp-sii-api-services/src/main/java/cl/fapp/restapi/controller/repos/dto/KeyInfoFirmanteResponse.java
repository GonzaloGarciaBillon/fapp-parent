package cl.fapp.restapi.controller.repos.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KeyInfoFirmanteResponse {
    String keystoreTipo;
    String keystorePath;
    byte[] keystoreContent;
    String keystoreAlias;
    String keystorePassword;
    String certificatePassword;
    Date certificateExpiryDate;
    Date fechaCreacion;
    String rutFirmante;
    String issuer;
}