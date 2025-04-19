import { Expresion } from "../Abstractas/Expresion";
import { Instruccion } from "../Abstractas/Instruccion";
import { Entorno } from "../Entorno/Entorno";
import { TipoInstruccion } from "../Utilidades/TipoInstruccion";

export class Asignacion extends Instruccion{
    constructor(linea: number, columna: number, private id: string, private valor: Expresion) {
        super(linea, columna, TipoInstruccion.ASIGNACION);
    }

    public ejecutar(entorno: Entorno) {
        let valor = this.valor.ejecutar(entorno);
        entorno.setVariable(this.id, valor.valor);
    }
}