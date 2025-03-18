package org.example;
import java.io.*;
import java.util.*;

public class CSV {


    public static Map<String, Pokemon> CargarPokemons(String ruta, Mapa<String, Pokemon> factory) {
        Map<String, Pokemon> pokemonMap = factory.createMap();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String name = data[0];
                int pokedexNumber = Integer.parseInt(data[1]);
                String type1 = data[2];
                String type2 = data[3].isEmpty() ? "None" : data[3];
                String classification = data[4];
                double height = Double.parseDouble(data[5]);
                double weight = Double.parseDouble(data[6]);
                List<String> abilities = Arrays.asList(data[7].split(","));
                int generation = Integer.parseInt(data[8]);
                boolean isLegendary = data[9].equalsIgnoreCase("Yes");

                Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification,
                        height, weight, abilities, generation, isLegendary);
                pokemonMap.put(name, pokemon);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return pokemonMap;
    }
}