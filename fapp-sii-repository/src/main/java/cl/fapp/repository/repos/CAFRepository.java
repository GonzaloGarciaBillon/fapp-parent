package cl.fapp.repository.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cl.fapp.repository.agg.IAggCafPorEmisor;
import cl.fapp.repository.model.Caf;

@Repository
@RepositoryRestResource(exported = false)
public interface CAFRepository extends JpaRepository<Caf, Long> {
	/**
	 * Busca en la entidad Firmantes, por rutfirmante y rutemisor
	 * 
	 * @param rutemisor     rut emisor
	 * @param tipoDocumento tipo de doumento (39 => boletas)
	 * @return caf asociado al emisor
	 */
	Optional<Caf> findByEmisoreRutemisorAndTipoDocumentoAndEstado(String rutemisor, Integer tipoDocumento, String estado);

	/**
	 * Busca registros con el numero de disponibles menor al valor indicado filtrado por estado
	 * 
	 * @param disponibles numero maximo por el cual buscar
	 * @param estado      filtra el estado del registro segun {@link EntityCAFStatuses}
	 * @return
	 */
	Optional<List<Caf>> findByDisponiblesLessThanEqualAndEstado(Integer disponibles, String estado);

	/**
	 * Consulta caf en estado 'disponible' para cada emisor. Retorna cuantos folios quedan disponibles y si se debe o no enviar una alarma
	 * 
	 * @param ticketType     tipo de ticket que se busca
	 * @param refEntity      entidad que referencia el id que se almacena
	 * @param estadoEmisor   estado del emisor
	 * @param estadoCaf      estado del caf
	 * @param minDisponibles minimo numero de folios disponibles antes de comenzar a enviar alarmas
	 * @return lista de emisores con el numero de folios restantes
	 */
	// @formatter:off
    @Query(value="select caf.id_caf as idCaf, emisores.rutemisor as rutEmisor, caf.tipo_documento as tipoDocumento, caf.disponibles, 'tipo1' as tipoAlarma\n"
    		+ " from emisores, caf\n"
    		+ " left join support_ticket tk on ( tk.ticket_type = :ticketType and tk.ref_entity = :refEntity and tk.ref_entity_id = caf.id_caf )"
    		+ " where emisores.rutemisor = caf.rutemisor\n"
    		+ " and emisores.estado = :estadoEmisor\n"
    		+ " and caf.estado= :estadoCaf\n"
    		+ " and caf.disponibles <= :minDisponibles\n"
    		+ " and tk.ticket_value is null", nativeQuery = true)
    Optional<List<IAggCafPorEmisor>> reportCafByEmisor(
    		@Param("ticketType")String ticketType,
    		@Param("refEntity")String refEntity,
    		@Param("estadoEmisor")String estadoEmisor, 
    		@Param("estadoCaf")String estadoCaf, 
    		@Param("minDisponibles")Integer minDisponibles );
    // @formatter:on

}