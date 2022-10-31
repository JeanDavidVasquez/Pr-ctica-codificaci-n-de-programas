import java.util.Scanner;

public class EcuacionCuadratica {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Resolver una ecuacion cuadratica");
        System.out.println("Ingrese el calor de a: ");
        double a = teclado.nextDouble();
        System.out.println("Ingrese el calor de b: ");
        double b = teclado.nextDouble();
        System.out.println("Ingrese el calor de c: ");
        double c = teclado.nextDouble();
        double exp = 2;
        double determinante = (Math.pow(b, exp)-4*a*c);
        if (exp<0)
        System.out.println("Su ecuacion no tiene resultado: ");
        double x1 = (-b + determinante) /(2*a);
        double x2 = (-b - determinante) /(2*a);
        System.out.println("El total de X1 es: " + x1);
        System.out.println("El total de X2 es: " + x2);

    }
}
