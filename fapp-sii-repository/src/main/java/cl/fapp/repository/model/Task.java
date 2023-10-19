package cl.fapp.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@Table(name="task")
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idTask;
	private Date createdat;
	private String description;
	private Date lastExecTimestamp;
	private String lastResultMessage;
	private String name;
	private String scheduledExpression;
	private String status;
	private Date updatedat;

	public Task() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_task", unique=true, nullable=false)
	public Integer getIdTask() {
		return this.idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatedat() {
		return this.createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}


	@Column(length=256)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_exec_timestamp")
	public Date getLastExecTimestamp() {
		return this.lastExecTimestamp;
	}

	public void setLastExecTimestamp(Date lastExecTimestamp) {
		this.lastExecTimestamp = lastExecTimestamp;
	}


	@Column(name="last_result_message", length=4096)
	public String getLastResultMessage() {
		return this.lastResultMessage;
	}

	public void setLastResultMessage(String lastResultMessage) {
		this.lastResultMessage = lastResultMessage;
	}


	@Column(nullable=false, length=64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="scheduled_expression", length=256)
	public String getScheduledExpression() {
		return this.scheduledExpression;
	}

	public void setScheduledExpression(String scheduledExpression) {
		this.scheduledExpression = scheduledExpression;
	}


	@Column(nullable=false, length=16)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedat() {
		return this.updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}

}