/* Enunciado: Crie uma classe Produto com os atributos nome (String), categoria (String) e preco (double). Crie uma lista (ArrayList<Produto>) contendo diversos produtos de categorias variadas (ex: "Informática", "Alimentos", "Livros"). Em seguida, implemente uma rotina que agrupe esses produtos em um HashMap<String, List<Produto>>, onde cada chave é uma categoria e o valor associado é uma lista contendo apenas os produtos daquela categoria. Ao final, exiba os produtos agrupados sob seus respectivos títulos de categoria.
Conceitos: Estruturas de dados aninhadas (Map<K, List<V>>), inicialização condicional de listas dentro de mapas e agrupamento de objetos de domínio
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExAgrupamentoProdutos {

    static class Produto {
        private String nome;
        private String categoria;
        private double preco;

        public Produto(String nome, String categoria, double preco) {
            this.nome = nome;
            this.categoria = categoria;
            this.preco = preco;
        }

        public String getNome() {
            return nome;
        }

        public String getCategoria() {
            return categoria;
        }

        public double getPreco() {
            return preco;
        }
    }

    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook", "Informática", 3500.00));
        produtos.add(new Produto("Mouse", "Informática", 80.00));
        produtos.add(new Produto("Teclado", "Informática", 150.00));
        produtos.add(new Produto("Arroz 5kg", "Alimentos", 25.00));
        produtos.add(new Produto("Feijão 1kg", "Alimentos", 8.50));
        produtos.add(new Produto("Clean Code", "Livros", 95.00));
        produtos.add(new Produto("Java: How to Program", "Livros", 180.00));

        Map<String, List<Produto>> produtosPorCategoria = new HashMap<>();

        for (Produto produto : produtos) {
            String categoria = produto.getCategoria();

            if (!produtosPorCategoria.containsKey(categoria)) {
                produtosPorCategoria.put(categoria, new ArrayList<>());
            }

            produtosPorCategoria.get(categoria).add(produto);
        }

        System.out.println("=== AGRUPAMENTO DE PRODUTOS POR CATEGORIA ===");
        for (Map.Entry<String, List<Produto>> entry : produtosPorCategoria.entrySet()) {
            System.out.println("\nCategoria: " + entry.getKey());
            System.out.println("----------------------------------------");
            for (Produto p : entry.getValue()) {
                System.out.println("  - " + p.getNome() + " | Preço: R$ " + String.format("%.2f", p.getPreco()));
            }
        }
    }
}