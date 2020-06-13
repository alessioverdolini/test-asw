package asw.instagnam.ricetteseguite.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@IdClass(RicettaSeguitaId.class)
@Data @NoArgsConstructor @AllArgsConstructor
public class RicettaSeguita {
	
	@Id
	private String follower; 
	@Id
	private Long idRicetta; 
	@Id
	private String autoreRicetta; 
	@Id
	private String titoloRicetta;

	public Ricetta getRicetta(){
		return new Ricetta(idRicetta, autoreRicetta, titoloRicetta);
	}

}