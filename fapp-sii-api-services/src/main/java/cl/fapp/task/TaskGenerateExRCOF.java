package cl.fapp.task;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.repository.model.Dte;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TaskGenerateExRCOF {

	@Autowired
	DteRepository repoDte;

	@Autowired
	EmisoresRepository repoEmisores;

	/**
	 * Inicia una tarea de tipo TaskGenerateExRCOF
	 */
	//@Scheduled(cron = "0 * * * * *", zone = "America/Santiago")
	public void init() {
		try {
			Date ahora = new Date();
			log.debug("Iniciando tarea " + this.getClass().getName() + " at " + ahora);

			// objetivo: obtener lista de emisores
			// por cada emisor->obtener lista de set de boletas
			// por cada boleta de un set -> sumar montos
			List<Dte> listadtes = repoDte.findByEstado(EntityDTEStatuses.SETDTEASIGNADO.toString());
			for (Dte dte : listadtes) {
				log.debug("DTE - id=" + dte.getIdDte() + ", setdte=" + dte.getSetdte().getIdSetdte());
			}

		} catch (Exception ex) {
			log.debug("Se produjo un error iniciando la tarea. Error=" + ex.getMessage());
		} finally {
			Date fin = new Date();
			log.debug("Finalizando tarea " + this.getClass().getName() + " at " + fin);
		}
	}
}
