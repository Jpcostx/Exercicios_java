/*Enunciado: Desenvolva um programa que leia duas notas de um aluno, calcule a média aritmética e determine a situação acadêmica com base nas seguintes regras:

Média maior ou igual a 7.0: Aprovado

Média entre 5.0 (inclusive) e 6.9: Em Recuperação

Média abaixo de 5.0: Reprovado

Conceitos: Estrutura condicional encadeada (if-else if-else) e operadores lógicos (&&).
*/

import java.util.Scanner;

public class SituacaoAluno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double nota1 = sc.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = sc.nextDouble();

        double media = (nota1 + nota2) / 2;

        System.out.println("Média: " + media);

        if(media >= 7.0 ) {
            System.out.println("Situação final: Aprovado");
        }
            else if(media >= 5.0 && media < 7) {
                System.out.println("Situação final: Em recuperação ");
            }
            else {
                System.out.println("Situação final: Reprovado");
            }

        sc.close();
    }
    
}
