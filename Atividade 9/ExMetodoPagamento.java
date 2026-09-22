/*Enunciado: Crie uma interface MetodoPagamento contendo os métodos:

void processarPagamento(double valor)
String obterDetalhes()
Implemente duas classes concretas que assinem o contrato: CartaoCredito (com atributos numeroCartao e limite) e Pix (com atributo chavePix). Na classe Main, crie um método finalizarCompra(MetodoPagamento metodo, double total) que processe compras utilizando qualquer um dos dois métodos.

Conceitos: Contrato de interface (interface, implements), desacoplamento e polimorfismo via interface.
 */
public class ExMetodoPagamento {
    public interface MetodoPagamento {
        void processarPagamento(double valor);
        String obterDetalhes();
    }

    static class CartaoCredito implements MetodoPagamento {
        private String numeroCartao;
        private double limite;

        public CartaoCredito(String numeroCartao, double limite) {
            this.numeroCartao = numeroCartao;
            this.limite = limite;
        }

        public String getNumeroCartao() {
            return numeroCartao;
        }

        public double getLimite() {
            return limite;
        }

        @Override
        public void processarPagamento(double valor) {
            if (valor <= this.limite) {
                this.limite -= valor;
                System.out.println("Pagamento de R$ " + String.format("%.2f", valor) + " aprovado no Cartão de Crédito.");
                System.out.println("   Limite restante: R$ " + String.format("%.2f", this.limite));
            } else {
                System.out.println("Pagamento recusado: Limite insuficiente no cartão de crédito (Disponível: R$ " + String.format("%.2f", limite) + ").");
            }
        }

        @Override
        public String obterDetalhes() {
            String ultimosDigitos = numeroCartao.substring(Math.max(0, numeroCartao.length() - 4));
            return "Cartão de Crédito (Final **** " + ultimosDigitos + ")";
        }
    }

    static class Pix implements MetodoPagamento {
        private String chavePix;

        public Pix(String chavePix) {
            this.chavePix = chavePix;
        }

        public String getChavePix() {
            return chavePix;
        }

        @Override
        public void processarPagamento(double valor) {
            System.out.println("Pagamento de R$ " + String.format("%.2f", valor) + " recebido instantaneamente via Pix.");
        }

        @Override
        public String obterDetalhes() {
            return "Pix (Chave: " + chavePix + ")";
        }
    }

    public static void finalizarCompra(MetodoPagamento metodo, double total) {
        System.out.println("--- PROCESSANDO CHECKOUT ---");
        System.out.println("Método Selecionado: " + metodo.obterDetalhes());
        System.out.println("Total a Pagar: R$ " + String.format("%.2f", total));
        
        metodo.processarPagamento(total);
        System.out.println("----------------------------\n");
    }

    public static void main(String[] args) {
        MetodoPagamento cartao = new CartaoCredito("1234-5678-9012-3456", 1500.00);
        MetodoPagamento pix = new Pix("joao@email.com");

        System.out.println("=== CHECKOUT E-COMMERCE ===\n");

        finalizarCompra(pix, 250.00);

        finalizarCompra(cartao, 800.00);

        finalizarCompra(cartao, 900.00);
    }
}