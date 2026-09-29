/*Enunciado: Crie uma classe de exceção personalizada chamada SaldoInsuficienteException que herde de Exception (Checked Exception). Em seguida, crie uma classe ContaCorrente com os atributos numero (String) e saldo (double). O método sacar(double valor) deve lançar a exceção (throws SaldoInsuficienteException) caso o valor solicitado seja superior ao saldo disponível. No método main, realize saques dentro de um bloco try-catch capturando e exibindo a mensagem de erro.
Conceitos: Criação de Checked Exceptions (extends Exception), cláusulas throw e throws, e propagação de erros de domínio.
 */
public class ExSaldoInsuficiente {

    static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensagem) {
            super(mensagem);
        }
    }

    static class ContaCorrente {
        private String numero;
        private double saldo;

        public ContaCorrente(String numero, double saldoInicial) {
            this.numero = numero;
            this.saldo = saldoInicial;
        }

        public String getNumero() {
            return numero;
        }

        public double getSaldo() {
            return saldo;
        }

        public void sacar(double valor) throws SaldoInsuficienteException {
            if (valor > this.saldo) {
                throw new SaldoInsuficienteException(
                    "Falha na operacao: Saldo insuficiente para sacar R$ " + String.format("%.2f", valor) +
                    ". Saldo disponivel: R$ " + String.format("%.2f", this.saldo)
                );
            }
            this.saldo -= valor;
            System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso.");
        }
    }

    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente("CC-3003", 500.00);

        System.out.println("Conta: " + conta.getNumero() + " | Saldo Inicial: R$ " + String.format("%.2f", conta.getSaldo()));

        try {
            System.out.println("\nTentando sacar R$ 200,00...");
            conta.sacar(200.00);
            System.out.println("Saldo restante: R$ " + String.format("%.2f", conta.getSaldo()));
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nTentando sacar R$ 400,00...");
            conta.sacar(400.00);
            System.out.println("Saldo restante: R$ " + String.format("%.2f", conta.getSaldo()));
        } catch (SaldoInsuficienteException e) {
            System.out.println("Excecao capturada: " + e.getMessage());
        }

        System.out.println("\nPrograma finalizado com sucesso.");
    }
}