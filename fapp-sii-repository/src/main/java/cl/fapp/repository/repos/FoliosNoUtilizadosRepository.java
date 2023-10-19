package cl.fapp.repository.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cl.fapp.repository.model.FoliosNoutilizado;

@Repository
@RepositoryRestResource(exported = false)
public interface FoliosNoUtilizadosRepository extends JpaRepository<FoliosNoutilizado, Long> {

}