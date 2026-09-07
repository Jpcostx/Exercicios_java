/*Enunciado: Desenvolva um programa que armazene as notas finais de 8 alunos em um vetor do tipo double. Calcule a média aritmética da turma e, em um segundo laço, exiba quais notas ficaram estritamente acima da média calculada.
Conceitos: Múltiplas passagens pelo mesmo vetor, cálculo acumulador e filtragem condicional de elementos.
 */
import java.util.Scanner;

public class MediaDaTurma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[] notas = new double[8];
        double soma = 0;

        System.out.println("Digite as notas finais dos 8 alunos:");

        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota do aluno " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
            soma += notas[i]; 
        }

        double media = soma / notas.length;
        
        System.out.println("\n--- Resumo ---");
        System.out.println("Média da turma: " + media);
        System.out.println("\nAlunos acima da média da turma:");

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > media) {
                System.out.println("Aluno " + (i + 1) + ": " + notas[i]);
            }
        }

        sc.close();
    }
}