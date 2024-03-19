package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class IPokedexFactoryTest {
    @Test
    public void someTest() throws PokedexException {
        PokedexFactory pokedexFactory = new PokedexFactory();
        Mockito.when(pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory())).thenReturn(new Pokedex(new PokemonMetadataProvider(), new PokemonFactory()));

        IPokedex pokedexTest = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        assertEquals(pokedexTest, new Pokedex(new PokemonMetadataProvider(), new PokemonFactory()));
    }
}
