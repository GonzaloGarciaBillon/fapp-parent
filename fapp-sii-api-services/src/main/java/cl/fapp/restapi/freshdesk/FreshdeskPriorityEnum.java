package cl.fapp.restapi.freshdesk;

public enum FreshdeskPriorityEnum {
	LOW(1),
	MEDIUM(2),
	HIGH(3),
	URGENT(4);

	private final int priority;

	FreshdeskPriorityEnum(final int priority) {
		this.priority = priority;
	}

	public int getValue() {
		return this.priority;
	}
}
