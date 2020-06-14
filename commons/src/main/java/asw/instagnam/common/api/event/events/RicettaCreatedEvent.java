package asw.instagnam.common.api.event.events;

import asw.instagnam.common.api.event.events.DomainEvent;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RicettaCreatedEvent implements DomainEvent {
	
	private String autore; 
	private String titolo;

	public RicettaCreatedEvent(String autore, String titolo) {
		this.autore = autore;
		this.titolo = titolo;
	}
}
