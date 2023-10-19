package cl.fapp.foliomanager.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Folio {
    Long cardinal;
    String rutEmisor;
    String tagCaf;
    String rsask;
}
