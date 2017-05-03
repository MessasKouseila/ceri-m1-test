package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IPokedexTest {

    @Mock
    private IPokedex IPokedex1;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private int size = 0;
    private int indexe = 0;
    private List<Pokemon> listPokemons = new ArrayList<Pokemon>(151);

    private Pokemon bulbi = new Pokemon(0,
            "Bulbasaur",
            126,
            126,
            90,
            613,
            64,
            4000,
            4,
            56
    );
    private Pokemon aquali = new Pokemon(133,
            "Vaporeon",
            186,
            168,
            260,
            2729,
            202,
            5000,
            4,
            100
    );


    public IPokedex getProvider() throws IOException {
        return IPokedex1;
    }


    @Test
    public void sizeTest() throws IOException, PokedexException {
        assertEquals(0, getProvider().size());
        getProvider().addPokemon(create(bulbi));
        getProvider().addPokemon(create(aquali));
        assertEquals(2, getProvider().size());

    }

    @Test
    public void addPokemonTest() throws IOException, PokedexException {

        assertEquals(0, getProvider().addPokemon(create(bulbi)));
        assertEquals(1, getProvider().addPokemon(create(aquali)));

    }

    @Test
    public void createPokemonTest() throws IOException, PokedexException {
        Pokemon tmp = getProvider().createPokemon(0, 613, 64, 4000, 4);
        assertEquals(bulbi.getName(), tmp.getName());
        assertEquals(bulbi.getAttack(), tmp.getAttack());
        assertEquals(bulbi.getDefense(), tmp.getDefense());
        assertEquals(bulbi.getStamina(), tmp.getStamina());
        assertEquals(bulbi.getCp(), tmp.getCp());
        assertEquals(bulbi.getHp(), tmp.getHp());
        assertEquals(bulbi.getDust(), tmp.getDust());
        assertEquals(bulbi.getIv(), tmp.getIv(), 0);
    }

    @Test
    public void getPokemonTest() throws PokedexException, IOException {

        getProvider().addPokemon(create(bulbi));
        getProvider().addPokemon(create(aquali));

        assertEquals(bulbi, getProvider().getPokemon(0));
        assertEquals(aquali, getProvider().getPokemon(1));
    }

    @Test
    public void getPokemonsTest() throws IOException {
        List<Pokemon> tmp = getProvider().getPokemons();
        assertEquals(listPokemons, tmp);
    }

    @Before
    public void setUp() throws PokedexException, IOException {

        MockitoAnnotations.initMocks(this);

        Mockito.when(IPokedex1.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbi);
        Mockito.when(IPokedex1.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);

        Mockito.when(IPokedex1.getPokemon(0)).thenReturn(bulbi);
        Mockito.when(IPokedex1.getPokemon(1)).thenReturn(aquali);
        Mockito.when(IPokedex1.getPokemon(151)).thenThrow(new PokedexException("aucun pokem trouver à cet indexe"));

        size = 0;
        this.listPokemons.clear();
        Answer<Integer> theSize = new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocation) {
                return size;
            }
        };

        indexe = 0;
        this.listPokemons.clear();
        Answer<Integer> theIndexe = new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocation) {
                return indexe;
            }
        };

        Mockito.when(IPokedex1.size()).thenAnswer(theSize);

        Mockito.when(IPokedex1.addPokemon(bulbi)).thenAnswer(theIndexe);
        Mockito.when(IPokedex1.addPokemon(aquali)).thenAnswer(theIndexe);


        Mockito.when(IPokedex1.getPokemons()).thenReturn(listPokemons);

    }


    public Pokemon create(Pokemon p) {
        listPokemons.add(p);
        size++;
        indexe = size - 1;
        return p;
    }
}
