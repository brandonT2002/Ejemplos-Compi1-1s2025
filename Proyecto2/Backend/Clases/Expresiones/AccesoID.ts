import { Expresion } from "../Abstractas/Expresion";
import { Entorno } from "../Entorno/Entorno";
import { Simbolo } from "../Entorno/Simbolo";
import { Tipo, TipoRetorno } from "../Utilidades/Tipo";
import { TipoExpresion } from "../Utilidades/TipoExpresion";

export class AccesoID extends Expresion {
    constructor (linea: number, columna: number, private id: string) {
        super(linea, columna, TipoExpresion.ACCESO_ID);
    }

    public ejecutar(entorno: Entorno): TipoRetorno {
        const valor: Simbolo | null = entorno.getVariable(this.id);
        if (valor){
            return {valor: valor.valor, tipo: valor.tipo};
        }
        return {valor: 'NULL', tipo: Tipo.NULL};
    }
}