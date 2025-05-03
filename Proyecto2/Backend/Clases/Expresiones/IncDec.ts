import { Instruccion } from "../Abstractas/Instruccion";
import { Entorno } from "../Entorno/Entorno";
import { TipoInstruccion } from "../Utilidades/TipoInstruccion";

export class IncDec extends Instruccion{
    constructor(linea: number, columna: number, private id: string, private operacion: string) {
        super(linea, columna, TipoInstruccion.INCREMENTO);
    }

    public ejecutar(entorno: Entorno) {
        let valor = entorno.getVariable(this.id);
        if (valor !== undefined) {
            let v : number;
            switch (this.operacion) {
                case 'inc':
                    v = valor?.valor + 1;
                    entorno.setVariable(this.id, v);
                    return {valor: v, tipo: valor?.tipo};
                case 'dec':
                    v = valor?.valor - 1;
                    entorno.setVariable(this.id, v);
                    return {valor: v, tipo: valor?.tipo};
                default:
                    // Error: Operacion no soportada
            }
        }
    }
}