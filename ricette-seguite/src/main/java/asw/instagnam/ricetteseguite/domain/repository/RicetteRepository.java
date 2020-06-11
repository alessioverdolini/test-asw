package asw.instagnam.ricetteseguite.domain.repository;

import asw.instagnam.ricetteseguite.domain.Ricetta;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface RicetteRepository extends CrudRepository<Ricetta, Long> {

	public Collection<Ricetta> findAll();

	public Collection<Ricetta> findAllByAutore(String autore);

}

