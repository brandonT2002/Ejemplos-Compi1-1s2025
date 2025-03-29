import { Tipo } from "../Utilidades/Tipo";

export class Simbolo {
    constructor(public valor: any, public id: string, public tipo: Tipo) {
        this.id = id;
    }
}