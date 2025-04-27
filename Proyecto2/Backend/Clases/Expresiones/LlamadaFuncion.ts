import { Expresion } from "../Abstractas/Expresion";
import { Entorno } from "../Entorno/Entorno";
import { TipoRetorno } from "../Utilidades/Tipo";
import { TipoExpresion } from "../Utilidades/TipoExpresion";
import { Parametro } from "./Parametro";
import { Bloque } from "../Instrucciones/Bloque";

export class LlamadaFUncion extends Expresion{
    constructor(linea: number, columna: number, public id: string, public argumentos: Expresion[]) {
        super(linea, columna, TipoExpresion.ARMITEMETICO);
    }

    public ejecutar(entorno: Entorno): TipoRetorno | any {
        const funcion = entorno.getFuncion(this.id);
        if (funcion) {
            // Validar argumentos
            const entornoFuncion: Entorno = new Entorno(entorno, 'Funcion ' + this.id);
            // Validar la misma cantidad de argumentos
            if (this.argumentos.length === funcion.parametros.length) {
                var valor: TipoRetorno;
                var parametro: Parametro;
                // Recorrer la lista de parametros/argumentos
                for (let i = 0; i < funcion.parametros.length; i++) {
                    valor = this.argumentos[i].ejecutar(entorno);
                    parametro = funcion.parametros[i];
                    // console.log('Parametro: ' + parametro.id + ' tipo: ' + parametro.tipo + ' valor: ' + valor.valor + ' tipo: ' + valor.tipo);
                    // Validar el tipo de dato del argumento
                    if (valor.tipo == parametro.tipo) {
                        entornoFuncion.guardarVariable(parametro.id, valor.valor, parametro.tipo, this.linea, this.columna);
                        continue;
                    }
                    // Error semántico - No coinciden los tipos de los argumentos
                    return null;
                }
                // Ejecutar el bloque de la funcion
                let ejecucion: any = new Bloque(this.linea, this.columna, funcion.instrucciones).ejecutar(entornoFuncion);
                if (ejecucion) {
                    if (ejecucion.valor === TipoExpresion.RETORNAR) {
                        // console.log('Retorno de la funcion: ' + this.id + ' con valor: ' + ejecucion.valor);
                        return
                    }
                    return ejecucion;
                }
                return null;
            }
            // Error semántico - No coinciden la cantidad de argumentos
            return null;
        }
        // Error semántico - Funcion no existe
        return null;
    }
}