package Estructuras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Matriz de calificaciones de usuarios y películas
        double[][] userMovie = {
                {9, 5, 7, 9},
                {4, 5, 3, 7},
                {5, 7, 4, 3},
                {1, 4, 6, 1},
        };

        // Almacenar las distancias entre los usuarios
        double[][] compMatris = new double[userMovie.length][userMovie.length];

        // Arreglo para almacenar el índice del usuario más similar a cada usuario
        int[] users = new int[compMatris.length];

        // Calcular las distancias entre los usuarios y almacenarlas en compMatris
        for (int i = 0; i < userMovie.length; i++) {
            for (int j = 0; j < userMovie.length; j++) {
                double sumOfSquares = 0;
                // Calcular la suma de los cuadrados de las diferencias entre las calificaciones
                for (int k = 0; k < userMovie[0].length; k++) {
                    sumOfSquares += Math.pow(userMovie[i][k] - userMovie[j][k], 2);
                }
                // Calcular la raíz cuadrada de la suma de los cuadrados
                compMatris[i][j] = Math.sqrt(sumOfSquares);
            }
        }

        // Imprimir la matriz de distancias
        for (int i = 0; i < compMatris.length; i++) {
            for (int j = 0; j < compMatris[0].length; j++) {
                System.out.print(String.format("%.2f ", compMatris[i][j]) + "\t");
            }
            System.out.println();
        }
        System.out.println();

        // Solicitar al usuario un número de usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de usuario (1-" + userMovie.length + "): ");
        int selectedUser = scanner.nextInt();
        scanner.close();

        // Verificar si el número de usuario es válido
        if (selectedUser < 1 || selectedUser > userMovie.length) {
            System.out.println("Número de usuario inválido.");
            return;
        }

        // Índice del usuario seleccionado
        // selectedIndex representa el índice del usuario seleccionado en las matrices
        // minDistance se utiliza para realizar un seguimiento de la distancia mínima entre el usuario seleccionado y otros usuarios
        int selectedIndex = selectedUser - 1;
        double minDistance = Double.MAX_VALUE;

        // Encontrar el usuario más similar al usuario seleccionado
        for (int i = 0; i < compMatris[0].length; i++) {
            if (i != selectedIndex && compMatris[selectedIndex][i] < minDistance) {
                minDistance = compMatris[selectedIndex][i];
                users[selectedIndex] = i;
            }
        }

        // Imprimir el resultado de usuario más similar
        System.out.println("El usuario " + selectedUser + " tiene los mismos gustos que " + (users[selectedIndex] + 1));
    }
}