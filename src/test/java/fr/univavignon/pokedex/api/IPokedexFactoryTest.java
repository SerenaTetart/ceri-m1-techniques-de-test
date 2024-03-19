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

        IPokedex pokedexTest = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        assertEquals(pokedexTest.size(), 0);
    }
}
