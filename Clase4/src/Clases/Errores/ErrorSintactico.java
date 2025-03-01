package Clases.Errores;

public class ErrorSintactico {
    int linea;
    int columna;
    Object toke;
    String tipo;

    String error;
    public ErrorSintactico(int linea, int columna, Object toke, String tipo) {
        this.linea = linea;
        this.columna = columna;
        this.toke = toke;
        this.tipo = tipo;
    }

    public ErrorSintactico(String error) {
        this.error = error;
    }

    public String toString() {
        if (error != null) {
            return error;
        }
        return "Error Sintactico en la linea " + linea + " columna " + columna + "no se esperaba " + tipo + " " + toke;
    }
}
