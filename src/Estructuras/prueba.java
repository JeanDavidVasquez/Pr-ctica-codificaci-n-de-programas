package Estructuras;

import java.util.Scanner;

public class prueba {
    public static void main(String[] args) {
        // Matriz de valoraciones de películas por usuarios
        double[][] userMovie = {
                {9, 5, 7, 9},
                {4, 5, 3, 7},
                {5, 7, 4, 3},
                {1, 4, 6, 1},
        };

        // Matriz para almacenar las distancias entre los usuarios
        double[][] compMatris = new double[userMovie.length][userMovie.length];

        // Arreglo para almacenar el índice del usuario más similar a cada usuario
        int[] users = new int[compMatris.length];

        // Calcular las distancias entre los usuarios y almacenarlas en la matriz compMatris
        // +- variable = variable + valor
        for (int i = 0; i < userMovie.length; i++) {
            for (int j = 0; j < userMovie.length; j++) {
                double sumOfSquares = 0;
                for (int k = 0; k < userMovie[0].length; k++) {
                    sumOfSquares += Math.pow(userMovie[i][k] - userMovie[j][k], 2);
                }
                compMatris[i][j] = Math.sqrt(sumOfSquares);
            }
        }

        // Ordenar la matriz userMovie utilizando el método de inserción
        for (int i = 1; i < userMovie.length; i++) {
            double[] currentMovie = userMovie[i];
            double[] currentCompRow = compMatris[i];
            int currentUser = users[i];
            int j = i - 1;

            while (j >= 0 && userMovie[j][0] > currentMovie[0]) {
                userMovie[j + 1] = userMovie[j];
                compMatris[j + 1] = compMatris[j];
                users[j + 1] = users[j];
                j--;
            }

            userMovie[j + 1] = currentMovie;
            compMatris[j + 1] = currentCompRow;
            users[j + 1] = currentUser;
        }

        // Imprimir la matriz compMatris
        for (int i = 0; i < compMatris.length; i++) {
            for (int j = 0; j < compMatris[0].length; j++) {
                System.out.print(String.format("%.2f ", compMatris[i][j]) + "\t");
            }
            System.out.println();
        }
        System.out.println();

        // Solicitar al usuario que ingrese un número de usuario válido
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de usuario (1-" + userMovie.length + "): ");
        int selectedUser = scanner.nextInt();
        scanner.close();

        if (selectedUser < 1 || selectedUser > userMovie.length) {
            System.out.println("Número de usuario inválido.");
            return;
        }

        int selectedIndex = selectedUser - 1;
        double minDistance = Double.MAX_VALUE;

        // Encontrar el usuario más similar al usuario seleccionado
        for (int i = 0; i < compMatris[0].length; i++) {
            if (i != selectedIndex && compMatris[selectedIndex][i] < minDistance) {
                minDistance = compMatris[selectedIndex][i];
                users[selectedIndex] = i;
            }
        }

        // Imprimir el resultado de usuarios con gustos similares
        System.out.println("El usuario " + selectedUser + " tiene los mismos gustos que " + (users[selectedIndex] + 1));
    }
}
