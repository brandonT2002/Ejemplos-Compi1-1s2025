package Clases.Objetos;

public class Partida {
    String nombre;
    public String jugador1;
    public String jugador2;
    public Object rondas;
    public Puntos puntos;
    public Partida(String nombre, String jugador1, String jugador2, Object rondas, Puntos puntos) {
        this.nombre = nombre;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.rondas = rondas;
        this.puntos = puntos;
    }
}
