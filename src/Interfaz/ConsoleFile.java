/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import javax.swing.JTextArea;

/**
 *
 * @author pamel
 */
public class ConsoleFile {
    
    private static JTextArea Consola;

    public static void setConsola(JTextArea consolaInstance) {
        Consola = consolaInstance;
    }

    public static JTextArea getConsola() {
        return Consola;
    }
    
}
