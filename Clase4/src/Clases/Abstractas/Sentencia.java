package Clases.Abstractas;

import Clases.Utilidades.TipoSentencia;

public abstract class Sentencia {
    TipoSentencia tipoSetencia;
    public Sentencia(TipoSentencia tipoSetencia) {
        this.tipoSetencia = tipoSetencia;
    }
}
