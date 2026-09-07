/*
Exercício 1: Calculadora de Média Simples
Enunciado: Escreva um programa em Java que leia três notas de um aluno (números decimais), calcule e exiba a média aritmética simples dessas notas.
Conceitos: Leitura de dados (Scanner), variáveis do tipo double, operadores aritméticos de soma e divisão.
Exemplo de Entrada: 7.5, 8.0, 6.5 Saída esperada: Média: 7.33
*/ 

import java.util.Scanner;

public class CalculadoraMedia {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();

        double media = (nota1 + nota2 + nota3) / 3.0;

        System.out.printf("Média: %.2f\n", media);

        scanner.close();
    }
}