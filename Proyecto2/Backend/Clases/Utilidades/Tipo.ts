export enum Tipo{
    ENTERO,
    DECIMAL,
    BOOLEANO,
    CARACTER,
    CADENA,
    OBJETO,
    NULL,
}

export type TipoRetorno = {valor: any, tipo: Tipo}