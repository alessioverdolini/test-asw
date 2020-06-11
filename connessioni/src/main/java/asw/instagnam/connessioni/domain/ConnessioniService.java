package asw.instagnam.connessioni.domain;

import asw.instagnam.common.api.event.DomainEventProducer;
import org.springframework.stereotype.Service;
import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioniservice.api.event.ConnessioneCreatedEvent;


import org.springframework.beans.factory.annotation.Autowired;
import java.util.*; 

@Service
public class ConnessioniService {

	private final ConnessioniRepository connessioniRepository;
	private final DomainEventProducer domainEventProducer;

	@Autowired
	public ConnessioniService(ConnessioniRepository connessioniRepository, DomainEventProducer domainEventProducer) {
		this.connessioniRepository = connessioniRepository;
		this.domainEventProducer = domainEventProducer;
	}


	public Connessione createConnessione(String follower, String followed) {
		Connessione connessione = new Connessione(follower, followed); 
		connessione = connessioniRepository.save(connessione);
		DomainEvent event = new ConnessioneCreatedEvent(connessione.getId(), connessione.getFollower(), connessione.getFollowed()); 
		domainEventProducer.produce(event);
		return connessione;
	}

 	public Connessione getConnessione(Long id) {
		Connessione connessione = connessioniRepository.findById(id).orElse(null);
		return connessione;
	}

 	public Collection<Connessione> getConnessioni() {
		Collection<Connessione> connessioni = connessioniRepository.findAll();
		return connessioni;
	}

	public Collection<Connessione> getConnessioniByFollower(String follower) {
		Collection<Connessione> connessioni = connessioniRepository.findAllByFollower(follower);
		return connessioni;
	}

}
