package Clases.Instruccion;

import Clases.Abstractas.Expresion;
import Clases.Abstractas.Instruccion;
import Clases.Entorno.Entorno;
import Clases.Objetos.Estrategia;
import Clases.Objetos.Partida;
import Clases.Utilidades.Salida;
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

    Estrategia estrategia1;
    Estrategia estrategia2;
    public PuntoAcceso(Object partida) {
        super(TipoInstruccion.MAIN);
        this.partida = partida;
    }

    public void jugar(Entorno entorno) {
        Partida partida = entorno.obtenerPartida(this.partida.toString());
        if (partida != null) {
            this.rondas = (int) partida.rondas;
            entorno.setPartidaActual(partida);

            estrategia1 = entorno.obtenerEstrategia(partida.jugador1);
            estrategia2 = entorno.obtenerEstrategia(partida.jugador2);

            cooperacion = (int) partida.puntos.cooperacion.jugar(entorno).valor;
            defeccion = (int) partida.puntos.defeccion.jugar(entorno).valor;
            traidor = (int) partida.puntos.traidor.jugar(entorno).valor;
            traicionado = (int) partida.puntos.traicionado.jugar(entorno).valor;

            Salida.salidaConsola.add("=== PARTIDA ===");
            Salida.salidaConsola.add("-> CONFIGURACION");
            Salida.salidaConsola.add("\t-> Estrategias: " + estrategia1.nombre + " vs " + estrategia2.nombre);
            Salida.salidaConsola.add("\t-> Rondas: " + rondas);
            Salida.salidaConsola.add("\t-> Scoring: ");
            Salida.salidaConsola.add("\t\t-> Cooperación Mutua: " + cooperacion);
            Salida.salidaConsola.add("\t\t-> Defección Mutua: " + defeccion);
            Salida.salidaConsola.add("\t\t-> Traición: " + traidor + "/" + traicionado + " (Traidor/Traicionado)");
            Salida.salidaConsola.add("-> DESARROLLO");

            for (int i = 0; i < rondas; i++) {
                entorno.setRondaActual(i);
                if (i == 0) {
                    decision1 = decisionInicial(entorno, estrategia1);
                    decision2 = decisionInicial(entorno, estrategia2);
                    formato(i, estrategia1.nombre, estrategia2.nombre);
                } else {
                    decision1 = (boolean) validarRegla(entorno, estrategia1);
                    decision2 = (boolean) validarRegla(entorno, estrategia2);
                    formato(i, estrategia1.nombre, estrategia2.nombre);
                }
            }
        }
        Salida.salidaConsola.add("-> RESULTADO");
        Salida.salidaConsola.add("\t-> Puntuación " + estrategia1.nombre + ": " + puntuacion1);
        Salida.salidaConsola.add("\t-> Puntuación " + estrategia2.nombre + ": " + puntuacion2);
    }

    public boolean decisionInicial(Entorno entorno, Estrategia estrategia) {
        Expresion decisionInicial = estrategia.instrucciones.inicio;
        return (boolean) decisionInicial.jugar(entorno).valor;
    }

    public Object validarRegla(Entorno entorno, Estrategia estrategia) {
        Object decisonDefault = null;

        for (Regla regla : estrategia.instrucciones.reglas) {
            if (regla.condicion != null && (boolean) regla.condicion.jugar(entorno).valor) {
                // regla if CONDICION then ACCION 
                return regla.acion.jugar(entorno).valor;
            } else if (regla.condicion == null) {
                decisonDefault = regla.acion.jugar(entorno).valor;
            }
        }
        return decisonDefault;
    }

    public void formato(int i, String estrategia1, String estrategia2) {
        if (decision1 && decision2) { // Cooperacon mutua
            Salida.salidaConsola.add("\t-> Ronda: " + i + ": " + estrategia1 + " = COOPERATE" + " , " + estrategia2 + " = COOPERATE (" + cooperacion + "-" + cooperacion + ")");
            puntuacion1 += cooperacion;
            puntuacion2 += cooperacion;
        } else if (!decision1 && !decision2) { // Defección mutua
            Salida.salidaConsola.add("\t-> Ronda: " + i + ": " + estrategia1 + " = DEFECT" + " , " + estrategia2 + " = DEFECT (" + defeccion + "-" + defeccion + ")");
            puntuacion1 += defeccion;
            puntuacion2 += defeccion;
        } else if (!decision1 && decision2) { // Estrategia 1 defectuo - Estrategia coopero
            Salida.salidaConsola.add("\t-> Ronda: " + i + ": " + estrategia1 + " = DEFECT" + " , " + estrategia2 + " = COOPERATE (" + traidor + "-" + traicionado + ")");
            puntuacion1 += traidor;
            puntuacion2 += traicionado;
        } else { // Estrategia 1 coopero - Estrartegia 2 defectua
            Salida.salidaConsola.add("\t-> Ronda: " + i + ": " + estrategia1 + " = COOPERATE" + " , " + estrategia2 + " = DEFECT (" + traicionado + "-" + traidor + ")");
            puntuacion1 += traicionado;
            puntuacion2 += traidor;
        }
    }
}
