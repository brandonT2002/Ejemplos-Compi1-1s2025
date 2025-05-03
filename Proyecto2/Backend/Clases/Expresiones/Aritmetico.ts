import { Expresion } from "../Abstractas/Expresion";
import { Entorno } from "../Entorno/Entorno";
import { Tipo, TipoRetorno } from "../Utilidades/Tipo";
import { TipoExpresion } from "../Utilidades/TipoExpresion";
import { suma, multiplicacion, potencia } from "../Utilidades/OperacionDominante";

export class Aritmetico extends Expresion{
    private tipo: Tipo = Tipo.NULL;
    constructor(linea: number, columna: number, public exp1: Expresion, public signo: string, public exp2: Expresion) {
        super(linea, columna, TipoExpresion.ARMITEMETICO);
    }

    public ejecutar(entorno: Entorno): TipoRetorno {
        switch(this.signo) {
            case '+':
                return this.suma(entorno);
            case '-':
                if (this.exp1 !== undefined) {
                    return this.resta(entorno);
                }
                return this.negacionUnaria(entorno);
            case '*':
                return this.multiplicacion(entorno);
            case '/':
                return this.division(entorno);
            case '^':
                return this.potencia(entorno);
            default:
                throw new Error(`Operador logico no reconocido: ${this.signo}`);
        }
    }

    suma (entorno: Entorno): TipoRetorno {
        const valor1 = this.exp1.ejecutar(entorno);
        const valor2 = this.exp2.ejecutar(entorno);
        this.tipo = suma[valor1.tipo][valor2.tipo];
        if (this.tipo !== Tipo.NULL) {
            if (this.tipo === Tipo.ENTERO) {
                return {valor: valor1.valor + valor2.valor, tipo: this.tipo};
            } else if (this.tipo === Tipo.DECIMAL) {
                return {valor: valor1.valor + valor2.valor, tipo: this.tipo};
            } else if (this.tipo === Tipo.CADENA) {
                return {valor: valor1.valor.toString() + valor2.valor.toString(), tipo: this.tipo};
            }
        }
        return {valor: valor1.valor && valor2.valor, tipo: this.tipo};
    }
    resta (entorno: Entorno): TipoRetorno {
        const valor1 = this.exp1.ejecutar(entorno);
        const valor2 = this.exp2.ejecutar(entorno);
        this.tipo = suma[valor1.tipo][valor2.tipo];
        if (this.tipo !== Tipo.NULL) {
            if (this.tipo === Tipo.ENTERO) {
                return {valor: valor1.valor - valor2.valor, tipo: this.tipo};
            } else if (this.tipo === Tipo.DECIMAL) {
                return {valor: valor1.valor - valor2.valor, tipo: this.tipo};
            } else if (this.tipo === Tipo.CADENA) {
                // Error semántico: no se puede restar cadenas
            }
        }
        return {valor: valor1.valor && valor2.valor, tipo: this.tipo};
    }
    negacionUnaria (entorno: Entorno): TipoRetorno {
        const valor = this.exp2.ejecutar(entorno);
        this.tipo = valor.tipo;
        if (this.tipo === Tipo.ENTERO || this.tipo === Tipo.DECIMAL) {
            return {valor: -valor.valor, tipo: this.tipo};
        }
        // Error semántico: no se puede negar un valor que no es numérico
        return {valor: 'NULL', tipo: Tipo.NULL};
    }
    multiplicacion (entorno: Entorno): TipoRetorno {
        let valor1 = this.exp1.ejecutar(entorno);
        let valor2 = this.exp2.ejecutar(entorno);
        this.tipo = multiplicacion[valor1.tipo][valor2.tipo];
        if (this.tipo !== Tipo.NULL) {
            if (this.tipo === Tipo.ENTERO) {
                return {valor: valor1.valor * valor2.valor, tipo: this.tipo};
            } else if (this.tipo === Tipo.DECIMAL) {
                return {valor: valor1.valor * valor2.valor, tipo: this.tipo};
            }
        }
        return {valor: 'NULL', tipo: Tipo.NULL};
    }
    division (entorno: Entorno): TipoRetorno {
        let valor1 = this.exp1.ejecutar(entorno);
        let valor2 = this.exp2.ejecutar(entorno);
        this.tipo = multiplicacion[valor1.tipo][valor2.tipo];
        if (this.tipo !== Tipo.NULL) {
            if (this.tipo === Tipo.ENTERO) {
                return {valor: valor1.valor / valor2.valor, tipo: this.tipo};
            } else if (this.tipo === Tipo.DECIMAL) {
                return {valor: valor1.valor / valor2.valor, tipo: this.tipo};
            }
        }
        return {valor: 'NULL', tipo: Tipo.NULL};
    }
    potencia (entorno: Entorno): TipoRetorno {
        let valor1 = this.exp1.ejecutar(entorno);
        let valor2 = this.exp2.ejecutar(entorno);
        this.tipo = potencia[valor1.tipo][valor2.tipo];
        if (this.tipo !== Tipo.NULL) {
            if (this.tipo === Tipo.ENTERO) {
                return {valor: Math.pow(valor1.valor, valor2.valor), tipo: this.tipo};
            } else if (this.tipo === Tipo.DECIMAL) {
                return {valor: Math.pow(valor1.valor, valor2.valor), tipo: this.tipo};
            }
        }
        return {valor: 'NULL', tipo: Tipo.NULL};
    }
}