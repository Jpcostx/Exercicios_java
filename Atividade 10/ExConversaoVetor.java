/*Enunciado: Desenvolva um programa que contenha um vetor estático de Strings com 4 posições (ex: {"10", "25", "abc", "50"}). Solicite ao usuário um índice para acessar e converter o valor correspondente para um número inteiro (Integer.parseInt). Trate as exceções caso o usuário informe um índice inexistente ou se a string da posição escolhida não for um número válido.
Conceitos: Captura de exceções de índice fora do limite (ArrayIndexOutOfBoundsException) e falha de conversão numérica (NumberFormatException).
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExConversaoVetor {

    public static void main(String[] args) {
        String[] valores = {"10", "25", "abc", "50"};
        Scanner sc = new Scanner(System.in);

        System.out.println("Conteúdo do vetor: [ \"10\", \"25\", \"abc\", \"50\" ]");
        System.out.print("Digite o índice que deseja acessar (0 a 3): ");

        try {
            int indice = sc.nextInt();

            String elemento = valores[indice];
            System.out.println("Texto recuperado na posição [" + indice + "]: \"" + elemento + "\"");

            int numero = Integer.parseInt(elemento);

            System.out.println("Conversão bem-sucedida! Número inteiro resultante: " + numero);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: O índice informado não existe no vetor. Digite uma posição de 0 a " + (valores.length - 1) + ".");

        } catch (NumberFormatException e) {
            System.out.println("Erro: O valor encontrado não é um número inteiro válido.");

        } catch (InputMismatchException e) {
            System.out.println("Erro: O índice precisa ser um número inteiro.");

        } finally {
            System.out.println("Operação finalizada.");
            sc.close();
        }
    }
}