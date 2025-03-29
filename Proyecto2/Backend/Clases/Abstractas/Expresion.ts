import { TipoExpresion } from "..//Utilidades/TipoExpresion";
import { Entorno } from "../Entorno/Entorno";
import { TipoRetorno } from "../Utilidades/Tipo";

export abstract class Expresion {
    constructor (public linea: number, public columna: number, public tipoExpresion: TipoExpresion) {}
    public abstract ejecutar(entorno: Entorno): TipoRetorno
}