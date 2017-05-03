package fr.univavignon.pokedex.impl;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;

import java.io.IOException;

/**
 * Created by kouceila on 03/05/17.
 */
public class PokedexFactoryImpl implements IPokedexFactory {

    private static PokedexFactoryImpl instance = null;

    private PokedexFactoryImpl() {

    }

    public static PokedexFactoryImpl pokedexFactory() {
        if (instance == null) instance = new PokedexFactoryImpl();
        return instance;
    }
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) throws IOException {

        return new PokedexImpl(metadataProvider, pokemonFactory);
    }
}
