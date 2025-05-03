import { Expresion } from "../Abstractas/Expresion";
import { Entorno } from "../Entorno/Entorno";
import { Objeto } from "../Entorno/Objeto";
import { Tipo, TipoRetorno } from "../Utilidades/Tipo";
import { TipoExpresion } from "../Utilidades/TipoExpresion";

export class AccesoObjeto extends Expresion {
    constructor (linea: number, columna: number, private id: string) {
        super(linea, columna, TipoExpresion.ACCESO_ID);
    }

    public ejecutar(entorno: Entorno): TipoRetorno {
        const valor: Objeto | null = entorno.getObjeto(this.id);
        if (valor) {
            return {valor: valor?.id, tipo: Tipo.OBJETO};
        }
        return {valor: 'NULL', tipo: Tipo.NULL};
    }
}