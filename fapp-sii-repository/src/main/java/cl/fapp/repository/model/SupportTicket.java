package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the support_ticket database table.
 * 
 */
@Entity
@Table(name="support_ticket")
@NamedQuery(name="SupportTicket.findAll", query="SELECT s FROM SupportTicket s")
public class SupportTicket implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idTicket;
	private Date createdat;
	private String refEntity;
	private Long refEntityId;
	private String request;
	private String response;
	private String source;
	private String ticketType;
	private String ticketValue;
	private Date updatedat;

	public SupportTicket() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ticket", unique=true, nullable=false)
	public Integer getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatedat() {
		return this.createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}


	@Column(name="ref_entity", nullable=false, length=32)
	public String getRefEntity() {
		return this.refEntity;
	}

	public void setRefEntity(String refEntity) {
		this.refEntity = refEntity;
	}


	@Column(name="ref_entity_id", nullable=false)
	public Long getRefEntityId() {
		return this.refEntityId;
	}

	public void setRefEntityId(Long refEntityId) {
		this.refEntityId = refEntityId;
	}


	@Column(nullable=false, length=2048)
	public String getRequest() {
		return this.request;
	}

	public void setRequest(String request) {
		this.request = request;
	}


	@Column(nullable=false, length=2048)
	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}


	@Column(nullable=false, length=64)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}


	@Column(name="ticket_type", nullable=false, length=32)
	public String getTicketType() {
		return this.ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}


	@Column(name="ticket_value", nullable=false, length=64)
	public String getTicketValue() {
		return this.ticketValue;
	}

	public void setTicketValue(String ticketValue) {
		this.ticketValue = ticketValue;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedat() {
		return this.updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}

}