
package DATA_analisis; 
import java_cup.runtime.*;
import java.util.LinkedList;
 

/*------------------ 2da Area: Opciones y Declaraciones ------------------*/
%%
%{
    //---> Codigo de usuario en sintaxis java
   // public static LinkedList<TError> TablaEL = new LinkedList<TError>();
   // public static LinkedList<Tokens> tabla_tokens = new LinkedList<Tokens>();
    
%}

%eof{
    System.out.println("analisis completo");
    //System.out.println(TablaEL.toString());
%eof}
	
//-------> Directivas (No tocar)

%public 
%class Lexer
%cup
%char
%column
%line
%unicode
%ignorecase
//%standalone


// ------> Expresiones Regulares ------->

multi_comentario  = "/*"([^*]|("*"+[^*/]))*"*/"
simple_comentario = "//"[^\n]*\n 
espacios_en_blanco= [ \r\t\n]+
CARACTER=\' ([^\'] | '\\\'')+ \'
STRCADENA = \" ([^\"] | "\\\"")+ \"
NUMERO = [0-9]+
DIGITO = [0-9]+("."[  |0-9]+)?
ID = [a-zA-Z_][a-zA-Z0-9_]*

[ \t\r\n\f]     // Espacios en blanco se ignoran 
"!" [^\n]* \n?   // Ignorar comentario de una línea 
"<!"[^!]*"!>"    // Ignorar comentario multilinea 


%%
// Palabras reservas
"program"   {return new Symbol(sym.PROGRAM, yycolumn, yyline, yytext());}
"var"       {return new Symbol(sym.VAR, yycolumn, yyline, yytext());}
"arr"       {return new Symbol(sym.ARR, yycolumn, yyline, yytext());}
"double"    {return new Symbol(sym.DOUBLEVAR, yycolumn, yyline, yytext());}
"char"      {return new Symbol(sym.VARIABLECHAR, yycolumn, yyline, yytext());}
"sum"      {return new Symbol(sym.SUMA, yycolumn, yyline, yytext());}
"res"     {return new Symbol(sym.RESTA, yycolumn, yyline, yytext());}
"mul"     {return new Symbol(sym.MULTIPLICACION, yycolumn, yyline, yytext());}
"div"  {return new Symbol(sym.DIVISION, yycolumn, yyline, yytext());}
"mod"    {return new Symbol(sym.MOD, yycolumn, yyline, yytext());}
"media"  {return new Symbol(sym.MEDIA, yycolumn, yyline, yytext());}
"mediana" {return new Symbol(sym.MEDIANA, yycolumn, yyline, yytext());}
"moda"    {return new Symbol(sym.MODA, yycolumn, yyline, yytext());}
"varianza" {return new Symbol(sym.VARIANZA, yycolumn, yyline, yytext());}
"max"      {return new Symbol(sym.MAX, yycolumn, yyline, yytext());}
"min"      {return new Symbol(sym.MIN, yycolumn, yyline, yytext());}
"console"  {return new Symbol(sym.CONSOLE, yycolumn, yyline, yytext());}
"print"    {return new Symbol(sym.PRINT, yycolumn, yyline, yytext());}
"column"   {return new Symbol(sym.COLUMN, yycolumn, yyline, yytext());}
"end"       {return new Symbol(sym.END, yycolumn, yyline, yytext());}


//  Espacio que reconoce los simbolos

"("         {return new Symbol(sym.PAR_IZQUIERDO, yycolumn, yyline, yytext());}
")"         {return new Symbol(sym.PAR_DERECHO, yycolumn, yyline, yytext());}
","         {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
"="         {return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
";"         {return new Symbol(sym.PUNTO_Y_COMA, yycolumn, yyline, yytext());}
":"         {return new Symbol(sym.DOSPUNTOS, yycolumn, yyline, yytext());}
"<"         {return new Symbol(sym.MENORQUE, yycolumn, yyline, yytext());}
">"         {return new Symbol(sym.MAYORQUE, yycolumn, yyline, yytext());}
"-"         {return new Symbol(sym.GUION, yycolumn, yyline, yytext());}
"["         {return new Symbol(sym.COR_IZQUIERDO, yycolumn, yyline, yytext());}
"]"         {return new Symbol(sym.COR_DERECHO, yycolumn, yyline, yytext());}
"@"    {return new Symbol(sym.ARROBA, yycolumn, yyline, yytext());}
     

{NUMERO}    {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext()); }
{STRCADENA}    {return new Symbol(sym.STRCADENA, yycolumn, yyline, yytext());}
{ID}        {return new Symbol(sym.ID, yycolumn, yyline, yytext());}
{DIGITO}   {return new Symbol(sym.DIGITO, yycolumn, yyline, yytext());}


//------> Errores Léxicos 
.           	{ System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }

    

