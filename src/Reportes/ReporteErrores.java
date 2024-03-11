/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import Reportes.ErroresLex;
import javax.swing.JOptionPane;

/**
 *
 * @author pamel
 */

public class ReporteErrores {
    
    public static void generarReporteERR(LinkedList<ErroresLex> listaERR) {
        String contenido="";
        //se hace un string para guardar los datos de el html 
        contenido +="<html>\n" +
                                                    "<head><title>Lista de Tokens</title></head>\n" +
                                                    "<body>\n" +
                                                 
                                                    "<table border=\"1\" style=\"margin: 0 auto;\">\n" +
                                                    "<tr><th>TIPO ERROR</th>\n" +
                                                    "<th >TOKEN</th>\n" +
                                                    "<th >LINEA</th>\n" +
                                                    "<th >COLUMNA</th></tr>";

        for (ErroresLex error : listaERR) {
            contenido += "<tr >\n" +
                             "<td >" + error.getTipo_Error() + "</td>\n" +
                             "<td >" + error.getDescripcion() + "</td>\n" +
                             "<td>" + error.getLinea() + "</td>\n" +
                             "<td>" + error.getColumna() + "</td>\n" +
                             "</tr>";
        }

        contenido+= "</table>\n" +
                        "</div>\n"+
                        "</body>\n" +
                        "</html>";
        try {
            FileWriter file = new FileWriter("erroresLexicos.html");
            file.write(contenido.toString());
            file.close();
            System.out.println("Reporte generado con exito.");
        } catch (Exception e) {
        }
    }
}
