package cl.fapp.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.domain.EntityTaskNames;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.common.domain.statuses.EntityEmisoresStatuses;
import cl.fapp.common.domain.statuses.EntityTaskStatuses;
import cl.fapp.repository.agg.IAggNumeroDtePorEmisor;
import cl.fapp.repository.model.Task;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.restapi.controller.boleta.GenerarBoletasSetDTEController;
import cl.fapp.restapi.controller.boleta.dto.GenerarSetDTERequest;
import cl.fapp.restapi.controller.boleta.dto.GenerarSetDTEResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TaskSetBoletasCreator {
	// private final static String THIS_TASK_REF_ENTITY = "SETDTE";

	@Autowired
	DteRepository dteRepo;

	@Autowired
	GenerarBoletasSetDTEController controllerGenerarSet;
	
	@Autowired
	TaskUtilsService taskUtils;
	
	@Value("${fapp.task.setboletas.creator.cron}")
	private String SCHEDULER_EXPRESSION;
	
	@Value("${fapp.task.setboletas.partition.size:1}")
	private Integer TAMANO_PARTICION;
	
	@Value("${fapp.task.setboletas.group.remainder:true}")
	private Boolean GROUP_REMAINDER;

	/**
	 * Inicia una tarea de tipo TaskBoletasSetCreator 
	 * &lt;second&gt;&lt;minute&gt;&lt;hour&gt;&lt;day of month&gt;&lt;month&gt;&lt;day of week&gt;
	 */
	@Scheduled(cron = "${fapp.task.setboletas.creator.cron}")
	public void init() {
		String myTaskName = EntityTaskNames.TASK_SETBOLETAS_CREATOR.getValue();
		String myClassName = String.format("[%s]", this.getClass().getName());
		String lastMessage = "";
		Date initTaskTimestamp = new Date();

		log.debug("**** Iniciando tarea " + myClassName + " at " + initTaskTimestamp + " ****");

		Optional<Task> taskRecord = null;
		try {
			// recupera registro de la tarea
			taskRecord = taskUtils.findByNameIgnoreCase(myTaskName);
			if (!taskRecord.isPresent()) {
				log.error("No se encuentra registro para task name=" + myTaskName);
				throw new Exception("No se encuentra registro para task name=" + myTaskName);
			}

			// verifica estado de la tarea
			if (!taskRecord.get().getStatus().equalsIgnoreCase(EntityTaskStatuses.HABILITADA.getValue())) {
				log.warn("La tarea name=" + myTaskName + ", no se encuentra en estado=" + EntityTaskStatuses.HABILITADA.getValue() + ". Estado actual=" + taskRecord.get().getStatus().toUpperCase());
				throw new Exception("La tarea name=" + myTaskName + " no esta habilitada");
			} else {
				log.info("La tarea name=" + myTaskName + ", se encuentra " + EntityTaskStatuses.HABILITADA.getValue());
			}

			// ----------------------------------------------------------------------------------------------
			// la tarea puede ser ejecutada
			log.debug("Creando set de boletas por cada emisor. Se incluyen boletas (afecta, exenta) en estado 'creadofirmado'...");

			List<Integer> tiposDocumentoEnSet = new ArrayList<Integer>();
			tiposDocumentoEnSet.add(ConstantesTipoDocumento.BOLETA_AFECTA.getValue());
			tiposDocumentoEnSet.add(ConstantesTipoDocumento.BOLETA_EXENTA.getValue());

			// @formatter:off
			// test query dte
			List<SetDteDTO> listIdSetdte = new ArrayList<SetDteDTO>();
			Optional<List<IAggNumeroDtePorEmisor>> yy = dteRepo.reportNumeroDtePorEmisor(
					EntityEmisoresStatuses.ACTIVO.getValue(), 
					EntityDTEStatuses.CREADOFIRMADO.getValue(), 
					tiposDocumentoEnSet, 
					TAMANO_PARTICION, 
					new Date());
			// @formatter:on
			if (!yy.isPresent() || (yy.isPresent() && yy.get().isEmpty())) {
				log.error("No se encontraron Boletas (exentas, afectas) para formar un set...");
				lastMessage = "No se encontraron Boletas (exentas, afectas) para formar un set...";

			} else {
				boolean procesarRestos = GROUP_REMAINDER;
				for (IAggNumeroDtePorEmisor item : yy.get()) {
				
					log.debug("-----------------------------------------------------------");
					log.debug("Item=" + item.getRutEmisor() + ", numeroDtes=" + item.getNroDtes() + ", iteraciones=" + item.getNroIteraciones() + ", resto=" + item.getDtesRemanentes() + ", tamanoParticion=" + item.getTamanoParticion());
					
					// cada iteracion es una particion de tamano TAMANO_PARTICION
					for (int i = 0; i < item.getNroIteraciones(); i++) {
						// prepara request para servicio que genera el set (limitando a TAMANO_PARTICION)
						GenerarSetDTERequest request = new GenerarSetDTERequest();
						request.setNroMaxDteEnSet(item.getTamanoParticion());
						request.setRutEmisor(item.getRutEmisor());
						request.setRutFirmante(item.getRutFirmante());

						// genera el set
						GenerarSetDTEResponse idNewSetDte = execControllerGenerarBoletaSetDte(item, request);
						
						// agrega el set generado a la respuesta
						SetDteDTO setDtedto = new SetDteDTO();
						setDtedto.setRutEmisor(idNewSetDte.getRutEmisor());
						setDtedto.setIdSetdte(idNewSetDte.getIdSetBoletas());
						setDtedto.setNroDtes(idNewSetDte.getNroBoletas());
						
						// acumula la respuesta
						listIdSetdte.add(setDtedto);
					}

					// verifica si debe agregar los remanentes
					if (procesarRestos && item.getDtesRemanentes() > 0) {
						// prepara request (limita a remanentes)
						GenerarSetDTERequest request = new GenerarSetDTERequest();
						request.setNroMaxDteEnSet(item.getDtesRemanentes());
						request.setRutEmisor(item.getRutEmisor());
						request.setRutFirmante(item.getRutFirmante());

						// genera el set con los remanentes
						GenerarSetDTEResponse idNewSetDte = execControllerGenerarBoletaSetDte(item, request);
						
						// agrega el set de remanentes a la respuesta
						SetDteDTO setDtedto = new SetDteDTO();
						setDtedto.setRutEmisor(idNewSetDte.getRutEmisor());
						setDtedto.setIdSetdte(idNewSetDte.getIdSetBoletas());
						setDtedto.setNroDtes(idNewSetDte.getNroBoletas());
						
						// acumula la respuesta
						listIdSetdte.add(setDtedto);
					}
					
					lastMessage = "SetDteCreados(" + listIdSetdte.toString() + ")";
				}
			}

			// fin ejecucion de la tarea
			return;

		} catch (Exception ex) {
			lastMessage = ex.getMessage();
			log.error("Ocurrio una excepcion ejecutando la tarea " + myClassName + ". Mensaje=" + lastMessage);

		} finally {
			Date endTaskTimestamp = new Date();
			if (taskRecord != null && taskRecord.isPresent() && taskRecord.get().getStatus().equalsIgnoreCase(EntityTaskStatuses.HABILITADA.getValue())) {
				taskUtils.registerTaskExecution(taskRecord.get(), SCHEDULER_EXPRESSION, initTaskTimestamp, endTaskTimestamp, lastMessage);
			}
			log.debug("**** Finalizando tarea " + this.getClass().getName() + " at " + endTaskTimestamp + " ****");
		}
	}
	
	private GenerarSetDTEResponse execControllerGenerarBoletaSetDte(IAggNumeroDtePorEmisor item, GenerarSetDTERequest request) {

		GenerarSetDTEResponse resp = controllerGenerarSet.internalGenerarBoletasSetDte(request);
		if (resp.getIdSetBoletas()==null) {
			log.error("Se produjo un error invocando el controller...");
			
		} else {
			log.debug("Se genero el set sin problemas. Response=" + resp);
		}
		
		return resp;
	}

	@Getter
	@Setter
	@NoArgsConstructor
	private class SetDteDTO{
		private String rutEmisor;
		private Long idSetdte;
		private Integer nroDtes;
		
		@Override
		public String toString() {
			return "[emisor=" + rutEmisor + ", idSet=" + idSetdte + ", boletas=" + nroDtes + "]";
		}
		
		
	}
}
