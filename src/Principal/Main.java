
package Principal;

/**
 *
 * @author pamel
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.SwingUtilities;
import Interfaz.Dinamico;
import Interfaz.Panel;

public class Main {
     
    public static void main(String[] args) {
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
}

}