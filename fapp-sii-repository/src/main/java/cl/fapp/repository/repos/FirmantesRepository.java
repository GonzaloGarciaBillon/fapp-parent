package cl.fapp.repository.repos;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cl.fapp.repository.model.Firmantes;

@Repository
@RepositoryRestResource(exported = false)
public interface FirmantesRepository extends JpaRepository<Firmantes, String> {
	// busca en la entidad Firmantes, por rutfirmante y rutemisor
	Optional<Firmantes> findByRutfirmanteAndEmisoreRutemisor(String rutfirmante, String rutemisor);
	boolean existsByRutfirmanteAndEmisoreRutemisor(String rutfirmante, String rutemisor);
	
	
	//Optional<Firmantes> findFirstByEmisoreRutemisorAndEstadoOrderByCreatedatDesc(String rutemisor, String estado);
	//Optional<Firmantes> findFirstByEmisoreRutemisorAndEstadoAndKeystoreFirmantesCertificateExpiryDateGreaterThanEqualOrderByCreatedatDesc(String rutemisor, String estado, Date ahora);
	Optional<Firmantes> findFirstByEmisoreRutemisorAndEstadoAndKeystoreFirmantesCertificateExpiryDateGreaterThanEqualOrderByKeystoreFirmantesCertificateExpiryDateDesc(String rutemisor, String estado, Date ahora);

}