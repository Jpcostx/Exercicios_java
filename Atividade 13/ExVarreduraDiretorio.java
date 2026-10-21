/*Enunciado: Escreva um programa que faça uma varredura recursiva em uma pasta de projeto (ex: pasta src ou projeto/) utilizando Files.walk(path). O programa deve:
Filtrar apenas arquivos regulares (Files.isRegularFile()).
Selecionar apenas arquivos com extensão .java.
Exibir o caminho relativo, o tamanho em bytes (Files.size()) de cada arquivo e a soma total do tamanho dos arquivos Java encontrados.
Conceitos: Varredura recursiva de árvores de diretórios (Files.walk), inspeção de metadados de arquivos e fechamento do stream de diretório.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExVarreduraDiretorio {

    public static void main(String[] args) {
        Path diretorio = Paths.get(".");

        System.out.println("=== VARREDURA DE ARQUIVOS JAVA ===");
        System.out.println("Diretorio base: " + diretorio.toAbsolutePath().normalize());

        long tamanhoTotal = 0;

        try (Stream<Path> stream = Files.walk(diretorio)) {
            List<Path> arquivosJava = stream
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .collect(Collectors.toList());

            for (Path arquivo : arquivosJava) {
                try {
                    long tamanho = Files.size(arquivo);
                    tamanhoTotal += tamanho;
                    
                    Path caminhoRelativo = diretorio.relativize(arquivo);
                    System.out.println(caminhoRelativo + " | " + tamanho + " bytes");
                    
                } catch (IOException e) {
                    System.out.println("Falha ao ler o arquivo: " + arquivo);
                }
            }

            System.out.println("\nTotal de arquivos encontrados: " + arquivosJava.size());
            System.out.println("Tamanho total somado: " + tamanhoTotal + " bytes");

        } catch (IOException e) {
            System.out.println("Erro de Entrada/Saida durante a varredura: " + e.getMessage());
        }
    }
}