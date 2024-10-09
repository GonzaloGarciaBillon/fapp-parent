package cl.fapp.repository.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.fapp.repository.model.ActividadEconomica;

@Repository
public interface ActividadEconomicaRepository extends JpaRepository<ActividadEconomica, Long> {
    boolean existsByCodigo(String codigo);
    Optional<ActividadEconomica> findByCodigo(String codigo);
}
