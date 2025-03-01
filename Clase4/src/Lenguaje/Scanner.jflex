/* 1. Package e importaciones*/
package Lenguaje;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import Clases.Errores.ErrorLexico;

%%
/* 2. Configuraciones para el analisis (Operaciones y Declaraciones) */
%{
    // Codigo Java
    ArrayList<ErrorLexico> erroresLexicos = new ArrayList<>();
    void addErrorLexico(int linea, int columna, String lexema){
        erroresLexicos.add(new ErrorLexico(linea, columna, lexema));
    }
    public ArrayList<ErrorLexico> getErroresLexicos(){
        return erroresLexicos;
    }
%}

// Directivas
// %<Directiva>
%class Scanner
%public
%cupsym Terminal
%cup
%char
%column
%full
%line
%unicode

// Constructor
%init{
    yyline = 1;
    yychar = 1;
%init}

// Expresiones regulares
UNUSED = [ \r\t]+
INTEGER = [0-9]+
DOUBLE = [0-9]+\.[0-9]+
ID = (\_)*[a-zA-Z][a-zA-Z0-9\_]*
COMMENTS = "//"([^\r\n]*)?
COMMENTM = [/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]
%%

/* 3. Reglas Semanticas */
// {ER} {return new Symbol(parámetros);}
{UNUSED}                        {}
// === RESERVADAS
"strategy"                      {return new Symbol(Terminal.RW_strategy,          yyline, yychar, yytext());}
"initial"                       {return new Symbol(Terminal.RW_initial,          yyline, yychar, yytext());}
"C"                             {return new Symbol(Terminal.RW_C,          yyline, yychar, yytext());}
"D"                             {return new Symbol(Terminal.RW_D,          yyline, yychar, yytext());}
"rules"                         {return new Symbol(Terminal.RW_rules,          yyline, yychar, yytext());}
"if"                            {return new Symbol(Terminal.RW_if,          yyline, yychar, yytext());}
"then"                          {return new Symbol(Terminal.RW_then,          yyline, yychar, yytext());}
"else"                          {return new Symbol(Terminal.RW_else,          yyline, yychar, yytext());}
"get_move"                      {return new Symbol(Terminal.RW_get_move,          yyline, yychar, yytext());}
"last_move"                     {return new Symbol(Terminal.RW_last_move,          yyline, yychar, yytext());}
"get_moves_count"               {return new Symbol(Terminal.RW_get_moves_count,          yyline, yychar, yytext());}
"get_last_n_moves"              {return new Symbol(Terminal.RW_get_last_n_moves,          yyline, yychar, yytext());}
"round_number"                  {return new Symbol(Terminal.RW_round_number,          yyline, yychar, yytext());}
"match"                         {return new Symbol(Terminal.RW_match,          yyline, yychar, yytext());}
"players"                       {return new Symbol(Terminal.RW_players,          yyline, yychar, yytext());}
"strategies"                    {return new Symbol(Terminal.RW_strategies,          yyline, yychar, yytext());}
"rounds"                        {return new Symbol(Terminal.RW_rounds,          yyline, yychar, yytext());}
"scoring"                       {return new Symbol(Terminal.RW_scoring,          yyline, yychar, yytext());}
"mutual cooperation"            {return new Symbol(Terminal.RW_cooperacionM,          yyline, yychar, yytext());}
"mutual defection"              {return new Symbol(Terminal.RW_defeccionnM,          yyline, yychar, yytext());}
"betrayal reward"               {return new Symbol(Terminal.RW_traidor,          yyline, yychar, yytext());}
"betrayal punishment"           {return new Symbol(Terminal.RW_traicionado,          yyline, yychar, yytext());}
"main"                          {return new Symbol(Terminal.RW_main,          yyline, yychar, yytext());}
"run"                           {return new Symbol(Terminal.RW_run,          yyline, yychar, yytext());}
"with"                          {return new Symbol(Terminal.RW_with,          yyline, yychar, yytext());}
"seed"                          {return new Symbol(Terminal.RW_seed,          yyline, yychar, yytext());}
"true"                          {return new Symbol(Terminal.RW_true,          yyline, yychar, yytext());}
"false"                         {return new Symbol(Terminal.RW_false,          yyline, yychar, yytext());}
"random"                        {return new Symbol(Terminal.RW_random,          yyline, yychar, yytext());}
"opponent_history"              {return new Symbol(Terminal.RW_opponent_history,          yyline, yychar, yytext());}
"self_history"                  {return new Symbol(Terminal.RW_self_history,          yyline, yychar, yytext());}
// === IDENTIFICADORES Y VALORES ===
{ID}                            {return new Symbol(Terminal.TK_id,          yyline, yychar, yytext());}
{INTEGER}                       {return new Symbol(Terminal.TK_enteros,          yyline, yychar, yytext());}
{DOUBLE}                        {return new Symbol(Terminal.TK_decimales,          yyline, yychar, yytext());}
// === OPERADORES ===
"=="                      {return new Symbol(Terminal.TK_igual,          yyline, yychar, yytext());}
"!="                      {return new Symbol(Terminal.TK_diferente,          yyline, yychar, yytext());}
">"                      {return new Symbol(Terminal.TK_mayor,          yyline, yychar, yytext());}
"<"                      {return new Symbol(Terminal.TK_menor,          yyline, yychar, yytext());}
"<="                      {return new Symbol(Terminal.TK_menorIgual,          yyline, yychar, yytext());}
">="                      {return new Symbol(Terminal.TK_mayorIgual,          yyline, yychar, yytext());}
"||"                      {return new Symbol(Terminal.TK_or,          yyline, yychar, yytext());}
"&&"                      {return new Symbol(Terminal.TK_and,          yyline, yychar, yytext());}
"!"                      {return new Symbol(Terminal.TK_not,          yyline, yychar, yytext());}
// === AGRUPACION ===
"{"                      {return new Symbol(Terminal.TK_llaveA,          yyline, yychar, yytext());}
"}"                      {return new Symbol(Terminal.TK_llaveC,          yyline, yychar, yytext());}
"["                      {return new Symbol(Terminal.TK_corcheteA,          yyline, yychar, yytext());}
"]"                      {return new Symbol(Terminal.TK_corcheteC,          yyline, yychar, yytext());}
"("                      {return new Symbol(Terminal.TK_parA,          yyline, yychar, yytext());}
")"                      {return new Symbol(Terminal.TK_parC,          yyline, yychar, yytext());}
":"                      {return new Symbol(Terminal.TK_dosPuntos,          yyline, yychar, yytext());}
","                      {return new Symbol(Terminal.TK_coma,          yyline, yychar, yytext());}
\n                       {yychar = 1;}
{COMMENTS}               {}
{COMMENTM}               {}
.                        {addErrorLexico(yyline, yychar, yytext());}