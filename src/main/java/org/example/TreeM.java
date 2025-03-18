package org.example;
import java.util.Map;
import java.util.TreeMap;

public class TreeM<K, V> extends Mapa<K, V> {
    @Override
    public Map<K, V> createMap() {
        return new TreeMap<>();
    }
}
