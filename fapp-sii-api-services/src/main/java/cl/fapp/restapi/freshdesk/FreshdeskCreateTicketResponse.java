package cl.fapp.restapi.freshdesk;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FreshdeskCreateTicketResponse {
	private boolean created;
	private String request;
	private String response;
	private String ticketValue;
	private String message;
}
