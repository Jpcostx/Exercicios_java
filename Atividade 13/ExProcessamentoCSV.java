/*Enunciado: Desenvolva um programa que processe um arquivo produtos.csv onde cada linha (exceto o cabeçalho) segue o padrão Nome,Quantidade,PrecoUnitario (ex: Monitor,5,1200.00). O programa deve:
Ler todas as linhas utilizando Files.readAllLines().
Pular a primeira linha (cabeçalho).
Realizar o split dos campos, calcular o valor total de cada item (quantidade * preço) e somar o valor global do inventário.
Tratar exceções de formato (NumberFormatException) e I/O (IOException).
Conceitos: Leitura em memória de arquivos tabulares, conversão de dados primitivos e controle de exceções de parsing em arquivos.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ExProcessamentoCSV {

    public static void main(String[] args) {
        Path arquivoCSV = Path.of("produtos.csv");

        try {
            String conteudoCSV = "Nome,Quantidade,PrecoUnitario\n" +
                                 "Monitor,5,1200.00\n" +
                                 "Teclado,10,150.50\n" +
                                 "Mouse,ERRO,80.00\n" +
                                 "Notebook,2,4500.00";
            Files.writeString(arquivoCSV, conteudoCSV, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Falha ao preparar o arquivo de teste.");
            return;
        }

        double valorGlobalInventario = 0.0;

        try {
            List<String> linhas = Files.readAllLines(arquivoCSV);

            System.out.println("=== RELATORIO DE INVENTARIO ===");

            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i);
                String[] campos = linha.split(",");

                if (campos.length == 3) {
                    try {
                        String nome = campos[0].trim();
                        int quantidade = Integer.parseInt(campos[1].trim());
                        double precoUnitario = Double.parseDouble(campos[2].trim());

                        double valorTotalItem = quantidade * precoUnitario;
                        valorGlobalInventario += valorTotalItem;

                        System.out.println("Produto: " + nome + " | Qtd: " + quantidade + " | Total: R$ " + String.format("%.2f", valorTotalItem));

                    } catch (NumberFormatException e) {
                        System.out.println("Falha de conversao na linha " + (i + 1) + ": " + linha);
                    }
                }
            }

            System.out.println("\nValor Global do Inventario: R$ " + String.format("%.2f", valorGlobalInventario));

        } catch (IOException e) {
            System.out.println("Falha de leitura do arquivo: " + e.getMessage());
        }
    }
}