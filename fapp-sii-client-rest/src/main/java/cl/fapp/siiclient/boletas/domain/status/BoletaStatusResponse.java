package cl.fapp.siiclient.boletas.domain.status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class BoletaStatusResponse {
    String codigo;
    String descripcion;
}
