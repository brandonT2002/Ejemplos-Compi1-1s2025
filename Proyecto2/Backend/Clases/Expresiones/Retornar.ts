import { Expresion } from "../Abstractas/Expresion";
import { Entorno } from "../Entorno/Entorno";
import { Tipo, TipoRetorno } from "../Utilidades/Tipo";
import { TipoExpresion } from "../Utilidades/TipoExpresion";

export class Retornar extends Expresion{
    constructor(linea: number, columna: number, private expresion: Expresion) {
        super(linea, columna, TipoExpresion.RETORNAR);
    }

    public ejecutar(entorno: Entorno): TipoRetorno {
        // validación para la expresión de retorno
        if (this.expresion) {
            const valor = this.expresion.ejecutar(entorno);
            return {valor: valor.valor, tipo: valor.tipo};
        }
        return {valor: this.tipoExpresion, tipo: Tipo.NULL};
    }
}