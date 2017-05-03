package fr.univavignon.pokedex.impl;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokedexFactoryTest;

import static fr.univavignon.pokedex.impl.PokedexFactoryImpl.PokedexFactory;

/**
 * Created by kouceila on 03/05/17.
 */
public class IPokedexFactoryImplTest extends IPokedexFactoryTest {

    @Override
    public IPokedexFactory getProvider() {

        return PokedexFactory();
    }
}
