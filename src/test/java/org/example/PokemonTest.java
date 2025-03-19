package org.example;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class PokemonTest {

    @Test
    public void testGetName() {
        Pokemon pokemon = new Pokemon("Pikachu", 25, "Electric", "None", "Mouse Pokémon", 0.4, 6.0,
                Arrays.asList("Static", "Lightning Rod"), 1, false);
        assertEquals("Pikachu", pokemon.getName());
    }

    @Test
    public void testGetNameIncorrecto() {
        Pokemon pokemon = new Pokemon("Pikachu", 25, "Electric", "None", "Mouse Pokémon", 0.4, 6.0,
                Arrays.asList("Static", "Lightning Rod"), 1, false);
        assertNotEquals("Charmander", pokemon.getName());
    }

    @Test
    public void testGetAbilities() {
        List<String> abilities = Arrays.asList("Static", "Lightning Rod");
        Pokemon pokemon = new Pokemon("Pikachu", 25, "Electric", "None", "Mouse Pokémon", 0.4, 6.0, abilities, 1, false);
        assertEquals(abilities, pokemon.getAbilities());
    }

    @Test
    public void testGetAbilitiesIncorrecto() {
        List<String> abilities = Arrays.asList("Static", "Lightning Rod");
        Pokemon pokemon = new Pokemon("Pikachu", 25, "Electric", "None", "Mouse Pokémon", 0.4, 6.0, abilities, 1, false);
        assertNotEquals(Arrays.asList("Blaze"), pokemon.getAbilities());
    }
}