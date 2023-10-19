package cl.fapp.repository.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.fapp.repository.model.Setdte;

@Repository
@RepositoryRestResource(exported = false)
public interface SetDTERepository extends JpaRepository<Setdte, Long> {
	
	/**
	 * Busca por identificador y estado particular
	 * @param idsetdte identificador del registro
	 * @param estado estado en que debe encontrarse el registro
	 * @return
	 */
	Optional<Setdte> findByIdSetdteAndEstado(Long idsetdte, String estado);

	/**
	 * Actualiza el estado del setdte que se indica por parametro
	 * @param idsetdte identificador del setdte al cual cambiar el estado
	 * @param newstatus estado en que queda el setdte
	 * @return 
	 */
	@Transactional
	@Modifying
	@Query("update Setdte d set d.estado=:newstatus where d.idSetdte=:idsetdte")
	void updateByIdSetdte(@Param("idsetdte") Long idsetdte, @Param("newstatus") String newstatus);
	
	/**
	 * Busca setdte por estado y tipo de set
	 * @param estadoSetdte estado del set
	 * @param tipoSet tipo de set
	 * @return lista de setdte que cumplen los criterios de busqueda
	 */
	Optional<List<Setdte>> findByEstadoAndTipoSetOrderByIntentosEnvioDesc(String estadoSetdte, String tipoSet);

	Optional<List<Setdte>> findByEstadoAndTipoSetAndRutemisorIsNullAndRutfirmanteIsNullOrderByIntentosEnvioDesc(String estadoSetdte, String tipoSet);
}