
package DATA_analisis; 
import java_cup.runtime.*;
import java.util.LinkedList;
import Reportes.ErroresLex;
import Reportes.Token; 

/*------------------ 2da Area: Opciones y Declaraciones ------------------*/
%%
%{
    //---> Codigo de usuario en sintaxis java
   public static LinkedList<ErroresLex> errorsitos = new LinkedList<ErroresLex>();
   public static LinkedList<Token> tokensito = new LinkedList<Token>();
    
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


// ------> Expresiones Regulares 

entero = [0-9]+
decimal = [0-9]+("."[0-9]+)?
cadena = [\"][^\n\"]*[\"]
id = [a-zA-Z][a-zA-Z0-9_]*


%%

//------> Ingorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}
"!" [^\n]* \n?   { /* Ignorar comentario de una línea */ }
"<!"[^!]*"!>"    { /* Ignorar comentario multilinea */ }

// ------------  Reglas Lexicas -------------------
// Palabras reservas
"program"   {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.PROGRAM, yycolumn, yyline, yytext());
            }
"var"       {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.VARIABLE, yycolumn, yyline, yytext());
            }
"arr"       {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.ARROBA, yycolumn, yyline, yytext());
            }
"double"    {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.DOUBLEVARIABLE, yycolumn, yyline, yytext());
            }
"char"      {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.CHARVAR, yycolumn, yyline, yytext());
            }
"sum"      {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.SUMA, yycolumn, yyline, yytext());
            }
"res"     {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.RESTA, yycolumn, yyline, yytext());
            }
"mul"     {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.MULTIPLICACION, yycolumn, yyline, yytext());
                }
"div"  {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.DIVISION, yycolumn, yyline, yytext());
        }
"mod"    {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.MOD, yycolumn, yyline, yytext());
        }
"media"  {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.MEDIA, yycolumn, yyline, yytext());
        }
"mediana" {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.MEDIANA, yycolumn, yyline, yytext());
            }
"moda"    {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.MODA, yycolumn, yyline, yytext());
            }
"varianza" {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.VARIANZA, yycolumn, yyline, yytext());
            }
"max"      {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.MAX, yycolumn, yyline, yytext());
            }
"min"      {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.MIN, yycolumn, yyline, yytext());
            }
"console"  {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.CONSOLE, yycolumn, yyline, yytext());
            }
"print"    {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.PRINT, yycolumn, yyline, yytext());
            }
"column"   {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.COLUMN, yycolumn, yyline, yytext());
            }
"end"      {tokensito.add(new Token(yytext(),"Reservada",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.END, yycolumn, yyline, yytext());
            }

"end program" {return new Symbol(sym.ENDPROGRAM, yycolumn, yyline, yytext());
                }

// Simbolos

"("         {tokensito.add(new Token(yytext(),"Simbolo",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.PAR_IZQUIERDO, yycolumn, yyline, yytext());
            }
")"         {tokensito.add(new Token(yytext(),"Simbolo",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.PAR_DERECHO, yycolumn, yyline, yytext());
            }
","         {tokensito.add(new Token(yytext(),"Simbolo",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.COMA, yycolumn, yyline, yytext());
            }
"="         {tokensito.add(new Token(yytext(),"Simbolo",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());
            }
";"         {tokensito.add(new Token(yytext(),"Simbolo",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.PYC, yycolumn, yyline, yytext());
            }
":"         {tokensito.add(new Token(yytext(),"Simbolo",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.DOSP, yycolumn, yyline, yytext());
            }
"<"         {tokensito.add(new Token(yytext(),"Simbolo",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.MENORQ, yycolumn, yyline, yytext());
            }
">"         {tokensito.add(new Token(yytext(),"Simbolo",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.MAYORQ, yycolumn, yyline, yytext());
            }
"-"         {tokensito.add(new Token(yytext(),"Simbolo",(yyline) + 1, (yycolumn) + 1)); return new Symbol(sym.GUION, yycolumn, yyline, yytext());
            }
"["         {tokensito.add(new Token(yytext(),"Simbolo",(yyline) + 1, (yycolumn) + 1));
            return new Symbol(sym.CORIZQ, yycolumn, yyline, yytext());
            }
"]"         {tokensito.add(new Token(yytext(),"Simbolo",(yyline) + 1, (yycolumn) + 1));
            return new Symbol(sym.CORDER, yycolumn, yyline, yytext());
            }
     

// Operadores
"+"         {tokensito.add(new Token(yytext(),"Operador",(yyline) + 1, (yycolumn) + 1));
            return new Symbol(sym.MAS, yycolumn, yyline, yytext());
            }

// Expresiones
{entero}    {tokensito.add(new Token(yytext(),"Expresion",(yyline) + 1, (yycolumn) + 1));
            return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); 
            }
{cadena}    {tokensito.add(new Token(yytext(),"Expresion",(yyline) + 1, (yycolumn) + 1));
            return new Symbol(sym.CADENA, yycolumn, yyline, yytext());
           }
"@"{id}     {tokensito.add(new Token(yytext(),"Expresion",(yyline) + 1, (yycolumn) + 1));
            return new Symbol(sym.IDARROBA, yycolumn, yyline, yytext());
           }
{id}        {tokensito.add(new Token(yytext(),"Expresion",(yyline) + 1, (yycolumn) + 1));
            return new Symbol(sym.ID, yycolumn, yyline, yytext());}
{decimal}   {tokensito.add(new Token(yytext(),"Expresion",(yyline) + 1, (yycolumn) + 1));
            return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext());
            }


//------> Errores Léxicos 
.           	{   
                    errorsitos.add(new ErroresLex("Error lexico" , yytext() + "",  (yyline) + 1, (yycolumn) + 1));
                    
                    //System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); 
                }
    

