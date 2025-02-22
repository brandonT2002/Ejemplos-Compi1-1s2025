package Clases.Instruccion;

import Clases.Abstractas.Expresion;
import Clases.Abstractas.Instruccion;
import Clases.Entorno.Entorno;
import Clases.Objetos.Jugadores;
import Clases.Objetos.Puntos;
import Clases.Utilidades.TipoInstruccion;

public class InstruccionesPartida extends Instruccion{
    Jugadores jugadores; 
    Expresion rondas; 
    Puntos puntos;
    public InstruccionesPartida(Jugadores jugadores, Expresion rondas, Puntos puntos) {
        super(TipoInstruccion.PARTIDA);
        this.jugadores = jugadores;
        this.rondas = rondas;
        this.puntos = puntos;
    }

    public void jugar(Entorno entorno) {
        rondas.jugar(entorno);
        puntos.cooperacion.jugar(entorno);
        puntos.defeccion.jugar(entorno);
        puntos.traidor.jugar(entorno);
        puntos.traicionado.jugar(entorno);
    }
}
