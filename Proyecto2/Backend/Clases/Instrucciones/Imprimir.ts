import { Expresion } from "../Abstractas/Expresion";
import { Instruccion } from "../Abstractas/Instruccion";
import { Entorno } from "../Entorno/Entorno";
import { TipoInstruccion } from "../Utilidades/TipoInstruccion";

export class Imprimir extends Instruccion{
    constructor(linea: number, columna: number, private expresion: Expresion){
        super(linea, columna, TipoInstruccion.IMPRIMIR);
    }

    public ejecutar(entorno: Entorno) {
        let valor = this.expresion ? this.expresion.ejecutar(entorno) : null;
        entorno.setPrint(valor ? valor.valor : '');
    }
}