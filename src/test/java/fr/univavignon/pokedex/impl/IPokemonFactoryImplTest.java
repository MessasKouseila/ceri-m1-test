package fr.univavignon.pokedex.impl;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonFactoryTest;

import java.io.IOException;

import static fr.univavignon.pokedex.impl.PokemonFactoryImpl.pokemonFactory;

/**
 * Created by kouceila on 03/05/17.
 */
public class IPokemonFactoryImplTest extends IPokemonFactoryTest {
    @Override
    public IPokemonFactory getProvider() throws IOException {
        return pokemonFactory();
    }
}
