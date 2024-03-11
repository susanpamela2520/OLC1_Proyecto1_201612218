
package funciones;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author pamel
 */
public class Statistics {
    
    public Statistics(){
    
    }
    
       public static double Media(Object listaStrings) {
        LinkedList<Double> listaDoubles = convertirLista(listaStrings);
        double suma = 0;

        for (double valor : listaDoubles) {
            suma += valor;
        }

        return suma / listaDoubles.size();
    }

    public static double Mediana(Object listaStrings) {
        LinkedList<Double> listaDoubles = convertirLista(listaStrings);
        Double[] arreglo = listaDoubles.toArray(new Double[0]);

        Arrays.sort(arreglo);

        int mitad = arreglo.length / 2;

        if (arreglo.length % 2 == 0) {
            return (arreglo[mitad - 1] + arreglo[mitad]) / 2.0;
        } else {
            return arreglo[mitad];
        }
    }

    public static double Moda(Object listaStrings) {
        LinkedList<Double> listaDoubles = convertirLista(listaStrings);
        Double[] arreglo = listaDoubles.toArray(new Double[0]);

        Map<Double, Integer> frecuencias = new HashMap<>();

        for (double valor : arreglo) {
            frecuencias.put(valor, frecuencias.getOrDefault(valor, 0) + 1);
        }

        double moda = 0;
        int maxFrecuencia = 0;

        for (Map.Entry<Double, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                moda = entry.getKey();
            }
        }

        return moda;
    }

    public static double Varianza(Object listaStrings) {
        LinkedList<Double> listaDoubles = convertirLista(listaStrings);
        double media = Media(listaStrings);

        double sum = 0;
        for (double valor : listaDoubles) {
            sum += Math.pow(valor - media, 2.0);
        }

        return sum / listaDoubles.size();
    }

    public static double Max(Object listaStrings) {
        LinkedList<Double> listaDoubles = convertirLista(listaStrings);

        if (listaDoubles == null || listaDoubles.isEmpty()) {
            throw new IllegalArgumentException("La lista está vacía o es nula.");
        }

        double maximo = listaDoubles.getFirst();

        for (double valor : listaDoubles) {
            if (valor > maximo) {
                maximo = valor;
            }
        }

        return maximo;
    }

    public static double Min(Object listaStrings) {
        LinkedList<Double> listaDoubles = convertirLista(listaStrings);

        if (listaDoubles == null || listaDoubles.isEmpty()) {
            throw new IllegalArgumentException("La lista está vacía o es nula.");
        }

        double minimo = listaDoubles.getFirst();

        for (double valor : listaDoubles) {
            if (valor < minimo) {
                minimo = valor;
            }
        }

        return minimo;
    }

private static LinkedList<Double> convertirLista(Object lista) {
    LinkedList<Double> listaDoubles = new LinkedList<>();

    if (lista instanceof LinkedList<?>) {
        LinkedList<?> listaOriginal = (LinkedList<?>) lista;

        for (Object valor : listaOriginal) {
            try {
                if (valor instanceof Number) {
                    listaDoubles.add(((Number) valor).doubleValue());
                } else {
                    double valorDouble = Double.parseDouble(valor.toString());
                    listaDoubles.add(valorDouble);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir el valor: " + valor + ". Se omite.");
            }
        }
    } else {
        System.out.println("Error: El objeto no es una LinkedList.");
    }

    return listaDoubles;
}
    
    
}
