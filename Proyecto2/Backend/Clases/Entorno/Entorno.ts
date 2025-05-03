import { Console } from "console";
import { salidasConsola } from "../Utilidades/Salida";
import { Tipo } from "../Utilidades/Tipo";
import { Simbolo } from "./Simbolo";
import { Funcion } from "../Instrucciones/Funcion";
import { tablaSimbolos } from "./Tabla";
import { SimboloTabla } from "./SimboloTabla";
import { Objeto } from "./Objeto";
import { Atributo } from "../Expresiones/Atributo";

export class Entorno {
    public ids: Map<string, Simbolo> = new Map<string, Simbolo>()
    public funciones: Map<string, Funcion> = new Map<string, Funcion>()
    public objetos: Map<string, Objeto> = new Map<string, Objeto>()

    constructor(private anterior: Entorno | null, public nombre: string) {}

    // === Guardar Variable ===
    public guardarVariable(id: string, valor: any, tipo: Tipo, linea: number, columna: number) {
        let entorno: Entorno = this
        if (!entorno.ids.has(id)) {
            // Guardar variable
            entorno.ids.set(id, new Simbolo(valor, id, tipo))
            // Insertamos en la tabla de simbolos
            tablaSimbolos.push(new SimboloTabla(linea, columna, true, true, valor, tipo, id, entorno.nombre))
        }
        // Error semántico - Variable ya existe
    }

    // === Obtener Variable ===
    public getVariable(id: string): Simbolo | null {
        let entorno: Entorno | null = this
        while (entorno != null){
            if (entorno.ids.has(id)) {
                return entorno.ids.get(id)!
            }
            entorno = entorno.anterior
        }
        // Error semántico - Variable no existe
        return null
    }

    // === Actualizar Variable ===
    public setVariable(id: string, valor: any) {
        let entorno: Entorno | null = this
        while (entorno != null) {
            if (entorno.ids.has(id)) {
                let simbolo: Simbolo = entorno.ids.get(id)!
                simbolo.valor = valor
                return
            }
            entorno = entorno.anterior;
        }
    }

    // === GUARDAR OBJETO ===
    public guardarObjeto(id: string, atributos: Atributo[]) {
        let entorno: Entorno = this
        if (!entorno.objetos.has(id)) {
            // console.log(atributos)
            this.objetos.set(id, new Objeto(id))
            this.guardarAtributo(id, atributos)
        }
        // Error semántico - Objeto ya existe
    }

    public guardarAtributo(id: string, atributo: Atributo[]) {
        let entorno: Entorno = this
        if (entorno.objetos.has(id)) {
            let objeto: Objeto = entorno.objetos.get(id)!
            for (let i = 0; i < atributo.length; i++) {
                // console.log(atributo[i])
                objeto.atributos.set(atributo[i].id, atributo[i])
            }
        }
        // Error semántico - Objeto no existe
    }

    // === OBTENER OBJETO ===
    public getObjeto(id: string): Objeto | null {
        let entorno: Entorno | null = this
        while (entorno != null) {
            if (entorno.objetos.has(id)) {
                console.log('Objeto encontrado: ' + id)
                console.log(entorno.objetos.get(id))
                return entorno.objetos.get(id)!
            }
            entorno = entorno.anterior
        }
        // Error semántico - Objeto no existe
        return null
    }

    // === GUARDAR FUNCION ===
    public guardarFuncion(id: string, funcion: Funcion) {
        let entorno: Entorno = this
        if (!entorno.funciones.has(id)) {
            // Guardar Funcion
            // console.log('Guardando funcion: ' + id + ' en el entorno: ' + entorno.nombre)
            // console.log(funcion)
            entorno.funciones.set(id, funcion)
            // Insertamos en la tabla de simbolos
            tablaSimbolos.push(new SimboloTabla(funcion.linea, funcion.columna, false, false, null, funcion.tipo, id, entorno.nombre))
        }
        // Error semántico - Funcion ya existe
    }

    // === OBTENER FUNCION ===
    public getFuncion(id: string): Funcion | null {
        let entorno: Entorno | null = this
        while (entorno != null) {
            if (entorno.funciones.has(id)) {
                return entorno.funciones.get(id)!
            }
            entorno = entorno.anterior
        }
        // Error semántico - Funcion no existe
        return null
    }

    public setPrint(print: string) {
        salidasConsola.push(print)
    }
}