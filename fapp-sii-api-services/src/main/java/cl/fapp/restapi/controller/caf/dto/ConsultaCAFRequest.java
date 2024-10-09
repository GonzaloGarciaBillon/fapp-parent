package cl.fapp.restapi.controller.caf.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ConsultaCAFRequest {
    private String rutEmisor;
    private String sucursal;
    private Integer tipoDocumento;
    private Integer cantidadFolios;  // Cambiado para solicitar la cantidad de folios
}
