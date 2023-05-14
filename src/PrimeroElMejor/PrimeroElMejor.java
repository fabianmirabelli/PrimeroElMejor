/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeroElMejor;


/**
 *
 * @author LoreyFaby
 */
import java.util.*;

class Nodo {
    String estado;
    Nodo padre;
    int costo;
    
    public Nodo(String estado, Nodo padre, int costo) {
        this.estado = estado;
        this.padre = padre;
        this.costo = costo;
    }
}

public class PrimeroElMejor {
    public static void main(String[] args) {
        Map<String, Integer> movimientos = new HashMap<>();
        movimientos.put("B->B1", 1);
        movimientos.put("B1->B5", 7);
        movimientos.put("B1->B5", 7);
        movimientos.put("B5->A", 8);
        movimientos.put("B->B2", 2);
        movimientos.put("B2->B3", 6);
        movimientos.put("B->B4", 8);
        movimientos.put("B4->A", 2);
        movimientos.put("B->B6", 6);
        movimientos.put("B6->B3", 1);
        movimientos.put("B3->A", 8);
        
        String inicio = "B";
        String objetivo = "A";
        
        List<String> solucion = buscarSolucion(inicio, objetivo, movimientos);
        
        if (solucion != null) {
            System.out.print("El resultado de movimiento de la pieza con la busqueda primero el mejor de el nodo B es la siguiente: ");
            for (String movimiento : solucion) {
                System.out.print(movimiento + " ");
            }
        } else {
            System.out.println("No se encontró una solución.");
        }
    }
    
    public static List<String> buscarSolucion(String inicio, String objetivo, Map<String, Integer> movimientos) {
        Queue<Nodo> frontera = new PriorityQueue<>(Comparator.comparingInt(n -> n.costo));
        Set<String> explorado = new HashSet<>();
        
        frontera.add(new Nodo(inicio, null, 0));
        
        while (!frontera.isEmpty()) {
            Nodo actual = frontera.poll();
            
            if (actual.estado.equals(objetivo)) {
                // Se ha encontrado la solución, reconstruir el camino hacia atrás
                List<String> solucion = new ArrayList<>();
                Nodo nodo = actual;
                while (nodo.padre != null) {
                    solucion.add(0, nodo.estado);
                    nodo = nodo.padre;
                }
                return solucion;
            }
            
            explorado.add(actual.estado);
            
            // Generar sucesores y agregarlos a la frontera
            for (Map.Entry<String, Integer> movimiento : movimientos.entrySet()) {
                String movimientoStr = movimiento.getKey();
                String[] estados = movimientoStr.split("->");
                String estadoInicio = estados[0];
                String estadoFin = estados[1];
                int costoMovimiento = movimiento.getValue();
                
                if (actual.estado.equals(estadoInicio) && !explorado.contains(estadoFin)) {
                    frontera.add(new Nodo(estadoFin, actual, actual.costo + costoMovimiento));
                }
            }
        }
        
        return null; // No se encontró una solución
    }
}
