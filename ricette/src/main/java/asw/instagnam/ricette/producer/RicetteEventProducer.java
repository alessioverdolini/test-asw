package asw.instagnam.ricette.producer;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.common.api.event.DomainEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class RicetteEventProducer implements DomainEventProducer {

	private final KafkaTemplate<String, DomainEvent> template;

	@Autowired
	public RicetteEventProducer(KafkaTemplate<String, DomainEvent> template) {
		this.template = template;
	}

	@Override
	public void produce(DomainEvent event) {
		template.send(getTopic(), event);
	}

	@Override
	public String getTopic() {
		return "ricette-service-event-channel";
	}

}
