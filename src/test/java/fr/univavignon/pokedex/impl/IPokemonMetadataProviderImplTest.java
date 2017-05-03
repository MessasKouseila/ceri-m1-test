package fr.univavignon.pokedex.impl;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;

import java.io.IOException;

import static fr.univavignon.pokedex.impl.PokemonMetadataProviderImpl.pokemonMetadataProvider;

/**
 * Created by kouceila on 19/04/17.
 */
public class IPokemonMetadataProviderImplTest extends IPokemonMetadataProviderTest{
    @Override
    public IPokemonMetadataProvider getProvider() throws IOException {
        return pokemonMetadataProvider();
    }
}
