package org.example;

import java.util.Comparator;

public class Usuario {
    private Mapa coleccion;

    public Usuario(Mapa coleccion){
        this.coleccion = coleccion;
    }

    public void AgregarPokemon(String name, Pokemon pokemon){
        if(!coleccion.containsKey(name)){
            coleccion.put(name, pokemon);
            System.out.println("Se ha agregado correctamente");
        }
        else{
            System.out.println("El pokemon ya existe en la colección");
        }
    }

    public void mostrarColeccionOrdenadaPorTipo() {
        coleccion.mapaInterno.values().stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getType1() + "\n"));
    }


}
