import java.util.Scanner;

public class AreadeCircuferencia {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Como calcular el area de una Circuferencia");
        System.out.println("Ingrese el valor de la radio ");
        double radio = teclado.nextDouble();
        double area = (Math.PI* Math.pow(radio,2));
        System.out.println("El resultado del area de la circuferencia es: " + area);

    }
}
