package cl.fapp.restapi.controller.caf.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import cl.fapp.repository.model.Caf;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultaCAFResponse {
    private String message;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Caf caf;
}
