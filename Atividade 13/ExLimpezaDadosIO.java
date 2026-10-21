/*Enunciado: Crie um programa que leia um arquivo de texto bruto clientes_bruto.txt contendo nomes em formatos despadronizados (letras minúsculas, espaços extras antes/depois). O programa deve:
Abrir um stream de leitura com Files.lines().
Limpar os espaços em branco das extremidades (.trim()).
Filtrar linhas em branco (!line.isBlank()).
Converter cada nome para o formato padronizado (primeira letra em maiúscula, restante em minúscula ou tudo em caixa alta).
Gravar a lista tratada em um novo arquivo clientes_padronizado.txt utilizando Files.write() com StandardOpenOption.CREATE.
Conceitos: Pipeline completo de I/O (leitura streaming → transformação intermediária → gravação atômica), manipulação de List<String> e coletores de I/O.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExLimpezaDadosIO {

    public static void main(String[] args) {
        Path arquivoEntrada = Path.of("clientes_bruto.txt");
        Path arquivoSaida = Path.of("clientes_padronizado.txt");

        try {
            String clientesBrutos = "   joao silva   \n" +
                                    "\n" +
                                    "MARIA SOUZA\n" +
                                    "  carlos EDUARDO \n" +
                                    "   \n" +
                                    "ana  \n";
            Files.writeString(arquivoEntrada, clientesBrutos, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Falha ao preparar o arquivo de entrada.");
            return;
        }

        try (Stream<String> linhas = Files.lines(arquivoEntrada)) {
            List<String> clientesPadronizados = linhas
                    .map(String::trim)
                    .filter(linha -> !linha.isBlank())
                    .map(linha -> linha.substring(0, 1).toUpperCase() + linha.substring(1).toLowerCase())
                    .collect(Collectors.toList());

            Files.write(arquivoSaida, clientesPadronizados, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Processamento concluido com sucesso.");
            System.out.println("Total de clientes processados: " + clientesPadronizados.size());
            System.out.println("Arquivo gravado em: " + arquivoSaida.toAbsolutePath());
            
            System.out.println("\n=== CONTEUDO DO ARQUIVO PADRONIZADO ===");
            clientesPadronizados.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Erro durante o processamento de I/O: " + e.getMessage());
        }
    }
}
