import { Expresion } from "../Abstractas/Expresion";
import { Instruccion } from "../Abstractas/Instruccion";
import { Entorno } from "../Entorno/Entorno";
import { TipoRetorno } from "../Utilidades/Tipo";
import { TipoInstruccion } from "../Utilidades/TipoInstruccion";
import { Bloque } from "./Bloque";

export class Si extends Instruccion{
    private bloque: Bloque;
    private bloqueExcepsion: Bloque;
    constructor(linea: number, columna: number, private condicion: Expresion, private instrucciones: Instruccion[], private excepsion: Instruccion[]) {
        super(linea, columna, TipoInstruccion.SI);
        this.bloque = new Bloque(linea, columna, instrucciones);
        this.bloqueExcepsion = new Bloque(linea, columna, excepsion);
    }

    public ejecutar(entorno: Entorno) {
        let condicion = this.condicion.ejecutar(entorno);
        const entornoLocal = new Entorno(entorno, entorno.nombre + '_IF')
        if (condicion.valor) { // if (condicion)
            let bloque = this.bloque.ejecutar(entornoLocal);
            if (bloque) {
                return bloque;
            }
            return;
        }
        // else
        if (this.excepsion) {
            let bloqueExcepsion: TipoRetorno = this.bloqueExcepsion.ejecutar(entornoLocal);
            if (bloqueExcepsion) {
                return bloqueExcepsion;
            }
            return;
        }
        return;
    }
}