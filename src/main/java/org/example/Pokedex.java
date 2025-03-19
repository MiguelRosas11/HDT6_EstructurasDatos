package org.example;
import java.io.*;
import java.util.*;

public class Pokedex {
    private Mapa pokedex;

    public Pokedex(Mapa pokedex) {
        this.pokedex = CargarPokemons(ruta, pokedex);
    }

    static String ruta = "C:/Users/rogue/OneDrive/Escritorio/pokemon_data_pokeapi.csv";

    public Mapa CargarPokemons(String ruta, Mapa pokedex) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String line;
            br.readLine(); // Saltar encabezado

            while ((line = br.readLine()) != null) {
                try {
                    // ✅ Usar un analizador de CSV adecuado
                    String[] data = parseCSVLine(line);

                    String name = data[0].trim();
                    int number = Integer.parseInt(data[1].trim());
                    String type1 = data[2].trim();
                    String type2 = data[3].trim().isEmpty() ? "None" : data[3].trim();
                    String classification = data[4].trim();
                    double height = Double.parseDouble(data[5].trim());
                    double weight = Double.parseDouble(data[6].trim());

                    // ✅ Manejar correctamente las habilidades con comas dentro de valores
                    String abilitiesRaw = data[7].trim();
                    List<String> abilities = Arrays.asList(abilitiesRaw.split(",\\s*"));

                    int generation = Integer.parseInt(data[8].trim());
                    boolean isLegendary = data[9].trim().equalsIgnoreCase("Yes");

                    Pokemon pokemon = new Pokemon(name, number, type1, type2, classification,
                            height, weight, abilities, generation, isLegendary);

                    pokedex.put(name, pokemon);
                } catch (Exception e) {
                    System.err.println("Error al procesar línea: " + line);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return pokedex;
    }

    private String[] parseCSVLine(String line) {
        List<String> values = new ArrayList<>();
        boolean insideQuotes = false;
        StringBuilder currentValue = new StringBuilder();

        for (char c : line.toCharArray()) {
            if (c == '"') {
                insideQuotes = !insideQuotes; // Alternar estado de comillas
            } else if (c == ',' && !insideQuotes) {
                values.add(currentValue.toString().trim());
                currentValue.setLength(0);
            } else {
                currentValue.append(c);
            }
        }
        values.add(currentValue.toString().trim());

        return values.toArray(new String[0]);
    }

    public void mostrarTodosOrdenadosPorTipo() {
        List<Pokemon> listaPokemon = new ArrayList<>(pokedex.mapaInterno.values());
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


    public void buscarPorHabilidad(String habilidad) {
        boolean encontrado = false;

        for (Pokemon p : pokedex.mapaInterno.values()) {
            if (p.getAbilities().contains(habilidad)) {
                System.out.println(p.getName());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron Pokémon con la habilidad: " + habilidad);
        }
    }

    public void buscarPorNombre(String name) {
        Pokemon pokemon = pokedex.get(name);  // ✅ Buscar directamente en el `Map`

        if (pokemon != null) {
            System.out.println("Nombre: " + pokemon.getName());
            System.out.println("Tipo 1: " + pokemon.getType1());
            System.out.println("Tipo 2: " + pokemon.getType2());
            System.out.println("Altura: " + pokemon.getHeight() + " m");
            System.out.println("Peso: " + pokemon.getWeight() + " kg");
            System.out.println("Clasificación: " + pokemon.getClassification());
            System.out.println("Habilidades: " + String.join(", ", pokemon.getAbilities()));
        } else {
            System.out.println("No se encontró un Pokémon con el nombre: " + name);
        }
    }




    public Pokemon getPokemon(String name) {
        return pokedex.get(name);
    }


}