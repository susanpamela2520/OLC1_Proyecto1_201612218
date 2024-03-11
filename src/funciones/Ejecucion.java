package funciones;

import Interfaz.ConsoleFile;
import Interfaz.Panel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JTextArea;
import Interfaz.Ventana2;

/**
 *
 * @author pamel
 */
public class Ejecucion {
    public static HashMap<String, Object> tablaVariables = new HashMap<>();
    public static LinkedList<Object> listaPrint = new LinkedList<Object>();
    public static String cadenita = "";
    
    public static void print(String exp){
        System.out.println(exp);
        cadenita +=" "+ exp + "\n " ;
    }
    
    public static void mostrarTablaVariables() {
        System.out.println("Impresion de Tabla de Variables:");
        for (Map.Entry<String, Object> entry : tablaVariables.entrySet()) {
                System.out.print("Nombre: " + entry.getKey() + ", Cantidad: ");
                cadenita +=  entry.getKey() + " = " ;

        Object valor = entry.getValue();
        if (valor instanceof LinkedList<?>) {
            // Verificamos que el valor sea realmente una LinkedList
            LinkedList<?> linkedListValue = (LinkedList<?>) valor;
            
            // Mostramos los elementos de la LinkedList
            
            System.out.println(Arrays.toString(linkedListValue.toArray()));
             cadenita += Arrays.toString(linkedListValue.toArray()) + "\n";
        } else {
            // Si no es una LinkedList, se muestra valor
            System.out.println(valor);
            cadenita += valor + "\n";
           
        }
            }
    }
    
    public static void mostrarLista(LinkedList<String> lista){
        lista.forEach((element) -> {
            System.out.println(element);
            cadenita += element + "\n";
        });
    }
    
    
    public static void Print(Object lista) {
        
        System.out.print("---------------Salida--------------------: ");
        LinkedList<?> listaPrint = (LinkedList<?>) lista;

            
            for (Object elemento : listaPrint) {
                System.out.print(elemento.toString() + " , ");
                cadenita += elemento.toString();
            }
            cadenita +="\n";
            System.out.println("");
            
     
        
            
    }
    
        public static void PrintArr(Object listaO, String name) {
        System.out.println("----------------Salida: ---------------------");
            System.out.println("-----------------");
            System.out.println(quitarComillas(name));
            System.out.println("-----------------");
           if (listaO instanceof LinkedList<?>) {
                LinkedList<?> lista = (LinkedList<?>) listaO;

         
            for (Object elemento : lista) {
                System.out.println(quitarComillas(elemento.toString()));
                cadenita += quitarComillas(elemento.toString()) ;
            }
            cadenita +="\n";
        } else {
            System.out.println("El objeto no es una LinkedList<Object>.");
        }
    }
        
      //  public static pruebaConsola(){
            
       // }
        
       
         
    public static String quitarComillas(String entrada) {
        return entrada.replaceAll("\"", "");
    }
}
