package fr.univavignon.pokedex.impl;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.io.IOException;

/**
 * Created by kouceila on 19/04/17.
 */
public class PokemonFactoryImpl implements IPokemonFactory{
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
        PokemonMetadata tmp = new PokemonMetadataProviderImpl().getPokemonMetadata(index);
        int tmp_iv = 0;

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
