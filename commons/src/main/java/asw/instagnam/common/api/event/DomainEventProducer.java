package asw.instagnam.common.api.event;

public interface DomainEventProducer {
	void produce(DomainEvent event);

	String getTopic();
}
