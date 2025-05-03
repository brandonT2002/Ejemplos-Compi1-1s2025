export class Atributo {
    constructor(public id: string, public tipo: string, public valor: any | null) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }
}