/*Enunciado: Crie um programa que leia continuamente números inteiros positivos fornecidos pelo usuário. A leitura deve ser encerrada imediatamente quando o usuário digitar um número negativo (flag de parada). Ao final, o programa deve exibir a quantidade de números digitados, a soma total e a média aritmética deles (desconsiderando o valor negativo).

Conceitos: Laço com condição de parada indeterminada (while), acumulador de valores e contador de iterações.
 */

import java.util.Scanner;

public class SomaMediaFlag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int soma = 0;
        int contador = 0;
        
        System.out.println("Digite números inteiros positivos (ou um número negativo para encerrar):");
        System.out.print("Número: ");
        int numero = sc.nextInt();

        while (numero >= 0) {
            soma += numero;
            contador++;
            
            System.out.print("Número: ");
            numero = sc.nextInt();
        }

        System.out.println("\n--- Resultados ---");
        
        if (contador > 0) {
            double media = (double) soma / contador;
            
            System.out.println("Quantidade de números: " + contador);
            System.out.println("Soma total: " + soma);
            System.out.println("Média aritmética: " + media);
        } else {
            System.out.println("Nenhum número válido foi digitado.");
        }

        sc.close();
    }
}

