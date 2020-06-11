package asw.instagnam.common.api.event;

import asw.instagnam.common.api.event.DomainEvent;

public interface DomainEventProducer {
	void produce(DomainEvent event);

	String getTopic();
}
