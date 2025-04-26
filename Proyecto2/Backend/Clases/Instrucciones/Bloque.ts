import { Expresion } from "../Abstractas/Expresion";
import { Instruccion } from "../Abstractas/Instruccion";
import { Entorno } from "../Entorno/Entorno";
import { Tipo } from "../Utilidades/Tipo";
import { TipoInstruccion } from "../Utilidades/TipoInstruccion";

export class Bloque extends Instruccion{
    constructor(linea: number, columna: number, private instrucciones: Instruccion[]) {
        super(linea, columna, TipoInstruccion.BLOQUE_INSTRUCCIONES);
    }

    public ejecutar(entorno: Entorno) {
        const nuevoEntorno = new Entorno(entorno, entorno.nombre)
        for (const instruccion of this.instrucciones) {
            try {
                const result = instruccion.ejecutar(nuevoEntorno);
                if (result) {
                    return result;
                }
            } catch (error) {}
        }
    }
}