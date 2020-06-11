package asw.instagnam.ricetteseguite.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
@Data @NoArgsConstructor @AllArgsConstructor
public class Connessione {

	@Id
	@GeneratedValue
	private Long id;

	private String follower;
	private String followed;

	public Connessione(String follower, String followed) {
		this.follower = follower;
		this.followed = followed;
	}
}
