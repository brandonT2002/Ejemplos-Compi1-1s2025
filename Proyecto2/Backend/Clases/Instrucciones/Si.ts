import { Expresion } from "../Abstractas/Expresion";
import { Instruccion } from "../Abstractas/Instruccion";
import { Entorno } from "../Entorno/Entorno";
import { TipoInstruccion } from "../Utilidades/TipoInstruccion";

export class Si extends Instruccion{
    constructor(linea: number, columna: number, private condicion: Expresion, private instrucciones: Instruccion[], private excepsion: Instruccion[]) {
        super(linea, columna, TipoInstruccion.SI);
    }

    public ejecutar(entorno: Entorno) {
        let condicion = this.condicion.ejecutar(entorno);
        const entornoLocal = new Entorno(entorno, entorno.nombre + '_IF')
        if (condicion.valor) { // if (condicion)
            for (const instruccion of this.instrucciones) {
                try {
                    const result = instruccion.ejecutar(entornoLocal);
                    if (result) {
                        if (result.tipo == TipoInstruccion.CONTINUAR) {
                            console.log('Continuar: ')
                            continue;
                        } else {
                            return result;
                        }
                    }
                } catch (error) {}
            }
            return;
        }
        // else
        if (this.excepsion) {
            for (const excepsion of this.excepsion) {
                try {
                    const result = excepsion.ejecutar(entornoLocal);
                    if (result) {
                        return result;
                    }
                } catch (error) {}
            }
            return;
        }
        return;
    }
}