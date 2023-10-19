package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the apikey database table.
 * 
 */
@Entity
@Table(name="apikey")
@NamedQuery(name="Apikey.findAll", query="SELECT a FROM Apikey a")
public class Apikey implements Serializable {
	private static final long serialVersionUID = 1L;
	private String apikey;
	private Date createdat;
	private String estado;
	private String metadata;
	private Date updatedat;
	private Emisores emisore;

	public Apikey() {
	}


	@Id
	@Column(unique=true, nullable=false, length=128)
	public String getApikey() {
		return this.apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
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

}