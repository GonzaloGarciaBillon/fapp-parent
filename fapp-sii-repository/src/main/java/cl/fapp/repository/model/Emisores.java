package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the emisores database table.
 * 
 */
@Entity
@Table(name = "emisores")
@NamedQuery(name = "Emisores.findAll", query = "SELECT e FROM Emisores e")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
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
	private Integer id_template;
	private Date updatedat;
	private List<Apikey> apikeys;
	private List<Caf> cafs;
	private List<Dte> dtes;
	private List<Firmantes> firmantes;
	private List<Impresoras> impresoras;
	private List<Productos> productos;
	private List<Proveedores> proveedores;
	private List<Clientes> clientes;
	private List<Recepcion> recepciones;
	private List<RecepcionDte> dtesRecepcion;
	
	@OneToMany(mappedBy = "emisor")
	private List<EmisorActividad> emisorActividades;

	public Emisores() {
		// Constructor vacio
	}

	@Id
	@Column(unique = true, nullable = false, length = 20)
	public String getRutemisor() {
		return this.rutemisor;
	}

	public void setRutemisor(String rutemisor) {
		this.rutemisor = rutemisor;
	}

	@Column(length = 128)
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Column(name = "codigo_resolucion", length = 128)
	public String getCodigoResolucion() {
		return this.codigoResolucion;
	}

	public void setCodigoResolucion(String codigoResolucion) {
		this.codigoResolucion = codigoResolucion;
	}

	@Column(name = "codigo_sii", length = 128)
	public String getCodigoSii() {
		return this.codigoSii;
	}

	public void setCodigoSii(String codigoSii) {
		this.codigoSii = codigoSii;
	}

	@Column(name = "codigo_sucursal", length = 64)
	public String getCodigoSucursal() {
		return this.codigoSucursal;
	}

	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	@Column(length = 128)
	public String getComuna() {
		return this.comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	public Date getCreatedat() {
		return this.createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	@Column(length = 256)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(length = 256)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = false, length = 16)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_resolucion")
	public Date getFechaResolucion() {
		return this.fechaResolucion;
	}

	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	@Column(nullable = false, length = 256)
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

	@Column(length = 2147483647)
	public String getMetadata() {
		return this.metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	@Column(name = "razon_social", length = 256)
	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Column(length = 24)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "id_template")
	@ColumnDefault("1")
	public Integer getIdTemplate() {
		return this.id_template;
	}

	public void setIdTemplate(Integer idTemplate) {
		this.id_template = idTemplate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedat() {
		return this.updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}

	// bi-directional many-to-one association to Apikey
	@OneToMany(mappedBy = "emisore")
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

	// bi-directional many-to-one association to Caf
	@OneToMany(mappedBy = "emisore")
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

	// bi-directional many-to-one association to Dte
	@OneToMany(mappedBy = "emisore")
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

	// bi-directional many-to-one association to Firmantes
	@OneToMany(mappedBy = "emisore")
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

	// bi-directional many-to-one association to Impresoras
	@OneToMany(mappedBy = "cliente")
	public List<Impresoras> getImpresoras() {
		return this.impresoras;
	}

	public void setImpresoras(List<Impresoras> impresoras) {
		this.impresoras = impresoras;
	}

	public Impresoras addImpresoras(Impresoras impresora) {
		getImpresoras().add(impresora);
		impresora.setCliente(this);

		return impresora;
	}

	public Impresoras removeImpresoras(Impresoras impresora) {
		getImpresoras().remove(impresora);
		impresora.setCliente(null);

		return impresora;
	}

	// bi-directional many-to-one association to Productos
	@OneToMany(mappedBy = "emisor")
	public List<Productos> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	public Productos addProductos(Productos producto) {
		getProductos().add(producto);
		producto.setEmisor(this);

		return producto;
	}

	public Productos removeProductos(Productos producto) {
		getProductos().remove(producto);
		producto.setEmisor(null);

		return producto;
	}

	// bi-directional many-to-one association to Proveedores
	@OneToMany(mappedBy = "emisor")
	public List<Proveedores> getProveedores() {
		return this.proveedores;
	}

	public void setProveedores(List<Proveedores> proveedores) {
		this.proveedores = proveedores;
	}

	public Proveedores addProveedores(Proveedores proveedor) {
		getProveedores().add(proveedor);
		proveedor.setEmisor(this);

		return proveedor;
	}

	public Proveedores removeProveedores(Proveedores proveedor) {
		getProveedores().remove(proveedor);
		proveedor.setEmisor(null);

		return proveedor;
	}

	// bi-directional many-to-one association to Clientes
	@OneToMany(mappedBy = "emisor")
	public List<Clientes> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Clientes> clientes) {
		this.clientes = clientes;
	}

	public Clientes addCliente(Clientes cliente) {
		getClientes().add(cliente);
		cliente.setEmisor(this);

		return cliente;
	}

	public Clientes removeCliente(Clientes cliente) {
		getClientes().remove(cliente);
		cliente.setEmisor(null);

		return cliente;
	}

	// bi-directional many-to-one association to Recepcion
	@OneToMany(mappedBy = "rutReceptor")
	public List<Recepcion> getRecepciones() {
		return this.recepciones;
	}

	public void setRecepciones(List<Recepcion> recepciones) {
		this.recepciones = recepciones;
	}

	public Recepcion addRecepcion(Recepcion recepcion) {
		getRecepciones().add(recepcion);
		recepcion.setRutReceptor(this);

		return recepcion;
	}

	public Recepcion removeRecepcion(Recepcion recepcion) {
		getRecepciones().remove(recepcion);
		recepcion.setRutReceptor(null);

		return recepcion;
	}

	@OneToMany(mappedBy = "rutReceptor")
	public List<RecepcionDte> getDtesRecepcion() {
		return this.dtesRecepcion;
	}

	public void setDtesRecepcion(List<RecepcionDte> dtesRecepcion) {
		this.dtesRecepcion = dtesRecepcion;
	}

	public RecepcionDte addDtesRecepcion(RecepcionDte dtesRecepcion) {
		getDtesRecepcion().add(dtesRecepcion);
		dtesRecepcion.setRutReceptor(this);

		return dtesRecepcion;
	}

	public RecepcionDte removeDtesRecepcion(RecepcionDte dtesRecepcion) {
		getDtesRecepcion().remove(dtesRecepcion);
		dtesRecepcion.setRutReceptor(null);

		return dtesRecepcion;
	}

}