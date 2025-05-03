import { Tipo } from "./Tipo";

export const suma: Tipo[][] = [
    [Tipo.ENTERO,  Tipo.DECIMAL, Tipo.ENTERO, Tipo.ENTERO, Tipo.CADENA],
    [Tipo.DECIMAL, Tipo.DECIMAL, Tipo.DECIMAL,Tipo.DECIMAL,Tipo.DECIMAL],
    [Tipo.ENTERO,  Tipo.DECIMAL, Tipo.NULL,   Tipo.NULL,   Tipo.CADENA],
    [Tipo.ENTERO,  Tipo.DECIMAL, Tipo.NULL,   Tipo.CADENA, Tipo.CADENA],
    [Tipo.CADENA,  Tipo.CADENA,  Tipo.CADENA, Tipo.CADENA, Tipo.CADENA],
]

export const resta: Tipo[][] = [
    [Tipo.ENTERO,  Tipo.DECIMAL, Tipo.ENTERO, Tipo.ENTERO, Tipo.NULL],
    [Tipo.DECIMAL, Tipo.DECIMAL, Tipo.DECIMAL,Tipo.DECIMAL,Tipo.NULL],
    [Tipo.ENTERO,  Tipo.DECIMAL, Tipo.NULL,   Tipo.NULL,   Tipo.NULL],
    [Tipo.ENTERO,  Tipo.DECIMAL, Tipo.NULL,   Tipo.NULL, Tipo.NULL],
    [Tipo.NULL,  Tipo.NULL,  Tipo.NULL, Tipo.NULL, Tipo.NULL],
]

export const multiplicacion: Tipo[][] = [
    [Tipo.ENTERO,  Tipo.DECIMAL, Tipo.ENTERO ],
    [Tipo.DECIMAL, Tipo.DECIMAL, Tipo.DECIMAL],
    [Tipo.ENTERO,  Tipo.DECIMAL, Tipo.NULL   ],
]

export const division: Tipo[][] = [
    [Tipo.DECIMAL, Tipo.DECIMAL, Tipo.DECIMAL],
    [Tipo.DECIMAL, Tipo.DECIMAL, Tipo.DECIMAL],
    [Tipo.DECIMAL, Tipo.DECIMAL, Tipo.NULL   ],
]

export const potencia: Tipo[][] = [
    [Tipo.ENTERO,  Tipo.DECIMAL ],
    [Tipo.DECIMAL, Tipo.DECIMAL],
]