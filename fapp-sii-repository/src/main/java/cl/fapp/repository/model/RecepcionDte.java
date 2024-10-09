package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;

/**
 * The persistent class for the dte database table.
 * 
 */
@Entity
@Table(name = "recepcion_dte")
@NamedQuery(name = "recepcion_dte.findAll", query = "SELECT r FROM RecepcionDte r")
public class RecepcionDte implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idRecepcionDte;
	private Recepcion recepcion;
	private String rutEmisor;
	private Emisores rutReceptor;
	private String estado;
	private Long folioAsignado;
	private Integer tipoDocumento;
	private BigInteger monto;
	private String documentoXml;
	private Date fchEmis;
	private Date fchFirma;
	private Date createdate;
	private Date updatedate;

	public RecepcionDte() {
		// Default constructor
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recepcion_dte", unique = true, nullable = false)
	public Long getIdRecepcionDte() {
		return this.idRecepcionDte;
	}

	public void setIdRecepcionDte(Long idRecepcionDte) {
		this.idRecepcionDte = idRecepcionDte;
	}

	// bi-directional many-to-one association to Recepcion
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_recepcion", nullable = false)
	public Recepcion getRecepcion() {
		return this.recepcion;
	}

	public void setRecepcion(Recepcion recepcion) {
		this.recepcion = recepcion;
	}

	@Column(name = "rut_emisor", length = 20)
	public String getRutEmisor() {
		return this.rutEmisor;
	}

	public void setRutEmisor(String rutEmisor) {
		this.rutEmisor = rutEmisor;
	}

	// bi-directional many-to-one association to Emisores
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rutemisor", nullable = false)
	public Emisores getRutReceptor() {
		return this.rutReceptor;
	}

	public void setRutReceptor(Emisores rutReceptor) {
		this.rutReceptor = rutReceptor;
	}

	@Column(name = "estado", nullable = false, length = 16)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "folio_asignado")
	public Long getFolioAsignado() {
		return this.folioAsignado;
	}

	public void setFolioAsignado(Long folioAsignado) {
		this.folioAsignado = folioAsignado;
	}

	@Column(name = "tipo_documento", nullable = false)
	public Integer getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Column(name = "monto", nullable = false)
	public BigInteger getMonto() {
		return this.monto;
	}

	public void setMonto(BigInteger monto) {
		this.monto = monto;
	}

	@Column(name = "documento_xml", nullable = false, columnDefinition = "text")
	public String getDocumentoXml() {
		return this.documentoXml;
	}

	public void setDocumentoXml(String documentoXml) {
		this.documentoXml = documentoXml;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_emision", nullable = false)
	public Date getFchEmis() {
		return this.fchEmis;
	}

	public void setFchEmis(Date fchEmis) {
		this.fchEmis = fchEmis;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_firma", nullable = false)
	public Date getFchFirma() {
		return this.fchFirma;
	}

	public void setFchFirma(Date fchFirma) {
		this.fchFirma = fchFirma;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", nullable = false)
	public Date getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

}