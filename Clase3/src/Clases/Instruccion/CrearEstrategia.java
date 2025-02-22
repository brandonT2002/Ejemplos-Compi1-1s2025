package Clases.Instruccion;

import Clases.Abstractas.Instruccion;
import Clases.Entorno.Entorno;
import Clases.Objetos.Estrategia;
import Clases.Utilidades.TipoInstruccion;

public class CrearEstrategia extends Instruccion {
    String nombre;
    InstruccionEstrategia instrucciones;
    public CrearEstrategia(String nombre, InstruccionEstrategia instrucciones) {
        super(TipoInstruccion.ESTRATEGIA);
        this.nombre = nombre;
        this.instrucciones = instrucciones;
    }

    public void jugar(Entorno entorno) {
        Estrategia estrategia = new Estrategia(nombre, instrucciones);
        entorno.guardarEstrategia(nombre, estrategia);
        System.out.println("guardó la estrategia");
    }
}
