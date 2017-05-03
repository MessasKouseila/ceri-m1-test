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
		assertEquals(Metadata.getIndex(), getProvider().getPokemonMetadata(0).getIndex());
		assertEquals(Metadata.getName(), getProvider().getPokemonMetadata(0).getName());
		assertEquals(Metadata.getAttack(), getProvider().getPokemonMetadata(0).getAttack());
		assertEquals(Metadata.getDefense(), getProvider().getPokemonMetadata(0).getDefense());
		assertEquals(Metadata.getStamina(), getProvider().getPokemonMetadata(0).getStamina());
		
		assertEquals(Metadata2.getIndex(), getProvider().getPokemonMetadata(133).getIndex());
		assertEquals(Metadata2.getName(), getProvider().getPokemonMetadata(133).getName());
		assertEquals(Metadata2.getAttack(), getProvider().getPokemonMetadata(133).getAttack());
		assertEquals(Metadata2.getDefense(), getProvider().getPokemonMetadata(133).getDefense());
		assertEquals(Metadata2.getStamina(), getProvider().getPokemonMetadata(133).getStamina());
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
