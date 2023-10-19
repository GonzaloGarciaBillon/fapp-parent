package cl.fapp.siiclient.boletas.domain.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;

import cl.fapp.siiclient.boletas.domain.token.response.RESP_BODY;
import cl.fapp.siiclient.boletas.domain.token.response.RESP_HDR;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
/* 
<?xml version="1.0" encoding="UTF-8"?>
<SII:RESPUESTA xmlns:SII="http://www.sii.cl/XMLSchema">
    <SII:RESP_BODY>
        <TOKEN>BDJIKBLKNG2TH</TOKEN>
    </SII:RESP_BODY>
    <SII:RESP_HDR>
        <ESTADO>00</ESTADO>
        <GLOSA>Token Creado</GLOSA>
    </SII:RESP_HDR>
</SII:RESPUESTA>
*/

@XmlRootElement(name = "RESPUESTA")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter @NoArgsConstructor @ToString
public class BoletaTokenResponse {
	
	@XmlElement(name="RESP_BODY")
	private RESP_BODY RESP_BODY;

	@XmlElement(name="RESP_HDR")
	private RESP_HDR RESP_HDR;

}