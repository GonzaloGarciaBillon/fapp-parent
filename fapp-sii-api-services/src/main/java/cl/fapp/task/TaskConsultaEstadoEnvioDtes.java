package cl.fapp.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import cl.fapp.common.domain.statuses.EntityEnvioDTEStatuses;
import cl.fapp.repository.model.Setdte;
import cl.fapp.repository.repos.SetDTERepository;

public class TaskConsultaEstadoEnvioDtes {
    
    // @Autowired
    // private DTE setdteRepo;

    @Autowired
    TaskUtilsService taskUtils;

    @Value("${fapp.task.consultaEstadoEnvioDTEs.cron}")
    private String SCHEDULER_EXPRESSION;

    /**
     * Consulta el estado de los DTE en el SII.
     */
    @Scheduled(cron = "${fapp.task.consultaEstadoEnvioDTEs.cron}")
    public void consultarEstadoDTE() {
        // List<Setdte> dtesPendientes = setdteRepo.findAllByEstadoNotIn(EntityEnvioDTEStatuses.);

        // for (Setdte dte : dtesPendientes) {
            // String estadoActual = siiService.consultarEstadoDTE(dte.getTrackid());
            // Logica para actualizar el estado en tu sistema
            // if (estadoActual != null && !estadoActual.equals(dte.getEstado())) {
            //     dte.setEstado(estadoActual);
            //     // setdteRepo.save(dte);
            // }
        // }
    }
}
