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

import java.io.IOException;

public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokedex pokedex;
    @Mock
    private IPokedexFactory pokdexFactory;
    @Mock
    private IPokemonTrainerFactory IPokemonTrainerFactory1;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    public IPokemonTrainerFactory getProvider() {
        return IPokemonTrainerFactory1;
    }



    @Test
    public void createTrainerTest() throws IOException {
        PokemonTrainer tmp = getProvider().createTrainer("sacha", Team.VALOR,  getPokdexFactory());
        assertEquals("sacha", tmp.getName());
        assertEquals(0, tmp.getPokedex().getPokemons().size());
        assertEquals(Team.VALOR, tmp.getTeam());
    }

    @Before
    public void setUp() throws PokedexException, IOException {
        MockitoAnnotations.initMocks(this);
        PokemonTrainer pokTrain = new PokemonTrainer("sacha", Team.VALOR,  pokedex);
        Mockito.when(IPokemonTrainerFactory1.createTrainer("sacha", Team.VALOR,  pokdexFactory)).thenReturn(pokTrain);
    }

    //----------GETTERS AND SETTERS ----------------------/////

    public IPokedexFactory getPokdexFactory() {
        return pokdexFactory;
    }

    public void setPokdexFactory(IPokedexFactory pokdexFactory) {
        this.pokdexFactory = pokdexFactory;
    }
}
