package cl.fapp.repository.agg;

/**
 * Agregacion para resultado de @Query nativas y no nativas para
 * CAF por Emisor
 */
public class AggCafPorEmisor {

	private String rutEmisor;
	private Integer tipoDocumento;
	private Integer disponibles;
	private String tipoAlarma;

	public AggCafPorEmisor() {
		super();
	}

	public String getRutEmisor() {
		return rutEmisor;
	}

	public void setRutEmisor(String rutEmisor) {
		this.rutEmisor = rutEmisor;
	}

	public Integer getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(Integer disponibles) {
		this.disponibles = disponibles;
	}

	public String getTipoAlarma() {
		return tipoAlarma;
	}

	public void setTipoAlarma(String tipoAlarma) {
		this.tipoAlarma = tipoAlarma;
	}

	@Override
	public String toString() {
		return "AggCafPorEmisor [rutEmisor=" + rutEmisor + ", tipoDocumento=" + tipoDocumento + ", disponibles=" + disponibles + ", tipoAlarma=" + tipoAlarma + "]";
	}

}
