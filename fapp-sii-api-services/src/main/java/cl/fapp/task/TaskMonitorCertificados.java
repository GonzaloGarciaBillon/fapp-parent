package cl.fapp.task;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cl.fapp.common.domain.EntityTaskNames;
import cl.fapp.common.domain.EntityTicketTypes;
import cl.fapp.common.domain.statuses.EntityTaskStatuses;
import cl.fapp.repository.agg.IAggCertificateExpiryDate;
import cl.fapp.repository.model.SupportTicket;
import cl.fapp.repository.model.Task;
import cl.fapp.repository.repos.KeystoreFirmantesRepository;
import cl.fapp.restapi.freshdesk.FreshdeskCreateTicketRequest;
import cl.fapp.restapi.freshdesk.FreshdeskCreateTicketResponse;
import cl.fapp.restapi.freshdesk.FreshdeskHelpers;
import cl.fapp.restapi.freshdesk.FreshdeskPriorityEnum;
import cl.fapp.restapi.freshdesk.FreshdeskStatusEnum;
import cl.fapp.restapi.freshdesk.SupportTicketUtilsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TaskMonitorCertificados {
	private final static String THIS_TASK_REF_ENTITY = "KEYSTORE_FIRMANTES";

	@Autowired
	KeystoreFirmantesRepository repoKeystore;

	@Autowired
	TaskUtilsService taskUtils;

	@Autowired
	FreshdeskHelpers freshdesk;

	@Autowired
	SupportTicketUtilsService supportUtils;

	@Value("${fapp.task.monitor.cert-expiry-days:30}")
	private Integer KEYSTORE_CERT_EXPIRY_DAYS;

	@Value("${fapp.task.monitor.certificados.cron}")
	private String SCHEDULER_EXPRESSION;

	@Value("${freshdesk.ticket.certificados.groupid}")
	private BigInteger freshdeskTicketGroupId;

	@Value("${freshdesk.ticket.certificados.responderid}")
	private BigInteger freshdeskTicketResponderId;

	/**
	 * Inicia una tarea de tipo TaskMonitorCertificados <second><minute><hour><day of month><month><day of week>
	 */
	@Scheduled(cron = "${fapp.task.monitor.certificados.cron}", zone = "America/Santiago")
	public void init() {
		String myTaskName = EntityTaskNames.MONITOR_CERTIFICADOS.getValue();
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
			LocalDate fechaProceso = LocalDate.now(ZoneId.systemDefault());
			LocalDate ahoraMasXDias = fechaProceso.plusDays(KEYSTORE_CERT_EXPIRY_DAYS);
			LocalDateTime localHasta = LocalDateTime.parse(ahoraMasXDias.format(DateTimeFormatter.ISO_LOCAL_DATE) + "T23:59:59", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			Date fechaHasta = Date.from(localHasta.atZone(ZoneId.systemDefault()).toInstant());

			// @formatter:off
			log.debug("Iniciando busqueda de certificados con fecha de expiracion anterior a=" + localHasta);
			Optional<List<IAggCertificateExpiryDate>> ks = repoKeystore.reportCertificateExpiryDate(
					EntityTicketTypes.TYPE_CERTIFICADO.getValue(),
					THIS_TASK_REF_ENTITY,
					fechaHasta);
			// @formatter:on
			if (ks.isPresent() == false) {
				log.info("No se obtuvo respuesta consultando por certificados proximos a expirar");
				lastMessage = "No se obtuvo respuesta consultando por certificados proximos a expirar";

			} else {
				List<IAggCertificateExpiryDate> listaksFirmantes = ks.get();
				if (listaksFirmantes.size() <= 0) {
					log.info("No se encontraron certificados por expirar en los proximos " + KEYSTORE_CERT_EXPIRY_DAYS + " dias. FechaExpiracion <= " + localHasta);
					lastMessage = "No se encontraron certificados por expirar en los proximos " + KEYSTORE_CERT_EXPIRY_DAYS + " dias. FechaExpiracion <= " + localHasta;

				} else {
					// por cada keystore, abre un ticket
					int totalTicketsCreados = 0;
					int totalTicketsIntentos = 0;
					for (IAggCertificateExpiryDate item : ks.get()) {
						log.warn("Certificado id=" + item.getIdKeystore() + ", expira el=" + item.getExpiryDate());
						
						String descAddendum = "";
						if( item.getExpiryDate().before(initTaskTimestamp) ) {
							// la fecha de expiracion de certificado es antes que hoy
							descAddendum = ", ha expirado";
						}else {
							// la fecha de expiracion de certificado es posterior (o igual) a hoy
							descAddendum = ", esta proximo a expirar";							
						}

						// crea un ticket de soporte
						FreshdeskCreateTicketRequest fdrequest = new FreshdeskCreateTicketRequest();
						fdrequest.setName(myTaskName);
						fdrequest.setDescription("El certificado asociado al Firmante rut=" + item.getRutFirmante() + ", que representa al Emisor rut=" + item.getRutEmisor() + " (" + item.getRazonSocial() + ")" + descAddendum + ". Fecha de expiracion=" + item.getExpiryDate());
						fdrequest.setEmail("monitor.certificados@billonapp.com");
						fdrequest.setPriority(FreshdeskPriorityEnum.LOW.getValue());
						fdrequest.setStatus(FreshdeskStatusEnum.PENDING.getValue());
						fdrequest.setSubject("Expiracion de certificado del firmante rut=" + item.getRutFirmante());
						fdrequest.setGroupid(freshdeskTicketGroupId);
						fdrequest.setResponderid(freshdeskTicketResponderId);

						log.debug("FDREQUEST=" + fdrequest);

						// crea el ticket
						FreshdeskCreateTicketResponse fdresponse = freshdesk.createTicket(fdrequest);
						if (fdresponse.isCreated()) {
							totalTicketsCreados++;
							// @formatter:off
							// crea el registro en entidad SupportTicket
							SupportTicket newTicket = supportUtils.createSupportTicketEntry(
									EntityTicketTypes.TYPE_CERTIFICADO.getValue(), 
									fdresponse.getTicketValue(), 
									myTaskName, 
									fdresponse.getRequest(), 
									fdresponse.getResponse(), 
									THIS_TASK_REF_ENTITY,
									item.getIdKeystore());
							if( newTicket != null ) {
								log.info("Ticket de soporte id_ticket=" + newTicket.getIdTicket() + ", ticket_value=" + fdresponse.getTicketValue() + " creado correctamente para id_keystore=" + item.getIdKeystore());
							}else {
								log.warn("No fue posible registrar el ticket de soporte => se crea en freshdesk, pero no se registra. Se intentara su creacion nuevamente (se duplicaran ticket's)");
							}
							// @formatter:on
						} else {
							totalTicketsIntentos++;
							log.error("No fue posible crear el ticket de soporte");
						}
					}
					lastMessage = "De un total de " + (totalTicketsCreados + totalTicketsIntentos) + " tickets, se crearon " + totalTicketsCreados;
				}
			}
			log.debug("Finalizando TaskMonitorCertExpired...");

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
