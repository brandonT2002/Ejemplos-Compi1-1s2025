package Clases.Objetos;

import Clases.Instruccion.InstruccionEstrategia;

public class Estrategia {
    String nombre;
    InstruccionEstrategia instrucciones;
    public Estrategia(String nombre, InstruccionEstrategia instrucciones) {
        this.nombre = nombre;
        this.instrucciones = instrucciones;
    }
}
