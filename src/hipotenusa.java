import java.util.Scanner;

public class hipotenusa {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Calcular el valor de la hipotenusa");
        System.out.println("Ingrese el valor del cateto adyacente");
        double a = teclado.nextDouble();
        System.out.println("Ingrese el valor del cateto opuesto");
        double b = teclado.nextDouble();
        double c = (Math.pow(a,2) + Math.pow(b,2));
        double raiz = (Math.sqrt(c));
        System.out.println("El valor de la hipotenusa es: " + raiz);
    }
}
