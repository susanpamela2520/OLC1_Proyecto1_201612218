/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

import java.io.FileWriter;
import java.util.LinkedList;

/**
 *
 * @author pamel
 */
public class ReporteTokens {
            
    public static void generarReporteTOK(LinkedList<Token> listaTokens) {
        String contenido="";
        //se hace un string para guardar los datos de el html 
        contenido +="<html>\n" +
                                                    "<head><title>Lista de Tokens</title></head>\n" +
                                                    "<body>\n" +
                                                 
                                                    "<table border=\"1\" style=\"margin: 0 auto;\">\n" +
                                                    "<tr><th>LEXEMA</th>\n" +
                                                    "<th >TIPO TOKEN</th>\n" +
                                                    "<th >LINEA</th>\n" +
                                                    "<th >COLUMNA</th></tr>";

        for (Token tokens : listaTokens) {
            contenido += "<tr >\n" +
                             "<td >" + tokens.getLexema() + "</td>\n" +
                             "<td >" + tokens.getTipo() + "</td>\n" +
                             "<td>" + tokens.getLinea() + "</td>\n" +
                             "<td>" + tokens.getColumna() + "</td>\n" +
                             "</tr>";
        }

        contenido+= "</table>\n" +
                        "</div>\n"+
                        "</body>\n" +
                        "</html>";
      
        try {
            FileWriter file = new FileWriter("reporteTOKEN.html");
            file.write(contenido.toString());
            file.close();
            System.out.println("Reporte generado con exito.");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
