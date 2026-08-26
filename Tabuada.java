import java.util.Scanner;

public class Tabuada {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = sc.nextInt();

        System.out.println("\nTabuada de " + numero + ":");
        System.out.println("----------------");

        for(int i = 1; i <= 10; i++) {
            int resultado = i * numero;

            System.out.println(numero + " x " + i + " = " + resultado);
        }

        sc.close();
    }
}

