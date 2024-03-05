package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class IPokedexFactoryTest {
    @Mock
    IPokedexFactory pokedexFactory;
    IPokemonMetadataProvider metadataProvider;
    IPokemonFactory pokemonFactory;
    IPokedex pokedex;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        //IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        //IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        //IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        //IPokedex pokedex = mock(IPokedex.class);
    }
    @Test
    public void someTest() throws PokedexException {
        Mockito.when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        IPokedex pokedexTest = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertEquals(pokedexTest, pokedex);
    }
}
