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

    private Pokemon Arbok = new Pokemon(3,
            "Arbok",
            166,
            166,
            120,
            118,
            39,
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
        assertEquals(bulbi.getCandy(), tmp.getCandy());
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

    @Test
    public void getPokemonMetadataTest() throws IOException, PokedexException {
        PokemonMetadata metaData_1 = getProvider().getPokemonMetadata(0);

        assertEquals(0, metaData_1.getIndex());
        assertEquals("Bulbasaur", metaData_1.getName());
        assertEquals(126, metaData_1.getAttack());
        assertEquals(126, metaData_1.getDefense());
        assertEquals(90, metaData_1.getStamina());

        PokemonMetadata metaData_2 = getProvider().getPokemonMetadata(133);

        assertEquals(133, metaData_2.getIndex());
        assertEquals("Vaporeon", metaData_2.getName());
        assertEquals(186, metaData_2.getAttack());
        assertEquals(168, metaData_2.getDefense());
        assertEquals(260, metaData_2.getStamina());

    }

    @Test
    public void getPokemonsComparatorTest() throws IOException, PokedexException {

        // list ordonne via l'indexe
        getProvider().addPokemon(create(bulbi));
        getProvider().addPokemon(create(aquali));
        getProvider().addPokemon(create(Arbok));

        List<Pokemon> listOrderedIndex = getProvider().getPokemons(PokemonComparators.INDEX);
        List<Pokemon> listOrderedName = getProvider().getPokemons(PokemonComparators.NAME);
        // on teste que le pokemon retourne est bien le bon
        assertEquals(bulbi.getName(), listOrderedIndex.get(0).getName());
        assertEquals(Arbok.getName(), listOrderedIndex.get(1).getName());
        assertEquals(aquali.getName(), listOrderedIndex.get(2).getName());


        assertEquals(Arbok.getName(), listOrderedName.get(0).getName());
        assertEquals(bulbi.getName(), listOrderedName.get(1).getName());
        assertEquals(aquali.getName(), listOrderedName.get(2).getName());

    }


    @Before
    public void setUp() throws PokedexException, IOException {

        MockitoAnnotations.initMocks(this);

        Mockito.when(IPokedex1.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbi);
        Mockito.when(IPokedex1.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);

        Mockito.when(IPokedex1.getPokemon(0)).thenReturn(bulbi);
        Mockito.when(IPokedex1.getPokemon(1)).thenReturn(aquali);
        Mockito.when(IPokedex1.getPokemon(2)).thenReturn(Arbok);
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



        Mockito.when(IPokedex1.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));
        Mockito.when(IPokedex1.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133, "Vaporeon", 186, 168, 260));



        Mockito.when(IPokedex1.getPokemons()).thenReturn(listPokemons);

        List<Pokemon> orderByIndex = new ArrayList<Pokemon>(151);
        // le bon ordre par indexe
        orderByIndex.add(IPokedex1.getPokemon(0));
        orderByIndex.add(IPokedex1.getPokemon(2));
        orderByIndex.add(IPokedex1.getPokemon(1));



        List<Pokemon> orderByName = new ArrayList<Pokemon>(151);
        // le bon ordre par nom
        orderByName.add(IPokedex1.getPokemon(2));
        orderByName.add(IPokedex1.getPokemon(0));
        orderByName.add(IPokedex1.getPokemon(1));


        Mockito.when(IPokedex1.getPokemons(PokemonComparators.INDEX)).thenReturn(orderByIndex);
        Mockito.when(IPokedex1.getPokemons(PokemonComparators.NAME)).thenReturn(orderByName);

    }


    public Pokemon create(Pokemon p) {
        listPokemons.add(p);
        size++;
        indexe = size - 1;
        return p;
    }
}
