import { Tipo } from "../Utilidades/Tipo";

export class Parametro {
    constructor(public linea: number, public columna: number, public id: string, public tipo: Tipo) {
    }
}