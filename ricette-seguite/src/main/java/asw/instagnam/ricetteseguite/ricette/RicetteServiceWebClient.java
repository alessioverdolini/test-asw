package asw.instagnam.ricetteseguite.ricette;

import asw.instagnam.ricetteseguite.domain.Ricetta;
import asw.instagnam.ricetteseguite.domain.RicetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Flux;

import java.util.Collection;

@Service 
@Primary 
public class RicetteServiceWebClient implements RicetteService {

	@Autowired 
	@Qualifier("loadBalancedWebClient")
    private WebClient loadBalancedWebClient;
	
	public Collection<Ricetta> getRicetteByAutore(String autore) {
		Collection<Ricetta> ricette = null; 
        Flux<Ricetta> response = loadBalancedWebClient
                .get()
				.uri(uriBuilder -> uriBuilder 
					.scheme("http")
					.host("ricette")
					.path("/ricette")
					.queryParam("autore", autore)
					.build())
                .retrieve()
                .bodyToFlux(Ricetta.class);
        try {
            ricette = response.collectList().block();
        } catch (WebClientException e) {
            e.printStackTrace();
        }
		return ricette; 
	}	

}
