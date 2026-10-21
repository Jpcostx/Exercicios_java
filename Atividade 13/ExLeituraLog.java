/*Enunciado: Crie um programa que leia um arquivo de log estruturado chamado servidor.log contendo entradas no formato [NÍVEL] Mensagem (ex: [INFO] Servidor iniciado, [ERROR] Falha de conexao, [ERROR] Timeout no banco). Utilizando Files.lines(path) em um bloco try-with-resources, processe o stream de linhas para:
Filtrar apenas as linhas de erro ([ERROR]).
Extrair apenas a mensagem limpa (removendo o prefixo [ERROR] ).
Contar e exibir o total de erros encontrados e listar cada mensagem.
Conceitos: Stream<String> com I/O (Files.lines), liberação automática do descritor de arquivo via try-with-resources e encadeamento com a Streams API.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExLeituraLog {

    public static void main(String[] args) {
        Path arquivoLog = Path.of("servidor.log");

        try {
            String logs = "[INFO] Servidor iniciado\n" +
                          "[WARNING] Memoria alta\n" +
                          "[ERROR] Falha de conexao\n" +
                          "[INFO] Processamento concluido\n" +
                          "[ERROR] Timeout no banco\n";
            Files.writeString(arquivoLog, logs, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Falha ao preparar o arquivo de teste.");
            return;
        }

        try (Stream<String> linhas = Files.lines(arquivoLog)) {
            List<String> erros = linhas
                    .filter(linha -> linha.startsWith("[ERROR]"))
                    .map(linha -> linha.replace("[ERROR] ", ""))
                    .collect(Collectors.toList());

            System.out.println("Total de erros encontrados: " + erros.size());
            erros.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Falha ao ler o arquivo: " + e.getMessage());
        }
    }
}
