// Analizador Léxico
%{
    // JavaScript
    let { errores } = require ('../Clases/Utilidades/Salida')
    const { Error } = require ('../Clases/Utilidades/Error')
    const { TipoError } = require ('../Clases/Utilidades/TipoError')
%}

%lex

// Expresiones Regulares
UNUSED      [\s\r\t]+
CONTENT     ([^\n\"\\]|\\.)
ID          [a-zA-Z_][a-zA-Z0-9_]*
STRING      \"({CONTENT}*)\"
CHAT        \'({CONTENT})\'
INTEGER     [0-9]+\b
DOUBLE      [0-9]+\.[0-9]+\b
COMMENTS    \/\/.*
COMMENTM    [/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]

%%
// Reglas semánticas
\n                      {}
{COMMENTS}              {}
{COMMENTM}              {}
{UNUSED}                {}
// === TOKENS ===
// === RESERVADAS ===
'ingresar'              { return 'RW_ingresar' }
'como'                  { return 'RW_como'     }
'con'                   { return 'RW_con'      }
'valor'                 { return 'RW_valor'    }
'imprimir'              { return 'RW_imprimir' }
'verdadero'             { return 'RW_verdadero'}
'falso'                 { return 'RW_falso'    }
'fin'                   { return 'RW_fin'      }
'o'                     { return 'RW_o'       }
'si'                    { return 'RW_si'       }
'de lo contrario'       { return 'RW_deLoContrario' }
'para'                  { return 'RW_para'     }
'hasta'                 { return 'RW_hasta'    }
'incremento'            { return 'RW_incremento' }
'decremento'            { return 'RW_decremento' }
'hacer'                 { return 'RW_hacer'    }
'entonces'              { return 'RW_entonces' }
'retornar'              { return 'RW_retornar' }
'regresar'              { return 'RW_regresar' }
'continuar'             { return 'RW_continuar'}
'funcion'               { return 'RW_funcion'  }
'parametros'            { return 'RW_parametros' }
'objeto'                { return 'RW_objeto'  }
// === TIPOS DE DATOS ===
'entero'                { return 'RW_entero'   }
'decimal'               { return 'RW_decimal'  }
'cadena'                { return 'RW_cadena'   }
// === EXPRESIONES ===
{ID}                    { return 'TK_id'       }
{STRING}                { yytext = yytext.substr(1,yyleng - 2); return 'TK_string'   }
{CHAT}                  { yytext = yytext.substr(1,yyleng - 2); return 'TK_char'     }
{DOUBLE}                { return 'TK_double'   }
{INTEGER}               { return 'TK_integer'  }
// === ASIGNACION ===
'->'                    { return 'TK_asign'    }
// === OPERADORES ===
// === RELACIONALES ===
'=='                    { return 'TK_igual'    }
'!='                    { return 'TK_dif'      }
'>='                    { return 'TK_mayorI'   }
'<='                    { return 'TK_menorI'   }
'>'                     { return 'TK_mayor'    }
'<'                     { return 'TK_menor'    }
// === LOGICOS ===
'&&'                    { return 'TK_and'      }
'||'                    { return 'TK_or'       }
'!'                     { return 'TK_not'      }
// === INC DEC ===
'++'                    { return 'TK_inc'     }
'--'                    { return 'TK_dec'     }
// === ARITMETICOS ===
'+'                     { return 'TK_suma'     }
'-'                     { return 'TK_resta'    }
'*'                     { return 'TK_mult'     }
'/'                     { return 'TK_div'      }
'%'                     { return 'TK_mod'      }
'^'                     { return 'TK_pot'    }
// === SIGNOS DE AGRUPACION Y FINALIZACION ===
'('                     { return 'TK_parA'     }
')'                     { return 'TK_parC'     }
','                     { return 'TK_coma'     }
//
.                       { errores.push(new Error(yylloc.first_line, yylloc.first_column + 1, TipoError.LEXICO, `Caracter no reconocido «${yytext}»`)); }
<<EOF>>                 { return 'EOF'         }
/lex

// Analizador Sintáctico
%{
    // Tipos
    const { Tipo } = require ('../Clases/Utilidades/Tipo')
    // Instrucciones
    const { DeclaracionID } = require ('../Clases/Instrucciones/DeclaracionID')
    const { Asignacion } = require ('../Clases/Instrucciones/Asignacion')
    const { Imprimir } = require ('../Clases/Instrucciones/Imprimir')
    const { Si } = require ('../Clases/Instrucciones/Si')
    const { Para } = require ('../Clases/Instrucciones/Para')
    const { Continuar } = require ('../Clases/Instrucciones/Continuar')
    const { Funcion } = require ('../Clases/Instrucciones/Funcion')
    const { GuardarObjeto } = require ('../Clases/Instrucciones/GuardarObjeto')
    // Expresiones
    const { Primitivo } = require ('../Clases/Expresiones/Primitivo')
    const { AccesoID } = require ('../Clases/Expresiones/AccesoID')
    const { IncDec } = require ('../Clases/Expresiones/IncDec')
    const { Aritmetico } = require ('../Clases/Expresiones/Aritmetico')
    const { Relacional } = require ('../Clases/Expresiones/Relacional')
    const { Logico } = require ('../Clases/Expresiones/Logico')
    const { Retornar } = require ('../Clases/Expresiones/Retornar')
    const { Parametro } = require ('../Clases/Expresiones/Parametro')
    const { LlamadaFUncion } = require ('../Clases/Expresiones/LlamadaFUncion')
    const { AccesoObjeto } = require ('../Clases/Expresiones/AccesoObjeto')
    const { Atributo } = require ('../Clases/Expresiones/Atributo')
%}

// Precedencia de Operadores
%left 'TK_or'
%left 'TK_and'
%right 'TK_not'
%left 'TK_igual' 'TK_dif'
%left 'TK_menor' 'TK_menorI' 'TK_mayor' 'TK_mayorI'
%left 'TK_suma' 'TK_resta'
%left 'TK_mult' 'TK_div' 'TK_mod', 'TK_pot'
%right TK_negacionUnaria

// Gramática
%start INICIO
%%

INICIO : 
        INSTRUCCIONES EOF  {return $1} |
        EOF                {return []} ;

INSTRUCCIONES :
            INSTRUCCIONES INSTRUCCION {$$.push($2)} |
            INSTRUCCION               {$$ = [$1]  } ;

INSTRUCCION :
            DECLARACION       {$$ = $1} |
            OBJETOS           {$$ = $1} | 
            ASIGNACION        {$$ = $1} |
            FUNCIONES_METODOS {$$ = $1} |
            IMPRIMIR          {$$ = $1} |
            CONDICIONAL_SI    {$$ = $1} |
            CICLO_PARA        {$$ = $1} |
            RETORNO           {$$ = $1} |
            RW_continuar      {$$ = new Continuar(@1.first_line, @1.first_column)} |
            error             {errores.push(new Error(this._$.first_line, this._$.first_column + 1, TipoError.SINTACTICO, `No se esperaba «${yytext}»`))} ;

RETORNO : 
            RW_regresar           {$$ = new Retornar(@1.first_line, @1.first_column, null);} |
            RW_retornar EXPRESION {$$ = new Retornar(@1.first_line, @1.first_column, $2);  } ;

DECLARACION :
            RW_ingresar TK_id RW_como TIPO RW_con RW_valor EXPRESION {$$ = new DeclaracionID(@1.first_line, @1.first_column, $2, $4, $7)} ;

IMPRIMIR :
            RW_imprimir EXPRESION {$$ = new Imprimir(@1.first_line, @1.first_column, $2)} ;

ASIGNACION :
            TK_id TK_asign EXPRESION {$$ = new Asignacion(@1.first_line, @1.first_column, $1, $3)} ;

INCREMENTO :
            TK_id TK_inc {$$ = new IncDec(@1.first_line, @1.first_column, $1, 'inc')} |
            TK_id TK_dec {$$ = new IncDec(@1.first_line, @1.first_column, $1, 'dec')} ;

// === OBJETOS ===
OBJETOS : 
            RW_objeto TK_id TK_parA ATRIBUTORS_OBJETO TK_parC {$$ = new GuardarObjeto(@1.first_line, @1.first_column, $2, $4)} ;

ATRIBUTORS_OBJETO :
            ATRIBUTORS_OBJETO ATRIBUTO_OBJETO {$$.push($2)} |
            ATRIBUTO_OBJETO                   {$$ = [$1]  } ;

ATRIBUTO_OBJETO:
            TK_id TIPO {$$ = new Atributo($1, $2, undefined)} ;

// === OBTNER OBJETO ===
OBTENER_OBJETO:
            RW_objeto TK_id TK_parA TK_parC {$$ = new AccesoObjeto(@1.first_line, @1.first_column, $2)} ;

// === CONDIONALES ===
// === SI ===
CONDICIONAL_SI :
            RW_si EXPRESION RW_entonces INSTRUCCIONES RW_deLoContrario INSTRUCCIONES RW_fin RW_si  {$$ = new Si(@1.first_line, @1.first_column, $2, $4, $6)}        |
            RW_si EXPRESION RW_entonces INSTRUCCIONES RW_fin RW_si                                 {$$ = new Si(@1.first_line, @1.first_column, $2, $4, undefined)} ;

// === CICLOS ===
// === PARA ===
CICLO_PARA :
            RW_para TK_id TK_asign EXPRESION RW_hasta EXPRESION RW_con RW_incremento EXPRESION RW_hacer INSTRUCCIONES RW_fin RW_para {$$ = new Para(@1.first_line, @1.first_column, $2, $4, $6, $8, $11)} |
            RW_para TK_id TK_asign EXPRESION RW_hasta EXPRESION RW_con RW_decremento EXPRESION RW_hacer INSTRUCCIONES RW_fin RW_para {$$ = new Para(@1.first_line, @1.first_column, $2, $4, $6, $8, $11)} ;

// === FUNCIONES/METODOS ===
FUNCIONES_METODOS :
            RW_funcion TK_id TIPO RW_con RW_parametros TK_parA PARAMETROS TK_parC INSTRUCCIONES RW_fin RW_funcion {$$ = new Funcion(@1.first_line, @1.first_column, $2, $3, $7, $9)} |
            RW_funcion TK_id TIPO INSTRUCCIONES RW_fin RW_funcion                                                 {$$ = new Funcion(@1.first_line, @1.first_column, $2, $3, [], $4)} ;

PARAMETROS :
            PARAMETROS TK_coma PARAMETRO {$$.push($3)} |
            PARAMETRO                    {$$ = [$1]  } ;

PARAMETRO :
            TK_id TIPO {$$ = new Parametro(@1.first_line, @1.first_column, $1, $2)} ;

// === LLAMAR FUNCION/METODO ===
LLAMAR_FUNCIONES_METODOS :
            TK_id TK_parA ARGUMENTOS TK_parC {$$ = new LlamadaFUncion(@1.first_line, @1.first_column, $1, $3)} |
            TK_id TK_parA TK_parC            {$$ = new LlamadaFUncion(@1.first_line, @1.first_column, $1, [])} ;

ARGUMENTOS :
            ARGUMENTOS TK_coma EXPRESION {$$.push($3)} |
            EXPRESION                    {$$ = [$1]  } ;

EXPRESION :
            ARITMETICOS              {$$ = $1} |
            RELACIONALES             {$$ = $1} |
            LOGICOS                  {$$ = $1} |
            INCREMENTO               {$$ = $1} |
            LLAMAR_FUNCIONES_METODOS {$$ = $1} |
            OBTENER_OBJETO           {$$ = $1} |
            TK_id        {$$ = new AccesoID(@1.first_line, @1.first_column, $1                )} |
            RW_verdadero {$$ = new Primitivo(@1.first_line, @1.first_column, $1, Tipo.BOOLEANO)} |
            RW_falso     {$$ = new Primitivo(@1.first_line, @1.first_column, $1, Tipo.BOOLEANO)} |
            TK_string    {$$ = new Primitivo(@1.first_line, @1.first_column, $1, Tipo.CADENA  )} |
            TK_char      {$$ = new Primitivo(@1.first_line, @1.first_column, $1, Tipo.CARACTER)} |
            TK_double    {$$ = new Primitivo(@1.first_line, @1.first_column, $1, Tipo.DECIMAL )} |
            TK_integer   {$$ = new Primitivo(@1.first_line, @1.first_column, $1, Tipo.ENTERO  )} |
            TK_parA EXPRESION TK_parC {$$ = $2} ;

ARITMETICOS :
            EXPRESION TK_suma EXPRESION  {$$ = new Aritmetico(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_resta EXPRESION {$$ = new Aritmetico(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_mult EXPRESION  {$$ = new Aritmetico(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_div  EXPRESION  {$$ = new Aritmetico(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_mod  EXPRESION  {$$ = new Aritmetico(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_pot  EXPRESION  {$$ = new Aritmetico(@1.first_line, @1.first_column, $1, $2, $3)} |
            TK_resta EXPRESION %prec TK_negacionUnaria {$$ = new Aritmetico(@1.first_line, @1.first_column, undefined, $1, $2)} ;

RELACIONALES : 
            EXPRESION TK_igual  EXPRESION {$$ = new Relacional(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_dif    EXPRESION {$$ = new Relacional(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_mayor  EXPRESION {$$ = new Relacional(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_menor  EXPRESION {$$ = new Relacional(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_mayorI EXPRESION {$$ = new Relacional(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_menorI EXPRESION {$$ = new Relacional(@1.first_line, @1.first_column, $1, $2, $3)} ;

LOGICOS :
            EXPRESION TK_and EXPRESION {$$ = new Logico(@1.first_line, @1.first_column, $1, $2, $3)       } |
            EXPRESION TK_or  EXPRESION {$$ = new Logico(@1.first_line, @1.first_column, $1, $2, $3)       } |
            TK_not EXPRESION           {$$ = new Logico(@1.first_line, @1.first_column, undefined, $1, $2)} ;

TIPO :
            RW_cadena  {$$ = Tipo.CADENA } |
            RW_entero  {$$ = Tipo.ENTERO } |
            RW_decimal {$$ = Tipo.DECIMAL} ;