import { SimboloTabla } from "./SimboloTabla";

class Tabla {
    public simbolos: SimboloTabla[];
    constructor() {
        this.simbolos = [];
    }

    public push(simbolo: SimboloTabla): void {
        if (this.validarSimbolo(simbolo)) {
            this.simbolos.push(simbolo);
        }
    }

    public validarSimbolo(simbolo: SimboloTabla) {
        for (const i of this.simbolos) {
            if(i.hash() == simbolo.hash()) {
                return false;
            }
        }
        return true;
    }
    
    public splice() {
        this.simbolos.splice(0);
    }

    public imprimirTabla() {
        console.log("Tabla de simbolos:");
        for (const simbolo of this.simbolos) { 
            console.log(simbolo.toString());
        }
    }

    public toString(): string {
        var table = '╔═' + '═'.repeat(69) + '═╗'
        table += '\n║ ' + ' '.repeat(26) + 'TABLA DE SÍMBOLOS' + ' '.repeat(26) + ' ║' 
        table += '\n╠═' + '═'.repeat(20) + '═╦═' + '═'.repeat(10) + '═╦═' +  '═'.repeat(15) + '═╦═' +  '═'.repeat(5) + '═╦═' +  '═'.repeat(7) + '═╣'
        table += '\n║ ' + 'ID'.padEnd(20) + ' ║ ' + 'TIPO'.padEnd(10) + ' ║ ' + 'ENTORNO'.padEnd(15) + ' ║ ' + 'LINEA'.padEnd(5) + ' ║ ' + 'COLUMNA'.padEnd(7) + ' ║' 
        table += '\n╠═' + '═'.repeat(20) + '═╬═' + '═'.repeat(10) + '═╬═' +  '═'.repeat(15) + '═╬═' +  '═'.repeat(5) + '═╬═' +  '═'.repeat(7) + '═╣'
        for(const sym of this.simbolos) {
            table += '\n' + sym.toString()
        }
        table += '\n╚═' + '═'.repeat(20) + '═╩═' + '═'.repeat(10) + '═╩═' +  '═'.repeat(15) + '═╩═' +  '═'.repeat(5) + '═╩═' +  '═'.repeat(7) + '═╝'
        return table
    }
}

export var tablaSimbolos: Tabla = new Tabla();