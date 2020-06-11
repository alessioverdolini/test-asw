package asw.instagnam.ricetteseguite.consumer;

import asw.instagnam.common.api.event.ConnessioneCreatedEvent;
import asw.instagnam.common.api.event.ConnessioniServiceEventChannel;
import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricetteseguite.domain.RicetteSeguiteService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class ConnessioniDomainEventConsumer implements DomainEventConsumer {

	private final RicetteSeguiteService service;

	@Autowired
	public ConnessioniDomainEventConsumer(RicetteSeguiteService ricetteSeguiteService) {
		this.service = ricetteSeguiteService;
	}

	@KafkaListener(topics = ConnessioniServiceEventChannel.channel)
	public void onEvent(ConsumerRecord<String, DomainEvent> evt) {
		if(evt.value().getClass().equals(ConnessioneCreatedEvent.class)){
			ConnessioneCreatedEvent event = (ConnessioneCreatedEvent) evt.value();
			service.addConnessione(event.getFollowed(), event.getFollower());
		}
	}
}
