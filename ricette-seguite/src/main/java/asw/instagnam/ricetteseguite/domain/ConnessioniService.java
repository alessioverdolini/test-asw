package asw.instagnam.ricetteseguite.domain;

import java.util.Collection;

public interface ConnessioniService {

	public Collection<Connessione> getConnessioniByFollower(String follower); 
	
}
