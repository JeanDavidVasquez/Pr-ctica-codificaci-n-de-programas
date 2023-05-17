package pruebaP1;

import java.util.Random;

public class repe {
    public static void main(String[] args) {
        Random random = new Random();

        int[] numeros = new int[20];

        System.out.println("Arreglo original:");

        // Generar números aleatorios y mostrar el arreglo original
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(20) + 1; // Genera números aleatorios entre 1 y 20
            System.out.print(numeros[i] + " ");
        }

        System.out.println("\nNúmeros repetidos y su cantidad de repeticiones:");

        // Calcular y mostrar números repetidos y sus repeticiones
        for (int i = 0; i < numeros.length; i++) {
            int numeroActual = numeros[i];
            int repeticiones = 0;

            // Verificar repeticiones contando los números iguales
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[j] == numeroActual) {
                    repeticiones++;
                }
            }

            // Mostrar resultado si hay repeticiones
            if (repeticiones > 1) {
                System.out.println("El número " + numeroActual + " está repetido " + repeticiones + " veces.");
            }
        }
    }
}
