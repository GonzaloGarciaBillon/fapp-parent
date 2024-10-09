package cl.fapp.restapi.controller.decrypt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecryptRequest {

    private String encryptedData;
    private String secretKey;
    private String iv;
}
