package cl.fapp.restapi.freshdesk;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FreshdeskCreateTicketRequest {
	private String name;
	private String description;
	private String subject;
	private String email;
	private Integer priority;
	private Integer status;
	
	@JsonProperty("group_id")
	private BigInteger groupid;
	
	@JsonProperty("responder_id")
	private BigInteger responderid;
	
}
