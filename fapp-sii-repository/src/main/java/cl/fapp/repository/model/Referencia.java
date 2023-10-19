package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the referencias database table.
 * 
 */
@Entity
@Table(name="referencias")
@NamedQuery(name="Referencia.findAll", query="SELECT r FROM Referencia r")
public class Referencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idReferencia;
	private String codref;
	private Date fchref;
	private String folioref;
	private Integer indglobal;
	private Integer nrolinref;
	private String razonref;
	private String rutotro;
	private String tpodocref;
	private Dte dte;

	public Referencia() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_referencia", unique=true, nullable=false)
	public Integer getIdReferencia() {
		return this.idReferencia;
	}

	public void setIdReferencia(Integer idReferencia) {
		this.idReferencia = idReferencia;
	}


	@Column(nullable=false, length=12)
	public String getCodref() {
		return this.codref;
	}

	public void setCodref(String codref) {
		this.codref = codref;
	}


	@Temporal(TemporalType.DATE)
	public Date getFchref() {
		return this.fchref;
	}

	public void setFchref(Date fchref) {
		this.fchref = fchref;
	}


	@Column(length=20)
	public String getFolioref() {
		return this.folioref;
	}

	public void setFolioref(String folioref) {
		this.folioref = folioref;
	}


	public Integer getIndglobal() {
		return this.indglobal;
	}

	public void setIndglobal(Integer indglobal) {
		this.indglobal = indglobal;
	}


	@Column(nullable=false)
	public Integer getNrolinref() {
		return this.nrolinref;
	}

	public void setNrolinref(Integer nrolinref) {
		this.nrolinref = nrolinref;
	}


	@Column(nullable=false, length=90)
	public String getRazonref() {
		return this.razonref;
	}

	public void setRazonref(String razonref) {
		this.razonref = razonref;
	}


	@Column(length=20)
	public String getRutotro() {
		return this.rutotro;
	}

	public void setRutotro(String rutotro) {
		this.rutotro = rutotro;
	}


	@Column(length=3)
	public String getTpodocref() {
		return this.tpodocref;
	}

	public void setTpodocref(String tpodocref) {
		this.tpodocref = tpodocref;
	}


	//bi-directional many-to-one association to Dte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_dte", nullable=false)
	public Dte getDte() {
		return this.dte;
	}

	public void setDte(Dte dte) {
		this.dte = dte;
	}

}