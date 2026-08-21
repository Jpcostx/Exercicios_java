/*
Enunciado: Desenvolva um programa que receba o valor da hora de trabalho de um funcionário e a quantidade de horas trabalhadas no mês. O programa deve calcular o salário bruto, descontar uma taxa fixa de 10% referente ao INSS e exibir o salário líquido final.
Conceitos: Multiplicação, cálculo percentual e variáveis intermediárias.
Exemplo de Entrada: Valor da hora: 50.00, Horas: 160  Saída esperada: Salário Bruto: R$ 8000.00, Salário Líquido: R$ 7200.00
*/

import java.util.Scanner;

public class SalarioInss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o valor da hora trabalhada: ");
        double valorHora = sc.nextDouble();

        System.out.print("Digite o número de horas trabalhadas no mês: ");
        double horasTrabalhadas = sc.nextDouble();
       
        double salarioBruto = valorHora * horasTrabalhadas;

        double desconto = salarioBruto * 0.10;

        double salarioLiquido = salarioBruto - desconto;

        System.out.printf("Salário Bruto: R$ %.2f\n", salarioBruto);
        System.out.printf("Salário Líquido: R$ %.2f\n", salarioLiquido);

        sc.close();
    }
}
