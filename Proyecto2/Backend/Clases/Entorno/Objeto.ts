import { Atributo } from "../Expresiones/Atributo";
import { Metodo } from "./Metodo";

export class Objeto {
    public atributos: Map<string, Atributo>;
    public metodos: Map<string, Metodo>;
    constructor(public id: string) {
        this.id = id;
        this.atributos = new Map<string, Atributo>();
        this.metodos = new Map<string, Metodo>();
    }
}