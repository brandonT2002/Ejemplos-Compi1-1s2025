import { Expresion } from "../Abstractas/Expresion";
import { Entorno } from "../Entorno/Entorno";
import { Tipo, TipoRetorno } from "../Utilidades/Tipo";
import { TipoExpresion } from "../Utilidades/TipoExpresion";

export class Primitivo extends Expresion{
    constructor(linea: number, columna: number, public valor: any, public tipo: Tipo){
        super(linea, columna, TipoExpresion.PRIMITIVO);
    }

    public ejecutar(_: Entorno): TipoRetorno {
        switch(this.tipo) {
            case Tipo.ENTERO:
                return {valor: parseInt(this.valor), tipo: this.tipo};
            case Tipo.DECIMAL:
                return {valor: parseFloat(this.valor), tipo: this.tipo};
            case Tipo.BOOLEANO:
                return {valor: this.valor.toString() === 'verdadero', tipo: this.tipo};
            case Tipo.CARACTER:
                return {valor: this.valor.toString().charCodeAt(0), tipo: this.tipo};
            default:
                this.valor = this.valor.replace(/\\n/g, '\n')
                this.valor = this.valor.replace(/\\t/g, '\t')
                this.valor = this.valor.replace(/\\"/g, '\"')
                this.valor = this.valor.replace(/\\'/g, '\'')
                this.valor = this.valor.replace(/\\\\/g, '\\')
                return {valor: this.valor, tipo: this.tipo};
        }
    }
}