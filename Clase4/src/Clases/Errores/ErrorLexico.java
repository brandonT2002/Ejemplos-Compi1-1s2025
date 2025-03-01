package Clases.Errores;

public class ErrorLexico {
    int linea;
    int columna;
    String caracter;
    public ErrorLexico(int linea, int columna, String caracter) {
        this.linea = linea;
        this.columna = columna;
        this.caracter = caracter;
    }
    public String toString() {
        return linea + " ".repeat(6 - String.valueOf(linea).length()) + columna + " ".repeat(8 - String.valueOf(columna).length()) + "Caracter no reconocido: " + caracter;
    }
}
