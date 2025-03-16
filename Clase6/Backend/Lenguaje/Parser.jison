// Analizador Léxico
%{
    // JavaScript
%}

%lex

// Expresiones Regulares
UNUSED      [\s\r\t]+
INTEGER     [0-9]+\b

%%
// Reglas semánticas
\n                      {}
{UNUSED}                {}
{INTEGER}               { return 'TK_integer'; }
'+'                     { return 'TK_suma';    }
'-'                     { return 'TK_resta';   }
'*'                     { return 'TK_mult';    }
'/'                     { return 'TK_div';     }
'('                     { return 'TK_parA';    }
')'                     { return 'TK_parC';    }
'=='                    { return 'TK_igual';   }
'!='                    { return 'TK_dif';     }
'>='                    { return 'TK_mayorI';  }
'<='                    { return 'TK_menorI';  }
'>'                     { return 'TK_mayor';   }
'<'                     { return 'TK_menor';   }
'||'                    { return 'TK_or';      }
'&&'                    { return 'TK_and';     }
'!'                     { return 'TK_not';     }
<<EOF>>                 { return 'EOF';        }
/lex

// Analizador Sintáctico
%{
    // JavaScript
%}

// Precedencia de Operadores
%left 'TK_igual' 'TK_dif'
%left 'TK_menor' 'TK_menorI' 'TK_mayor' 'TK_mayorI'
%left 'TK_suma' 'TK_resta'
%left 'TK_mult' 'TK_div'
%left 'TK_or'
%left 'TK_and'
%right 'TK_not'

// Gramática
%start INICIO
%%

INICIO : 
        OPERACIONES EOF  {return $1} |
        EOF              {return []} ;

OPERACIONES : 
            OPERACIONES EXP {$$.push($2); } |
            EXP             {$$ = [$1];   } ;

EXP :
    ARITMETICO          {$$ = $1;        } |
    RELACIONAL          {$$ = $1;        } |
    LOGICOS             {$$ = $1;        } |
    TK_parA EXP TK_parC {$$ = $2;        } |
    TK_integer          {$$ = Number($1);} ;

ARITMETICO : 
            EXP TK_suma EXP  {$$ = $1 + $3; } |
            EXP TK_resta EXP {$$ = $1 - $3; } |
            EXP TK_mult EXP  {$$ = $1 * $3; } |
            EXP TK_div EXP   {$$ = $1 / $3; } ;

RELACIONAL : 
            EXP TK_igual EXP  {$$ = $1 == $3; } |
            EXP TK_dif EXP    {$$ = $1 != $3; } |
            EXP TK_mayor EXP  {$$ = $1 >  $3; } |
            EXP TK_menor EXP  {$$ = $1 <  $3; } |
            EXP TK_mayorI EXP {$$ = $1 >= $3; } |
            EXP TK_menorI EXP {$$ = $1 <= $3; } ;

LOGICOS :
            EXP TK_and EXP    {$$ = $1 && $3; } |
            EXP TK_or EXP     {$$ = $1 || $3; } |
            TK_not EXP        {$$ = !$2;      } ;