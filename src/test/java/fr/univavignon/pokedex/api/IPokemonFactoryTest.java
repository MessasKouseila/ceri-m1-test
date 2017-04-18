package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonFactoryTest {

	private Pokemon bulbi = new Pokemon(0,
            "Bulbizarre",
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
	
	@Test
	public void testCreatPokemon() {
        Pokemon tmp = IPokemonFactory1.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(tmp.getName(), bulbi.getName());
        assertEquals(tmp.getAttack(), bulbi.getAttack());
        assertEquals(tmp.getDefense(), bulbi.getDefense());
        assertEquals(tmp.getStamina(), bulbi.getStamina());
        assertEquals(tmp.getCp(), bulbi.getCp());
        assertEquals(tmp.getHp(), bulbi.getHp());
        assertEquals(tmp.getDust(), bulbi.getDust());
        assertEquals(tmp.getIv(), bulbi.getIv(), 0);
	}
    @Before
    public void setUp() throws PokedexException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(IPokemonFactory1.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbi);
    }

	/*
	 * 
	 * 	 * @param index Pokemon index.
	 * @param cp Pokemon CP.
	 * @param hp Pokemon HP.
	 * @param dust Required dust for upgrading pokemon.
	 * @param candy Required candy for upgrading pokemon.
	 * @return Created pokemon instance.
	 *
	Pokemon createPokemon(int index, int cp, int hp, int dust, int candy);*/

}
