/*Enunciado: Crie um programa que receba um número inteiro não negativo N e calcule o seu fatorial N!

Conceitos: Variável acumuladora de produto (inicializada em 1), controle de laço decrescente/crescente e tipo de dado numérico para evitar overflow (long).
 */

import java.util.Scanner;

public class CalculadoraFatorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Erro: Não existe fatorial de número negativo.");
        } else {
            long fatorial = 1;
            
            for (int i = n; i >= 1; i--) {
                fatorial *= i;
            }
            
            System.out.println("\nO resultado de " + n + "! é: " + fatorial);
        }

        sc.close();
    }
}