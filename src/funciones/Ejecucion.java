package funciones;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author pamel
 */
public class Ejecucion {
    public static HashMap<String, Object> tablaVariables = new HashMap<>();
    public static LinkedList<Object> listaPrint = new LinkedList<Object>();
    
    public static void print(String exp){
        System.out.println(exp);
    }
    
    public static void mostrarTablaVariables() {
        System.out.println("Tabla de Variables:");
        for (Map.Entry<String, Object> entry : tablaVariables.entrySet()) {
                System.out.print("Clave: " + entry.getKey() + ", Valor: ");

        Object valor = entry.getValue();
        if (valor instanceof LinkedList<?>) {
            // Verificamos que el valor sea realmente una LinkedList
            LinkedList<?> linkedListValue = (LinkedList<?>) valor;
            
            // Mostramos los elementos de la LinkedList
            System.out.println(Arrays.toString(linkedListValue.toArray()));
        } else {
            // Si no es una LinkedList, simplemente mostramos el valor
            System.out.println(valor);
        }
            }
    }
    
    public static void mostrarLista(LinkedList<String> lista){
        lista.forEach((element) -> {
            System.out.println(element);
        });
    }
    
    public static void Print(Object lista) {
        System.out.print(">>output: ");
        LinkedList<?> listaPrint = (LinkedList<?>) lista;

            
            for (Object elemento : listaPrint) {
                System.out.print(elemento.toString() + " , ");
            }
            
            System.out.println("");
    }
    
        public static void PrintArr(Object listaO, String name) {
        System.out.println(">>output: ");
            System.out.println("-----------------");
            System.out.println(quitarComillas(name));
            System.out.println("-----------------");
           if (listaO instanceof LinkedList<?>) {
                LinkedList<?> lista = (LinkedList<?>) listaO;

         
            for (Object elemento : lista) {
                System.out.println(quitarComillas(elemento.toString()));
            }
        } else {
            System.out.println("El objeto no es una LinkedList<Object>.");
        }
            
           
    }
        
    public static String quitarComillas(String entrada) {
        return entrada.replaceAll("\"", "");
    }
}
