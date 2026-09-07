/*Enunciado: Desenvolva um programa que leia uma matriz quadrada de ordem 4 (4 x 4) de números reais (double). O programa deve calcular e exibir a soma de todos os elementos que pertencem à diagonal principal (onde o índice da linha é igual ao índice da coluna: i == j).

Conceitos: Matrizes quadradas, identificação geométrica de índices e otimização de iteração (laço único vs laços aninhados). */
import java.util.Scanner;

public class SomaDiagonalPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[][] matriz = new double[4][4];
        
        System.out.println("Digite os valores em números reais para a matriz 4x4:");
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Posição [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }
        
        double somaDiagonal = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            somaDiagonal += matriz[i][i]; 
        }
        
        System.out.println("\n--- Resultado ---");
        System.out.println("A soma da diagonal principal é: " + somaDiagonal);
        
        sc.close();
    }
}