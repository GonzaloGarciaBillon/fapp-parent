package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the folios_noutilizados database table.
 * 
 */
@Entity
@Table(name="impresoras")
@NamedQuery(name="Impresoras.findAll", query="SELECT I FROM Impresoras I")
public class Impresoras implements Serializable {
	private static final long serialVersionUID = 1L;
	// CAMPOS IMPRESORA
	// ID, NOMBRE, IP, TIPO, ESTADO, CLIENTE, CREATEDATE, PUERTO
	private Long idImpresora;
	private String nombre;
	private String ip;
	private Integer puerto;
	private String tipo;
	private String estado;
	private Emisores cliente;
	private Date createDate;
	private Date updateDate;

	public Impresoras() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_impresora", unique=true, nullable=false)
	public Long getIdImpresora() {
		return this.idImpresora;
	}

	public void setIdImpresora(Long idImpresora) {
		this.idImpresora = idImpresora;
	}

	@Column(name="nombre", nullable=false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name="ip", nullable=false)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name="puerto", length = 5)
	public Integer getPuerto() {
		return this.puerto;
	}

	public void setPuerto(Integer puerto) {
		this.puerto = puerto;
	}


	@Column(name="tipo", nullable=false, length=16)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name="estado", nullable=false, length=16)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	//bi-directional many-to-one association to Emisores
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rutemisor", nullable=false)
	public Emisores getCliente() {
		return this.cliente;
	}

	public void setCliente(Emisores cliente) {
		this.cliente = cliente;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", nullable=false)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}