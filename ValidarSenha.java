/*Enunciado: Desenvolva um programa que simule a autenticação de uma senha numérica (ex: 2026). O programa deve solicitar a senha repetidamente até que o usuário informe o valor correto. Para cada tentativa errada, exiba "Senha Incorreta! Tente novamente.". Quando correta, exiba "Acesso Permitido!".

Conceitos: Validação de entradas de usuário, condição booleana de continuidade e controle de fluxo.

Exercício 4: Contagem de Números Pares e Ímpares em um Intervalo (for)
 */

import java.util.Scanner;

public class ValidarSenha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int senhaCorreta = 123456;
        
        System.out.print("Digite a senha numérica: ");
        int senhaDigitada = sc.nextInt();

        while (senhaDigitada != senhaCorreta) {
            System.out.println("Senha Incorreta! Tente novamente.\n");
            
            System.out.print("Digite a senha numérica: ");
            senhaDigitada = sc.nextInt();
        }

        System.out.println("\nAcesso Permitido!");

        sc.close();
    }
}