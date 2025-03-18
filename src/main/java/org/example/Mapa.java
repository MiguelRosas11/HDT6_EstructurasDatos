package org.example;

import java.util.Map;
import java.util.function.BiConsumer;

public abstract class Mapa implements iMap{
    protected Map<String, Pokemon> mapaInterno;  // ✅ Internamente usa un HashMap, TreeMap o LinkedHashMap

    public Mapa(Map<String, Pokemon> mapa) {
        this.mapaInterno = mapa;
    }

    @Override
    public Map<String, Pokemon> createMap() {
        return mapaInterno;
    }

    public void put(String key, Pokemon pokemon) {
        mapaInterno.put(key, pokemon);
    }

    public Pokemon get(String key) {
        return mapaInterno.get(key);
    }

    public boolean containsKey(String key) {
        return mapaInterno.containsKey(key);
    }

    public boolean isEmpty() {
        return mapaInterno.isEmpty();
    }

    public void forEach(BiConsumer<? super String, ? super Pokemon> action) {
        mapaInterno.forEach(action);
    }
}
