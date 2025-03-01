package Clases.Expresion;

import Clases.Abstractas.Expresion;
import Clases.Entorno.Entorno;
import Clases.Utilidades.Tipo;
import Clases.Utilidades.TipoExpresion;
import Clases.Utilidades.TipoRetorno;

public class Relacional extends Expresion {
    Expresion exp1;
    Expresion exp2;
    String operador;
    public Relacional(Expresion exp1, String operador, Expresion exp2) {
        super(TipoExpresion.RELACIONAL);
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operador = operador;
    }

    public TipoRetorno jugar(Entorno entorno) {
        switch (this.operador) {
            case "==":
                // Igualdad
                return igual(entorno);
            case "!=":
                return null;
            case ">":
                return null;
            case "<":
            return null;
            case ">=":
            return null;
            case "<=":
            return null;
            default:
                return new TipoRetorno(-1, null);
        }
    }

    public TipoRetorno igual(Entorno entorno) {
        TipoRetorno valor1 = exp1.jugar(entorno);
        TipoRetorno valor2 = exp2.jugar(entorno);
        if (valor1.tipo == Tipo.ENTERO || valor1.tipo == Tipo.DECIMAL) {
            if (valor2.tipo == Tipo.ENTERO || valor2.tipo == Tipo.DECIMAL) {
                // 12.0 == 12 -> true | false
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) == Double.parseDouble(valor2.valor.toString()), Tipo.BOOLEAN);
            }
        }
        return null;
    }
}
