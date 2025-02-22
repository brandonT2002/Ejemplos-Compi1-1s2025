package Clases.Expresion;

import Clases.Abstractas.Expresion;
import Clases.Entorno.Entorno;
import Clases.Utilidades.Tipo;
import Clases.Utilidades.TipoExpresion;
import Clases.Utilidades.TipoRetorno;

public class Primitivo extends Expresion{
    Object valor;
    Tipo tipo;
    public Primitivo(Object valor, Tipo tipo) {
        super(TipoExpresion.PRIMITIVO);
        this.valor = valor;
        this.tipo = tipo;
    }

    public TipoRetorno jugar(Entorno entorno) {
        switch (tipo) {
            case ENTERO:
                return new TipoRetorno(Integer.parseInt(valor.toString()), tipo);
            case DECIMAL:
                return new TipoRetorno(Double.parseDouble(valor.toString()), tipo);
            case BOOLEAN:
                return new TipoRetorno(valor.toString().equals("true"), tipo);
            case DECISION:
                return new TipoRetorno(valor.toString().equals("C"), tipo);
            default:
                break;
        }
        return null;
    }
}
