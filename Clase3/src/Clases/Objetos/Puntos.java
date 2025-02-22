package Clases.Objetos;

import Clases.Abstractas.Expresion;

public class Puntos {
    public Expresion cooperacion;
    public Expresion defeccion;
    public Expresion traidor;
    public Expresion traicionado;
    public Puntos(Expresion cooperacion, Expresion defeccion, Expresion traidor, Expresion traicionado) {
        this.cooperacion = cooperacion;
        this.defeccion = defeccion;
        this.traidor = traidor;
        this.traicionado = traicionado;
    }
}
