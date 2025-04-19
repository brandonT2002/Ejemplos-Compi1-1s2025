import { Expresion } from "../Abstractas/Expresion";
import { Instruccion } from "../Abstractas/Instruccion";
import { Entorno } from "../Entorno/Entorno";
import { Tipo } from "../Utilidades/Tipo";
import { TipoInstruccion } from "../Utilidades/TipoInstruccion";

export class Para extends Instruccion{
    constructor(linea: number, columna: number, private inicio: string, private limiteInferior: Expresion, private limiteSuperior: Expresion, private instrucciones: Instruccion[]) {
        super(linea, columna, TipoInstruccion.PARA);
    }

    public ejecutar(entorno: Entorno) {
        console.log('Ejecutando Para')
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
        if (entorno.getVariable(this.inicio)){
            for (let i = limiteInferior.valor; i <= limiteSuperior.valor; i++) {
                entorno.setVariable(this.inicio, i);
                for (const instruccion of this.instrucciones) {
                    try {
                        const result = instruccion.ejecutar(entornoLocal);
                        if (result) {
                            return result;
                        }
                    } catch (error) {}
                }
            }
        }
    }
}