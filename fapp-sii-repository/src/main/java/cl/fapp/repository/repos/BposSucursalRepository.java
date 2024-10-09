package cl.fapp.repository.repos;

import cl.fapp.repository.model.BposSucursal;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BposSucursalRepository extends JpaRepository<BposSucursal, Long> {
    Optional<BposSucursal> findBySerieBpos(String serieBpos);
}