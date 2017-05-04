package fr.univavignon.pokedex.impl;


import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactoryTest;
import org.junit.Before;


import static fr.univavignon.pokedex.impl.PokedexFactoryImpl.pokedexFactory;
import static fr.univavignon.pokedex.impl.PokemonTrainterFactoryImpl.pokemonTrainterFactory;

/**
 * Created by kouceila on 04/05/17.
 */
public class IPokemonTrainterFactoryImplTest extends IPokemonTrainerFactoryTest {
    @Override
    public IPokemonTrainerFactory getProvider() {
        return pokemonTrainterFactory();
    }
    @Override
    @Before
    public void setUp() {
        this.setPokdexFactory(pokedexFactory());
    }
}
