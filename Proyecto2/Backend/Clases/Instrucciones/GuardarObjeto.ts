import { Instruccion } from "../Abstractas/Instruccion";
import { Entorno } from "../Entorno/Entorno";
import { TipoInstruccion } from "../Utilidades/TipoInstruccion";

export class GuardarObjeto extends Instruccion{
    constructor(linea: number, columna: number, public id: string, public atributos: []) {
        super(linea, columna, TipoInstruccion.CREAR_OBJETO);
    }

    public ejecutar(entorno: Entorno) {
        entorno.guardarObjeto(this.id, this.atributos)
    }
}