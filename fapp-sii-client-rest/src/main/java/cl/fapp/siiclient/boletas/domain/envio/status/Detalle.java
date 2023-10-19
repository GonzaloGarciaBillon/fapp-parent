package cl.fapp.siiclient.boletas.domain.envio.status;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Detalle {
    Integer tipo;
    Integer folio;
    String estado;
    String descripcion;
    List<cl.fapp.siiclient.boletas.domain.envio.status.Error> error;

}
