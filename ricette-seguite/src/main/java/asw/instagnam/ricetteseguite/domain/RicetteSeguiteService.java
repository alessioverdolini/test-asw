package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.ricetteseguite.domain.entities.Connessione;
import asw.instagnam.ricetteseguite.domain.entities.Ricetta;
import asw.instagnam.ricetteseguite.domain.entities.RicettaSeguita;
import asw.instagnam.ricetteseguite.domain.repositories.ConnessioneRepository;
import asw.instagnam.ricetteseguite.domain.repositories.RicettaRepository;
import asw.instagnam.ricetteseguite.domain.repositories.RicettaSeguitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class RicetteSeguiteService {

    private final RicettaRepository ricettaRepository;
    private final ConnessioneRepository connessioneRepository;
    private final RicettaSeguitaRepository ricettaSeguitaRepository;

    private final Logger logger = Logger.getLogger(RicetteSeguiteService.class.toString());

    @Autowired
    public RicetteSeguiteService(RicettaRepository ricettaRepository, ConnessioneRepository connessioneRepository, RicettaSeguitaRepository ricettaSeguitaRepository) {
        this.ricettaRepository = ricettaRepository;
        this.connessioneRepository = connessioneRepository;
        this.ricettaSeguitaRepository = ricettaSeguitaRepository;
    }

    public Collection<Ricetta> getRicetteSeguite(String followerId) {
        return ricettaSeguitaRepository.findAllByFollower(followerId)
                .stream().map(RicettaSeguita::getRicetta).collect(Collectors.toList());
    }

    public void addConnessione(String followedId, String followerId) {
        logger.info("ADDING CONNESSIONE: (" + followedId + ", " + followerId + ")");
        connessioneRepository.save(connessioneFactory(followedId, followerId));
        List<Ricetta> ricette = ricettaRepository.findAllByAutore(followedId);
        markRicetteAsFollowedBy(followerId, ricette);
    }

    public void addRicetta(String autore, String titolo) {
        logger.info("ADDING RICETTA: (" + autore + ", " + titolo + ")");
        ricettaRepository.save(ricettaFactory(autore, titolo));
        List<Connessione> connessioni = connessioneRepository.findAllByFollowed(autore);
        List<String> utenti = connessioni.stream().map(Connessione::getFollower).collect(Collectors.toList());
        markRicettaFollowedBy(autore, titolo, utenti);
    }

    private void markRicetteAsFollowedBy(String followerId, List<Ricetta> ricette) {
        ricette.forEach(ricetta -> {
            saveRicettaSeguitaIfNotExists(followerId, ricetta.getAutore(), ricetta.getTitolo());
        });
    }

    private void markRicettaFollowedBy(String autore, String titolo, List<String> utenti) {
        utenti.forEach(utente -> {
            saveRicettaSeguitaIfNotExists(utente, autore, titolo);
        });
    }

    private void saveRicettaSeguitaIfNotExists(String followerId, String autore, String titolo) {
        try {
            ricettaSeguitaRepository.save(ricetteSeguiteFactory(
                    followerId,
                    autore,
                    titolo));
        } catch (DataIntegrityViolationException e) {
            logger.info("DUPLICATE FOUND, SKIPPING: (" + followerId + ", " + autore + ", " + titolo + ")");
        }
    }

    private Connessione connessioneFactory(String followedId, String followerId) {
        return new Connessione(followedId, followerId);
    }

    private Ricetta ricettaFactory(String autore, String titolo) {
        return new Ricetta(autore, titolo);
    }

    private RicettaSeguita ricetteSeguiteFactory(String followerId, String autoreId, String titolo) {
        return new RicettaSeguita(followerId, autoreId, titolo);
    }
}
