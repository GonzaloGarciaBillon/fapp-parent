package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the keystore_firmantes database table.
 * 
 */
@Entity
@Table(name="keystore_firmantes")
@NamedQuery(name="KeystoreFirmantes.findAll", query="SELECT k FROM KeystoreFirmantes k")
public class KeystoreFirmantes implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idKeystore;
	private Date certificateExpiryDate;
	private String certificatePassword;
	private String certificateIssuer;
	private Date createdat;
	private String keystoreAlias;
	private byte[] keystoreContent;
	private String keystorePassword;
	private String keystorePath;
	private String keystoreTipo;
	private String metadata;
	private Date updatedat;
	private Firmantes firmante;

	public KeystoreFirmantes() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_keystore", unique=true, nullable=false)
	public Long getIdKeystore() {
		return this.idKeystore;
	}

	public void setIdKeystore(Long idKeystore) {
		this.idKeystore = idKeystore;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="certificate_expiry_date", nullable=false)
	public Date getCertificateExpiryDate() {
		return this.certificateExpiryDate;
	}

	public void setCertificateExpiryDate(Date certificateExpiryDate) {
		this.certificateExpiryDate = certificateExpiryDate;
	}


	@Column(name="certificate_password", nullable=false, length=128)
	public String getCertificatePassword() {
		return this.certificatePassword;
	}

	public void setCertificatePassword(String certificatePassword) {
		this.certificatePassword = certificatePassword;
	}

	@Column(name="certificate_issuer", nullable=false, length=1024)
	public String getCertificateIssuer() {
		return this.certificateIssuer;
	}

	public void setCertificateIssuer(String certificateIssuer) {
		this.certificateIssuer = certificateIssuer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatedat() {
		return this.createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}


	@Column(name="keystore_alias", length=128)
	public String getKeystoreAlias() {
		return this.keystoreAlias;
	}

	public void setKeystoreAlias(String keystoreAlias) {
		this.keystoreAlias = keystoreAlias;
	}


	@Column(name="keystore_content")
	public byte[] getKeystoreContent() {
		return this.keystoreContent;
	}

	public void setKeystoreContent(byte[] keystoreContent) {
		this.keystoreContent = keystoreContent;
	}


	@Column(name="keystore_password", length=128)
	public String getKeystorePassword() {
		return this.keystorePassword;
	}

	public void setKeystorePassword(String keystorePassword) {
		this.keystorePassword = keystorePassword;
	}


	@Column(name="keystore_path", length=2048)
	public String getKeystorePath() {
		return this.keystorePath;
	}

	public void setKeystorePath(String keystorePath) {
		this.keystorePath = keystorePath;
	}


	@Column(name="keystore_tipo", nullable=false, length=16)
	public String getKeystoreTipo() {
		return this.keystoreTipo;
	}

	public void setKeystoreTipo(String keystoreTipo) {
		this.keystoreTipo = keystoreTipo;
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


	//bi-directional many-to-one association to Firmantes
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_firmante", nullable=false)
	public Firmantes getFirmante() {
		return this.firmante;
	}

	public void setFirmante(Firmantes firmante) {
		this.firmante = firmante;
	}

}