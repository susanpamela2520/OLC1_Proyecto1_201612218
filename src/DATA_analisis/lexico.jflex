
//------------  Paquete e importaciones ------------
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
    System.out.println("se completo el analisis");
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
CARACTER=\' ([^\'] | '\\\'')+ \'
STRCADENA = \" ([^\"] | "\\\"")+ \"
Coment_Simple = "//"[^\n]*\n 
NUMERO = [0-9]+
DIGITO = [0-9]+("."[  |0-9]+)?
ID = [a-zA-Z_][a-zA-Z0-9_]*
Espacios= [ \r\t\n]+
Caracter_Especial=   


    

