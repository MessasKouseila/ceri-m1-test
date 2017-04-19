package fr.univavignon.pokedex.Impl;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

import org.apache.commons.io.IOUtils;
import org.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;



/**
 * Created by kouceila on 19/04/17.
 */
public class PokemonMetadataProviderImpl implements IPokemonMetadataProvider {


    private static final String DATA_PATH = "https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json";
    private static JSONArray data;
    private static  final String name = "Identifier";
    private static  final String attack = "BaseAttack";
    private static  final String defense = "BaseDefense";
    private static  final String staminia = "BaseStamina";

    private void getData() throws IOException {
        try (InputStream is = new URL(DATA_PATH).openStream()){
            data = new JSONArray(IOUtils.toString(is, "UTF-8"));
        }

    }

    public PokemonMetadataProviderImpl() throws IOException {
        this.getData();
    }
    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <tt>index</tt>.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > 150) {
            throw new PokedexException("Index out Bounds");
        }
        try {
            JSONObject tmp = data.getJSONObject(index);
            if (tmp != null) {
                return new PokemonMetadata(index, tmp.getString(name), tmp.getInt(attack), tmp.getInt(defense), tmp.getInt(staminia));
            }
        } catch (JSONException e) {
            return null;
        }

        return null;
    }
}
