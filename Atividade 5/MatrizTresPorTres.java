/*Enunciado: Crie um programa em Java que declare e preencha uma matriz de inteiros 3 x 3 com valores fornecidos pelo usuário. Ao final, exiba a matriz formatada em formato de grade (linhas e colunas).

Conceitos: Declaração e instanciação de arrays bidimensionais (int[][]), laços aninhados (for dentro de for) e formatação de saída (print vs println). */
import java.util.Scanner;

public class MatrizTresPorTres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][] matriz = new int[3][3];
        
        System.out.println("Digite os valores para preencher a matriz 3x3:");
        
        for (int i = 0; i < matriz.length; i++) {           // Percorre as linhas
            for (int j = 0; j < matriz[i].length; j++) {    // Percorre as colunas da linha atual
                System.out.print("Posição [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("\n--- Matriz Formatada ---");
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t"); 
            }
            System.out.println(); 
        }
        
        sc.close();
    }
}