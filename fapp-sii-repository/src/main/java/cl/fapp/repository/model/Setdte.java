package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the setdte database table.
 * 
 */
@Entity
@Table(name="setdte")
@NamedQuery(name="Setdte.findAll", query="SELECT s FROM Setdte s")
public class Setdte implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idSetdte;
	private Date createdat;
	private String documentoXml;
	private String estado;
	private String idDocumento;
	private Integer intentosEnvio;
	private Integer nroDtes;
	private String respuestaSii;
	private String rutemisor;
	private String rutfirmante;
	private String tipoSet;
	private String trackid;
	private Date updatedat;
	private List<Dte> dtes;

	public Setdte() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_setdte", unique=true, nullable=false)
	public Long getIdSetdte() {
		return this.idSetdte;
	}

	public void setIdSetdte(Long idSetdte) {
		this.idSetdte = idSetdte;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatedat() {
		return this.createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}


	@Column(name="documento_xml", nullable=false, length=2147483647)
	public String getDocumentoXml() {
		return this.documentoXml;
	}

	public void setDocumentoXml(String documentoXml) {
		this.documentoXml = documentoXml;
	}


	@Column(nullable=false, length=16)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Column(name="id_documento", length=128)
	public String getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}


	@Column(name="intentos_envio")
	public Integer getIntentosEnvio() {
		return this.intentosEnvio;
	}

	public void setIntentosEnvio(Integer intentosEnvio) {
		this.intentosEnvio = intentosEnvio;
	}


	@Column(name="nro_dtes")
	public Integer getNroDtes() {
		return this.nroDtes;
	}

	public void setNroDtes(Integer nroDtes) {
		this.nroDtes = nroDtes;
	}


	@Column(name="respuesta_sii", length=2147483647)
	public String getRespuestaSii() {
		return this.respuestaSii;
	}

	public void setRespuestaSii(String respuestaSii) {
		this.respuestaSii = respuestaSii;
	}


	@Column(length=20)
	public String getRutemisor() {
		return this.rutemisor;
	}

	public void setRutemisor(String rutemisor) {
		this.rutemisor = rutemisor;
	}


	@Column(length=20)
	public String getRutfirmante() {
		return this.rutfirmante;
	}

	public void setRutfirmante(String rutfirmante) {
		this.rutfirmante = rutfirmante;
	}


	@Column(name="tipo_set", length=20)
	public String getTipoSet() {
		return this.tipoSet;
	}

	public void setTipoSet(String tipoSet) {
		this.tipoSet = tipoSet;
	}


	@Column(length=1024)
	public String getTrackid() {
		return this.trackid;
	}

	public void setTrackid(String trackid) {
		this.trackid = trackid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedat() {
		return this.updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}


	//bi-directional many-to-one association to Dte
	@OneToMany(mappedBy="setdte")
	public List<Dte> getDtes() {
		return this.dtes;
	}

	public void setDtes(List<Dte> dtes) {
		this.dtes = dtes;
	}

	public Dte addDte(Dte dte) {
		getDtes().add(dte);
		dte.setSetdte(this);

		return dte;
	}

	public Dte removeDte(Dte dte) {
		getDtes().remove(dte);
		dte.setSetdte(null);

		return dte;
	}

}
