/*Enunciado: Crie um programa que defina um caminho de diretório dados/relatorios e um arquivo chamado sumario.txt. O programa deve verificar se o diretório existe e, caso não exista, criá-lo automaticamente com Files.createDirectories(). Em seguida, grave uma string multilinhas contendo informações sobre a execução do sistema utilizando Files.writeString() com as opções CREATE e TRUNCATE_EXISTING.
Conceitos: Path.of(), instanciação segura de diretórios (Files.createDirectories) e escrita simplificada de texto.
Exemplo de Saída: Arquivo criado em dados/relatorios/sumario.txt com o cabeçalho e timestamp da execução.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExCriacaoArquivo {

    public static void main(String[] args) {
        Path diretorio = Path.of("dados", "relatorios");
        Path arquivo = diretorio.resolve("sumario.txt");

        try {
            Files.createDirectories(diretorio);

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            String conteudo = "=== RELATORIO DE EXECUCAO ===\n" +
                              "Data e Hora: " + timestamp + "\n" +
                              "Status: Processamento concluido com sucesso.\n" +
                              "Diretorio Base: " + diretorio.toAbsolutePath() + "\n";

            Files.writeString(
                arquivo, 
                conteudo, 
                StandardOpenOption.CREATE, 
                StandardOpenOption.TRUNCATE_EXISTING
            );

            System.out.println("Arquivo gravado com sucesso em: " + arquivo.toAbsolutePath());
            
        } catch (IOException e) {
            System.out.println("Erro de Entrada/Saida ao manipular o arquivo: " + e.getMessage());
        }
    }
}