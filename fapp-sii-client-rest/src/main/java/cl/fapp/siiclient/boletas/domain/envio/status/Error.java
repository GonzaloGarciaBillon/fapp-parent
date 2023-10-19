package cl.fapp.siiclient.boletas.domain.envio.status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Error {
    
    String seccion;
    Integer linea;
    Integer nivel;
    Integer codigo;
    String descripcion;
    String detalle;
}
