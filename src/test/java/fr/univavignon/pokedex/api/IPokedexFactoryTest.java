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
    PokedexFactory pokedexFactory;
    PokemonMetadataProvider metadataProvider;
    PokemonFactory pokemonFactory;
    Pokedex pokedex;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void someTest() throws PokedexException {
        Mockito.when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        IPokedex pokedexTest = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertEquals(pokedexTest, pokedex);
    }
}
