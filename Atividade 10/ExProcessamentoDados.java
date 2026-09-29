/*Enunciado: Crie uma exceção customizada ProcessamentoDadosException (extends Exception). Crie uma classe de serviço com um método processarArquivo(String caminho). Dentro do método, simule uma falha de leitura (lançando uma java.io.IOException se o caminho for nulo ou vazio) ou uma falha lógica de parsing. Capture a exceção original e relance-a encapsulada dentro da sua ProcessamentoDadosException utilizando o construtor com causa (super(mensagem, causa)). No main, exiba tanto a mensagem principal quanto o motivo raiz (getCause().getMessage()).
Conceitos: Encadeamento de exceções (Exception Chaining), preservação do stack trace original e abstração de falhas de baixo nível para camadas superiores de negócio.
 */
import java.io.IOException;

public class ExProcessamentoDados {

    static class ProcessamentoDadosException extends Exception {
        public ProcessamentoDadosException(String mensagem, Throwable causa) {
            super(mensagem, causa);
        }
    }

    static class ServicoArquivo {
        public void processarArquivo(String caminho) throws ProcessamentoDadosException {
            try {
                if (caminho == null || caminho.trim().isEmpty()) {
                    throw new IOException("Caminho do arquivo nao pode ser nulo ou vazio.");
                }
                if (caminho.endsWith(".corrupto")) {
                    throw new IllegalArgumentException("Estrutura do arquivo invalida para conversao.");
                }
                System.out.println("Leitura e processamento do arquivo " + caminho + " concluídos.");
            } catch (IOException | IllegalArgumentException e) {
                throw new ProcessamentoDadosException("Falha na camada de negocio ao processar o arquivo.", e);
            }
        }
    }

    public static void main(String[] args) {
        ServicoArquivo servico = new ServicoArquivo();

        System.out.println("TESTE 1: ERRO DE LEITURA (IOEXCEPTION)");
        try {
            servico.processarArquivo("");
        } catch (ProcessamentoDadosException e) {
            System.out.println("Mensagem da Excecao: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Causa: " + e.getCause().getMessage());
                System.out.println("Classe da Causa: " + e.getCause().getClass().getName());
            }
        }

        System.out.println("\nTESTE 2: ERRO DE PARSING (ILLEGALARGUMENTEXCEPTION)");
        try {
            servico.processarArquivo("dados.corrupto");
        } catch (ProcessamentoDadosException e) {
            System.out.println("Mensagem da Excecao: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Causa: " + e.getCause().getMessage());
                System.out.println("Classe da Causa: " + e.getCause().getClass().getName());
            }
        }

        System.out.println("\nPrograma finalizado com sucesso.");
    }
}