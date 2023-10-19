package cl.fapp.restapi.freshdesk;

public enum FreshdeskStatusEnum {
	OPEN(2),
	PENDING(3),
	RESOLVED(4),
	CLOSED(5);

	private final int status;

	FreshdeskStatusEnum(final int status) {
		this.status = status;
	}

	public int getValue() {
		return this.status;
	}
}
