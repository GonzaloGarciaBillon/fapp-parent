package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "productos")
@NamedQuery(name = "Productos.findAll", query = "SELECT P FROM Productos P")
public class Productos implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idProducto;
	private String nombre;
	private String descripcion;
	private Double precio;
	private String estado;
	private String codigo;
	private String categoria;
	private Emisores emisor;
	private Date createDate;
	private Date updateDate;

	public Productos() {
		// Constructor vacio
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto", unique = true, nullable = false)
	public Long getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "precio", nullable = false)
	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Column(name = "estado", nullable = false, length = 16)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "codigo", nullable = false, length = 1000)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "categoria", nullable = true, length = 32)
	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	// bi-directional many-to-one association to Emisores
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rutemisor", nullable = false)
	public Emisores getEmisor() {
		return this.emisor;
	}

	public void setEmisor(Emisores emisor) {
		this.emisor = emisor;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}