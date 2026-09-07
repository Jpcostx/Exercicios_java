/*Enunciado: Crie um programa que leia 10 números inteiros e os armazene em um vetor original. Em seguida, distribua os valores em dois novos vetores: um contendo apenas os números pares e outro contendo apenas os ímpares. Ao final, exiba os elementos de cada um dos novos vetores.
Conceitos: Controle de índices independentes para múltiplos vetores, operador módulo (%) e dimensionamento dinâmico ou estático de arrays auxiliares. */
import java.util.Scanner;

public class SeparadorParesImpares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] original = new int[10];
        int qtdPares = 0;
        
        System.out.println("Digite 10 números inteiros:");
        
        for (int i = 0; i < original.length; i++) {
            System.out.print("Posição " + i + ": ");
            original[i] = sc.nextInt();
        
            if (original[i] % 2 == 0) {
                qtdPares++;
            }
        }
        
        int[] pares = new int[qtdPares];
        int[] impares = new int[original.length - qtdPares];
        
        int indicePar = 0;
        int indiceImpar = 0;
        
        for (int i = 0; i < original.length; i++) {
            if (original[i] % 2 == 0) {
                pares[indicePar] = original[i]; 
                indicePar++;                   
            } else {
                impares[indiceImpar] = original[i]; 
                indiceImpar++;                    
            }
        }
        
        
        System.out.println("\n--- Valores Separados ---");
        
        System.out.print("Números Pares: ");
        for (int i = 0; i < pares.length; i++) {
            System.out.print(pares[i] + " ");
        }
        
        System.out.print("\nNúmeros Ímpares: ");
        for (int i = 0; i < impares.length; i++) {
            System.out.print(impares[i] + " ");
        }
        System.out.println();
        
        sc.close();
    }
}