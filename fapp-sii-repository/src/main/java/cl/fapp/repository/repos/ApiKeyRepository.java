package cl.fapp.repository.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cl.fapp.repository.model.Apikey;

@Repository
@RepositoryRestResource(exported = false)
public interface ApiKeyRepository extends JpaRepository<Apikey, String> {
	boolean existsByEmisoreRutemisor(String rutemisor);

}