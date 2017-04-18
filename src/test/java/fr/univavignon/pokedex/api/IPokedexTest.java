package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest {
	
	private static IPokedex pokedex;
	
	
	
	@Test
	public void testSize() {
		pokedex = getPokedex();
		assertEquals(pokedex.size(), 0);
	}
	@Test
	public void addPokemon() {

	}
	@Test
	public void getPokemon() {

	}
	@Test
	public void getPokemons(){

	}


	public IPokedex getPokedex() {
		pokedex = Mockito.mock(IPokedex.class);
		Mockito.when(pokedex.size()).thenReturn(0);
		return pokedex;
	}
	
	/*
	 * Returns the number of pokemon this pokedex contains.
	 * 
	 * @return Number of pokemon in this pokedex.
	 *
	int size();
	
	/**
	 * Adds the given <tt>pokemon</tt> to this pokedex and returns
	 * it unique index.
	 * 
	 * @param pokemon Pokemon to add to this pokedex.
	 * @return Index of this pokemon relative to this pokedex.
	 *
	int addPokemon(Pokemon pokemon);
	
	/**
	 * Locates the pokemon identified by the given <tt>id</tt>.
	 * 
	 * @param id Unique pokedex relative identifier.
	 * @return Pokemon denoted by the given identifier.
	 * @throws PokedexException If the given <tt>index</tt> is not valid.
	 *
	Pokemon getPokemon(int id) throws PokedexException;
	
	/**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * 
	 * @return Unmodifiable list of all pokemons.
	 *
	List<Pokemon> getPokemons();

	/**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * The list view will be sorted using the given <tt>order</tt>.
	 * 
	 * @param order Comparator instance used for sorting the created view.
	 * @return Sorted unmodifiable list of all pokemons.
	 * 
	 * List<Pokemon> getPokemons(Comparator<Pokemon> order);
	 */
}
