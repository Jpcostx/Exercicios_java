/* 
Enunciado: Crie um programa que solicite uma temperatura em graus Celsius ($C$) e a converta para Fahrenheit (F) utilizando a fórmula:
F = (C * 1.8) + 32 
Conceitos: Operações aritméticas com precedência de parênteses e formatação de saída.
Exemplo de Entrada: 25.0  Saída esperada: 77
*/

import java.util.Scanner;

public class ConversorTemperatura { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a temperatura em Celsius: ");
        double celsius = sc.nextDouble();

        double fahrenheit = (celsius * 1.8) + 32; 
        System.out.print(" A temperatura em Fahrenheit é: " + fahrenheit);

        sc.close();
    }
}
