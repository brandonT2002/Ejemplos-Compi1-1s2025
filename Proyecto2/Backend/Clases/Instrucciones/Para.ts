import { Expresion } from "../Abstractas/Expresion";
import { Instruccion } from "../Abstractas/Instruccion";
import { Entorno } from "../Entorno/Entorno";
import { Tipo } from "../Utilidades/Tipo";
import { TipoInstruccion } from "../Utilidades/TipoInstruccion";
import { Bloque } from "./Bloque";

export class Para extends Instruccion{
    private bloque: Bloque;
    constructor(linea: number, columna: number, private inicio: string, private limiteInferior: Expresion, private limiteSuperior: Expresion, private paso: string, private instrucciones: Instruccion[]) {
        super(linea, columna, TipoInstruccion.PARA);
        this.bloque = new Bloque(linea, columna, instrucciones);
    }

    public ejecutar(entorno: Entorno) {
        const entornoLocal = new Entorno(entorno, entorno.nombre + '_FOR')
        var limiteInferior = this.limiteInferior.ejecutar(entornoLocal);
        if (limiteInferior.tipo != Tipo.ENTERO) {
            // Tipo no válido para el rango de iteración
            return;
        }
        var limiteSuperior = this.limiteSuperior.ejecutar(entornoLocal);
        if (limiteSuperior.tipo != Tipo.ENTERO) {
            // Tipo no válido para el rango de iteración
            return;
        }
        // Buscar la variable del iterador
        if (this.paso == 'incremento') {
            if (entorno.getVariable(this.inicio)){
                for (let i = limiteInferior.valor; i <= limiteSuperior.valor; i++) {
                    entorno.setVariable(this.inicio, i);
                    let bloque = this.bloque.ejecutar(entornoLocal);
                    if (bloque) {
                        if (bloque.valor == TipoInstruccion.CONTINUAR) {
                            continue; // Continuar con la siguiente iteración
                        }
                        return bloque;
                    }
                }
                return;
            }
        } else if (this.paso == 'decremento') {
            if (entorno.getVariable(this.inicio)){
                for (let i = limiteInferior.valor; i >= limiteSuperior.valor; i--) {
                    entorno.setVariable(this.inicio, i);
                    let bloque = this.bloque.ejecutar(entornoLocal);
                    if (bloque) {
                        if (bloque.valor == TipoInstruccion.CONTINUAR) {
                            continue; // Continuar con la siguiente iteración
                        }
                        return bloque;
                    }
                }
                return;
            }
        }
    }
}