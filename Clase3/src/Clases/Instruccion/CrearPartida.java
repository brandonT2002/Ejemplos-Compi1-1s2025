package Clases.Instruccion;

import Clases.Abstractas.Instruccion;
import Clases.Entorno.Entorno;
import Clases.Objetos.Partida;
import Clases.Utilidades.TipoInstruccion;
import Clases.Utilidades.TipoRetorno;

public class CrearPartida extends Instruccion {
    String nombre;
    InstruccionesPartida instrucciones;
    public CrearPartida(String nombre, InstruccionesPartida instrucciones) {
        super(TipoInstruccion.PARTIDA);
        this.nombre = nombre;
        this.instrucciones = instrucciones;
    }

    public void jugar(Entorno entorno) {
        String jugador1 = instrucciones.jugadores.jugador1;
        String jugador2 = instrucciones.jugadores.jugador2;
        TipoRetorno rondas = instrucciones.rondas.jugar(entorno);
        Partida partida = new Partida(nombre, jugador1, jugador2, rondas.valor, instrucciones.puntos);
        entorno.guardarPartida(nombre, partida);
    }
}
