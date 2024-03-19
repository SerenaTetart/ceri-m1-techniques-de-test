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
        assertEquals(sacha.getName(), "Sacha");
        assertEquals(sacha.getPokedex(), pokedex_1);
        assertEquals(sacha.getTeam(), Team.VALOR);
        PokemonTrainer laura = new PokemonTrainer("Laura", Team.MYSTIC, pokedex_2);
        assertEquals(laura.getName(), "Laura");
        assertEquals(laura.getTeam(), Team.MYSTIC);

        PokemonTrainer testTrainer = pokemonTrainerFactory.createTrainer("Sacha", Team.VALOR, pokedexFactory);
        assertEquals(testTrainer.getName(), sacha.getName());
        assertEquals(testTrainer.getPokedex(), sacha.getPokedex());
        assertEquals(testTrainer.getTeam(), sacha.getTeam());

        testTrainer = pokemonTrainerFactory.createTrainer("Laura", Team.MYSTIC, pokedexFactory);
        assertEquals(testTrainer.getName(), laura.getName());
        assertEquals(testTrainer.getPokedex(), laura.getPokedex());
        assertEquals(testTrainer.getTeam(), laura.getTeam());
    }
}
