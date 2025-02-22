package Clases.Entorno;

import java.util.Map;
import java.util.TreeMap;

import Clases.Objetos.Estrategia;

public class Entorno {
    String nombre;
    public Map<String, Estrategia> estrategias = new TreeMap<>();

    public Entorno(String nombre) {
        this.nombre = nombre;
    }

    public boolean guardarEstrategia(String nombre, Estrategia estrategia) {
        if (!this.estrategias.containsKey(nombre)) {
            this.estrategias.put(nombre, estrategia);
            System.out.println("Se está guardando la estrategia");
            return true;
        }
        return false;
    }
}
