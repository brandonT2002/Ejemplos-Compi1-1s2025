import { Expresion } from "../Abstractas/Expresion";
import { Instruccion } from "../Abstractas/Instruccion";
import { Entorno } from "../Entorno/Entorno";
import { Parametro } from "../Expresiones/Parametro";
import { Tipo } from "../Utilidades/Tipo";
import { TipoInstruccion } from "../Utilidades/TipoInstruccion";
import { Bloque } from "./Bloque";

export class Funcion extends Instruccion{
    constructor(linea: number, columna: number, public nombreFuncion: string, public tipo: string, public parametros: Parametro[], public instrucciones: Instruccion[]) {
        super(linea, columna, TipoInstruccion.DECLARAR_FUNCION);
    }

    public ejecutar(entorno: Entorno) {
        entorno.guardarFuncion(this.nombreFuncion, this);
    }
}