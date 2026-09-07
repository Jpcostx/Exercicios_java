/*Enunciado: Faça um programa que leia um vetor de 6 números inteiros. Em seguida, solicite ao usuário um número de busca ($X$). O programa deve informar se $X$ está presente no vetor e, caso esteja, exibir a primeira posição (índice) onde ele foi encontrado. Se não estiver presente, exibir uma mensagem indicando ausência.

Conceitos: Algoritmo de busca sequencial, uso de flag booleana (boolean encontrado) e interrupção de repetição com break. 

 */
import java.util.Scanner;

public class BuscaSequencial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] numeros = new int[6];
        
        System.out.println("Digite 6 números inteiros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Posição " + i + ": ");
            numeros[i] = sc.nextInt();
        }
        
        System.out.print("\nDigite o número que deseja buscar (X): ");
        int x = sc.nextInt();
        
        boolean encontrado = false;
        int posicao = -1;
        
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == x) {
                encontrado = true; 
                posicao = i;       
                break;    
            }
        }
        
        System.out.println("\n--- Resultado ---");
        if (encontrado) {
            System.out.println("O número " + x + " foi encontrado primeiro no índice " + posicao + ".");
        } else {
            System.out.println("O número " + x + " não está presente no vetor.");
        }
        
        sc.close();
    }
}