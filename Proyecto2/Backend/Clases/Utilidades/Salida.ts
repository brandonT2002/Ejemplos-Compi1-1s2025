import { Error } from './Error'

export var salidasConsola: string[] = []
export var errores: Error[] = []

export function getSalida(): string {
    var out = ''
    for(let i = 0; i < salidasConsola.length; i ++) {
		out += salidasConsola[i]
		if(i < salidasConsola.length - 1) {
			out += "\n"
		}
	}
    if(errores.length > 0) {
		if(out != "") {
			out += "\n\n↳ ERRORES\n"
		} else {
			out += "↳ ERRORES\n"
		}
		for(var i = 0; i < errores.length; i ++) {
			out += errores[i].toString()
			if(i < errores.length - 1) {
				out += "\n"
			}
		}
	}
    return out
}

export function getErrores() {
	return errores;
}

export function limpiarSalidas() {
	salidasConsola.splice(0, salidasConsola.length)
	errores.splice(0, errores.length)
}