import { Entorno } from "../Entorno/Entorno";
import { TipoInstruccion } from "../Utilidades/TipoInstruccion";

export abstract class Instruccion {
    constructor(public linea: number, public columna: number, public tipoInstruccion: TipoInstruccion) {}
    public abstract ejecutar(entorno: Entorno): any
}