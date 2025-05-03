import { Tipo } from "../Utilidades/Tipo";

export class SimboloTabla {
    public indice: number;
    constructor(private linea: number, private columna: number, private isVariable: boolean, private isPrimitive: boolean, private valor: any, private tipo: Tipo, private id: string, private nombreEntorno: string) {
        this.indice = 0;
    }

    public toString(): string {
        return '║ ' + `${this.id}`.padEnd(20) + ' ║ ' + `${this.getTipo(this.tipo)}`.padEnd(10) + ' ║ ' + `${this.nombreEntorno}`.padEnd(15) + ' ║ ' + `${this.linea}`.padEnd(5) + ' ║ ' + `${this.columna}`.padEnd(7) + ' ║ ' 
    }

    public hash(): string {
        return `${this.id}_${this.tipo}_${this.nombreEntorno}_${this.linea}_${this.columna}_${this.isVariable}_${this.isPrimitive}`
    }

    public getTipo(tipo : Tipo): string {
        switch (this.tipo) {
            case Tipo.ENTERO:
                return "entero";
            case Tipo.DECIMAL:
                return "decimal";
            case Tipo.BOOLEANO:
                return "booleano";
            case Tipo.CARACTER:
                return "caracter";
            case Tipo.CADENA:
                return "cadena";
            case Tipo.NULL:
                return "null";
            default:
                return "desconocido";
        }
    }
}