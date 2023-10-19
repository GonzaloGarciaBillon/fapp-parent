package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the caf database table.
 * 
 */
@Entity
@Table(name="caf")
@NamedQuery(name="Caf.findAll", query="SELECT c FROM Caf c")
public class Caf implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idCaf;
	private Date createdat;
	private Integer disponibles;
	private String estado;
	private Long folioMax;
	private Long folioMin;
	private String tagAutorizacion;
	private String tagCaf;
	private String tagRsask;
	private Integer tipoDocumento;
	private Date updatedat;
	private Emisores emisore;
	private List<FoliosNoutilizado> foliosNoutilizados;

	public Caf() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_caf", unique=true, nullable=false)
	public Long getIdCaf() {
		return this.idCaf;
	}

	public void setIdCaf(Long idCaf) {
		this.idCaf = idCaf;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatedat() {
		return this.createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}


	@Column(nullable=false)
	public Integer getDisponibles() {
		return this.disponibles;
	}

	public void setDisponibles(Integer disponibles) {
		this.disponibles = disponibles;
	}


	@Column(nullable=false, length=16)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Column(name="folio_max", nullable=false)
	public Long getFolioMax() {
		return this.folioMax;
	}

	public void setFolioMax(Long folioMax) {
		this.folioMax = folioMax;
	}


	@Column(name="folio_min", nullable=false)
	public Long getFolioMin() {
		return this.folioMin;
	}

	public void setFolioMin(Long folioMin) {
		this.folioMin = folioMin;
	}


	@Column(name="tag_autorizacion", nullable=false, length=4096)
	public String getTagAutorizacion() {
		return this.tagAutorizacion;
	}

	public void setTagAutorizacion(String tagAutorizacion) {
		this.tagAutorizacion = tagAutorizacion;
	}


	@Column(name="tag_caf", nullable=false, length=1024)
	public String getTagCaf() {
		return this.tagCaf;
	}

	public void setTagCaf(String tagCaf) {
		this.tagCaf = tagCaf;
	}


	@Column(name="tag_rsask", nullable=false, length=1024)
	public String getTagRsask() {
		return this.tagRsask;
	}

	public void setTagRsask(String tagRsask) {
		this.tagRsask = tagRsask;
	}


	@Column(name="tipo_documento", nullable=false)
	public Integer getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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


	//bi-directional many-to-one association to FoliosNoutilizado
	@OneToMany(mappedBy="caf")
	public List<FoliosNoutilizado> getFoliosNoutilizados() {
		return this.foliosNoutilizados;
	}

	public void setFoliosNoutilizados(List<FoliosNoutilizado> foliosNoutilizados) {
		this.foliosNoutilizados = foliosNoutilizados;
	}

	public FoliosNoutilizado addFoliosNoutilizado(FoliosNoutilizado foliosNoutilizado) {
		getFoliosNoutilizados().add(foliosNoutilizado);
		foliosNoutilizado.setCaf(this);

		return foliosNoutilizado;
	}

	public FoliosNoutilizado removeFoliosNoutilizado(FoliosNoutilizado foliosNoutilizado) {
		getFoliosNoutilizados().remove(foliosNoutilizado);
		foliosNoutilizado.setCaf(null);

		return foliosNoutilizado;
	}

}