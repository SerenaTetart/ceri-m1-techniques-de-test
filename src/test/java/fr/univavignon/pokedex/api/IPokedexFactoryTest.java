package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokedexFactoryTest {
    @Test
    public void someTest() throws PokedexException {
        PokedexFactory pokedexFactory = new PokedexFactory();

        IPokedex pokedexTest = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        assertEquals(pokedexTest.size(), 0);
    }
}
