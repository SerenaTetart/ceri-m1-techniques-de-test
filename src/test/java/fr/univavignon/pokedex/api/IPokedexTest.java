package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.util.List;

public class IPokedexTest {
    @Test
    public void someTest() throws PokedexException {
        Pokedex pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
        Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(-1);
        });

        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(1000);
        });

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
        Pokemon test = pokedex.getPokemon(0);
        assertEquals(test, Bulbizarre);
        test = pokedex.getPokemon(1);
        assertEquals(test, Aquali);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(pokemons.size(), 2);
        assertEquals(pokemons.get(0), Bulbizarre);
        assertEquals(pokemons.get(1), Aquali);

        pokemons = pokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(pokemons.size(), 2);
        assertEquals(pokemons.get(0), Bulbizarre);
        assertEquals(pokemons.get(1), Aquali);

        pokemons = pokedex.getPokemons(PokemonComparators.NAME);
        assertEquals(pokemons.size(), 2);
        assertEquals(pokemons.get(0), Aquali);
        assertEquals(pokemons.get(1), Bulbizarre);
    }
}
