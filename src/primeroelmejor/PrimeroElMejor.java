/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeroelmejor;

/**
 *
 * @author LoreyFaby
 */
import java.util.*;

class Nodo {
    char estado;
    int distancia;
    int heuristica;

    public Nodo(char estado, int distancia, int heuristica) {
        this.estado = estado;
        this.distancia = distancia;
        this.heuristica = heuristica;
    }
}


public class PrimeroElMejor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la distancia entre la ubicacion B y ubicacion A: ");
        int distancia = scanner.nextInt();
        MejorPrimero.busqueda(distancia);
    }
}

class MejorPrimero {
    private static final char E_Inicial = 'B';
    private static final char E_Objetivo = 'A';

    private static int calcular(char estado, int distancia) {
        return Math.abs(estado - E_Objetivo) + distancia ;
    }

    public static void busqueda(int distancia) {
        PriorityQueue<Nodo> cola = new PriorityQueue<>(Comparator.comparingInt(a -> a.heuristica));
        cola.add(new Nodo(E_Inicial, 0, calcular(E_Inicial, distancia)));

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.println("Estado actual: " + actual.estado);

            if (actual.estado == E_Objetivo) {
                System.out.println("Se alcanzo el Objetivo en: " + distancia + " cm");
                return;
            }

            int nuevaDistancia = actual.distancia + 1;
            char estadoSiguiente1 = (char) (actual.estado + 1);
            char estadoSiguiente2 = (char) (actual.estado - 1);

            cola.add(new Nodo(estadoSiguiente1, nuevaDistancia, calcular(estadoSiguiente1, distancia)));
            cola.add(new Nodo(estadoSiguiente2, nuevaDistancia, calcular(estadoSiguiente2, distancia)));
        }

        System.out.println("No se encontró un camino hacia el objetivo.");
    }
}

