package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the firmantes database table.
 * 
 */
@Entity
@Table(name="firmantes")
@NamedQuery(name="Firmantes.findAll", query="SELECT f FROM Firmantes f")
public class Firmantes implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idFirmante;
	private Date createdat;
	private String estado;
	private String metadata;
	private String rutfirmante;
	private Date updatedat;
	private Emisores emisore;
	private List<KeystoreFirmantes> keystoreFirmantes;

	public Firmantes() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_firmante", unique=true, nullable=false)
	public Long getIdFirmante() {
		return this.idFirmante;
	}

	public void setIdFirmante(Long idFirmante) {
		this.idFirmante = idFirmante;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatedat() {
		return this.createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}


	@Column(nullable=false, length=16)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Column(length=2147483647)
	public String getMetadata() {
		return this.metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}


	@Column(nullable=false, length=20)
	public String getRutfirmante() {
		return this.rutfirmante;
	}

	public void setRutfirmante(String rutfirmante) {
		this.rutfirmante = rutfirmante;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedat() {
		return this.updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}


	//bi-directional many-to-one association to Emisores
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rutemisor", nullable=false)
	public Emisores getEmisore() {
		return this.emisore;
	}

	public void setEmisore(Emisores emisore) {
		this.emisore = emisore;
	}


	//bi-directional many-to-one association to KeystoreFirmantes
	@OneToMany(mappedBy="firmante")
	public List<KeystoreFirmantes> getKeystoreFirmantes() {
		return this.keystoreFirmantes;
	}

	public void setKeystoreFirmantes(List<KeystoreFirmantes> keystoreFirmantes) {
		this.keystoreFirmantes = keystoreFirmantes;
	}

	public KeystoreFirmantes addKeystoreFirmante(KeystoreFirmantes keystoreFirmante) {
		getKeystoreFirmantes().add(keystoreFirmante);
		keystoreFirmante.setFirmante(this);

		return keystoreFirmante;
	}

	public KeystoreFirmantes removeKeystoreFirmante(KeystoreFirmantes keystoreFirmante) {
		getKeystoreFirmantes().remove(keystoreFirmante);
		keystoreFirmante.setFirmante(null);

		return keystoreFirmante;
	}

}