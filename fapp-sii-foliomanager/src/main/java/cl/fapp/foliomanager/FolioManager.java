package cl.fapp.foliomanager;

import cl.fapp.repository.repos.CAFRepository;
import cl.fapp.repository.repos.DteRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;  // Para manejo de transacciones
import cl.fapp.foliomanager.domain.Folio;
import cl.fapp.foliomanager.exception.FoliosNotAvailableException;
import cl.fapp.foliomanager.exception.FoliosNotExistException;
import cl.fapp.repository.model.Caf;
import cl.fapp.repository.model.Dte;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
@Service
public class FolioManager {

    private static final Logger logger = LoggerFactory.getLogger(FolioManager.class);

    @Autowired
    CAFRepository cAFRepository;

    @Autowired
    DteRepository repoDte;

    /**
     * Obtiene el cardinal del folio disponible.
     * @param rutEmisor RUT del emisor
     * @param tipoDocumento Tipo de documento
     * @return Cardinal del folio
     */
    public Long getFolioCardinal(String rutEmisor, Integer tipoDocumento){
        Folio folio = getFolio(rutEmisor, tipoDocumento);
        return folio.getCardinal();
    }

    /**
     * Método encargado de obtener el folio disponible y asignarlo de manera segura.
     * Utiliza una transacción para garantizar que si algo falla, el folio quede disponible nuevamente.
     * @param rutEmisor RUT del emisor
     * @param tipoDocumento Tipo de documento
     * @return El folio asignado
     * @throws FoliosNotAvailableException Si no hay folios disponibles
     * @throws FoliosNotExistException Si no existe un CAF para el emisor
     */
    @Transactional(rollbackFor = Exception.class)  // Transacción para rollback en caso de fallo
    public Folio getFolio(String rutEmisor, Integer tipoDocumento)
        throws FoliosNotAvailableException, FoliosNotExistException {
        // Obtener la fecha actual para actualizar el CAF si es necesario
        Date fechaActualizacion = new Date();

        Optional<Caf> cafOpt = cAFRepository.findByEmisoreRutemisorAndTipoDocumentoAndEstado(rutEmisor, tipoDocumento, "DISPONIBLE");

        if (cafOpt.isPresent()) {
            Caf caf = cafOpt.get();
            Long folioMax = caf.getFolioMax();
            Integer foliosDisponibles = caf.getDisponibles();

            if (foliosDisponibles <= 0) {
                throw new FoliosNotAvailableException(
                    "No hay folios disponibles para emisor [" + rutEmisor + "] tipo documento [" + tipoDocumento + "]"
                );
            }

            Long folioAsignado = folioMax - foliosDisponibles + 1;

            while (isFolioAsignado(folioAsignado, rutEmisor, tipoDocumento)) {
                log.warn("El folio " + folioAsignado + " ya está asignado. Buscando el siguiente folio...");
                folioAsignado++;
            }

            Folio folio = new Folio();
            folio.setCardinal(folioAsignado);
            folio.setTagCaf(caf.getTagCaf());
            folio.setRsask(caf.getTagRsask());
            folio.setRutEmisor(caf.getEmisore().getRutemisor());

            logger.info("Folio obtenido: " + folio.getCardinal());

            caf.setUltimoFolioAsignado(folioAsignado);
            caf.setUpdatedat(new Date());

            // Guardar los cambios en el CAF
            cAFRepository.save(caf);

            // Decrementar los folios disponibles
            decrementarFoliosDisponibles(caf);

            return folio;
        } else {
            throw new FoliosNotExistException("No existe CAF para emisor [" + rutEmisor + "] tipo documento [" + tipoDocumento + "]");
        }
    }

    /**
     * Método auxiliar para verificar si un folio ya ha sido asignado a un DTE.
     * @param folio El número de folio a verificar.
     * @param rutEmisor RUT del emisor.
     * @param tipoDocumento Tipo de documento.
     * @return true si el folio ya está asignado, false en caso contrario.
     */
    private boolean isFolioAsignado(Long folio, String rutEmisor, Integer tipoDocumento) {
        Optional<Dte> dteExistente = repoDte.findByFolioAsignadoAndTipoDocumentoAndEmisoreRutemisor(folio, tipoDocumento, rutEmisor);
        return dteExistente.isPresent();
    }

    /**
     * Decrementa el contador de folios disponibles solo si todo el proceso fue exitoso.
     * @param caf El objeto CAF que se debe actualizar.
     */
    @Transactional(rollbackFor = Exception.class)  // Transacción para asegurar rollback si hay fallo
    public void decrementarFoliosDisponibles(Caf caf) {
        Integer foliosDisponibles = caf.getDisponibles();
        if (foliosDisponibles <= 0) {
            throw new FoliosNotAvailableException("No hay más folios disponibles para este CAF.");
        }

        // Actualiza los disponibles y marca el estado si es el último folio
        caf.setDisponibles(foliosDisponibles - 1);
        if (caf.getDisponibles() == 0) {
            caf.setEstado("UTILIZADO");
        }

        // Actualizar la fecha de modificación
        caf.setUpdatedat(new Date());

        // Guarda el cambio
        cAFRepository.save(caf);
        logger.info("Folio disponible actualizado correctamente. Folios restantes: " + caf.getDisponibles());

    }
}
