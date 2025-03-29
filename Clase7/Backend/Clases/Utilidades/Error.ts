import { TipoError } from './TipoError'

export class Error {
	constructor(public linea: number, public columna: number, public tipo: TipoError, public descripcion: string) {
    }
    
    public toString(): string {
        return `→ Error ${this.tipo}, ${this.descripcion}. ${this.linea}:${this.columna}`
    }
    
    public getData(): string[] {
        return [String(this.tipo), this.descripcion, String(this.linea), String(this.columna)]
    }
}