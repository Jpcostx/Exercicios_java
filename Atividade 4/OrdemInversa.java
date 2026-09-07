/*Enunciado: Escreva um programa em Java que declare um array de inteiros de tamanho 5, leia os 5 valores informados pelo usuário e, em seguida, exiba todos os elementos na ordem inversa à que foram digitados.
Conceitos: Declaração e instanciação de vetores, manipulação de índices e iteração decrescente (i--).

*/
import java.util.Scanner;

public class OrdemInversa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[5];

        System.out.println("Digite 5 números inteiros:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Posição " + i + ": ");
            numeros[i] = sc.nextInt();
        }

        System.out.println("\nOrdem inversa:");

        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }

        sc.close();
    }
}
