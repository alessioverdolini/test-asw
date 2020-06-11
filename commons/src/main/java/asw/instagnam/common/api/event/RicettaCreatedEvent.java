package asw.instagnam.common.api.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RicettaCreatedEvent implements DomainEvent{
	
	private Long id; 
	private String autore; 
	private String titolo;

	public RicettaCreatedEvent(Long id, String autore, String titolo) {
		this.id = id;
		this.autore = autore;
		this.titolo = titolo;
	}
}
