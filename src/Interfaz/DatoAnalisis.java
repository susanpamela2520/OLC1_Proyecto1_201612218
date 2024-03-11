/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;
import Principal.Exe;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author pamel
 */
public class DatoAnalisis {
 
    public static void analizarContenido(JTabbedPane tabbedPane, JTextArea resultadoTextArea) {
        // Obtiene el índice de la pestaña activa
        int index = tabbedPane.getSelectedIndex();

        // Verifica si hay alguna pestaña activa
        if (index != -1) {
            // Obtiene el componente de la pestaña activa
            Component selectedComponent = tabbedPane.getComponentAt(index);

            // Verifica si el componente es un JPanel
            if (selectedComponent instanceof JPanel) {
                // Cast a JPanel
                JPanel selectedPanel = (JPanel) selectedComponent;

                // Busca el JTextArea dentro del JPanel
                JTextArea textArea = encontrarJTextArea(selectedPanel);

                // Realiza el análisis utilizando el JTextArea
                if (textArea != null) {
                    Exe ejecuta = new Exe();
                    String contenido = textArea.getText();
                    ejecuta.analizar(contenido); 
                    //resultadoTextArea.setText("Hola mundo el analisis fue completo");

                }
            }
        }
    }

    private static JTextArea encontrarJTextArea(Container container) {
        // Busca recursivamente un JTextArea dentro del contenedor
        for (Component component : container.getComponents()) {
            if (component instanceof JTextArea) {
                return (JTextArea) component;
            } else if (component instanceof Container) {
                JTextArea nestedTextArea = encontrarJTextArea((Container) component);
                if (nestedTextArea != null) {
                    return nestedTextArea;
                }
            }
        }
        return null;
    
    }
    
}
