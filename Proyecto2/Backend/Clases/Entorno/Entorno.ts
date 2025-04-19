import { Console } from "console";
import { salidasConsola } from "../Utilidades/Salida";
import { Tipo } from "../Utilidades/Tipo";
import { Simbolo } from "./Simbolo";

export class Entorno {
    public ids: Map<string, Simbolo> = new Map<string, Simbolo>()

    constructor(private anterior: Entorno | null, public nombre: string) {}

    // === Guardar Variable ===
    public guardarVariable(id: string, valor: any, tipo: Tipo, linea: number, columna: number) {
        let entorno: Entorno = this
        if (!entorno.ids.has(id)) {
            // Guardar variable
            entorno.ids.set(id, new Simbolo(valor, id, tipo))
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

    public setPrint(print: string) {
        salidasConsola.push(print)
    }
}