package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        List<Pokemon> listaPokemon = new ArrayList<>(coleccion.mapaInterno.values());

        Collections.sort(listaPokemon, new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2) {
                return p1.getType1().compareTo(p2.getType1());
            }
        });

        for (Pokemon p : listaPokemon) {
            System.out.println(p.getName() + " - " + p.getType1());
        }
    }


}
