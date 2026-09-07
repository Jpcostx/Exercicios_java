/*Enunciado: Crie uma classe ContaBancaria com os atributos titular (String), numeroConta (String) e saldo (double, iniciando em zero). Implemente os métodos:
depositar(double valor): adiciona o valor ao saldo se valor > 0.
sacar(double valor): subtrai o valor do saldo apenas se houver saldo suficiente (saldo >= valor) e se valor > 0; caso contrário, imprime "Saldo insuficiente ou valor inválido".
consultarSaldo(): imprime o saldo atual.
Instancie uma conta no método principal e teste sequências válidas e inválidas de saques e depósitos.
Conceitos: Métodos com passagem de parâmetros, manipulação e proteção de estado interno com condicionais. */
import java.util.Scanner;

class ContaBancaria {
    String titular;
    String numeroConta;
    double saldo = 0;

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Falha: O valor de depósito deve ser maior que zero.");
        }
    }

    void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Falha no saque: Saldo insuficiente ou valor inválido.");
        }
    }

    void consultarSaldo() {
        System.out.println("\nConta: " + numeroConta + " | Titular: " + titular);
        System.out.println("Saldo atual: R$ " + saldo);
        System.out.println("----------------------------------------");
    }
}

public class ExContaBancaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaBancaria minhaConta = new ContaBancaria();
        
        System.out.println("--- Abertura de Conta ---");
        System.out.print("Digite o nome do titular: ");
        minhaConta.titular = sc.nextLine();
        
        System.out.print("Digite o número da conta: ");
        minhaConta.numeroConta = sc.nextLine();
        
        minhaConta.consultarSaldo();
        
        System.out.print("Digite o valor que deseja depositar: R$ ");
        double valorDeposito = sc.nextDouble();
        minhaConta.depositar(valorDeposito);
        minhaConta.consultarSaldo();
        
        System.out.print("Digite o valor que deseja sacar: R$ ");
        double valorSaque = sc.nextDouble();
        minhaConta.sacar(valorSaque);
        minhaConta.consultarSaldo();
        
        sc.close();
    }
}