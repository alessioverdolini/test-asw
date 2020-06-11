package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.ricetteseguite.domain.repositories.ConnessioneRepository;
import asw.instagnam.ricetteseguite.domain.repositories.RicettaRepository;
import asw.instagnam.ricetteseguite.domain.repositories.RicettaSeguitaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class RicetteSeguiteServiceTest {

    private RicetteSeguiteService service;

    private RicettaRepository ricettaRepository;
    private ConnessioneRepository connessioneRepository;
    private RicettaSeguitaRepository ricettaSeguitaRepository;
    private String idRicetta1 = "ricetta1";
    private String idRicetta2 = "ricetta2";
    private String idRicetta3 = "ricetta3";
    private String idAutore = "idAutore";

    @BeforeEach
    void setUp() {
        ricettaRepository = mock(RicettaRepository.class);
        connessioneRepository = mock(ConnessioneRepository.class);
        ricettaSeguitaRepository = mock(RicettaSeguitaRepository.class);
        service = new RicetteSeguiteService(ricettaRepository, connessioneRepository, ricettaSeguitaRepository);

    }

    @Test
    void testWhenAddRicetta() {
    }
}