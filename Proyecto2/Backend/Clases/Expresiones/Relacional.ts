import { Expresion } from "../Abstractas/Expresion";
import { Entorno } from "../Entorno/Entorno";
import { Tipo, TipoRetorno } from "../Utilidades/Tipo";
import { TipoExpresion } from "../Utilidades/TipoExpresion";

export class Relacional extends Expresion{
    private tipo: Tipo = Tipo.NULL;
    constructor(linea: number, columna: number, public exp1: Expresion, public signo: string, public exp2: Expresion) {
        super(linea, columna, TipoExpresion.RELACIONAL);
    }

    public ejecutar(entorno: Entorno): TipoRetorno {
        switch(this.signo) {
            case '==':
                return this.igual(entorno);
            case '!=':
                return this.diferente(entorno);
            case '>=':
                return this.mayorIgual(entorno);
            case '<=':
                return this.menorIgual(entorno);
            default:
                throw new Error(`Operador logico no reconocido: ${this.signo}`);
        }
    }

    igual (entorno: Entorno): TipoRetorno {
        const valor1 = this.exp1.ejecutar(entorno);
        const valor2 = this.exp2.ejecutar(entorno);
        this.tipo = Tipo.BOOLEANO;
        if (valor1.tipo === Tipo.ENTERO || valor1.tipo === Tipo.DECIMAL || valor1.tipo === Tipo.CARACTER) {
            if (valor2.tipo === Tipo.ENTERO || valor2.tipo === Tipo.DECIMAL || valor2.tipo === Tipo.CARACTER) {
                // '2' == 2 => true
                // '2' === 2 => false
                return {valor: valor1.valor === valor2.valor, tipo: this.tipo};
            }
            // Error semántico: no se puede comparar un número con una cadena
        }
        if (valor1.tipo === Tipo.CADENA && valor2.tipo === Tipo.CADENA) {
            return {valor: valor1.valor.toString() === valor2.valor.toString(), tipo: this.tipo};
        }
        // Error semántico: Los tipos no son comparables
        return {valor: 'NULL', tipo: Tipo.NULL};
    }
    diferente (entorno: Entorno): TipoRetorno {
        const valor1 = this.exp1.ejecutar(entorno);
        const valor2 = this.exp2.ejecutar(entorno);
        this.tipo = Tipo.BOOLEANO;
        return {valor: valor1.valor || valor2.valor, tipo: this.tipo};
    }
    mayorIgual (entorno: Entorno): TipoRetorno {
        const valor1 = this.exp2.ejecutar(entorno);
        const valor2 = this.exp1.ejecutar(entorno);
        this.tipo = Tipo.BOOLEANO;
        return {valor: valor1.valor >= valor2.valor, tipo: this.tipo};
    }
    menorIgual (entorno: Entorno): TipoRetorno {
        const valor1 = this.exp2.ejecutar(entorno);
        const valor2 = this.exp1.ejecutar(entorno);
        this.tipo = Tipo.BOOLEANO;
        return {valor: valor1.valor <= valor2.valor, tipo: this.tipo};
    }
}