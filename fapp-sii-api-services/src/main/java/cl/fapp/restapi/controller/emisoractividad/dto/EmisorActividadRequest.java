package cl.fapp.restapi.controller.emisoractividad.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmisorActividadRequest {
    String rutEmisor;
    String codigoActividad;
}
