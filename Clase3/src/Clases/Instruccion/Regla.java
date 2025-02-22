package Clases.Instruccion;

import Clases.Abstractas.Expresion;
import Clases.Abstractas.Instruccion;
import Clases.Entorno.Entorno;
import Clases.Utilidades.TipoInstruccion;

public class Regla extends Instruccion {
    Expresion condicion;
    Expresion acion;
    public Regla(Expresion condicion, Expresion acion) {
        super(TipoInstruccion.REGLA);
        this.condicion = condicion;
        this.acion = acion;
    }

    public void jugar(Entorno entorno) {
        if (condicion != null) {
            condicion.jugar(entorno);
        }
        acion.jugar(entorno);
    }
}
