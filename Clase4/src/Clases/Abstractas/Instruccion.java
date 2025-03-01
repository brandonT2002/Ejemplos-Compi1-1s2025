package Clases.Abstractas;

import Clases.Entorno.Entorno;
import Clases.Utilidades.TipoInstruccion;
import Clases.Utilidades.TipoSentencia;

public abstract class Instruccion extends Sentencia{
    TipoInstruccion tipoInstruccion;
    public Instruccion(TipoInstruccion tipoInstruccion) {
        super(TipoSentencia.INSTRUCION);
        this.tipoInstruccion = tipoInstruccion;
    }

    public abstract void jugar(Entorno entorno);
}
