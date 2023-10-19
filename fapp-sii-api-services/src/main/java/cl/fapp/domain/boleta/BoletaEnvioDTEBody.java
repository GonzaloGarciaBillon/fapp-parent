package cl.fapp.domain.boleta;

public class BoletaEnvioDTEBody {
	private String nombreProducto;
	private String cantidadProducto;
	private String precioProducto;
	private String montoItem;
	private String indicadorExento;
	private String descuento;
	private String descripcion;
	private String tipoMovimiento;
	private String tipoValor;
	private String valor;

	public BoletaEnvioDTEBody() {
		super();
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(String cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public String getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(String precioProducto) {
		this.precioProducto = precioProducto;
	}

	public String getMontoItem() {
		return montoItem;
	}

	public void setMontoItem(String montoItem) {
		this.montoItem = montoItem;
	}

	public String getIndicadorExento() {
		return indicadorExento;
	}

	public void setIndicadorExento(String indicadorExento) {
		this.indicadorExento = indicadorExento;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getTipoValor() {
		return tipoValor;
	}

	public void setTipoValor(String tipoValor) {
		this.tipoValor = tipoValor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
