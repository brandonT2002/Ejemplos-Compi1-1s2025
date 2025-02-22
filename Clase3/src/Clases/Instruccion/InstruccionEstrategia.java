package Clases.Instruccion;

import java.util.ArrayList;

import Clases.Abstractas.Expresion;
import Clases.Abstractas.Instruccion;
import Clases.Entorno.Entorno;
import Clases.Utilidades.TipoInstruccion;

public class InstruccionEstrategia extends Instruccion{
    Expresion inicio;
    ArrayList<Regla> reglas;
    public InstruccionEstrategia (Expresion inicio, ArrayList<Regla> reglas) {
        super(TipoInstruccion.ESTRATEGIA);
        this.inicio = inicio;
        this.reglas = reglas;
    }

    public void jugar(Entorno entorno) {
        inicio.jugar(entorno);
        for (Regla regla : reglas) {
            regla.jugar(entorno);
        }
    }
}
