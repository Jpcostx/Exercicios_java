/* Escreva um programa que leia uma matriz 3 x 4 de números inteiros. O programa deve identificar o maior valor presente na matriz e informar exatamente a linha e a coluna onde ele se encontra.

Conceitos: Rastreamento de múltiplos índices de posição (linhaMaior, colunaMaior) e busca linear bidimensional. */
import java.util.Scanner;

public class MaiorElementoMatriz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][] matriz = new int[3][4];
        
        System.out.println("Digite os valores para preencher a matriz 3x4:");
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Posição [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
        
        int maior = matriz[0][0];
        int linhaMaior = 0;
        int colunaMaior = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                
            
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j]; 
                    linhaMaior = i;      
                    colunaMaior = j;      
                }
            }
        }
        
        System.out.println("\n--- Resultado da Busca ---");
        System.out.println("O maior valor encontrado foi: " + maior);
        System.out.println("Localização exata -> Linha: " + linhaMaior + " | Coluna: " + colunaMaior);
        
        sc.close();
    }
}