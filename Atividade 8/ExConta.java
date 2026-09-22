/*Enunciado: Crie uma classe Conta com atributos encapsulados numero (String) e saldo (double), com métodos depositar(double valor) e sacar(double valor). Em seguida:
Crie a subclasse ContaPoupanca com o atributo taxaRendimento (double) e método aplicarRendimento(). O método sacar() funciona normalmente sem taxas.
Crie a subclasse ContaCorrente com o atributo limiteChequeEspecial (double). Sobrescreva o método sacar(double valor) para cobrar uma taxa fixa de R$ 2.00 por saque e permitir que o saldo fique negativo até o limite do cheque especial.
Conceitos: Reutilização de métodos da superclasse, sobrescrita com alteração de regras de validação/taxação e uso de super.sacar().
 */
public class ExConta {

    static class Conta {
        private String numero;
        private double saldo;

        public Conta(String numero, double saldoInicial) {
            this.numero = numero;
            this.saldo = saldoInicial;
        }

        public String getNumero() {
            return numero;
        }

        public double getSaldo() {
            return saldo;
        }

        protected void creditar(double valor) {
            this.saldo += valor;
        }

        protected void debitar(double valor) {
            this.saldo -= valor;
        }

        public void depositar(double valor) {
            if (valor > 0) {
                creditar(valor);
                System.out.println("Depósito de R$ " + String.format("%.2f", valor) + " realizado.");
            } else {
                System.out.println("Valor de depósito inválido.");
            }
        }

        protected boolean podeSacar(double valor) {
            return this.saldo >= valor;
        }

        public void sacar(double valor) {
            if (valor <= 0) {
                System.out.println("O valor do saque deve ser maior que zero.");
                return;
            }

            if (podeSacar(valor)) {
                debitar(valor);
                System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso.");
            } else {
                System.out.println("Saque recusado: Saldo insuficiente. (Saldo atual: R$ " + String.format("%.2f", saldo) + ")");
            }
        }
    }

    static class ContaPoupanca extends Conta {
        private double taxaRendimento; // Ex: 0.5 para 0.5%

        public ContaPoupanca(String numero, double saldoInicial, double taxaRendimento) {
            super(numero, saldoInicial);
            this.taxaRendimento = taxaRendimento;
        }

        public double getTaxaRendimento() {
            return taxaRendimento;
        }

        public void aplicarRendimento() {
            double rendimento = getSaldo() * (this.taxaRendimento / 100.0);
            creditar(rendimento);
            System.out.println("Rendimento de R$ " + String.format("%.2f", rendimento) + " creditado.");
        }
    }

    static class ContaCorrente extends Conta {
        private double limiteChequeEspecial;
        private static final double TAXA_SAQUE = 2.00;

        public ContaCorrente(String numero, double saldoInicial, double limiteChequeEspecial) {
            super(numero, saldoInicial);
            this.limiteChequeEspecial = limiteChequeEspecial;
        }

        public double getLimiteChequeEspecial() {
            return limiteChequeEspecial;
        }

        @Override
        protected boolean podeSacar(double valor) {
            return (getSaldo() + limiteChequeEspecial) >= valor;
        }

        @Override
        public void sacar(double valor) {
            double valorTotalComTaxa = valor + TAXA_SAQUE;
            System.out.println("Operação: Saque de R$ " + String.format("%.2f", valor) + " + Taxa R$ " + String.format("%.2f", TAXA_SAQUE));
            
            super.sacar(valorTotalComTaxa);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== TESTE CONTA POUPANÇA ===");
        ContaPoupanca poupanca = new ContaPoupanca("CP-100", 1000.00, 0.5);
        poupanca.aplicarRendimento();
        System.out.println("Saldo Poupança: R$ " + String.format("%.2f", poupanca.getSaldo()));
        poupanca.sacar(200.00); 
        System.out.println("Saldo após saque: R$ " + String.format("%.2f", poupanca.getSaldo()));

        System.out.println("\n=== TESTE CONTA CORRENTE ===");
        ContaCorrente corrente = new ContaCorrente("CC-200", 100.00, 500.00);
        System.out.println("Saldo Inicial: R$ " + String.format("%.2f", corrente.getSaldo()) + " | Limite: R$ " + String.format("%.2f", corrente.getLimiteChequeEspecial()));

        corrente.sacar(50.00);
        System.out.println("Saldo atual: R$ " + String.format("%.2f", corrente.getSaldo()));

        corrente.sacar(200.00);
        System.out.println("Saldo atual (com cheque especial): R$ " + String.format("%.2f", corrente.getSaldo()));

        corrente.sacar(350.00);
        System.out.println("Saldo Final Corrente: R$ " + String.format("%.2f", corrente.getSaldo()));
    }
}