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
    @Test
    public void someTest() throws PokedexException {
        Pokedex pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
        Random rand = new Random();

        Pokemon Bulbizarre = pokedex.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(Bulbizarre.getName(), "Bulbizarre");
        assertEquals(Bulbizarre.getIndex(), 0);
        assertTrue(Bulbizarre.getAttack() >= 126 && Bulbizarre.getAttack() <= 126+15);
        assertTrue(Bulbizarre.getDefense() >= 126 && Bulbizarre.getDefense() <= 126+15);
        assertTrue(Bulbizarre.getStamina() >= 90 && Bulbizarre.getStamina() <= 90+15);
        assertEquals(613, Bulbizarre.getCp());
        assertEquals(64, Bulbizarre.getHp());
        assertEquals(4000, Bulbizarre.getDust());
        assertEquals(4, Bulbizarre.getCandy());
        assertEquals(56, Bulbizarre.getIv());

        Pokemon Aquali = pokedex.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(Aquali.getName(), "Aquali");
        assertEquals(Aquali.getIndex(), 133);
        assertTrue(Aquali.getAttack() >= 186 && Aquali.getAttack() <= 186+15);
        assertTrue(Aquali.getDefense() >= 168 && Aquali.getDefense() <= 168+15);
        assertTrue(Aquali.getStamina() >= 260 && Aquali.getStamina() <= 260+15);
        assertEquals(2729, Aquali.getCp());
        assertEquals(202, Aquali.getHp());
        assertEquals(5000, Aquali.getDust());
        assertEquals(4, Aquali.getCandy());
        assertEquals(100, Aquali.getIv());
    }
}
