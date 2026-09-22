/*Enunciado: Crie uma classe Produto encapsulada com os atributos privados: nome (String), preco (double) e quantidadeEstoque (int). Implemente:
Um construtor completo que inicialize os 3 atributos.
Um construtor sobrecarregado que receba apenas nome e preco, inicializando quantidadeEstoque com 0.
Métodos getters e setters para todos os atributos (com validação no setter do preço e do estoque para não aceitarem valores negativos).
Um método calcularValorTotalEmEstoque() que retorne preco * quantidadeEstoque.
Conceitos: Modificadores de acesso private/public, palavra-chave this, sobrecarga de construtores (constructor overloading) e proteção de estado via setters.
Exemplo de Execução: Instanciar Produto A com 3 parâmetros e Produto B com 2 parâmetros; tentar atribuir um preço negativo via setPreco(-10.0) e validar que o valor não se altera.
 */
public class ExProduto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public ExProduto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.setPreco(preco);
        this.setQuantidadeEstoque(quantidadeEstoque);
    }

    public ExProduto(String nome, double preco) {
        this(nome, preco, 0); 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            System.out.println(" Erro de validação: O preço não pode ser negativo. Valor mantido: R$ " + this.preco);
            return;
        }
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0) {
            System.out.println(" Erro de validação: O estoque não pode ser negativo. Valor mantido: " + this.quantidadeEstoque);
            return;
        }
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double calcularValorTotalEmEstoque() {
        return preco * quantidadeEstoque;
    }

    public static void main(String[] args) {
        ExProduto produtoA = new ExProduto("Monitor 24 Polegadas", 899.90, 20);

        ExProduto produtoB = new ExProduto("Cabo HDMI", 35.50);

        System.out.println("=== Detalhes do Produto A ===");
        System.out.println("Nome: " + produtoA.getNome());
        System.out.println("Preço: R$ " + produtoA.getPreco());
        System.out.println("Estoque: " + produtoA.getQuantidadeEstoque() + " unidades");
        System.out.println("Valor total em estoque: R$ " + produtoA.calcularValorTotalEmEstoque());

        System.out.println("\n=== Detalhes do Produto B ===");
        System.out.println("Nome: " + produtoB.getNome());
        System.out.println("Preço: R$ " + produtoB.getPreco());
        System.out.println("Estoque (Criado via sobrecarga): " + produtoB.getQuantidadeEstoque() + " unidades");

        System.out.println("\n=== Teste de Regra de Negócio ===");
        System.out.println("Tentando executar: produtoA.setPreco(-10.0)...");
        
        produtoA.setPreco(-10.0);
        
        System.out.println("Validação -> Preço atual do Produto A: R$ " + produtoA.getPreco());
    }
}
