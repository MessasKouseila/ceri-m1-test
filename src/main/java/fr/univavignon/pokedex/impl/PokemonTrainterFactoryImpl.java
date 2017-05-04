package fr.univavignon.pokedex.impl;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;
import org.junit.Before;

import java.io.IOException;

import static fr.univavignon.pokedex.impl.PokemonFactoryImpl.pokemonFactory;
import static fr.univavignon.pokedex.impl.PokemonMetadataProviderImpl.pokemonMetadataProvider;

/**
 * Created by kouceila on 04/05/17.
 */
public class PokemonTrainterFactoryImpl implements IPokemonTrainerFactory {

    private static PokemonTrainterFactoryImpl instance = null;

    private PokemonTrainterFactoryImpl() {

    }

    public static synchronized PokemonTrainterFactoryImpl pokemonTrainterFactory() {
        if (instance == null) instance = new PokemonTrainterFactoryImpl();
        return instance;
    }

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) throws IOException {
        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(pokemonMetadataProvider(), pokemonFactory()));
    }
}
