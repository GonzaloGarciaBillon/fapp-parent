package cl.fapp.siiclient.boletas.domain.envio;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class DteEnvioResponse {
    /*
     * "rut_emisor": "45000054-K",
     * "rut_envia": "83154595-0",
     * "trackid": 1014,
     * "fecha_recepcion": "2020-09-01 20:30:10",
     * "estado": "REC",
     * "file": "boleta-2020-09-01-001.xml"
     */

    String rut_emisor;
    String rut_envia;
    Long trackid;
    String fecha_recepcion;
    String estado;
    String file;
}
