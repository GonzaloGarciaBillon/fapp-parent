package cl.fapp.services.dtelocator;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.fapp.repository.model.Dte;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.services.dtelocator.dto.ServiceDTELocatorSimpleRequest;
import cl.fapp.services.dtelocator.dto.ServiceDTELocatorSimpleResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * Bean utilizado para localizar DTEs empleando una lista de parametros como filtro
 *
 */
@Slf4j
@Service
public class ServiceDTELocatorSimple {

	@Autowired
	DteRepository repoDTE;

	/**
	 * Realiza una busqueda simple de un DTE. 
	 * Si se indica UUID, utiliza este como llave del registro. 
	 * En caso contrario utiliza otras propiedades para localizar el DTE. 
	 * Se marca con @Transactional para que pueda hacer lazy loading de los datos del emisor relacionado.
	 * 
	 * @param request parametros de entrada
	 * @return un unico DTE que cumple con los criterios de busqueda
	 */
	@Transactional
	public ServiceDTELocatorSimpleResponse locatorSimple(ServiceDTELocatorSimpleRequest request) {
		try {
			ServiceDTELocatorSimpleResponse response;
			log.debug(request.getDteRutEmisor());
			log.debug(request.getDteUUID());
			if (request.getDteUUID() != null && !request.getDteUUID().isEmpty() && !request.getDteUUID().isBlank()) {
				// busca por uuid
				Optional<List<Dte>> dteEntity = repoDTE.findAllByDteUuidAndEmisoreRutemisor(request.getDteUUID(), request.getDteRutEmisor());
				if (dteEntity.isPresent()) {
					log.debug(dteEntity.get().get(0).toString());
					log.debug(dteEntity.get().get(0).getEmisore().toString());
					if (dteEntity.get().size() != 1) {
						log.error("Se encontro mas de un DTE que cumple con los criterios de busqueda. Request=" + request);
						throw new Exception("DTE no es unico");

					} else {
						response = new ServiceDTELocatorSimpleResponse();
						response.setDte(dteEntity.get().get(0));
						response.setEmisor(dteEntity.get().get(0).getEmisore());
						return response;
					}
				} else {
					log.warn("No se encontro DTE con uuid=" + request.getDteUUID());
					throw new Exception("No se encontro DTE con identificador indicado");
				}
			} else {

				// busca por el resto de los parametros
				Optional<List<Dte>> dteEntity = repoDTE.findAllByFolioAsignadoAndMontoAndTipoDocumentoAndEmisoreRutemisor(request.getDteFolioAsignado(), request.getDteMonto(), request.getDteTipoDocumento(), request.getDteRutEmisor());
				if (dteEntity.isPresent()) {
					if (dteEntity.get().size() != 1) {
						log.error("Se encontro mas de un DTE que cumple con los criterios de busqueda. Request=" + request);
						throw new Exception("No es posible localizar un unico DTE");

					} else {
						response = new ServiceDTELocatorSimpleResponse();
						response.setDte(dteEntity.get().get(0));
						response.setEmisor(dteEntity.get().get(0).getEmisore());
						log.debug("DTE retornado=" + response);
						return response;
					}
				} else {
					log.warn("No se encontro DTE con propiedades=" + request);
					throw new Exception("No se encontro DTE con el filtro indicado");
				}
			}

		} catch (Exception ex) {
			log.error("Se produjo un error ubicando el DTE. Error=" + ex.getMessage());
			return null;
		}
	}
}
