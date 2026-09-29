/*Enunciado: Crie um programa que solicite ao usuário dois números inteiros e realize a divisão do primeiro pelo segundo. Trate especificamente as seguintes situações:
Divisão por zero (ArithmeticException).
Entrada de dados não numéricos (InputMismatchException).
Utilize o bloco finally para garantir a exibição da mensagem "Operação finalizada." e o fechamento do recurso Scanner.
Conceitos: Blocos try-catch múltiplos, tratamento de exceções nativas da biblioteca padrão e garantia de liberação de recursos com finally.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExTratamentoExcecao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Digite o primeiro número inteiro: ");
            int dividendo = sc.nextInt();

            System.out.print("Digite o segundo número inteiro: ");
            int divisor = sc.nextInt();

            int resultado = dividendo / divisor; 
            
            System.out.println("Resultado da divisão: " + resultado);

        } catch (ArithmeticException e) {
            System.out.println("Erro: Não é possível realizar divisão por zero.");

        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas números inteiros válidos.");

        } finally {
            System.out.println("Operação finalizada.");
            sc.close();
        }
    }
}

