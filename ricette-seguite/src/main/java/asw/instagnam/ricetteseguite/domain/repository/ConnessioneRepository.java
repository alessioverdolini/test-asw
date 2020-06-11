package asw.instagnam.ricetteseguite.domain.repository;

import asw.instagnam.ricetteseguite.domain.Connessione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ConnessioneRepository extends JpaRepository<Connessione, Long> {

     List<Connessione> findAllByFollower(String follower);

     List<Connessione> findAllByFollowed(String followed);


}

