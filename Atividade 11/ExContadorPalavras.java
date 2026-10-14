/*Enunciado: Escreva um programa que receba um texto (frase longa) do usuário, divida o texto em palavras separadas por espaços (utilizando .toLowerCase() e .split("\\s+")) e utilize um HashMap<String, Integer> para contar a quantidade de ocorrências de cada palavra. Ao final, percorra o mapa exibindo cada palavra e sua respectiva frequência.
Conceitos: Interface Map, pares chave-valor (put, getOrDefault), iteração sobre entrySet().
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExContadorPalavras {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CONTADOR DE FREQUENCIA DE PALAVRAS ===");
        System.out.println("Digite uma frase ou texto longo:");
        String texto = sc.nextLine();

        Map<String, Integer> frequenciaPalavras = new HashMap<>();

        if (texto != null && !texto.trim().isEmpty()) {
            String[] palavras = texto.toLowerCase().trim().split("\\s+");

            for (String palavra : palavras) {
                palavra = palavra.replaceAll("[^a-zA-Záàâãéèêíïóôõöúçñ0-9]", "");
                
                if (!palavra.isEmpty()) {
                    frequenciaPalavras.put(palavra, frequenciaPalavras.getOrDefault(palavra, 0) + 1);
                }
            }
        }

        System.out.println("\n=== FREQUENCIA DE PALAVRAS ===");
        for (Map.Entry<String, Integer> entry : frequenciaPalavras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        sc.close();
    }
}
