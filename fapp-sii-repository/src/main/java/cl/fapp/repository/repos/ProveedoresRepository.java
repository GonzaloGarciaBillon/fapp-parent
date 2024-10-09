package cl.fapp.repository.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import java.util.List;

import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.model.Proveedores;

@Repository
@RepositoryRestResource(exported = false)
public interface ProveedoresRepository extends JpaRepository<Proveedores, Long> {
    List<Proveedores> findByEmisor(Emisores emisor);
}
