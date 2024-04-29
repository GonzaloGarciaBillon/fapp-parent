package cl.fapp.repository.repos;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.fapp.repository.agg.IAggNumeroDtePorEmisor;
import cl.fapp.repository.model.Dte;

@Repository
@RepositoryRestResource(exported = false)//(collectionResourceRel = "ddttee", path = "ddttee")
public interface DteRepository extends JpaRepository<Dte, Long> {
	/**
	 * Busca por rut emisor y estado del dte
	 * 
	 * @param emisoreRutemisor rut emisor
	 * @param estado           estado segun {@link EntityDTEStatuses}
	 * @return lista de dte
	 */
	List<Dte> findByEmisoreRutemisorAndEstado(String emisoreRutemisor, String estado);

	/**
	 * Busca por rut emisor y estado del dte
	 * 
	 * @param emisoreRutemisor rut emisor
	 * @param estado           estado segun {@link EntityDTEStatuses}
	 * @param tipoDocumento    tipo de documento
	 * @return lista de dte
	 */
	List<Dte> findByEmisoreRutemisorAndEstadoAndTipoDocumentoIn(String emisoreRutemisor, String estado, List<Integer> tipoDocumento);

	/**
	 * Busca por estado
	 * 
	 * @param estado estado segun {@link EntityDTEStatuses}
	 * @return lista de dte
	 */
	List<Dte> findByEstado(String estado);

	/**
	 * Busca por id y estado
	 * 
	 * @param estado estado segun {@link EntityDTEStatuses}
	 * @return lista de dte que cumplen el criterio
	 */
	Optional<Dte> findByIdDteAndEstado(Long iddte, String estado);

	/**
	 * Actualiza la referencia a setdte para cada dte que se indica en la lista
	 * 
	 * @param idsetdte  identificador del setdte al cual pertenece este dte
	 * @param iddteList lista de dte que forman el grupo
	 * @param newstatus estado en que quedan los dte
	 * @return lista de dte
	 */
	@Transactional
	@Modifying
	@Query("update Dte d set d.setdte.idSetdte=:idsetdte, d.estado=:newstatus where d.idDte in (:ids)")
	//@RestResource(exported = false)
	void updateByIds(@Param("idsetdte") Long idsetdte, @Param("ids") List<Long> iddteList, @Param("newstatus") String newstatus);

	/**
	 * Busca por fecha de creacion (fecha de emision) entre las indicadas como parametro
	 * 
	 * @param fechaDesde fecha desde
	 * @param fechaHasta fecha hasta
	 * @return lista de dte que cumplen el criterio de busqueda
	 */
	List<Dte> findAllByCreatedatBetween(Date fechaDesde, Date fechaHasta);

	/**
	 * Busca por fecha de creacion (fecha de emision) entre las indicadas como parametro en el estado indicado
	 * 
	 * @param fechaDesde fecha desde
	 * @param fechaHasta fecha hasta
	 * @param estado     estado en que deben encontrarse los registros retornados
	 * @return lista de dte que cumplen el criterio de busqueda
	 */
	List<Dte> findAllByCreatedatBetweenAndEstado(Date fechaDesde, Date fechaHasta, String estado);

	/**
	 * Busca por fecha de creacion (fecha de emision) entre las indicadas como parametro en el estado indicado
	 * 
	 * @param fechaDesde      fecha desde
	 * @param fechaHasta      fecha hasta
	 * @param estado          estado en que deben encontrarse los registros retornados
	 * @param <tipoDocumento> lista de tipos de documento a buscar
	 * @return lista de dte que cumplen el criterio de busqueda
	 */
	List<Dte> findAllByCreatedatBetweenAndEstadoAndTipoDocumentoIn(Date fechaDesde, Date fechaHasta, String estado, List<Integer> tipoDocumento);

	/**
	 * Busca por fecha de creacion (fecha de emision) entre las indicadas como parametro en el estado indicado
	 * 
	 * @param emisoreRutemisor rut del emisor
	 * @param fechaDesde       fecha desde
	 * @param fechaHasta       fecha hasta
	 * @param estado           estado en que deben encontrarse los registros retornados
	 * @param <tipoDocumento>  lista de tipos de documento a buscar
	 * @return lista de dte que cumplen el criterio de busqueda
	 */
	List<Dte> findAllByEmisoreRutemisorAndCreatedatBetweenAndEstadoAndTipoDocumentoIn(String emisoreRutemisor, Date fechaDesde, Date fechaHasta, String estado, List<Integer> tipoDocumento);

	/**
	 * Busca por dtes que cumplan los filtros y el rango de fechas
	 * 
	 * @param emisoreRutemisor rut del emisor
	 * @param tipoDocumento    list de tipo documento a buscar
	 * @param estado           lista de estados en que deben encontrarse los registros retornados
	 * @param fechaDesde       fecha desde
	 * @param fechaHasta       fecha hasta
	 * @return lista de dte que cumplen el criterio de busqueda
	 */
	Optional<List<Dte>> findAllByEmisoreRutemisorAndTipoDocumentoInAndEstadoInAndCreatedatBetween(String emisoreRutemisor, List<Integer> tipoDocumento, List<String> estado, Date fechaDesde, Date fechaHasta);

