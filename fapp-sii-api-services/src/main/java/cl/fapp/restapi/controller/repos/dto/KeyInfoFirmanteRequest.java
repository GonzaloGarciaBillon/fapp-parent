package cl.fapp.restapi.controller.repos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class KeyInfoFirmanteRequest {
    String rutEmisor;
}