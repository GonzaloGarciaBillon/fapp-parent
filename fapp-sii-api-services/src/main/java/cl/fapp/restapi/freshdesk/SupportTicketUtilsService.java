package cl.fapp.restapi.freshdesk;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.fapp.repository.model.SupportTicket;
import cl.fapp.repository.repos.SupportTicketRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SupportTicketUtilsService {

	@Autowired
	SupportTicketRepository repoSupportTicket;

	/**
	 * Crea un registro en la entidad SupportTicket
	 * 
	 * @param ticketType  tipo de ticket
	 * @param ticketValue valor del ticket
	 * @param source      fuente creadora del ticket
	 * @param request     request enviado a freshdesk
	 * @param response    response recibido desde freshdesk
	 * @param refEntity   entidad que referencia el ticket
	 * @param refEntityId id de la instancia de la entidad que referencia el ticket
	 * @return el registro creado en la base de datos
	 */
	public SupportTicket createSupportTicketEntry(String ticketType, String ticketValue, String source, String request, String response, String refEntity, Long refEntityId) {

		try {
			// fecha/hora de creacion del registro
			Date ahora = new Date();

			// crea una nueva instancia de la entidad
			SupportTicket newSupportTicket = new SupportTicket();
			newSupportTicket.setCreatedat(ahora);
			newSupportTicket.setRefEntity(refEntity);
			newSupportTicket.setRefEntityId(refEntityId);
			newSupportTicket.setRequest(request == null ? null : (request.length() < 2046 ? request : request.substring(0, 2046)));
			newSupportTicket.setResponse(response == null ? null : (response.length() < 2046 ? response : response.substring(0, 2046)));
			newSupportTicket.setSource(source);
			newSupportTicket.setTicketType(ticketType);
			newSupportTicket.setTicketValue(ticketValue);
			newSupportTicket.setUpdatedat(ahora);

			// almacena la entidad
			SupportTicket newRecord = repoSupportTicket.save(newSupportTicket);

			// retorna el registro recien creado
			return newRecord;

		} catch (Exception ex) {
			log.error("Excepcion mientras se creaba registro de soporte. Error=" + ex.getMessage());
			return null;
		}
	}
}
