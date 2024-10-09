package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "recepciones")
@NamedQuery(name = "Recepcion.findAll", query = "SELECT r FROM Recepcion r")
public class Recepcion implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idRecepcion;
	private String fromAddress;
	private String toAddress;
	private String subject;
	private Date date;
	private String cc;
	private String replyTo;
	private String messageId;
	private String received;
	private String dkimSignature;
	private String contentType;
	private String returnPath;
	private String autoSubmitted;
	private String rutEnvia;
	private Emisores rutReceptor;
	private String tpoDTE;
	private String nroDTE;
	private String tmstFirmaEnv;
	private String xml;
	private String rutEmisor;
	private Date createDate;
	private Date updateDate;
	private List<RecepcionDte> recepcionDtes;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recepcion", unique = true, nullable = false)
	public Long getIdRecepcion() {
		return this.idRecepcion;
	}

	public void setIdRecepcion(Long idRecepcion) {
		this.idRecepcion = idRecepcion;
	}

	@Column(name = "from_address", nullable = false, length = 100)
	public String getFrom() {
		return this.fromAddress;
	}

	public void setFrom(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	@Column(name = "to_address", nullable = false, length = 100)
	public String getTo() {
		return this.toAddress;
	}

	public void setTo(String toAddress) {
		this.toAddress = toAddress;
	}

	@Column(name = "subject", nullable = false, length = 100)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "date", nullable = false)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "cc", nullable = false)
	public String getCc() {
		return this.cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	@Column(name = "reply_to", nullable = false)
	public String getReplyTo() {
		return this.replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	@Column(name = "message_id", nullable = false)
	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Column(name = "received", nullable = false)
	public String getReceived() {
		return this.received;
	}

	public void setReceived(String received) {
		this.received = received;
	}

	@Column(name = "dkim_signature", nullable = false, columnDefinition = "text")
	public String getDkimSignature() {
		return this.dkimSignature;
	}

	public void setDkimSignature(String dkimSignature) {
		this.dkimSignature = dkimSignature;
	}

	@Column(name = "content_type", nullable = false)
	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Column(name = "return_path", nullable = false)
	public String getReturnPath() {
		return this.returnPath;
	}

	public void setReturnPath(String returnPath) {
		this.returnPath = returnPath;
	}

	@Column(name = "auto_submitted", nullable = false)
	public String getAutoSubmitted() {
		return this.autoSubmitted;
	}

	public void setAutoSubmitted(String autoSubmitted) {
		this.autoSubmitted = autoSubmitted;
	}

	@Column(name = "rut_envia", nullable = false)
	public String getRutEnvia() {
		return this.rutEnvia;
	}

	public void setRutEnvia(String rutEnvia) {
		this.rutEnvia = rutEnvia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rutemisor", nullable = false)
	public Emisores getRutReceptor() {
		return this.rutReceptor;
	}

	public void setRutReceptor(Emisores rutReceptor) {
		this.rutReceptor = rutReceptor;
	}

	@Column(name = "tpo_dte", nullable = false)
	public String getTpoDTE() {
		return this.tpoDTE;
	}

	public void setTpoDTE(String tpoDTE) {
		this.tpoDTE = tpoDTE;
	}

	@Column(name = "nro_dte", nullable = false)
	public String getNroDTE() {
		return this.nroDTE;
	}

	public void setNroDTE(String nroDTE) {
		this.nroDTE = nroDTE;
	}

	@Column(name = "tmst_firma_env", nullable = false)
	public String getTmstFirmaEnv() {
		return this.tmstFirmaEnv;
	}

	public void setTmstFirmaEnv(String tmstFirmaEnv) {
		this.tmstFirmaEnv = tmstFirmaEnv;
	}

	@Column(name = "xml", nullable = false, columnDefinition = "text")
	public String getXml() {
		return this.xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	@Column(name = "rut_emisor", nullable = false, length = 20)
	public String getRutEmisor() {
		return this.rutEmisor;
	}

	public void setRutEmisor(String rutEmisor) {
		this.rutEmisor = rutEmisor;
	}

	@Column(name = "create_date", nullable = false)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "update_date", nullable = false)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	// bi-directional many-to-one association to Recepcion
	@OneToMany(mappedBy = "recepcion")
	public List<RecepcionDte> getRecepcionDtes() {
		return this.recepcionDtes;
	}

	public void setRecepcionDtes(List<RecepcionDte> recepcionDtes) {
		this.recepcionDtes = recepcionDtes;
	}

	public RecepcionDte addRecepcionDte(RecepcionDte recepcionDte) {
		getRecepcionDtes().add(recepcionDte);
		recepcionDte.setRecepcion(this);

		return recepcionDte;
	}

	public RecepcionDte removeRecepcionDte(RecepcionDte recepcionDte) {
		getRecepcionDtes().remove(recepcionDte);
		recepcionDte.setRecepcion(null);

		return recepcionDte;
	}

	// toString
	@Override
	public String toString() {
		return "Recepcion [idRecepcion=" + idRecepcion + ", fromAddress=" + fromAddress + ", toAddress=" + toAddress
				+ ", subject=" + subject + ", date=" + date + ", cc=" + cc + ", replyTo=" + replyTo + ", messageId="
				+ messageId + ", received=" + received + ", dkimSignature=" + dkimSignature + ", contentType="
				+ contentType + ", returnPath=" + returnPath + ", autoSubmitted=" + autoSubmitted + ", rutEnvia="
				+ rutEnvia + ", rutReceptor=" + rutReceptor + ", tpoDTE=" + tpoDTE + ", nroDTE=" + nroDTE
				+ ", tmstFirmaEnv=" + tmstFirmaEnv + ", xml=" + xml + ", rutEmisor=" + rutEmisor + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", recepcionDtes=" + recepcionDtes + "]";
	}
}