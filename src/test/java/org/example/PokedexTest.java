package org.example;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class PokedexTest {
    private Pokedex pokedex;

    @Before
    public void setUp() {
        Mapa mapaPokedex = new HashMapMapa();
        pokedex = new Pokedex(mapaPokedex);

        Pokemon bulbasaur = new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon",
                0.7, 6.9, Arrays.asList("Overgrow", "Chlorophyll"), 1, false);
        mapaPokedex.put("Bulbasaur", bulbasaur);
    }


    @Test
    public void testBuscarPokemonExistente() {
        Pokemon p = pokedex.getPokemon("Bulbasaur");
        assertNotNull(p);
        assertEquals("Grass", p.getType1());
    }


    @Test
    public void testBuscarPokemonNoExiste() {
        assertNull(pokedex.getPokemon("Mewthree"));
    }


    @Test
    public void testBuscarPorHabilidadExistente() {
        pokedex.buscarPorHabilidad("Overgrow");
        assertTrue(true); // No lanza excepciones
    }


    @Test
    public void testBuscarPorHabilidadNoExiste() {
        pokedex.buscarPorHabilidad("InexistenteSkill");
        assertTrue(true); // No lanza excepciones
    }
}