package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {
	
	public PokemonMetadata Metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
	public PokemonMetadata Metadata2 = new PokemonMetadata(133, "Aquali", 186, 168, 260);

	public IPokemonMetadataProvider iPokMetaProvider1;
	
	

	@Test
	public void getPokemonMetadataTest() throws PokedexException {
		
		iPokMetaProvider1 = getIPokemonMetadataProvider(0);
		assertEquals(iPokMetaProvider1.getPokemonMetadata(0), Metadata);
		
		iPokMetaProvider1 = getIPokemonMetadataProvider(133);
		assertEquals(iPokMetaProvider1.getPokemonMetadata(133), Metadata2);
	}
	/*
	@Test (expected=PokedexException.class)
	public void execptionIndex() throws PokedexException {
		iPokMetaProvider1 = getIPokemonMetadataProvider(-1);
		iPokMetaProvider1.getPokemonMetadata(-1);
	}*/
	
	
	public IPokemonMetadataProvider getIPokemonMetadataProvider(int index) throws PokedexException {
		
		IPokemonMetadataProvider iPokMetaProvider;
		
		iPokMetaProvider = Mockito.mock(IPokemonMetadataProvider.class);
		if (index == 0)
			Mockito.when(iPokMetaProvider.getPokemonMetadata(0)).thenReturn(Metadata);
		if (index == 133)
			Mockito.when(iPokMetaProvider.getPokemonMetadata(133)).thenReturn(Metadata2);
		if (index < 0)
			Mockito.when(iPokMetaProvider.getPokemonMetadata(0)).thenThrow(new PokedexException("Index inexistatn"));
		return iPokMetaProvider;
	}
	
}
