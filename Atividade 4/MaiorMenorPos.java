/*Enunciado: Crie um programa que preencha um vetor de 10 números inteiros. O programa deve percorrer o vetor e identificar:
O maior valor e o índice onde ele se encontra.
O menor valor e o índice onde ele se encontra.
Conceitos: Inicialização de variáveis de controle com o primeiro elemento (vetor[0]), busca linear e rastreamento de índices.
 */
import java.util.Scanner;

public class MaiorMenorPos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];

        System.out.println("Digite 10 números inteiros:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Posição " + i + ": ");
            numeros[i] = sc.nextInt();
        }

        int maior = numeros[0];
        int menor = numeros[0];
        int indiceMaior = 0;
        int indiceMenor = 0;

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
                indiceMaior = i;
            }
            if (numeros[i] < menor) {
                menor = numeros[i];
                indiceMenor = i;
            }
        }

        System.out.println("\n--- Resultados ---");
        System.out.println("Maior valor: " + maior + " | Índice: " + indiceMaior);
        System.out.println("Menor valor: " + menor + " | Índice: " + indiceMenor);
        
        sc.close();
    }
} 
