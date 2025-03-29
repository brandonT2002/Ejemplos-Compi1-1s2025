export enum Tipo{
    ENTERO,
    DECIMAL,
    BOOLEANO,
    CARACTER,
    CADENA,
    NULL,
}

export type TipoRetorno = {valor: any, tipo: Tipo}