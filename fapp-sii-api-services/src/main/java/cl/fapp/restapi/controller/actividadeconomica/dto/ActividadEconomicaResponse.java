package cl.fapp.restapi.controller.actividadeconomica.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActividadEconomicaResponse {
    Long id;
    String message;
    String status;
    String codigo;
    String actividad;
    String afectaIva;
    String categoriaTributaria;
    boolean disponibleInternet;
    Long subRubro;
}
