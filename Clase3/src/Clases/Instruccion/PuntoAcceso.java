package Clases.Instruccion;

import Clases.Abstractas.Instruccion;
import Clases.Entorno.Entorno;
import Clases.Objetos.Estrategia;
import Clases.Objetos.Partida;
import Clases.Utilidades.TipoInstruccion;

public class PuntoAcceso extends Instruccion{
    Object partida;
    int rondas;
    boolean decision1;
    boolean decision2;
    int cooperacion = 0;
    int defeccion = 0;
    int traidor = 0;
    int traicionado = 0;
    int puntuacion1 = 0;
    int puntuacion2 = 0;
    public PuntoAcceso(Object partida) {
        super(TipoInstruccion.MAIN);
        this.partida = partida;
    }

    public void jugar(Entorno entorno) {
        Partida partida = entorno.obtenerPartida(this.partida.toString());
        if (partida != null) {
            this.rondas = (int) partida.rondas;

            Estrategia estrategia1 = entorno.obtenerEstrategia(partida.jugador1);
            Estrategia estrategia2 = entorno.obtenerEstrategia(partida.jugador2);

            cooperacion = (int) partida.puntos.cooperacion.jugar(entorno).valor;
            defeccion = (int) partida.puntos.defeccion.jugar(entorno).valor;
            traidor = (int) partida.puntos.traidor.jugar(entorno).valor;
            traicionado = (int) partida.puntos.traicionado.jugar(entorno).valor;

            for (int i = 1; i <= rondas; i++) {
                decision1 = (boolean) validarRegla(entorno, estrategia1);
                decision2 = (boolean) validarRegla(entorno, estrategia2);
                formato();
            }
        }
        System.out.println(puntuacion1);
        System.out.println(puntuacion2);
    }

    public Object validarRegla(Entorno entorno, Estrategia estrategia) {
        Object decisonDefault = null;

        for (Regla regla : estrategia.instrucciones.reglas) {
            if (regla.condicion != null) {
                // regla if CONDICION then ACCION 
            }
            decisonDefault = regla.acion.jugar(entorno).valor;
        }
        return decisonDefault;
    }

    public void formato() {
        if (decision1 && decision2) { // Cooperacon mutua
            puntuacion1 += cooperacion;
            puntuacion2 += cooperacion;
        } else if (!decision1 && !decision2) { // Defección mutua
            puntuacion1 += defeccion;
            puntuacion2 += defeccion;
        } else if (!decision1 && decision2) { // Estrategia 1 defectuo - Estrategia coopero
            puntuacion1 += traidor;
            puntuacion2 += traicionado;
        } else { // Estrategia 1 coopero - Estrartegia 2 defectua
            puntuacion1 += traicionado;
            puntuacion2 += traidor;
        }
    }
}
