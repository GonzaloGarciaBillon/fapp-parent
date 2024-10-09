package cl.fapp.restapi.controller.emisoractividad.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import cl.fapp.repository.model.ActividadEconomica;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmisorActividadResponse {
    String message;
    String status;
    List<ActividadEconomica> actividadEconomica;
}
