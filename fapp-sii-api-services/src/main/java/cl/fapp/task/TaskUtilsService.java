package cl.fapp.task;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.fapp.repository.model.Task;
import cl.fapp.repository.repos.TaskRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TaskUtilsService {
	
	@Autowired
	TaskRepository repoTask;
	
	/**
	 * Busca registro de tarea por su nombre, ignorando el case
	 * @param taskName nombre de la tarea
	 * @return registro en la base de datos para la tarea indicada
	 */
	public Optional<Task> findByNameIgnoreCase(String taskName){
		return repoTask.findByNameIgnoreCase(taskName);		
	}

	/**
	 * Actualiza los datos de la tarea
	 * 
	 * @param taskRecord    instancia de la entidad Task
	 * @param schedulerExpression expresion cron con la que se ejecuta la tarea. Solo informativa. Si se desea cambiar debe ser por configuracion
	 * @param initTimestamp fecha/hora de inicio de la ultima ejecucion de la tarea
	 * @param endTimestamp  fecha/hora de fin de la ultima ejecucion de la tarea
	 * @param lastMessage   ultimo mensaje generado por la tareas
	 */
	public void registerTaskExecution(Task taskRecord, String schedulerExpression, Date initTimestamp, Date endTimestamp, String lastMessage) {
		try {
			log.debug("Actualizando datos para task=" + taskRecord.getName());
			taskRecord.setLastExecTimestamp(initTimestamp);
			
			if( lastMessage != null ) {
				String lastMessageTruncated = lastMessage.substring(0, Math.min(lastMessage.length(), 4096));
				taskRecord.setLastResultMessage(lastMessageTruncated);
			}else {
				taskRecord.setLastResultMessage(null);
			}
			
			taskRecord.setUpdatedat(endTimestamp);
			taskRecord.setScheduledExpression("READONLY-[ cron=\"" + schedulerExpression + "\" ]");
			repoTask.save(taskRecord);
		} catch (Exception ex) {
			log.error("No fue posible actualizar registro en Task. Error=" + ex.getMessage());
		}
	}
}
