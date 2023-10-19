package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the dte database table.
 * 
 */
@Entity
@Table(name="dte")
@NamedQuery(name="Dte.findAll", query="SELECT d FROM Dte d")
public class Dte implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idDte;
	private Date createdat;
	private String documentoXml;
	private String dteUuid;
	private String estado;
	private Long folioAsignado;
	private String idDocumento;
	private BigInteger monto;
	private String rutfirmante;
	private Integer tipoDocumento;
	private Date updatedat;
	private Emisores emisore;
	private Setdte setdte;
	private String signatureValue;
	private List<Referencia> referencias;

	public Dte() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dte", unique=true, nullable=false)
	public Long getIdDte() {
		return this.idDte;
	}

	public void setIdDte(Long idDte) {
		this.idDte = idDte;
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


	@Column(name="dte_uuid", nullable=false, length=96)
	public String getDteUuid() {
		return this.dteUuid;
	}

	public void setDteUuid(String dteUuid) {
		this.dteUuid = dteUuid;
	}


	@Column(nullable=false, length=16)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Column(name="folio_asignado")
	public Long getFolioAsignado() {
		return this.folioAsignado;
	}

	public void setFolioAsignado(Long folioAsignado) {
		this.folioAsignado = folioAsignado;
	}


	@Column(name="id_documento", nullable=false, length=128)
	public String getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}


	@Column(nullable=false)
	public BigInteger getMonto() {
		return this.monto;
	}

	public void setMonto(BigInteger monto) {
		this.monto = monto;
	}

	
	@Column(length=20)
	public String getRutfirmante() {
		return this.rutfirmante;
	}

	public void setRutfirmante(String rutfirmante) {
		this.rutfirmante = rutfirmante;
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


	//bi-directional many-to-one association to Setdte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_setdte")
	public Setdte getSetdte() {
		return this.setdte;
	}

	public void setSetdte(Setdte setdte) {
		this.setdte = setdte;
	}

	@Column(name="signature_value", nullable=true, length=1024)
	public String getSignatureValue() {
		return this.signatureValue;
	}

	public void setSignatureValue(String signatureValue) {
		this.signatureValue = signatureValue;
	}

	//bi-directional many-to-one association to Referencia
	@OneToMany(mappedBy="dte")
	public List<Referencia> getReferencias() {
		return this.referencias;
	}

	public void setReferencias(List<Referencia> referencias) {
		this.referencias = referencias;
	}

	public Referencia addReferencia(Referencia referencia) {
		getReferencias().add(referencia);
		referencia.setDte(this);

		return referencia;
	}

	public Referencia removeReferencia(Referencia referencia) {
		getReferencias().remove(referencia);
		referencia.setDte(null);

		return referencia;
	}

}