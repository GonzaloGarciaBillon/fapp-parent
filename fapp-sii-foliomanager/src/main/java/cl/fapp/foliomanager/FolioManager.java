package cl.fapp.foliomanager;

import cl.fapp.repository.repos.CAFRepository;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.fapp.foliomanager.domain.Folio;
import cl.fapp.foliomanager.exception.FoliosNotAvailableException;
import cl.fapp.foliomanager.exception.FoliosNotExistException;
import cl.fapp.repository.model.Caf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FolioManager {

    private static final Logger logger = LoggerFactory.getLogger(FolioManager.class);

    @Autowired
    CAFRepository cAFRepository;

    public Long getFolioCardinal(String rutEmisor, Integer tipoDocumento){
        Folio folio = getFolio(rutEmisor,tipoDocumento);
        return folio.getCardinal();
    }

    public Folio getFolio(String rutEmisor, Integer tipoDocumento)
            throws FoliosNotAvailableException, FoliosNotExistException {
        // verifica el emisor y el tipo de documento para el CAF
    	Date fechaActualizacion = new Date();
        Optional<Caf> caf = cAFRepository.findByEmisoreRutemisorAndTipoDocumentoAndEstado(rutEmisor, tipoDocumento, "DISPONIBLE");
        if (caf.isPresent()) {
            Long folioMax = caf.get().getFolioMax();
            Integer folioDisp = caf.get().getDisponibles();
            if (folioDisp <= 0) {
                throw new FoliosNotAvailableException(
                        "No hay folios disponibles para emisor [" + rutEmisor + "] tipo documento ["
                                + tipoDocumento + "]");
            } else {
                Folio folio = new Folio();
                folio.setCardinal(folioMax - folioDisp + 1);
                folio.setTagCaf(caf.get().getTagCaf());
                folio.setRsask(caf.get().getTagRsask());
                folio.setRutEmisor(caf.get().getEmisore().getRutemisor());
                
                // se actualiza el CAF
                if( (folioDisp - 1) == 0 ) {
                	caf.get().setEstado("UTILIZADO");
                }
                caf.get().setDisponibles(folioDisp - 1);
                caf.get().setUpdatedat(fechaActualizacion);
                
                cAFRepository.save(caf.get());
                // cAFRepository.updateDisponibles(folioDisp-1, caf.get().getIdCaf());
                logger.info("Folio obtenido: " + folio.getCardinal());
                return folio;
            }

        } else {
            throw new FoliosNotExistException("No existe CAF para emisor [" + rutEmisor + "] tipo documento ["
                    + tipoDocumento + "]");
        }
    }

}
