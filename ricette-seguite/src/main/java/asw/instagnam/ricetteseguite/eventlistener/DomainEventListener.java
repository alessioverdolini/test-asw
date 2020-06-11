package asw.instagnam.ricetteseguite.eventlistener;

import asw.instagnam.common.api.event.DomainEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface DomainEventListener {
	public void listen(ConsumerRecord<String, DomainEvent> record); 
		
}
