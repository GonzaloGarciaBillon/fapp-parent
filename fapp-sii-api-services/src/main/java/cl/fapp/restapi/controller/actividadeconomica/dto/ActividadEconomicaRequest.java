package cl.fapp.restapi.controller.actividadeconomica.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ActividadEconomicaRequest {
    String codigo;
    String actividad;
    String afectaIva;
    String categoriaTributaria;
    boolean disponibleInternet;
    Long subRubro;
}
