/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Tokens.Errores;
import Tokens.Token;
import DATA_analisis.sintactico;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import DATA_analisis.*;


/**
 *
 * @author pamel
 */
public class Exe {
    
     public  void analizadores(String ruta, String jflexFile, String cupFile){
        try {
            String opcionesJflex[] =  {ruta+jflexFile,"-d",ruta};
            jflex.Main.generate(opcionesJflex);

            String opcionesCup[] =  {"-destdir", ruta,"-parser","Parser",ruta+cupFile};
            java_cup.Main.main(opcionesCup);
            
        } catch (Exception e) {
            System.out.println("No se ha podido generar los analizadores");
            System.out.println(e);
        }
    }
  
          // Realizar Analisis
    public  void analizar (String entrada){
        
         DATA_analisis.Lexer lexer = new DATA_analisis.Lexer(new StringReader(entrada)); 
        try {
         
            DATA_analisis.sintactico parser = new DATA_analisis.sintactico(lexer);
            parser.parse();
            
            
            

            
            
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
            // Imprimir tokens en consola
             
            System.out.println(e);
        } 
    } 
}

   