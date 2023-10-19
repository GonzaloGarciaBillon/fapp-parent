package cl.fapp.domain.boleta;

public class BoletaEnvioDTEHeader {
	private String tipoDTE;
	private String folio;
	private String fechaEmision;
	private String indicadorServicio;
	private String razonSocial;
	private String giro;
	private String direccionOrigen;
	private String comunaOrigen;
	
	// receptor
	private String rutReceptor;
	private String razonSocialReceptor;
	private String direccionReceptor;
	private String comunaReceptor;
	
	// totales
	private String montoTotal;
	private String montoNeto;
	private String iva;
	private String montoExento;
	
	public BoletaEnvioDTEHeader() {
		super();
	}

	public String getTipoDTE() {
		return tipoDTE;
	}

	public void setTipoDTE(String tipoDTE) {
		this.tipoDTE = tipoDTE;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getIndicadorServicio() {
		return indicadorServicio;
	}

	public void setIndicadorServicio(String indicadorServicio) {
		this.indicadorServicio = indicadorServicio;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getGiro() {
		return giro;
	}

	public void setGiro(String giro) {
		this.giro = giro;
	}

	public String getDireccionOrigen() {
		return direccionOrigen;
	}

	public void setDireccionOrigen(String direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}

	public String getComunaOrigen() {
		return comunaOrigen;
	}

	public void setComunaOrigen(String comunaOrigen) {
		this.comunaOrigen = comunaOrigen;
	}

	public String getRutReceptor() {
		return rutReceptor;
	}

	public void setRutReceptor(String rutReceptor) {
		this.rutReceptor = rutReceptor;
	}

	public String getRazonSocialReceptor() {
		return razonSocialReceptor;
	}

	public void setRazonSocialReceptor(String razonSocialReceptor) {
		this.razonSocialReceptor = razonSocialReceptor;
	}

	public String getDireccionReceptor() {
		return direccionReceptor;
	}

	public void setDireccionReceptor(String direccionReceptor) {
		this.direccionReceptor = direccionReceptor;
	}

	public String getComunaReceptor() {
		return comunaReceptor;
	}

	public void setComunaReceptor(String comunaReceptor) {
		this.comunaReceptor = comunaReceptor;
	}

	public String getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(String montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getMontoNeto() {
		return montoNeto;
	}

	public void setMontoNeto(String montoNeto) {
		this.montoNeto = montoNeto;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getMontoExento() {
		return montoExento;
	}

	public void setMontoExento(String montoExento) {
		this.montoExento = montoExento;
	}

}
