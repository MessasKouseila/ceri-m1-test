package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

public class IPokemonFactoryTest {

	private Pokemon bulbi = new Pokemon(0,
            "Bulbasaur",
            126,
            126,
            90,
            613,
            64,
            4000,
            4,
            56
            );
	@Mock
	private IPokemonFactory IPokemonFactory1;

    public IPokemonFactory getProvider() throws IOException {
        return IPokemonFactory1;
    }

	@Test
	public void testCreatPokemon() throws IOException, PokedexException {
        Pokemon tmp = getProvider().createPokemon(0, 613, 64, 4000, 4);
        assertEquals(bulbi.getName(), tmp.getName());
        assertEquals(bulbi.getAttack(), tmp.getAttack());
        assertEquals(bulbi.getDefense(), tmp.getDefense());
        assertEquals(bulbi.getStamina(), tmp.getStamina());
        assertEquals(bulbi.getCp(), tmp.getCp());
        assertEquals(bulbi.getHp(), tmp.getHp());
        assertEquals(bulbi.getDust(), tmp.getDust());
        assertEquals(bulbi.getIv(), tmp.getIv() , 0);
	}
    @Before
    public void setUp() throws PokedexException, IOException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(IPokemonFactory1.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbi);
    }
}
