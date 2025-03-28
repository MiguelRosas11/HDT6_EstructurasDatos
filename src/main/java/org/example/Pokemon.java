package org.example;

import java.util.List;

public class Pokemon {
    private String name;
    private int pokedexNumber;
    private String type1;
    private String type2;
    private String classification;
    private double height;
    private double weight;
    private List<String> abilities;
    private int generation;
    private boolean isLegendary;

    public Pokemon(String name, int pokedexNumber, String type1, String type2,
                   String classification, double height, double weight,
                   List<String> abilities, int generation, boolean isLegendary) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.isLegendary = isLegendary;
    }

    public String getName() { return name; }
    public String getType1() { return type1; }
    public List<String> getAbilities() { return abilities; }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getGeneration() {
        return generation;
    }

    public String getClassification() {
        return classification;
    }

    public String getType2() {
        return type2;
    }

}
