package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokedexFactoryTest {

    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedex unPokedex;
    @Mock
    private IPokedexFactory IPokedexFactory1;
    //IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory);

    @Test
    public void createPokedex() {
        assertEquals(IPokedexFactory1.createPokedex(metadataProvider, pokemonFactory), unPokedex);
    }

    @Before
    public void setUp() throws PokedexException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(IPokedexFactory1.createPokedex(metadataProvider, pokemonFactory)).thenReturn(unPokedex);
    }
}
