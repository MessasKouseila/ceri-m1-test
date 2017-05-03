package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class IPokedexFactoryTest {

    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedex unPokedex;
    @Mock
    private IPokedexFactory IPokedexFactory1;

    public IPokedexFactory getProvider() {
        return IPokedexFactory1;
    }

    @Test
    public void createPokedex() {
        assertEquals(unPokedex, getProvider().createPokedex(metadataProvider, pokemonFactory));
    }

    @Before
    public void setUp() throws PokedexException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(IPokedexFactory1.createPokedex(metadataProvider, pokemonFactory)).thenReturn(unPokedex);
    }
}
