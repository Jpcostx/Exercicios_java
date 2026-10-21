import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class ExCalculosStreams {

    static class Produto {
        private String nome;
        private double preco;

        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }
    }

    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook", 4500.00),
            new Produto("Monitor", 1200.00),
            new Produto("Teclado", 350.00),
            new Produto("Mouse", 150.00),
            new Produto("Mesa", 800.00),
            new Produto("Cadeira", 1500.00)
        );

        double valorTotal = produtos.stream()
            .mapToDouble(Produto::getPreco)
            .sum();

        OptionalDouble precoMedioOpt = produtos.stream()
            .mapToDouble(Produto::getPreco)
            .average();
        
        double precoMedio = precoMedioOpt.orElse(0.0);

        Optional<Produto> produtoMaisCaroOpt = produtos.stream()
            .max(Comparator.comparingDouble(Produto::getPreco));

        System.out.println("=== ESTATISTICAS DE PRODUTOS ===");
        System.out.println("Valor total do estoque: R$ " + String.format("%.2f", valorTotal));
        System.out.println("Preco medio dos produtos: R$ " + String.format("%.2f", precoMedio));

        if (produtoMaisCaroOpt.isPresent()) {
            Produto caro = produtoMaisCaroOpt.get();
            System.out.println("Produto mais caro: " + caro.getNome() + " (R$ " + String.format("%.2f", caro.getPreco()) + ")");
        }
    }
}