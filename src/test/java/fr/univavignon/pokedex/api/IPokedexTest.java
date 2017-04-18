package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class IPokedexTest {

    @Mock
    private IPokedex IPokedex1;

    private int nbr = 0;
    private List<Pokemon> listPokemons = new ArrayList<Pokemon>(151);

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
    private Pokemon aquali = new Pokemon(133,
            "Aquali",
            186,
            168,
            260,
            2729,
            202,
            5000,
            4,
            100
    );
	

	@Test
	public void addPokemonTest() {
        assertEquals(IPokedex1.addPokemon(bulbi), 0);
        assertEquals(IPokedex1.addPokemon(aquali), 1);
	}
	@Test
	public void getPokemonTest() throws PokedexException {
        assertEquals(IPokedex1.getPokemon(0), bulbi);
        assertEquals(IPokedex1.getPokemon(1), aquali);
	}
	@Test
	public void getPokemonsTest(){
        List<Pokemon> tmp = IPokedex1.getPokemons();
        assertEquals(tmp, listPokemons);
	}
    @Test
    public void sizeTest() {
        assertEquals(IPokedex1.size(), 2);
    }


    @Before
    public void setUp() throws PokedexException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(IPokedex1.addPokemon(bulbi)).thenReturn(nbr);
        listPokemons.add(bulbi);
        nbr++;
        Mockito.when(IPokedex1.addPokemon(aquali)).thenReturn(nbr);
        listPokemons.add(aquali);
        nbr++;
        Mockito.when(IPokedex1.size()).thenReturn(nbr);
        Mockito.when(IPokedex1.getPokemon(0)).thenReturn(bulbi);
        Mockito.when(IPokedex1.getPokemon(1)).thenReturn(aquali);
        Mockito.when(IPokedex1.getPokemons()).thenReturn(listPokemons);
    }
}
