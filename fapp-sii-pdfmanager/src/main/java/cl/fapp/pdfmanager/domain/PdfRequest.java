package cl.fapp.pdfmanager.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PdfRequest {
	private String dte;
	private Integer tipoDte;
	private String rut;
	private byte[] logo;
	private String resolucionFecha;
	private String resolucionCodigo;
}
