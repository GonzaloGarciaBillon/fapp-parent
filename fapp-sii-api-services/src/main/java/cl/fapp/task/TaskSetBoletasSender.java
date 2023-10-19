package cl.fapp.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cl.fapp.common.domain.EntitySetDteTipoSet;
import cl.fapp.common.domain.EntityTaskNames;
import cl.fapp.common.domain.statuses.EntitySetDTEStatuses;
import cl.fapp.common.domain.statuses.EntityTaskStatuses;
import cl.fapp.repository.model.Setdte;
import cl.fapp.repository.model.Task;
import cl.fapp.repository.repos.SetDTERepository;
import cl.fapp.restapi.controller.boleta.EnviarBoletaSetDTEController;
import cl.fapp.restapi.controller.boleta.dto.EnviarBoletaSetDTERequest;
import cl.fapp.restapi.controller.boleta.dto.EnviarBoletaSetDTEResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TaskSetBoletasSender {
	private final static String THIS_TASK_REF_ENTITY = "SETDTE";

	@Autowired
	SetDTERepository setdteRepo;

	@Autowired
	EnviarBoletaSetDTEController controllerEnviarSet;

	@Autowired
	TaskUtilsService taskUtils;

	@Value("${fapp.task.setboletas.sender.cron}")
	private String SCHEDULER_EXPRESSION;

	/**
	 * Inicia una tarea de tipo TaskSetBoletasSender &lt;second&gt;&lt;minute&gt;&lt;hour&gt;&lt;day of month&gt;&lt;month&gt;&lt;day of week&gt;
	 */
	@Scheduled(cron = "${fapp.task.setboletas.sender.cron}")
	public void init() {
		String myTaskName = EntityTaskNames.TASK_SETBOLETAS_SENDER.getValue();
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
			log.debug("Se intenta enviar todos los set pendientes de envio. Se realiza por emisor...");

			// @formatter:off
			Optional<List<Setdte>> listaSetdte = setdteRepo.findByEstadoAndTipoSetOrderByIntentosEnvioDesc(
					EntitySetDTEStatuses.ENVIOPENDIENTE.getValue(), 
					EntitySetDteTipoSet.BOLETA.getValue());
			// @formatter:on
			if (!listaSetdte.isPresent() || (listaSetdte.isPresent() && listaSetdte.get().isEmpty())) {
				log.error("No se encontraron set de boletas que deban ser enviados...");
				lastMessage = "No se encontraron set de boletas que deban ser enviados...";

			} else {
				String token = null;
				String keytoken = null;
				HashMap<String,String> listaToken = new HashMap<String, String>();
				List<EnvioSetDteResponseDTO> listaResponse = new ArrayList<EnvioSetDteResponseDTO>();
				for (Setdte item : listaSetdte.get()) {
					// arma la llave utilizada para manejar los token en esta ejecucion
					keytoken = item.getRutemisor() + "#" + item.getRutfirmante();
					
					log.debug("Se inicia envio de idSetDte=" + item.getIdSetdte() + ", keytoken=" + keytoken);

					// si la llave ya tiene asociado un token, lo reutiliza
					if( listaToken.containsKey(keytoken) && listaToken.get(keytoken)!=null) {
						token = listaToken.get(keytoken);
						log.debug("Reutiliza token=" + token);
					}else {
						token = null;
						log.debug("Se solicitara un nuevo token");						
					}

					// prepara el request al servicio que realizara el envio
					EnviarBoletaSetDTERequest enviarSetRequest = new EnviarBoletaSetDTERequest();
					enviarSetRequest.setIdSetDte(item.getIdSetdte());
					enviarSetRequest.setRutEmisor(item.getRutemisor());
					enviarSetRequest.setRutFirmante(item.getRutfirmante());
					enviarSetRequest.setToken(token);

					// realiza el envio
					EnviarBoletaSetDTEResponse envioSetResponse = controllerEnviarSet.internalEnviarBoletaSetDte(enviarSetRequest);
					if (envioSetResponse.getTrackid() != null) {
						log.debug("Envio correcto idSetDte=" + envioSetResponse.getIdSetDte() + ". Trackid=" + envioSetResponse.getTrackid());
						// @formatter:off
						listaResponse.add(new EnvioSetDteResponseDTO(
								envioSetResponse.getIdSetDte(), 
								envioSetResponse.getTrackid(), 
								null));
						// @formatter:on

					} else {
						log.error("Envio fallido idSetDte=" + envioSetResponse.getIdSetDte() + ". Message=" + envioSetResponse.getErrorMessage());
						// @formatter:off
						listaResponse.add(new EnvioSetDteResponseDTO(
								envioSetResponse.getIdSetDte(), 
								null, 
								envioSetResponse.getErrorMessage()));
						// @formatter:on
					}
					
					// si la respuesta contiene un token, lo guarda asociado a rut emisor/firmante, siempre que este ya no este asociado
					if( envioSetResponse.getToken()!=null ) {
						if( !listaToken.containsKey(keytoken) ) {
							listaToken.put(keytoken, envioSetResponse.getToken());
						}
					}
					
					log.debug("Finaliza envio de idSetDte=" + item.getIdSetdte() + ", keytoken=" + keytoken);
				}
				
				lastMessage = "SetDteEnviados(" + listaResponse.toString() + ")";
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

	@Getter
	@Setter
	@AllArgsConstructor
	private class EnvioSetDteResponseDTO {
		private Long idSetdte;
		private String trackid;
		private String message;
		
		@Override
		public String toString() {
			String messageTruncated = message==null?null:message.substring(0, Math.min(message.length(), 100));
			return "[" + idSetdte + ", " + trackid + ", " + messageTruncated + "]";
		}
	}
}
