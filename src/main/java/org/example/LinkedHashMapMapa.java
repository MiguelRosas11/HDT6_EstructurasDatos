package org.example;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapMapa extends Mapa {
    public LinkedHashMapMapa() {
        super(new LinkedHashMap<String, Pokemon>());
    }
}
