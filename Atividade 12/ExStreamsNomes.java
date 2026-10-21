/*Enunciado: Dada uma lista de nomes com diferentes tamanhos e formatações (ex: Arrays.asList("ana", "carlos", "beatriz", "antonio", "amanda", "bernardo")), utilize a API de Streams para:
Filtrar apenas os nomes que começam com a letra "A" (ignorando maiúsculas/minúsculas).
Converter todos os nomes filtrados para letras maiúsculas.
Ordenar os resultados em ordem alfabética.
Coletar o resultado em uma nova lista (toList()) e imprimi-la.
Conceitos: Operações intermediárias (filter, map, sorted), expressões lambda com predicados e operação terminal (toList / collect).
 */  
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExStreamsNomes {

    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("ana", "carlos", "beatriz", "antonio", "amanda", "bernardo");

        List<String> nomesFiltrados = nomes.stream()
                .filter(nome -> nome.toLowerCase().startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Lista original: " + nomes);
        System.out.println("Lista processada: " + nomesFiltrados);
    }
}