/*Enunciado: Crie um programa que leia uma matriz A de dimensão 2 x 3 de números inteiros. Em seguida, construa e exiba a sua matriz transposta A^ de dimensão 3 x 2 (onde o elemento da posição [i][j] em A passa a ocupar a posição [j][i] em A^).

Conceitos: Manipulação e inversão de dimensões (linhas viram colunas), instanciação de matrizes complementares. */
import java.util.Scanner;

public class MatrizTransposta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][] matrizA = new int[2][3];         
        int[][] matrizTransposta = new int[3][2];
        
        System.out.println("Digite os valores da Matriz A (2x3):");
        
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                System.out.print("Posição [" + i + "][" + j + "]: ");
                matrizA[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
            
                matrizTransposta[j][i] = matrizA[i][j];
            }
        }
        
        System.out.println("\n--- Matriz Original ---");
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                System.out.print(matrizA[i][j] + "\t");
            }
            System.out.println();
        }
        
        System.out.println("\n--- Matriz Transposta ---");
        for (int i = 0; i < matrizTransposta.length; i++) {
            for (int j = 0; j < matrizTransposta[i].length; j++) {
                System.out.print(matrizTransposta[i][j] + "\t");
            }
            System.out.println();
        }
        
        sc.close();
    }
}