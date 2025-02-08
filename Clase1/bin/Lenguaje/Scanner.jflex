// === 1. PACKAGE E IMPORTS
package Lenguaje;
import java_cup.runtime.Symbol;

%%
// === 2. CONFIGURACIONES PARA EL ANALISIS
%{
    // Código Java
%}

// === DIRECTIVAS
// %Directiva
%class Scanner
%public
%cupsym Terminal
%cup
%char
%column
%full
%line
%unicode

// === CONSTRUCTOR
%init{
    yyline = 1;
    yychar = 1;
%init}

// === EXPRESIONES REGULARES
UNUSED = [ \r\t]+ // Caracteres que se omiten
NUMEROS = [0-9]+(\.[0-9]+)?
%%

// === 3. REGLAS SEMÁNTICAS
// {ER} { return new Symbol(parametros); }
{UNUSED}                    {}
"+"                         {return new Symbol(Terminal.TK_suma,        yyline, yychar, yytext());}
{NUMEROS}                   {return new Symbol(Terminal.TK_numero,      yyline, yychar, yytext());}
\n                          {yychar = 1;}