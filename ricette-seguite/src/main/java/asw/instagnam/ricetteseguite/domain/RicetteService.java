package asw.instagnam.ricetteseguite.domain;

import java.util.Collection;

public interface RicetteService {

	public Collection<Ricetta> getRicetteByAutore(String autore); 
	
}
