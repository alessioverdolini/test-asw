package asw.instagnam.connessioni.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;



@Entity 
@IdClass(ConnessioneId.class)
@Data @NoArgsConstructor
public class Connessione {

	@Id 
	private String follower;
	@Id
	private String followed; 
	
	public Connessione(String follower, String followed) {
		this(); 
		this.follower = follower; 
		this.followed = followed; 
	}
	
}
