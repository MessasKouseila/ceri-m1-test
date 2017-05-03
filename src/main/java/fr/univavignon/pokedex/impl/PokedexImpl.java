package fr.univavignon.pokedex.impl;

import fr.univavignon.pokedex.api.*;

import java.io.IOException;
import java.util.*;

import static fr.univavignon.pokedex.impl.PokemonFactoryImpl.PokemonFactory;
import static fr.univavignon.pokedex.impl.PokemonMetadataProviderImpl.PokemonMetadataProvider;

/**
 * Created by kouceila on 19/04/17.
 */
public class PokedexImpl implements IPokedex {

    private IPokemonFactory pokemonfactory;
    private IPokemonMetadataProvider provider;
    private List<Pokemon> listOfpokemon;


    public PokedexImpl() throws IOException {
        // 151 pokemons pour la 1er generation
        this.setListOfpokemon(new ArrayList<Pokemon>(151));
        this.setPokemonfactory(PokemonFactory());
        this.setProvider(PokemonMetadataProvider());
    }

    public PokedexImpl(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonfactory) throws IOException {
        // 151 pokemons pour la 1er generation
        this.setListOfpokemon(new ArrayList<Pokemon>(151));
        this.setPokemonfactory(pokemonfactory);
        this.setProvider(metadataProvider);
    }


    // ---- GETTERS ---- //
    public IPokemonFactory getPokemonfactory() {
        return this.pokemonfactory;
    }
    public List<Pokemon> getListOfpokemon() {
        return this.listOfpokemon;
    }
    public IPokemonMetadataProvider getProvider() {
        return this.provider;
    }

    // ---- SETTERS ---- //

    public void setProvider(IPokemonMetadataProvider provider) {
        this.provider = provider;
    }
    public void setPokemonfactory(IPokemonFactory pokemonfactory) {
        this.pokemonfactory = pokemonfactory;
    }
    public void setListOfpokemon(List<Pokemon> listOfpokemon) {
        this.listOfpokemon = listOfpokemon;
    }


    @Override
    public int size() {
        return this.getPokemons().size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) throws PokedexException {
        if (this.size() == 151) {
            throw new PokedexException("Pokedex pleins");
        }
        this.getPokemons().add(pokemon);
        return this.getPokemons().indexOf(pokemon);
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        // l'indexe des pokemons est compris entre  0 Et 150 soit 151 pokemons
        if (id > this.getPokemons().size() || id < 0) {
            throw new PokedexException("Vous tentez de recupperer un pokemon inexistant, index => "+id);
        } else {
            return this.getPokemons().get(id);
        }
    }

    @Override
    public List<Pokemon> getPokemons() {

        return this.getListOfpokemon();
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> newList = new ArrayList<Pokemon>(this.getPokemons());
        Collections.sort(newList, order);
        return Collections.unmodifiableList(newList);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws IOException, PokedexException {
        return this.getPokemonfactory().createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException, IOException {
        return this.getProvider().getPokemonMetadata(index);
    }
}
