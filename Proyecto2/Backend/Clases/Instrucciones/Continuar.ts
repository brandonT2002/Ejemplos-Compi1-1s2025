import { Expresion } from "../Abstractas/Expresion";
import { Instruccion } from "../Abstractas/Instruccion";
import { Entorno } from "../Entorno/Entorno";
import { TipoInstruccion } from "../Utilidades/TipoInstruccion";

export class Continuar extends Instruccion{
    constructor(linea: number, columna: number) {
        super(linea, columna, TipoInstruccion.CONTINUAR);
    }

    public ejecutar(entorno: Entorno) {
        return { tipo: TipoInstruccion.CONTINUAR, valor: null };
    }
}