package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

public class IPokemonMetadataProviderTest {
	
	@Mock private IPokemonMetadataProvider iPokMetaProvider1;
	
	private PokemonMetadata Metadata = new PokemonMetadata(0, "Bulbasaur", 126, 126, 90);
	private PokemonMetadata Metadata2 = new PokemonMetadata(133, "Vaporeon", 186, 168, 260);

	public IPokemonMetadataProvider getProvider() throws IOException {
		return iPokMetaProvider1;
	}

	@Test
	public void getPokemonMetadataTest() throws PokedexException, IOException {
		assertEquals(getProvider().getPokemonMetadata(0).getIndex(), Metadata.getIndex());
		assertEquals(getProvider().getPokemonMetadata(0).getName(), Metadata.getName());
		assertEquals(getProvider().getPokemonMetadata(0).getAttack(), Metadata.getAttack());
		assertEquals(getProvider().getPokemonMetadata(0).getDefense(), Metadata.getDefense());
		assertEquals(getProvider().getPokemonMetadata(0).getStamina(), Metadata.getStamina());
		
		assertEquals(getProvider().getPokemonMetadata(133).getIndex(), Metadata2.getIndex());
		assertEquals(getProvider().getPokemonMetadata(133).getName(), Metadata2.getName());
		assertEquals(getProvider().getPokemonMetadata(133).getAttack(), Metadata2.getAttack());
		assertEquals(getProvider().getPokemonMetadata(133).getDefense(), Metadata2.getDefense());
		assertEquals(getProvider().getPokemonMetadata(133).getStamina(), Metadata2.getStamina());
	}

	@Test(expected = PokedexException.class)
	public void execptionIndex() throws PokedexException, IOException {
        getProvider().getPokemonMetadata(-1);
	}
	@Test(expected = PokedexException.class)
	public void execptionIndexOut() throws PokedexException, IOException {
        getProvider().getPokemonMetadata(151);
	}
	
	@Before
	public void setUp() throws PokedexException, IOException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(iPokMetaProvider1.getPokemonMetadata(0)).thenReturn(Metadata);
		Mockito.when(iPokMetaProvider1.getPokemonMetadata(133)).thenReturn(Metadata2);
		Mockito.when(iPokMetaProvider1.getPokemonMetadata(-1)).thenThrow(new PokedexException("Index inexistant"));
		Mockito.when(iPokMetaProvider1.getPokemonMetadata(151)).thenThrow(new PokedexException("Index outOfBounds"));
	}
	
}
