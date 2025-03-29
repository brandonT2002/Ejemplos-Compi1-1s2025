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
// === TIPOS DE DATOS ===
'entero'                { return 'RW_entero'   }
'decimal'               { return 'RW_decimal'  }
// === EXPRESIONES ===
{ID}                    { return 'TK_id'       }
{STRING}                { return 'TK_string'   }
{CHAT}                  { return 'TK_char'     }
{DOUBLE}                { return 'TK_double'   }
{INTEGER}               { return 'TK_integer'  }
// === ASIGNACION ===
'->'                    { return 'TK_asign'    }
// === SIGNOS DE AGRUPACION Y FINALIZACION ===
'('                     { return 'TK_parA'     }
')'                     { return 'TK_parC'     }
','                     { return 'TK_coma'     }
.                       { errores.push(new Error(yylloc.first_line, yylloc.first_column + 1, TipoError.LEXICO, `Caracter no reconocido «${yytext}»`)); }
<<EOF>>                 { return 'EOF'         }
/lex
// Analizador Sintáctico
%{
    // JavaScript
%}

// Precedencia de Operadores
// %left 'TK_igual' 'TK_dif'
// %left 'TK_menor' 'TK_menorI' 'TK_mayor' 'TK_mayorI'
// %left 'TK_suma' 'TK_resta'
// %left 'TK_mult' 'TK_div'
// %left 'TK_or'
// %left 'TK_and'
// %right 'TK_not'

// Gramática
%start INICIO
%%

INICIO : 
    INSTRUCCIONES EOF  {return $1} |
    EOF                {return []} ;

INSTRUCCIONES :
            INSTRUCCIONES INSTRUCCION |
            INSTRUCCION               ;

INSTRUCCION :
            DECLARACION |
            IMPRIMIR    ;

DECLARACION : RW_ingresar TK_id RW_como TIPO RW_con RW_valor EXPRESION ;

IMPRIMIR : RW_imprimir EXPRESION ;

EXPRESION :
            TK_id      |
            TK_string  |
            TK_char    |
            TK_double  |
            TK_integer ;

TIPO :
            RW_entero  |
            RW_decimal ;