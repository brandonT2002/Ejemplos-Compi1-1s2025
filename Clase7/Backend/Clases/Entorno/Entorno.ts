import { Console } from "console";
import { salidasConsola } from "../Utilidades/Salida";
import { Tipo } from "../Utilidades/Tipo";
// import { Simbolo } from "./Simbolo";

export class Entorno {
    constructor(private anterior: Entorno | null, public nombre: string) {}
}