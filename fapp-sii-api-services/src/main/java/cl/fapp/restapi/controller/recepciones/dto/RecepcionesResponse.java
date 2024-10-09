package cl.fapp.restapi.controller.recepciones.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RecepcionesResponse {
    private String status;
    private Long createdId;
    private String message;
}
