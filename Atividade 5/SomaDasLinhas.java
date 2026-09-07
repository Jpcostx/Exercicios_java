/*Faça um programa que leia uma matriz 4 x 3 de números inteiros. Em seguida, calcule a soma dos elementos de cada linha individualmente e armazene os resultados em um vetor unidimensional de tamanho 4. Ao final, exiba a soma correspondente a cada linha.

Conceitos: Integração entre arrays bidimensionais e unidimensionais, reinicialização de acumuladores dentro do laço externo. */
import java.util.Scanner;

public class SomaDasLinhas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][] matriz = new int[4][3];
        
        int[] somaLinhas = new int[4]; 
        
        System.out.println("Digite os valores para preencher a matriz 4x3:");
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Posição [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < matriz.length; i++) {
            int soma = 0; 
            
            for (int j = 0; j < matriz[i].length; j++) {
                soma += matriz[i][j];
            }
            
            somaLinhas[i] = soma; 
        }
        
        System.out.println("\n--- Resumo das Somas ---");
        for (int i = 0; i < somaLinhas.length; i++) {
            System.out.println("Soma da linha " + i + ": " + somaLinhas[i]);
        }
        
        sc.close();
    }
}