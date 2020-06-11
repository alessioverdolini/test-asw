package asw.instagnam.ricetteseguite.domain.repository;

import asw.instagnam.ricetteseguite.domain.Connessione;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ConnessioniRepository extends CrudRepository<Connessione, Long> {

	public Collection<Connessione> findAll();

	public Collection<Connessione> findAllByFollower(String follower);
	
	public Collection<Connessione> findAllByFollowed(String followed);


}

