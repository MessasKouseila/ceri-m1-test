package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;


public class IPokedexFactoryTest {

    @Mock
    private IPokemonMetadataProvider metadataProvider;
    @Mock
    private IPokemonFactory pokemonFactory;
    @Mock
    private IPokedexFactory IPokedexFactory1;
    @Mock
    private IPokedex unPokedex;


    public IPokedexFactory getProvider() {

        return IPokedexFactory1;
    }

    //---- GETTERS AND SETTERS -----//

    public IPokemonMetadataProvider getMetadataProvider() {
        return metadataProvider;
    }

    public void setMetadataProvider(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    public IPokemonFactory getPokemonFactory() {
        return pokemonFactory;
    }

    public void setPokemonFactory(IPokemonFactory pokemonFactory) {
        this.pokemonFactory = pokemonFactory;
    }

    public IPokedex getUnPokedex() {
        return unPokedex;
    }

    public void setUnPokedex(IPokedex unPokedex) {
        this.unPokedex = unPokedex;
    }

    public IPokedexFactory getIPokedexFactory1() {
        return IPokedexFactory1;
    }

    public void setIPokedexFactory1(IPokedexFactory IPokedexFactory1) {
        this.IPokedexFactory1 = IPokedexFactory1;
    }
    //-----------------------------------------------//

    @Test
    public void createPokedexTest() throws IOException {
        assertNotNull(getProvider().createPokedex(metadataProvider, pokemonFactory));
    }

    @Before
    public void setUp() throws PokedexException, IOException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(IPokedexFactory1.createPokedex(metadataProvider, pokemonFactory)).thenReturn(unPokedex);
    }
}
