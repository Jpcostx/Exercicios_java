/* Enunciado: Crie um programa que leia o ano de nascimento de uma pessoa e o ano atual. Calcule a idade e exiba se ela já é maior de idade (18 anos ou mais) ou menor de idade.

Conceitos: Operadores relacionais (>=) e subtração básica combinada com decisão.
*/

import java.util.Scanner;

public class Validador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o ano de nascimento ");
        int ano = sc.nextInt();

        System.out.print("Digite o ano atual ");
         int ano_atual = sc.nextInt();

         int idade = ano_atual - ano;

         System.out.print("Idade calculada: " + idade + " anos\n");

         if(ano > ano_atual) {
            System.out.print("Resultado inválido: ano de nascimento maior que o ano atual");
         }
        else if(idade >= 18) {
            System.out.print("Usuário com " + idade + " anos" + " é maior de idade ");
         } else {
             System.out.print("Usuário com " + idade + " anos" + " é menor de idade ");
         }
         sc.close();
    }
}
