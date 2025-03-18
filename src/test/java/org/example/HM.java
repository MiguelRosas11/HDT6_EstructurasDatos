package org.example;
import java.util.HashMap;
import java.util.Map;

public class HM<K, V> extends Mapa<K, V> {
    @Override
    public Map<K, V> createMap() {
        return new HashMap<>();
    }
}
