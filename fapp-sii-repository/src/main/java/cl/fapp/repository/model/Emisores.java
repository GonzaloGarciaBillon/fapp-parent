package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the emisores database table.
 * 
 */
@Entity
@Table(name="emisores")
@NamedQuery(name="Emisores.findAll", query="SELECT e FROM Emisores e")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Emisores implements Serializable {
	private static final long serialVersionUID = 1L;
	private String rutemisor;
	private String ciudad;
	private String codigoResolucion;
	private String codigoSii;
	private String codigoSucursal;
	private String comuna;
	private Date createdat;
	private String direccion;
	private String email;
	private String estado;
	private Date fechaResolucion;
	private String giro;
	private byte[] logo;
	private String metadata;
	private String razonSocial;
	private String telefono;
	private Date updatedat;
	private List<Apikey> apikeys;
	private List<Caf> cafs;
	private List<Dte> dtes;
	private List<Firmantes> firmantes;

	public Emisores() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getRutemisor() {
		return this.rutemisor;
	}

	public void setRutemisor(String rutemisor) {
		this.rutemisor = rutemisor;
	}


	@Column(length=128)
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	@Column(name="codigo_resolucion", length=128)
	public String getCodigoResolucion() {
		return this.codigoResolucion;
	}

	public void setCodigoResolucion(String codigoResolucion) {
		this.codigoResolucion = codigoResolucion;
	}


	@Column(name="codigo_sii", length=128)
	public String getCodigoSii() {
		return this.codigoSii;
	}

	public void setCodigoSii(String codigoSii) {
		this.codigoSii = codigoSii;
	}


	@Column(name="codigo_sucursal", length=64)
	public String getCodigoSucursal() {
		return this.codigoSucursal;
	}

	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}


	@Column(length=128)
	public String getComuna() {
		return this.comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatedat() {
		return this.createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}


	@Column(length=256)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Column(length=256)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(nullable=false, length=16)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_resolucion")
	public Date getFechaResolucion() {
		return this.fechaResolucion;
	}

	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}


	@Column(nullable=false, length=256)
	public String getGiro() {
		return this.giro;
	}

	public void setGiro(String giro) {
		this.giro = giro;
	}


	public byte[] getLogo() {
		return this.logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}


	@Column(length=2147483647)
	public String getMetadata() {
		return this.metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}


	@Column(name="razon_social", length=256)
	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	@Column(length=24)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedat() {
		return this.updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}


	//bi-directional many-to-one association to Apikey
	@OneToMany(mappedBy="emisore")
	public List<Apikey> getApikeys() {
		return this.apikeys;
	}

	public void setApikeys(List<Apikey> apikeys) {
		this.apikeys = apikeys;
	}

	public Apikey addApikey(Apikey apikey) {
		getApikeys().add(apikey);
		apikey.setEmisore(this);

		return apikey;
	}

	public Apikey removeApikey(Apikey apikey) {
		getApikeys().remove(apikey);
		apikey.setEmisore(null);

		return apikey;
	}


	//bi-directional many-to-one association to Caf
	@OneToMany(mappedBy="emisore")
	public List<Caf> getCafs() {
		return this.cafs;
	}

	public void setCafs(List<Caf> cafs) {
		this.cafs = cafs;
	}

	public Caf addCaf(Caf caf) {
		getCafs().add(caf);
		caf.setEmisore(this);

		return caf;
	}

	public Caf removeCaf(Caf caf) {
		getCafs().remove(caf);
		caf.setEmisore(null);

		return caf;
	}


	//bi-directional many-to-one association to Dte
	@OneToMany(mappedBy="emisore")
	public List<Dte> getDtes() {
		return this.dtes;
	}

	public void setDtes(List<Dte> dtes) {
		this.dtes = dtes;
	}

	public Dte addDte(Dte dte) {
		getDtes().add(dte);
		dte.setEmisore(this);

		return dte;
	}

	public Dte removeDte(Dte dte) {
		getDtes().remove(dte);
		dte.setEmisore(null);

		return dte;
	}


	//bi-directional many-to-one association to Firmantes
	@OneToMany(mappedBy="emisore")
	public List<Firmantes> getFirmantes() {
		return this.firmantes;
	}

	public void setFirmantes(List<Firmantes> firmantes) {
		this.firmantes = firmantes;
	}

	public Firmantes addFirmante(Firmantes firmante) {
		getFirmantes().add(firmante);
		firmante.setEmisore(this);

		return firmante;
	}

	public Firmantes removeFirmante(Firmantes firmante) {
		getFirmantes().remove(firmante);
		firmante.setEmisore(null);

		return firmante;
	}

}