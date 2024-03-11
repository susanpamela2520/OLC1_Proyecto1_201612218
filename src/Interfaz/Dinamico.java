
package Interfaz;

/**
 *
 * @author pamel
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dinamico extends JFrame {
 
     private JTabbedPane tabbedPane;

    public Dinamico() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Inicializa el JTabbedPane
        tabbedPane = new JTabbedPane();

        // Crea un botón para agregar pestañas
        JButton addButton = new JButton("Agregar Pestaña");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPestanaDinamica();
            }
        });

        // Agrega el JTabbedPane al centro del JFrame
        add(tabbedPane, BorderLayout.CENTER);

        // Crea un panel para el botón y agrégalo a la derecha
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.EAST);
    }

    private void agregarPestanaDinamica() {
        // Crea un nuevo JPanel para el contenido de la pestaña
        JPanel newPanel = new JPanel(new BorderLayout());

        // Agrega un JTextArea al JPanel
        JTextArea textArea = new JTextArea();
        newPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Añade la nueva pestaña al JTabbedPane
        tabbedPane.addTab("Archivo " + (tabbedPane.getTabCount() + 1), newPanel);
    }

    public void run() {
        setVisible(true);
    }
    
}
