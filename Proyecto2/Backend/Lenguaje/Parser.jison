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
// === TIPOS DE DATOS ===
'entero'                { return 'RW_entero'   }
'decimal'               { return 'RW_decimal'  }
// === EXPRESIONES ===
{ID}                    { return 'TK_id'       }
{STRING}                { yytext = yytext.substr(1,yyleng - 2); return 'TK_string'   }
{CHAT}                  { yytext = yytext.substr(1,yyleng - 2); return 'TK_char'     }
{DOUBLE}                { return 'TK_double'   }
{INTEGER}               { return 'TK_integer'  }
// === ASIGNACION ===
'->'                    { return 'TK_asign'    }
// === OPERADORES ===
// === LOGICOS ===
'&&'                    { return 'TK_and'      }
'||'                    { return 'TK_or'       }
'!'                     { return 'TK_not'      }
// === RELACIONALES ===
'=='                    { return 'TK_igual'    }
'!='                    { return 'TK_dif'      }
'>'                     { return 'TK_mayor'    }
'<'                     { return 'TK_menor'    }
'>='                    { return 'TK_mayorI'   }
'<='                    { return 'TK_menorI'   }
// === ARITMETICOS ===
'+'                     { return 'TK_suma'     }
'-'                     { return 'TK_resta'    }
'*'                     { return 'TK_mult'     }
'/'                     { return 'TK_div'      }
'%'                     { return 'TK_mod'      }
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
    const { Imprimir } = require ('../Clases/Instrucciones/Imprimir')
    // Expresiones
    const { Primitivo } = require ('../Clases/Expresiones/Primitivo')
    const { AccesoID } = require ('../Clases/Expresiones/AccesoID')
    const { Aritmetico } = require ('../Clases/Expresiones/Aritmetico')
    const { Relacional } = require ('../Clases/Expresiones/Relacional')
    const { Logico } = require ('../Clases/Expresiones/Logico')
%}

// Precedencia de Operadores
%left 'TK_or'
%left 'TK_and'
%right 'TK_not'
%left 'TK_igual' 'TK_dif'
%left 'TK_menor' 'TK_menorI' 'TK_mayor' 'TK_mayorI'
%left 'TK_suma' 'TK_resta'
%left 'TK_mult' 'TK_div' 'TK_mod'
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
            DECLARACION {$$ = $1} |  
            IMPRIMIR    {$$ = $1} |
            error       {errores.push(new Error(this._$.first_line, this._$.first_column + 1, TipoError.SINTACTICO, `No se esperaba «${yytext}»`))} ;

DECLARACION :
            RW_ingresar TK_id RW_como TIPO RW_con RW_valor EXPRESION {$$ = new DeclaracionID(@1.first_line, @1.first_column, $2, $4, $7)} ;

IMPRIMIR :
            RW_imprimir EXPRESION {$$ = new Imprimir(@1.first_line, @1.first_column, $2)} ;

EXPRESION :
            ARITMETICOS  {$$ = $1} |
            RELACIONALES {$$ = $1} |
            LOGICOS      {$$ = $1} |
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
            TK_resta EXPRESION %prec TK_negacionUnaria {$$ = new Aritmetico(@1.first_line, @1.first_column, undefined, $1, $2)} ;

RELACIONALES : 
            EXPRESION TK_igual  EXPRESION {$$ = new Relacional(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_dif    EXPRESION {$$ = new Relacional(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_mayor  EXPRESION {$$ = new Relacional(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_menor  EXPRESION {$$ = new Relacional(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_mayorI EXPRESION {$$ = new Relacional(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_menorI EXPRESION {$$ = new Relacional(@1.first_line, @1.first_column, $1, $2, $3)} ;

LOGICOS :
            EXPRESION TK_and EXPRESION {$$ = new Logico(@1.first_line, @1.first_column, $1, $2, $3)} |
            EXPRESION TK_or  EXPRESION {$$ = new Logico(@1.first_line, @1.first_column, $1, $2, $3)} |
            TK_not EXPRESION           {$$ = new Logico(@1.first_line, @1.first_column, undefined, $1, $2)} ;

TIPO :
            RW_entero  {$$ = Tipo.ENTERO} |
            RW_decimal {$$ = Tipo.DECIMAL} ;