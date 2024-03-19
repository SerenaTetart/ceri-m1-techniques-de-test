package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class IPokemonMetadataProviderTest {
    @Test
    public void someTest() throws PokedexException {
        Pokedex pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());

        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemonMetadata(-1);
        });

        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemonMetadata(152);
        });

        PokemonMetadata Bulbizarre = pokedex.getPokemonMetadata(0);
        assertEquals(Bulbizarre.getName(), "Bulbizarre");
        assertEquals(Bulbizarre.getIndex(), 0);
        assertEquals(Bulbizarre.getAttack(), 126);
        assertEquals(Bulbizarre.getDefense(), 126);
        assertEquals(Bulbizarre.getStamina(), 90);

        PokemonMetadata Aquali = pokedex.getPokemonMetadata(133);
        assertEquals(Aquali.getName(), "Aquali");
        assertEquals(Aquali.getIndex(), 133);
        assertEquals(Aquali.getAttack(), 186);
        assertEquals(Aquali.getDefense(), 168);
        assertEquals(Aquali.getStamina(), 260);
    }
}