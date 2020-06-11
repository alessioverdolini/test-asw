package asw.instagnam.connessioni.domain;

import asw.instagnam.common.api.event.DomainEvent;

public interface DomainEventProducer {
	void produce(DomainEvent event);

	String getTopic();
}
