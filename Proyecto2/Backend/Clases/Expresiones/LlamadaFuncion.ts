import { Expresion } from "../Abstractas/Expresion";
import { Entorno } from "../Entorno/Entorno";
import { Tipo, TipoRetorno } from "../Utilidades/Tipo";
import { TipoExpresion } from "../Utilidades/TipoExpresion";
import { suma } from "../Utilidades/OperacionDominante";
import { Parametro } from "./Parametro";
import { Bloque } from "../Instrucciones/Bloque";
import { Simbolo } from "../Entorno/Simbolo";

export class LlamadaFUncion extends Expresion{
    constructor(linea: number, columna: number, public id: string, public argumentos: Expresion[] | null) {
        super(linea, columna, TipoExpresion.ARMITEMETICO);
    }

    public ejecutar(entorno: Entorno): TipoRetorno | any {
        const funcion = entorno.getFuncion(this.id);
        if (funcion) {
            // const nuevoEntorno = new Entorno(entorno, 'Funcion ' + this.id);
            // if (funcion.parametros.length == this.argumentos?.length) {
            //     console.log('NO DEBERIA ENTRAR')
            //     var valor: TipoRetorno;
            //     var parametro: Parametro;
            //     for (let i = 0; i < this.argumentos.length; i++) {
            //         valor = this.argumentos[i].ejecutar(entorno);
            //         parametro = funcion.parametros[i];
            //         if (valor.tipo === parametro.tipo || parametro.tipo === Tipo.DECIMAL && valor.tipo === Tipo.ENTERO) {
            //             if (!entorno.ids.has(parametro.id)) {
            //                 entorno.setVariable(parametro.id, new Simbolo(valor.valor, parametro.id, parametro.tipo));
            //                 continue;
            //             }
            //             // Error Semantico - No pueden haber parametros duplicados o distintos con el mismo tipo
            //             return
            //         }
            //         return
            //     }
            //     let ejecucion: any = new Bloque(this.linea, this.columna, funcion.instrucciones).ejecutar(nuevoEntorno);
            //     if (ejecucion) {
            //         if (ejecucion.valor === TipoExpresion.RETORNAR) {
            //             // console.log('Retorno de la funcion: ' + this.id + ' con valor: ' + ejecucion.valor);
            //             return
            //         }
            //         console.log('Ejecucion de la funcion: ' + this.id + ' con valor: ' + ejecucion.valor);
            //         return ejecucion;
            //     }
            // }
            // console.log(funcion.instrucciones)
            let ejecucion: any = new Bloque(this.linea, this.columna, funcion.instrucciones).ejecutar(entorno);
            if (ejecucion) {
                if (ejecucion.valor === TipoExpresion.RETORNAR) {
                    // console.log('Retorno de la funcion: ' + this.id + ' con valor: ' + ejecucion.valor);
                    return
                }
                console.log('Ejecucion de la funcion: ' + this.id + ' con valor: ' + ejecucion.valor);
                return ejecucion;
            }
        }
        return;
    }
}