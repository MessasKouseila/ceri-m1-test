package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonTrainerFactoryTest {

    private IPokedex pokedex;
    private IPokedexFactory pokdexFactory;
    private PokemonTrainer pokTrain = new PokemonTrainer("sacha", Team.VALOR,  pokedex);

    @Mock
    private IPokemonTrainerFactory IPokemonTrainerFactory1;

    @Test
    public void createTrainerTest() {
        assertEquals(IPokemonTrainerFactory1.createTrainer("sacha", Team.VALOR,  pokdexFactory), pokTrain);
    }

    @Before
    public void setUp() throws PokedexException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(IPokemonTrainerFactory1.createTrainer("sacha", Team.VALOR,  pokdexFactory)).thenReturn(pokTrain);
    }
}


/*PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory);*/