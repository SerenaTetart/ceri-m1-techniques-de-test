package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokemonTrainerFactoryTest {
    @Mock
    IPokemonTrainerFactory pokemonTrainerFactory;
    IPokedexFactory pokedexFactory;
    IPokedex pokedex_1;
    IPokedex pokedex_2;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void someTest() throws PokedexException {
        PokemonTrainer sacha = new PokemonTrainer("Sacha", Team.VALOR, pokedex_1);
        PokemonTrainer laura = new PokemonTrainer("Laura", Team.MYSTIC, pokedex_2);
        Mockito.when(pokemonTrainerFactory.createTrainer("Sacha", Team.VALOR, pokedexFactory)).thenReturn(
                sacha
        );
        Mockito.when(pokemonTrainerFactory.createTrainer("Laura", Team.MYSTIC, pokedexFactory)).thenReturn(
                laura
        );

        PokemonTrainer testTrainer = pokemonTrainerFactory.createTrainer("Sacha", Team.VALOR, pokedexFactory);
        assertEquals(testTrainer, sacha);
        testTrainer = pokemonTrainerFactory.createTrainer("Laura", Team.MYSTIC, pokedexFactory);
        assertEquals(testTrainer, laura);
    }
}
