/* Enunciado: Crie um sistema de inventário de produtos onde a chave é o código do produto (String) e o valor é a quantidade em estoque (Integer). Implemente métodos para:
Inserir novos produtos.
Atualizar a quantidade somando ou subtraindo estoque com base em um código.
Consultar se um código existe (containsKey()) antes de realizar a operação.
Exibir a lista de todos os produtos com estoque zerado ou abaixo de um valor de alerta (ex: < 5 unidades).
Conceitos: Manipulação de entradas de mapas, validação de chaves e atualização de valores associados.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExInventarioEstoque {

    static class GerenciadorEstoque {
        private Map<String, Integer> estoque = new HashMap<>();

        public void cadastrarProduto(String codigo, int quantidadeInicial) {
            if (codigo == null || codigo.trim().isEmpty()) {
                System.out.println("Erro: Codigo do produto nao pode ser nulo ou vazio.");
                return;
            }
            if (quantidadeInicial < 0) {
                System.out.println("Erro: Quantidade inicial nao pode ser negativa.");
                return;
            }
            if (estoque.containsKey(codigo)) {
                System.out.println("Erro: Produto com codigo '" + codigo + "' ja cadastrado.");
                return;
            }
            estoque.put(codigo, quantidadeInicial);
            System.out.println("Produto '" + codigo + "' cadastrado com sucesso. Estoque inicial: " + quantidadeInicial);
        }

        public void atualizarEstoque(String codigo, int variacao) {
            if (!estoque.containsKey(codigo)) {
                System.out.println("Erro: Produto com codigo '" + codigo + "' nao encontrado no inventario.");
                return;
            }

            int quantidadeAtual = estoque.get(codigo);
            int novaQuantidade = quantidadeAtual + variacao;

            if (novaQuantidade < 0) {
                System.out.println("Erro: Operacao cancelada. Estoque insuficiente para o produto '" + codigo + 
                                   "'. Atual: " + quantidadeAtual + " | Tentativa de remocao: " + Math.abs(variacao));
                return;
            }

            estoque.put(codigo, novaQuantidade);
            System.out.println("Estoque do produto '" + codigo + "' atualizado: " + quantidadeAtual + " -> " + novaQuantidade);
        }

        public void consultarProduto(String codigo) {
            if (estoque.containsKey(codigo)) {
                System.out.println("Produto '" + codigo + "' | Quantidade em estoque: " + estoque.get(codigo));
            } else {
                System.out.println("Produto '" + codigo + "' nao existe no inventario.");
            }
        }

        public void exibirAlertasEstoque(int limiteAlerta) {
            System.out.println("\n=== RELATORIO DE ALERTA DE ESTOQUE (Abaixo de " + limiteAlerta + " unidades) ===");
            boolean encontrouAlerta = false;

            for (Map.Entry<String, Integer> entry : estoque.entrySet()) {
                if (entry.getValue() < limiteAlerta) {
                    System.out.println("ALERTA - Produto: " + entry.getKey() + " | Quantidade: " + entry.getValue());
                    encontrouAlerta = true;
                }
            }

            if (!encontrouAlerta) {
                System.out.println("Nenhum produto com estoque abaixo do limite de alerta.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorEstoque gerenciador = new GerenciadorEstoque();

        boolean executando = true;

        while (executando) {
            System.out.println("\n=== SISTEMA DE INVENTARIO DE ESTOQUE ===");
            System.out.println("1. Cadastrar Novo Produto");
            System.out.println("2. Atualizar Estoque (Adicionar/Remover)");
            System.out.println("3. Consultar Produto");
            System.out.println("4. Exibir Alertas de Estoque Baixo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                int opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o codigo do produto: ");
                        String codigoCad = sc.nextLine();
                        System.out.print("Digite a quantidade inicial: ");
                        int qtdCad = Integer.parseInt(sc.nextLine());
                        gerenciador.cadastrarProduto(codigoCad, qtdCad);
                        break;

                    case 2:
                        System.out.print("Digite o codigo do produto: ");
                        String codigoAtu = sc.nextLine();
                        System.out.print("Digite o valor para alterar (positivo para entrada, negativo para saida): ");
                        int variacao = Integer.parseInt(sc.nextLine());
                        gerenciador.atualizarEstoque(codigoAtu, variacao);
                        break;

                    case 3:
                        System.out.print("Digite o codigo do produto para consulta: ");
                        String codigoCon = sc.nextLine();
                        gerenciador.consultarProduto(codigoCon);
                        break;

                    case 4:
                        System.out.print("Digite a quantidade limite para o alerta: ");
                        int limite = Integer.parseInt(sc.nextLine());
                        gerenciador.exibirAlertasEstoque(limite);
                        break;

                    case 5:
                        executando = false;
                        System.out.println("Encerrando o sistema...");
                        break;

                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas numeros inteiros para opcoes e quantidades.");
            }
        }

        sc.close();
    }
}