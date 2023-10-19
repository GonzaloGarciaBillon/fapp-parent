package cl.fapp.repository.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cl.fapp.repository.model.Emisores;

@Repository
@RepositoryRestResource(exported = false)
public interface EmisoresRepository extends JpaRepository<Emisores, String> {


}