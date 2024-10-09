package cl.fapp.repository.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.fapp.repository.model.ActividadEconomica;
import cl.fapp.repository.model.EmisorActividad;
import cl.fapp.repository.model.Emisores;

@Repository
public interface EmisorActividadRepository extends JpaRepository<EmisorActividad, Long> {
    List<EmisorActividad> findByEmisor(Emisores emisor);
    List<EmisorActividad> findByEmisorAndActividadEconomica(Emisores emisor, ActividadEconomica actividadEconomica);
}
