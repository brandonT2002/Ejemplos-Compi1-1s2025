import { Expresion } from "../Abstractas/Expresion";
import { Entorno } from "../Entorno/Entorno";
import { Tipo, TipoRetorno } from "../Utilidades/Tipo";
import { TipoExpresion } from "../Utilidades/TipoExpresion";

export class Logico extends Expresion{
    private tipo: Tipo = Tipo.NULL;
    constructor(linea: number, columna: number, public exp1: Expresion, public signo: string, public exp2: Expresion) {
        super(linea, columna, TipoExpresion.LOGICO);
    }

    public ejecutar(entorno: Entorno): TipoRetorno {
        switch(this.signo) {
            case '&&':
                return this.and(entorno);
            case '||':
                return this.or(entorno);
            case '!':
                return this.not(entorno);
            default:
                throw new Error(`Operador logico no reconocido: ${this.signo}`);
        }
    }

    and (entorno: Entorno): TipoRetorno {
        const valor1 = this.exp1.ejecutar(entorno);
        const valor2 = this.exp2.ejecutar(entorno);
        this.tipo = Tipo.BOOLEANO;
        return {valor: valor1.valor && valor2.valor, tipo: this.tipo};
    }
    or (entorno: Entorno): TipoRetorno {
        const valor1 = this.exp1.ejecutar(entorno);
        const valor2 = this.exp2.ejecutar(entorno);
        this.tipo = Tipo.BOOLEANO;
        return {valor: valor1.valor || valor2.valor, tipo: this.tipo};
    }
    not (entorno: Entorno): TipoRetorno {
        const valor = this.exp2.ejecutar(entorno);
        this.tipo = Tipo.BOOLEANO;
        return {valor: ! valor.valor, tipo: this.tipo};
    }
}