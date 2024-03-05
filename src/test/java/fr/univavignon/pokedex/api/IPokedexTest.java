package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class IPokedexTest {
    @Mock
    IPokedex pokedex;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void someTest() throws PokedexException {
        Mockito.when(pokedex.size()).thenReturn(0, 1, 2);
        Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
        Mockito.when(pokedex.addPokemon(Bulbizarre)).thenReturn(0);
        Mockito.when(pokedex.addPokemon(Aquali)).thenReturn(1);
        Mockito.when(pokedex.getPokemon(0)).thenReturn(Bulbizarre);
        Mockito.when(pokedex.getPokemon(133)).thenReturn(Aquali);
        Mockito.when(pokedex.getPokemons()).thenReturn(new ArrayList<Pokemon>(Arrays.asList(Bulbizarre, Aquali)));

        int size = pokedex.size();
        assertEquals(size, 0);
        int index = pokedex.addPokemon(Bulbizarre);
        assertEquals(index, 0);
        size = pokedex.size();
        assertEquals(size, 1);
        index = pokedex.addPokemon(Aquali);
        assertEquals(index, 1);
        size = pokedex.size();
        assertEquals(size, 2);
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(pokemons.size(), 2);
        assertEquals(pokemons.get(0), Bulbizarre);
        assertEquals(pokemons.get(1), Aquali);
    }
}
