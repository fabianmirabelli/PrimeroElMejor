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

public class PrimeroElMejor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar la distancia de la pieza hacia el Destino A  (entre 100 y 106):");
        int distancia = scanner.nextInt();
        scanner.close();

        if (distancia >= 100 && distancia <= 106) {
            List<String> movimientos = Arrays.asList("B", "B1", "B2", "B3", "B4", "B5", "B6"); // Movimientos
            List<String> recorrido = new ArrayList<>();

            int posicion = 0;
            int mov =0;
            while (posicion < distancia - 99) { // la distancia entre A y B es de 100 Centimetros
                recorrido.add(movimientos.get(posicion));
                posicion++;
            }

            mov = posicion -1;
            System.out.println("El recorrido correcto es: " + String.join(" -> ", recorrido) + " -> A, El reccrrido en Centimetos es de: " + distancia + "cm . La cantidad de movimientos B realizados por la pieza es: " + mov );
        } else {
            System.out.println("La distancia ingresada no es válida. Debe estar entre 100 y 106");
        }
    }
}
