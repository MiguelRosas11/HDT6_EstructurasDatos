package org.example;

import java.util.Comparator;

public class Usuario {
    private Mapa coleccion;

    public Usuario(Mapa coleccion){
        this.coleccion = coleccion;
    }


    public void AgregarPokemon(String name, Pokedex pokedex){
        if (!coleccion.containsKey(name)) {
            Pokemon pokemon = pokedex.getPokemon(name);

            if (pokemon != null) {
                coleccion.put(name, pokemon);  // ✅ Agregarlo a la colección
                System.out.println("Se ha agregado correctamente");
            } else {
                System.out.println("El Pokémon no existe en la Pokédex");
            }
        } else {
            System.out.println("El Pokémon ya existe en la colección");
        }
    }

    public void mostrarColeccionOrdenadaPorTipo() {
        coleccion.mapaInterno.values().stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getType1() + "\n"));
    }


}
