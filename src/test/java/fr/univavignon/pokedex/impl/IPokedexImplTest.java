package fr.univavignon.pokedex.impl;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexTest;
import org.junit.Before;

import java.io.IOException;

/**
 * Created by kouceila on 03/05/17.
 */
public class IPokedexImplTest extends IPokedexTest {

    private static PokedexImpl instance;
    @Override
    @Before
    public void setUp() {
         instance = null;
    }
    ;


    @Override
    public IPokedex getProvider() throws IOException {
        if (instance == null) instance = new PokedexImpl();
        return instance;
    }
}
