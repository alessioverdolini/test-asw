package asw.instagnam.common.api.event.events;

import asw.instagnam.common.api.event.events.DomainEvent;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConnessioneCreatedEvent implements DomainEvent {
	
	private String follower; 
	private String followed;

	public ConnessioneCreatedEvent(String follower, String followed) {
		this.follower = follower;
		this.followed = followed;
	}
}
