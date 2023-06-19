package Estructuras;

import java.util.Scanner;

public class TareaEstructuras {
    public static void main(String[] args) {
        double[][] userMovie = {
                {9, 5, 7, 9},
                {4, 5, 3, 7},
                {5, 7, 4, 3},
                {1, 4, 6, 1},
        };

        double[][] compMatris = new double[userMovie.length][userMovie.length];
        int[] users = new int[compMatris.length];

        for (int i = 0; i < userMovie.length; i++) {
            for (int j = 0; j < userMovie.length; j++) {
                double sumOfSquares = 0;
                for (int k = 0; k < userMovie[0].length; k++) {
                    sumOfSquares += Math.pow(userMovie[i][k] - userMovie[j][k], 2);
                }
                compMatris[i][j] = Math.sqrt(sumOfSquares);
            }
        }

        for (int i = 0; i < compMatris.length; i++) {
            for (int j = 0; j < compMatris[0].length; j++) {
                System.out.print(String.format("%.2f ", compMatris[i][j]) + "\t");
            }
            System.out.println();
        }
        System.out.println();

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

        for (int i = 0; i < compMatris[0].length; i++) {
            if (i != selectedIndex && compMatris[selectedIndex][i] < minDistance) {
                minDistance = compMatris[selectedIndex][i];
                users[selectedIndex] = i;
            }
        }

        System.out.println("El usuario " + selectedUser + " tiene los mismos gustos que " + (users[selectedIndex] + 1));
    }
}
