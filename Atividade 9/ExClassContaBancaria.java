/*Enunciado: Crie uma classe abstrata ContaBancaria com atributos privados numero e saldo, métodos concretos depositar(double valor) e consultarSaldo(), e um método abstrato:

abstract void cobrarTaxaMensal()
Crie duas classes filhas:
ContaCorrente: a taxa mensal é um valor fixo de R$ 15.00.
ContaEmpresarial: a taxa mensal é de R$ 30.00 acrescida de 0.5% sobre o saldo atual.
Instancie contas de ambos os tipos em uma lista polimórfica List<ContaBancaria> e execute a rotina de virada de mês chamando cobrarTaxaMensal() para todas.
 */
import java.util.ArrayList;
import java.util.List;

public class ExClassContaBancaria {

    abstract static class ContaBancaria {
        private String numero;
        private double saldo;

        public ContaBancaria(String numero, double saldoInicial) {
            this.numero = numero;
            this.saldo = saldoInicial;
        }

        public String getNumero() {
            return numero;
        }

        public double getSaldo() {
            return saldo;
        }

        protected void debitar(double valor) {
            this.saldo -= valor;
        }

        public void depositar(double valor) {
            if (valor > 0) {
                this.saldo += valor;
                System.out.println("Depósito de R$ " + String.format("%.2f", valor) + " realizado na conta " + numero);
            } else {
                System.out.println("Valor de depósito inválido.");
            }
        }

        public void consultarSaldo() {
            System.out.println("Conta: " + numero + " | Saldo Atual: R$ " + String.format("%.2f", saldo));
        }

        public abstract void cobrarTaxaMensal();
    }

    static class ContaCorrente extends ContaBancaria {
        private static final double TAXA_FIXA = 15.00;

        public ContaCorrente(String numero, double saldoInicial) {
            super(numero, saldoInicial);
        }

        @Override
        public void cobrarTaxaMensal() {
            debitar(TAXA_FIXA);
            System.out.println("Taxa mensal fixa de R$ " + String.format("%.2f", TAXA_FIXA) + 
                               " descontada da Conta Corrente " + getNumero());
        }
    }

    static class ContaEmpresarial extends ContaBancaria {
        private static final double TAXA_FIXA = 30.00;
        private static final double PERCENTUAL_SALDO = 0.005; // 0.5%

        public ContaEmpresarial(String numero, double saldoInicial) {
            super(numero, saldoInicial);
        }

        @Override
        public void cobrarTaxaMensal() {
            double taxaVariavel = getSaldo() * PERCENTUAL_SALDO;
            double taxaTotal = TAXA_FIXA + taxaVariavel;

            debitar(taxaTotal);
            System.out.println("Taxa mensal de R$ " + String.format("%.2f", taxaTotal) + 
                               " (R$ 30,00 + 0,5% do saldo) descontada da Conta Empresarial " + getNumero());
        }
    }

    public static void main(String[] args) {
        List<ContaBancaria> contas = new ArrayList<>();

        contas.add(new ContaCorrente("CC-1001", 1000.00));
        contas.add(new ContaEmpresarial("CE-5001", 10000.00)); // Taxa esperada: R$ 30,00 + R$ 50,00 = R$ 80,00
        contas.add(new ContaCorrente("CC-1002", 500.00));

        System.out.println("=== SALDOS ANTES DA VIRADA DE MÊS ===");
        for (ContaBancaria conta : contas) {
            conta.consultarSaldo();
        }

        System.out.println("\n=== VIRADA DE MÊS ===");
        for (ContaBancaria conta : contas) {
            conta.cobrarTaxaMensal();
        }

        System.out.println("\n=== SALDOS APÓS A VIRADA DE MÊS ===");
        for (ContaBancaria conta : contas) {
            conta.consultarSaldo();
        }
    }
}