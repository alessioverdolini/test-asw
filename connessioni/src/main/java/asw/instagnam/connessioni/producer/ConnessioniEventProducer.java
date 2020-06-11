package asw.instagnam.connessioni.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioni.domain.DomainEventProducer;
import asw.instagnam.connessioniservice.api.event.ConnessioniServiceEventChannel;

@Component
public class EventProducer implements DomainEventProducer {

	private final KafkaTemplate<String, DomainEvent> template;

	@Autowired
	public EventProducer(KafkaTemplate<String, DomainEvent> template) {
		this.template = template;
	}

	@Override
	public void produce(DomainEvent event) {
		template.send(getTopic(), event);
	}

	@Override
	public String getTopic() {
		return null;
	}

}
