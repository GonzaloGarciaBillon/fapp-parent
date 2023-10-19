package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the folios_noutilizados database table.
 * 
 */
@Entity
@Table(name="folios_noutilizados")
@NamedQuery(name="FoliosNoutilizado.findAll", query="SELECT f FROM FoliosNoutilizado f")
public class FoliosNoutilizado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idFolionoutilizado;
	private Date createdat;
	private Long folioNoutilizado;
	private String razon;
	private Caf caf;

	public FoliosNoutilizado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_folionoutilizado", unique=true, nullable=false)
	public Long getIdFolionoutilizado() {
		return this.idFolionoutilizado;
	}

	public void setIdFolionoutilizado(Long idFolionoutilizado) {
		this.idFolionoutilizado = idFolionoutilizado;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatedat() {
		return this.createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}


	@Column(name="folio_noutilizado", nullable=false)
	public Long getFolioNoutilizado() {
		return this.folioNoutilizado;
	}

	public void setFolioNoutilizado(Long folioNoutilizado) {
		this.folioNoutilizado = folioNoutilizado;
	}


	@Column(nullable=false, length=128)
	public String getRazon() {
		return this.razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}


	//bi-directional many-to-one association to Caf
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_caf", nullable=false)
	public Caf getCaf() {
		return this.caf;
	}

	public void setCaf(Caf caf) {
		this.caf = caf;
	}

}