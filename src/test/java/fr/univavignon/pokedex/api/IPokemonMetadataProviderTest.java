package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {
	@Mock
    IPokemonMetadataProvider provider;
    @Before
    public void setup() {
        IPokemonMetadataProvider provider = mock(IPokemonMetadataProvider.class);
    }
    @Test
    public void someTest() throws PokedexException {
        IPokemonMetadataProvider providerTest = provider;
        Mockito.when(providerTest.getPokemonMetadata(0)).thenReturn(
                new PokemonMetadata(0, "Bulbizarre", 126, 126, 90)
        );
        Mockito.when(providerTest.getPokemonMetadata(0)).thenReturn(
                new PokemonMetadata(133, "Aquali", 186, 168, 260)
        );

        PokemonMetadata Bulbizarre = providerTest.getPokemonMetadata(0);
        assertEquals(Bulbizarre.getName(), "Bulbizarre");
        assertEquals(Bulbizarre.getAttack(), 126);
        assertEquals(Bulbizarre.getIndex(), 0);
        assertEquals(Bulbizarre.getDefense(), 168);
        assertEquals(Bulbizarre.getStamina(), 260);

        PokemonMetadata Aquali = providerTest.getPokemonMetadata(133);
        assertEquals(Aquali.getName(), "Aquali");
        assertEquals(Aquali.getAttack(), 186);
        assertEquals(Aquali.getIndex(), 133);
        assertEquals(Aquali.getDefense(), 168);
        assertEquals(Aquali.getStamina(), 260);
    }
}