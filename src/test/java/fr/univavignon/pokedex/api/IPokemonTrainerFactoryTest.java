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
        Pokedex pokedex_1 = (Pokedex) pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        Pokedex pokedex_2 = (Pokedex) pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        PokemonTrainer sacha = new PokemonTrainer("Sacha", Team.VALOR, pokedex_1);
        PokemonTrainer laura = new PokemonTrainer("Laura", Team.MYSTIC, pokedex_2);

        PokemonTrainer testTrainer = pokemonTrainerFactory.createTrainer("Sacha", Team.VALOR, pokedexFactory);
        assertEquals(testTrainer, sacha);
        testTrainer = pokemonTrainerFactory.createTrainer("Laura", Team.MYSTIC, pokedexFactory);
        assertEquals(testTrainer, laura);
    }
}
