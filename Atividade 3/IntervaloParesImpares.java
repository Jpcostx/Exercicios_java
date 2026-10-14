/*
Enunciado: Faça um programa que leia dois valores inteiros que representam os limites de um intervalo fechado [A, B] (onde A <= B). O programa deve iterar por todos os números desse intervalo e exibir:

A quantidade de números pares.
A quantidade de números ímpares.

Conceitos: Estrutura de repetição for combinada com decisão condicional (if/else) e operador módulo (%).

 */

import java.util.Scanner;

public class IntervaloParesImpares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor inicial do intervalo (A): ");
        int limiteA = sc.nextInt();

        System.out.print("Digite o valor final do intervalo (B): ");
        int limiteB = sc.nextInt();

        int qtdPares = 0;
        int qtdImpares = 0;

        for (int i = limiteA; i <= limiteB; i++) {
            
            if (i % 2 == 0) {
                qtdPares++; 
            } else {
                qtdImpares++; 
            }
        }

        System.out.println("\n--- Resultado do Intervalo [" + limiteA + ", " + limiteB + "] ---");
        System.out.println("Quantidade de números pares: " + qtdPares);
        System.out.println("Quantidade de números ímpares: " + qtdImpares);

        sc.close();
    }
}
