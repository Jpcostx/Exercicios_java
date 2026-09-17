/*Enunciado: Crie uma classe ContaBancaria com os atributos privados numeroConta (String), titular (String) e saldo (double). Regras de encapsulamento:
O construtor deve receber obrigatoriamente numeroConta e titular. O saldo inicial deve começar em zero (ou ter um segundo construtor que aceite um depósito inicial).
O atributo numeroConta deve ter apenas método getter (não pode ser alterado após a criação).
O atributo saldo não deve ter método setter direto — sua alteração só pode ocorrer através dos métodos operacionais depositar(double valor) e sacar(double valor).
O titular pode ter getter e setter.
Conceitos: Encapsulamento estrito (ocultação de atributos sem expor setters indiscriminadamente) e imutabilidade de campos identificadores.
 */
import java.util.Scanner;

public class ExContaBanco {
    private String numeroConta;
    private String titular;
    private double saldo;

    public ExContaBanco(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0; 
    }

    public ExContaBanco(String numeroConta, String titular, double depositoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
        this.depositar(depositoInicial); 
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println(" Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println(" Erro: O valor do depósito deve ser maior que zero.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println(" Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println(" Erro no saque: Saldo insuficiente ou valor inválido.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== ABERTURA DE CONTA ===");
        System.out.print("Digite o número da nova conta: ");
        String numeroDigitado = sc.nextLine();

        System.out.print("Digite o nome do titular: ");
        String titularDigitado = sc.nextLine();

        System.out.print("Deseja fazer um depósito inicial? (Digite o valor ou 0 para pular): R$ ");
        double depositoInicial = sc.nextDouble();

        ExContaBanco minhaConta;
        if (depositoInicial > 0) {
            minhaConta = new ExContaBanco(numeroDigitado, titularDigitado, depositoInicial);
        } else {
            minhaConta = new ExContaBanco(numeroDigitado, titularDigitado);
        }

        System.out.println("\n=== STATUS DA CONTA ===");
        System.out.println("Titular: " + minhaConta.getTitular());
        System.out.println("Saldo Atual: R$ " + minhaConta.getSaldo());

        System.out.println("\n=== OPERAÇÕES ===");
        System.out.print("Digite um valor para SACAR: R$ ");
        double valorSaque = sc.nextDouble();
        minhaConta.sacar(valorSaque); 

        System.out.println("\nSaldo Final: R$ " + minhaConta.getSaldo());

        sc.close();
    }
}