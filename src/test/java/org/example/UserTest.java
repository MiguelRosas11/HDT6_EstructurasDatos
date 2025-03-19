package org.example;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class UserTest {
    private Usuario usuario;
    private Pokedex pokedex;
    private Mapa coleccion;

    @Before
    public void setUp() {
        coleccion = new HashMapMapa();
        pokedex = new Pokedex(new HashMapMapa());
        usuario = new Usuario(coleccion);

        Pokemon pikachu = new Pokemon("Pikachu", 25, "Electric", "None", "Mouse Pokémon",
                0.4, 6.0, Arrays.asList("Static", "Lightning Rod"), 1, false);
        pokedex.getPokemon("Pikachu");
    }

    @Test
    public void testAgregarPokemonExitoso() {
        usuario.AgregarPokemon("Pikachu", pokedex);
        assertTrue(coleccion.containsKey("Pikachu"));
    }

    @Test
    public void testAgregarPokemonNoExiste() {
        usuario.AgregarPokemon("Mewthree", pokedex);
        assertFalse(coleccion.containsKey("Mewthree"));
    }

    @Test
    public void testMostrarColeccionOrdenada() {
        usuario.AgregarPokemon("Pikachu", pokedex);
        usuario.mostrarColeccionOrdenadaPorTipo();
        assertTrue(true); // No lanza excepciones
    }

    @Test
    public void testMostrarColeccionVacia() {
        usuario.mostrarColeccionOrdenadaPorTipo();
        assertEquals(0, coleccion.mapaInterno.size());
    }
}