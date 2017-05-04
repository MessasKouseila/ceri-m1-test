package fr.univavignon.pokedex.impl;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;


import java.io.IOException;

import static fr.univavignon.pokedex.impl.PokemonMetadataProviderImpl.pokemonMetadataProvider;

/**
 * Created by kouceila on 19/04/17.
 */
public class PokemonFactoryImpl implements IPokemonFactory{

    private static PokemonFactoryImpl instance = null;

    public static synchronized  PokemonFactoryImpl pokemonFactory() {
        if (instance == null) {
            instance = new PokemonFactoryImpl();
        }
        return instance;
    }

    private PokemonFactoryImpl() {

    }
    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws IOException, PokedexException {

        PokemonMetadata tmp =  pokemonMetadataProvider().getPokemonMetadata(index);
        // on utilse CalculatorIV pour calculé l'iv du pokemon
        int tmp_iv = new CalculatorIV().calculateIV(tmp.getName(), cp, hp, dust);

        return new Pokemon(index,
                tmp.getName(),
                tmp.getAttack(),
                tmp.getDefense(),
                tmp.getStamina(),
                cp,
                hp,
                dust,
                candy,
                tmp_iv
        );
    }
}
