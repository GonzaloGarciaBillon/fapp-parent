package cl.fapp.domain.boleta;

import java.util.ArrayList;
import java.util.List;

public class BoletaEnvioDTE {
	private BoletaEnvioDTEHeader encabezado = new BoletaEnvioDTEHeader();
	private List<BoletaEnvioDTEBody> detalle = new ArrayList<BoletaEnvioDTEBody>();

	public BoletaEnvioDTE() {
		super();
	}

	public BoletaEnvioDTEHeader getEncabezado() {
		return encabezado;
	}

	public void setEncabezado(BoletaEnvioDTEHeader encabezado) {
		this.encabezado = encabezado;
	}

	public List<BoletaEnvioDTEBody> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<BoletaEnvioDTEBody> detalle) {
		this.detalle = detalle;
	}

}
