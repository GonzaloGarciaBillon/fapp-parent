package cl.fapp.task;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cl.fapp.common.domain.EntityTaskNames;
import cl.fapp.common.domain.EntityTicketTypes;
import cl.fapp.common.domain.statuses.EntityCAFStatuses;
import cl.fapp.common.domain.statuses.EntityEmisoresStatuses;
import cl.fapp.common.domain.statuses.EntityTaskStatuses;
import cl.fapp.repository.agg.IAggCafPorEmisor;
import cl.fapp.repository.model.SupportTicket;
import cl.fapp.repository.model.Task;
import cl.fapp.repository.repos.CAFRepository;
import cl.fapp.restapi.freshdesk.FreshdeskCreateTicketRequest;
import cl.fapp.restapi.freshdesk.FreshdeskCreateTicketResponse;
import cl.fapp.restapi.freshdesk.FreshdeskHelpers;
import cl.fapp.restapi.freshdesk.FreshdeskPriorityEnum;
import cl.fapp.restapi.freshdesk.FreshdeskStatusEnum;
import cl.fapp.restapi.freshdesk.SupportTicketUtilsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TaskMonitorFoliosPorEmisor {
	private final static String THIS_TASK_REF_ENTITY = "CAF";

	@Autowired
	CAFRepository repoCAF;

	@Autowired
	TaskUtilsService taskUtils;

	@Autowired
	FreshdeskHelpers freshdesk;

	@Autowired
	SupportTicketUtilsService supportUtils;

	@Value("${fapp.task.monitor.min-folio:5}")
	private Integer MIN_FOLIOS_DISPONIBLES;

	@Value("${fapp.task.monitor.folios.cron}")
	private String SCHEDULER_EXPRESSION;

	@Value("${freshdesk.ticket.folios.groupid}")
	private BigInteger freshdeskTicketGroupId;

	@Value("${freshdesk.ticket.folios.responderid}")
	private BigInteger freshdeskTicketResponderId;

	/**
	 * Inicia una tarea de tipo TaskMonitorFoliosPorEmisor <second><minute><hour><day of month><month><day of week>
	 */
	@Scheduled(cron = "${fapp.task.monitor.folios.cron}") //--> cron = "0 0/2 * * * *", zone = "America/Santiago")
	public void init() {
		String myTaskName = EntityTaskNames.MONITOR_FOLIOS.getValue();
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
			log.debug("Buscando CAF que tengan " + MIN_FOLIOS_DISPONIBLES + " o menos folios disponibles...");

			// busca en la base los caf que cumplen el criterio, y no tienen un ticket asociado
			// @formatter:off
			Optional<List<IAggCafPorEmisor>> cafs = repoCAF.reportCafByEmisor(
					EntityTicketTypes.TYPE_FOLIO.getValue(), 
					THIS_TASK_REF_ENTITY, 
					EntityEmisoresStatuses.ACTIVO.name(), 
					EntityCAFStatuses.DISPONIBLE.name(), 
					MIN_FOLIOS_DISPONIBLES);
			// @formatter:on
			if (!cafs.isPresent() || (cafs.isPresent() && cafs.get().isEmpty())) {
				lastMessage = "No se encontraron caf que deban ser informados";
				log.info(lastMessage);

			} else {
				log.warn("Se encontraron " + cafs.get().size() + " caf's. Cada uno de estos, creara un ticket de atencion");
				for (IAggCafPorEmisor item : cafs.get()) {
					log.debug("Item=" + item.getRutEmisor() + ", disponibles=" + item.getDisponibles() + ", tipoAlarma=" + item.getTipoAlarma() + ", tipoDocumento=" + item.getTipoDocumento());

					// crea un ticket de soporte
					FreshdeskCreateTicketRequest fdrequest = new FreshdeskCreateTicketRequest();
					fdrequest.setName(myTaskName);
					fdrequest.setDescription("El numero de folios disponibles (" + item.getDisponibles() + ") de tipo " + item.getTipoDocumento() + " para el Emisor " + item.getRutEmisor() + " se estan agotando.");
					fdrequest.setEmail("monitor.folios@billonapp.com");
					fdrequest.setPriority(FreshdeskPriorityEnum.LOW.getValue());
					fdrequest.setStatus(FreshdeskStatusEnum.PENDING.getValue());
					fdrequest.setSubject("Folios tipo=" + item.getTipoDocumento() + " del Emisor=" + item.getRutEmisor());
					fdrequest.setGroupid(freshdeskTicketGroupId);
					fdrequest.setResponderid(freshdeskTicketResponderId);
					
					log.debug("FDREQUEST=" + fdrequest);

					// crea el ticket
					FreshdeskCreateTicketResponse fdresponse = freshdesk.createTicket(fdrequest);
					if (fdresponse.isCreated()) {
						// @formatter:off
						// crea el registro en entidad SupportTicket
						SupportTicket newTicket = supportUtils.createSupportTicketEntry(
								EntityTicketTypes.TYPE_FOLIO.getValue(), 
								fdresponse.getTicketValue(), 
								myTaskName, 
								fdresponse.getRequest(), 
								fdresponse.getResponse(), 
								THIS_TASK_REF_ENTITY,
								item.getIdCaf());
						if( newTicket != null ) {
							log.info("Ticket de soporte id_ticket=" + newTicket.getIdTicket() + ", ticket_value=" + fdresponse.getTicketValue() + " creado correctamente para id_caf=" + item.getIdCaf());
						}else {
							log.warn("No fue posible registrar el ticket de soporte => se crea en freshdesk, pero no se registra. Se intentara su creacion nuevamente (se duplicaran ticket's)");
						}
						// @formatter:on
					} else {
						log.error("No fue posible crear el ticket de soporte");
					}

				}

				lastMessage = "Ejecucion finalizada correctamente";
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

}
