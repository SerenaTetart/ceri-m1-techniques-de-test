package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokemonTrainerFactoryTest {
    @Test
    public void someTest() throws PokedexException {
        PokemonTrainerFactory pokemonTrainerFactory = new PokemonTrainerFactory();
        PokedexFactory pokedexFactory = new PokedexFactory();

        PokemonTrainer testTrainer = pokemonTrainerFactory.createTrainer("Sacha", Team.VALOR, pokedexFactory);
        assertEquals(testTrainer.getName(), "Sacha");
        assertEquals(testTrainer.getPokedex().size(), 0);
        assertEquals(testTrainer.getTeam(), Team.VALOR);

        testTrainer = pokemonTrainerFactory.createTrainer("Laura", Team.MYSTIC, pokedexFactory);
        assertEquals(testTrainer.getName(), "Laura");
        assertEquals(testTrainer.getPokedex().size(), 0);
        assertEquals(testTrainer.getTeam(), Team.MYSTIC);
    }
}
