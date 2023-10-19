package cl.fapp.siiclient.boletas.domain.envio.status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Estadistica {
    
    int tipo;
    int informados;
    int aceptados;
    int rechazados;
    int reparos;

}
