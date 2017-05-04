package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokedex pokedex;
    @Mock
    private IPokedexFactory pokdexFactory;
    @Mock
    private IPokemonTrainerFactory IPokemonTrainerFactory1;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private PokemonTrainer pokTrain;



    public IPokemonTrainerFactory getProvider() {
        return IPokemonTrainerFactory1;
    }

    @Test
    public void createTrainerTest() {
        PokemonTrainer tmp = getProvider().createTrainer("sacha", Team.VALOR,  pokdexFactory);
        assertEquals("sacha", tmp.getName());
        assertEquals(0, tmp.getPokedex().getPokemons().size());
        assertEquals(Team.VALOR, tmp.getTeam());
    }

    @Before
    public void setUp() throws PokedexException {
        MockitoAnnotations.initMocks(this);
        pokTrain = new PokemonTrainer("sacha", Team.VALOR,  pokedex);
        Mockito.when(IPokemonTrainerFactory1.createTrainer("sacha", Team.VALOR,  pokdexFactory)).thenReturn(pokTrain);
    }
}


/*PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory);*/