package cl.fapp.restapi.controller.repos.dto;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KeyinfoFindResponse {
	private X509Certificate certificate;
	private PrivateKey privatekey;
	private PublicKey publickey;
	private String issuer;

}