	/**
	 * Busca por dtes que cumplan los filtros (no incluye rango de fechas)
	 * 
	 * @param emisoreRutemisor rut del emisor
	 * @param tipoDocumento    list de tipo documento a buscar
	 * @param estado           lista de estados en que deben encontrarse los registros retornados
	 * @return lista de dte que cumplen el criterio de busqueda
	 */
	Optional<List<Dte>> findAllByEmisoreRutemisorAndTipoDocumentoInAndEstadoIn(String emisoreRutemisor, List<Integer> tipoDocumento, List<String> estado);

	/**
	 * Busca por dtes que cumplan los filtros
	 * 
	 * @param dteUuid   uuid asignado al DTE
	 * @param rutEmisor rut del emisor
	 * @return dte que cumple el criterio de busqueda
	 */
	Optional<List<Dte>> findAllByDteUuidAndEmisoreRutemisor(String dteUuid, String rutEmisor);

	/**
	 * Busca por dtes que cumplan los filtros
	 * 
	 * @param folioAsignado numero de folio
	 * @param monto         monto del dte
	 * @param tipoDocumento tipo de dte
	 * @param rutEmisor     rut del emisor
	 * @return dte que cumple los criterios de busqueda
	 */
	Optional<List<Dte>> findAllByFolioAsignadoAndMontoAndTipoDocumentoAndEmisoreRutemisor(Long folioAsignado, BigInteger monto, Integer tipoDocumento, String rutEmisor);

	/**
	 * Busca por folio, rut emisor y tipo de documento.
	 * 
	 * @param folioAsignado   número de folio del DTE
	 * @param rutEmisor       rut del emisor del DTE
	 * @param tipoDocumento   tipo de documento del DTE
	 * @return lista de DTE que cumplen los criterios de búsqueda
	 */
	List<Dte> findByFolioAsignadoAndEmisoreRutemisorAndTipoDocumento(Long folioAsignado, String rutEmisor, Integer tipoDocumento);
	
	/**
	 * Reporta numero de dtes en estadoDte, por emisor en estadoEmisor
	 * 
	 * @param estadoEmisor en que estado debe encontrarse el Emisor
	 * @param estadoDte    en que estado debe encontrarse el Dte
	 * @param tipoDocumento tipos de documento por el cual agrupar
	 * @param tamanoParticion numero de dte's por particion
	 * @return lista de Dte en estadoDte, por emisor en estadoEmisor
	 */
	/*
	// @formatter:off
	@Query(value="select emisores.rutemisor as rutEmisor,\n"
			   + "       dte.tipo_documento as tipoDocumento,\n"
			   + "       count(*) as nroDtes,\n"
			   + "       div(count(*), :tamanoParticion) as nroIteraciones,\n"
			   + "       (count(*) % :tamanoParticion) as dtesRemanentes,\n"
			   + "       array_to_string(array_agg(folio_asignado), ',') as listaFolios\n"
			   + "  from emisores\n"
			   + "  join dte on emisores.rutemisor=dte.rutemisor\n"
			   + "          and emisores.estado=:estadoEmisor\n"
			   + "          and dte.estado=:estadoDte\n"
			   + "          and dte.tipo_documento=:tipoDocumento\n"
			   + " group by emisores.rutemisor, dte.tipo_documento\r\n", nativeQuery = true)
	// @formatter:on
	*/
	// @formatter:off
	@Query(value="select emisores.rutemisor as rutEmisor,\n"
			+ "       f.rutfirmante as rutFirmante,\n"
			+ "       :tamanoParticion as tamanoParticion,\n"
			+ "       count(*) as nroDtes,\n"
			+ "       div(count(*), :tamanoParticion) as nroIteraciones,\n"
			+ "       (count(*) % :tamanoParticion) as dtesRemanentes\n"
			//+ "       array_to_string(array_agg(folio_asignado), ',') as listaFolios\n"
			+ "  from emisores\n"
			+ "  join dte on emisores.rutemisor=dte.rutemisor and dte.estado=:estadoDte and dte.tipo_documento in (:tipoDocumento) and emisores.estado=:estadoEmisor\n"
			+ "  join firmantes f on emisores.rutemisor=f.rutemisor\n"
			+ "  join keystore_firmantes kf on kf.id_firmante=f.id_firmante and kf.certificate_expiry_date >= :ahora\n"
			+ " group by emisores.rutemisor, f.rutfirmante", nativeQuery = true) //, dte.tipo_documento", nativeQuery = true)
	// @formatter:on
	Optional<List<IAggNumeroDtePorEmisor>> reportNumeroDtePorEmisor(
			@Param("estadoEmisor")String estadoEmisor, 
			@Param("estadoDte")String estadoDte, 
			@Param("tipoDocumento")List<Integer> tipoDocumento, 
			@Param("tamanoParticion")Integer tamanoParticion,
			@Param("ahora")Date ahora);

}