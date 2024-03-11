/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import funciones.Entradas;
import funciones.EstadoArchivos;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author pamel
 */
public class windowsFile {
    
    public static void agregarPestanaDinamica(JTabbedPane tabbedPane) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String nombreArchivo = fileChooser.getSelectedFile().getName();
            String contenidoArchivo = leerContenidoArchivo(fileChooser.getSelectedFile().getPath());

            // Crea un nuevo JPanel para el contenido de la pestaña
            JPanel newPanel = new JPanel(new BorderLayout());

            // Agrega un JTextArea al JPanel y establece el contenido del archivo
            JTextArea textArea = new JTextArea(contenidoArchivo);
            newPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
            
            Entradas fi = new Entradas(nombreArchivo,fileChooser.getSelectedFile().getPath() ,true);
            EstadoArchivos.estadoGuardado.add(fi);
            
            // Añade la nueva pestaña al JTabbedPane
            tabbedPane.addTab(nombreArchivo, newPanel);
        }
    }

    private static String leerContenidoArchivo(String rutaArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido.toString();
    }
    
    
    public static void agregarNuevaPestana(JTabbedPane tabbedPane) {
        // Crea un nuevo JPanel para el contenido de la pestaña
            JPanel newPanel = new JPanel(new BorderLayout());

            // Agrega un JTextArea al JPanel y establece el contenido del archivo
            JTextArea textArea = new JTextArea();
            newPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
             
            Entradas fi = new Entradas("Nuevo"+(tabbedPane.getTabCount() + 1), "" ,false);
            EstadoArchivos.estadoGuardado.add(fi);
            
            tabbedPane.addTab("Nuevo"+(tabbedPane.getTabCount() + 1), newPanel);

        // No se necesita establecer la instancia del JTextArea en ConsolaManager para esta pestaña
    }
 
    
 public static void guardarArchivo(JTabbedPane tabbedPane) {
    int index = tabbedPane.getSelectedIndex();
    if (index != -1) {
        // Obtiene el componente de la pestaña activa
        Component selectedComponent = tabbedPane.getComponentAt(index);
        
        
        boolean archivoYaGuardado = false;
        String pathArchGuar = "";
        
        LinkedList<Entradas> fi = EstadoArchivos.estadoGuardado;
        
        
         for (Entradas elemento : fi) {
            if(elemento.getName().equals( tabbedPane.getTitleAt(index))){
                System.out.println("pestaña de nombre: " + tabbedPane.getName());
                System.out.println("guardado: " + elemento.isExist());
                archivoYaGuardado = elemento.isExist();
                pathArchGuar = elemento.getDir();
            }
        }
        
        // Verifica si el componente es un JPanel
        if (selectedComponent instanceof JPanel) {
            // Cast a JPanel
            JPanel selectedPanel = (JPanel) selectedComponent;

            // Busca el JTextArea dentro del JPanel
            JTextArea textArea = encontrarJTextArea(selectedPanel);

            // Verifica si se encontró el JTextArea
            if (textArea != null) {
                // Obtiene el contenido del JTextArea
                String contenido = textArea.getText();

		if (!archivoYaGuardado) {
                    // Si el archivo no ha sido guardado, permite al usuario elegir la ubicación y el nombre del archivo
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showSaveDialog(null);

                    if (result == JFileChooser.APPROVE_OPTION) {
                            File archivo = fileChooser.getSelectedFile();
                            String rutaArchivo = archivo.getAbsolutePath();

                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
                                    
                                    writer.write(contenido);
                                    for (Entradas elemento : fi) {
                                            if(elemento.getName().equals( tabbedPane.getTitleAt(index))){
                                                elemento.setExist(true);
                                                elemento.setDir(rutaArchivo);
                                                elemento.setName(archivo.getName());
                                                
                                            }
                                        }
                                    // Establece el nombre de la pestaña al nombre del archivo
                                    tabbedPane.setTitleAt(index, archivo.getName());
                                    JOptionPane.showMessageDialog(null, "Archivo guardado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            } catch (IOException ex) {
                              JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                    }
		} else {
                    // Si el archivo ya ha sido guardado, sobrescribe el archivo asociado a la pestaña
                    // Usa la ruta existente
			

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathArchGuar))) {
				writer.write(contenido);
                                
                                 JOptionPane.showMessageDialog(null, "Archivo guardado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException ex) {
                               JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
						
			}
		}
            }
        }
    }
}   
    



    private static JTextArea encontrarJTextArea(Container container) {
    for (Component component : container.getComponents()) {
        if (component instanceof JTextArea) {
            return (JTextArea) component;
        } else if (component instanceof Container) {
            // Busca recursivamente dentro de los contenedores anidados
            JTextArea nestedTextArea = encontrarJTextArea((Container) component);
            if (nestedTextArea != null) {
                return nestedTextArea;
            }
        }
    }
    return null;
}
    
}
