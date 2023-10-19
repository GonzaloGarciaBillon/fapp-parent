package cl.fapp.siiclient.boletas.domain.envio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class DteEnvioRequest {
    String rutSender;
    String dvSender;
    String rutCompany;
    String dvCompany;
    String archivo;
}
