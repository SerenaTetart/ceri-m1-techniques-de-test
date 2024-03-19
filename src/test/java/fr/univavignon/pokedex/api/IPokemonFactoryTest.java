package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Random;
public class IPokemonFactoryTest {
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void someTest() throws PokedexException {
        Pokedex pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
        Random rand = new Random();
        Mockito.when(pokedex.createPokemon(0, 613, 64, 4000, 4)).thenReturn(
                new Pokemon(0, "Bulbizarre", 126+rand.nextInt(16), 126+rand.nextInt(16), 90+rand.nextInt(16), 613, 64, 4000, 4, 56)
        );
        Mockito.when(pokedex.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(
                new Pokemon(133, "Aquali", 186+rand.nextInt(16), 168+rand.nextInt(16), 260+rand.nextInt(16), 2729, 202, 5000, 4, 100)
        );

        PokemonMetadata Bulbizarre = pokedex.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(Bulbizarre.getName(), "Bulbizarre");
        assertEquals(Bulbizarre.getIndex(), 0);
        assertTrue(Bulbizarre.getAttack() >= 126 && Bulbizarre.getAttack() <= 126+15);
        assertTrue(Bulbizarre.getDefense() >= 126 && Bulbizarre.getDefense() <= 126+15);
        assertTrue(Bulbizarre.getStamina() >= 90 && Bulbizarre.getStamina() <= 90+15);

        PokemonMetadata Aquali = pokedex.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(Aquali.getName(), "Aquali");
        assertEquals(Aquali.getIndex(), 133);
        assertTrue(Aquali.getAttack() >= 186 && Aquali.getAttack() <= 186+15);
        assertTrue(Aquali.getDefense() >= 168 && Aquali.getDefense() <= 168+15);
        assertTrue(Aquali.getStamina() >= 260 && Aquali.getStamina() <= 260+15);
    }
}
