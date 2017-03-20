package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public final class IPokemonMetadataProviderTest {
	
	@Mock private IPokemonMetadataProvider iPokMetaProvider1;
	
	private PokemonMetadata Metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
	private PokemonMetadata Metadata2 = new PokemonMetadata(133, "Aquali", 186, 168, 260);
	
	@Test
	public void getPokemonMetadataTest() throws PokedexException {
		assertEquals(iPokMetaProvider1.getPokemonMetadata(0).getIndex(), Metadata.getIndex());
		assertEquals(iPokMetaProvider1.getPokemonMetadata(0).getName(), Metadata.getName());
		assertEquals(iPokMetaProvider1.getPokemonMetadata(0).getAttack(), Metadata.getAttack());
		assertEquals(iPokMetaProvider1.getPokemonMetadata(0).getDefense(), Metadata.getDefense());
		assertEquals(iPokMetaProvider1.getPokemonMetadata(0).getStamina(), Metadata.getStamina());
		
		assertEquals(iPokMetaProvider1.getPokemonMetadata(133).getIndex(), Metadata2.getIndex());
		assertEquals(iPokMetaProvider1.getPokemonMetadata(133).getName(), Metadata2.getName());
		assertEquals(iPokMetaProvider1.getPokemonMetadata(133).getAttack(), Metadata2.getAttack());
		assertEquals(iPokMetaProvider1.getPokemonMetadata(133).getDefense(), Metadata2.getDefense());
		assertEquals(iPokMetaProvider1.getPokemonMetadata(133).getStamina(), Metadata2.getStamina());
	}

	@Test(expected = PokedexException.class)
	public void execptionIndex() throws PokedexException {
		iPokMetaProvider1.getPokemonMetadata(-1);	
	}
	@Test(expected = PokedexException.class)
	public void execptionIndexOut() throws PokedexException {
		iPokMetaProvider1.getPokemonMetadata(151);	
	}
	
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(iPokMetaProvider1.getPokemonMetadata(0)).thenReturn(Metadata);
		Mockito.when(iPokMetaProvider1.getPokemonMetadata(133)).thenReturn(Metadata2);
		Mockito.when(iPokMetaProvider1.getPokemonMetadata(-1)).thenThrow(new PokedexException("Index inexistant"));
		Mockito.when(iPokMetaProvider1.getPokemonMetadata(151)).thenThrow(new PokedexException("Index outOfBounds"));
	}
	
}
