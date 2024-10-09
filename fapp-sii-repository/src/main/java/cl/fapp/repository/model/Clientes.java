package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clientes")
@NamedQuery(name = "Clientes.findAll", query = "SELECT C FROM Clientes C")
public class Clientes implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idCliente;
	private String rut;
	private String razonSocial;
	private String direccion;
	private String email;
	private String telefono;
	private Emisores emisor;
	private Date createDate;
	private Date updateDate;

	public Clientes() {
		// Constructor vacio
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente", unique = true, nullable = false)
	public Long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	@Column(name = "rut", nullable = false, length = 11)
	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	@Column(name = "razonSocial", nullable = false, length = 100)
	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Column(name = "direccion", length = 255)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "telefono", length = 20)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
