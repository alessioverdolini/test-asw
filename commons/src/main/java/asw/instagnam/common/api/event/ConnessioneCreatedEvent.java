package asw.instagnam.common.api.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConnessioneCreatedEvent implements DomainEvent{
	
	private Long id; 
	private String follower; 
	private String followed;

	public ConnessioneCreatedEvent(Long id, String follower, String followed) {
		this.id = id;
		this.follower = follower;
		this.followed = followed;
	}
}
