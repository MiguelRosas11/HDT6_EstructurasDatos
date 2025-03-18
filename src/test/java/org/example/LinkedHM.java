package org.example;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHM<K, V> extends Mapa<K, V> {
    @Override
    public Map<K, V> createMap() {
        return new LinkedHashMap<>();
    }
}
