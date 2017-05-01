package fr.univavignon.pokedex.impl;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;

import java.io.IOException;

/**
 * Created by kouceila on 19/04/17.
 */
public class PokemonMetadataProviderImplTest extends IPokemonMetadataProviderTest{
    @Override
    public IPokemonMetadataProvider getProvider() throws IOException {
        return new PokemonMetadataProviderImpl();
    }
}
