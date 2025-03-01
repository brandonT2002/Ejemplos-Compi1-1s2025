package Clases.Abstractas;

import Clases.Entorno.Entorno;
import Clases.Utilidades.TipoExpresion;
import Clases.Utilidades.TipoRetorno;
import Clases.Utilidades.TipoSentencia;

public abstract class Expresion extends Sentencia{
    TipoExpresion tipoExpresion;
    public Expresion(TipoExpresion tipoExpresion) {
        super(TipoSentencia.EXPRESION);
        this.tipoExpresion = tipoExpresion;
    }

    public abstract TipoRetorno jugar(Entorno entorno);
}
