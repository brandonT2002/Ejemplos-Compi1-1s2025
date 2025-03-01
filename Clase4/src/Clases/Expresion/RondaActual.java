package Clases.Expresion;

import Clases.Abstractas.Expresion;
import Clases.Entorno.Entorno;
import Clases.Utilidades.Tipo;
import Clases.Utilidades.TipoExpresion;
import Clases.Utilidades.TipoRetorno;

public class RondaActual extends Expresion {
    public RondaActual() {
        super(TipoExpresion.PRIMITIVO);
    }

    public TipoRetorno jugar(Entorno entorno) {
        return new TipoRetorno(entorno.getRondaActual(), Tipo.ENTERO);
    }
}
