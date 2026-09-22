/*Enunciado: Crie uma classe base Notificacao com o atributo destinatario (String) e um método enviar(String mensagem). Crie três subclasses:
EmailNotificacao: sobrescreve enviar exibindo "Enviando E-mail para [destinatario]: [mensagem]".
SmsNotificacao: sobrescreve enviar exibindo "Enviando SMS para o número [destinatario]: [mensagem]".
PushNotificacao: sobrescreve enviar exibindo "Enviando Push Notification para o dispositivo [destinatario]: [mensagem]".
Crie um método estático processarEnvio(Notificacao notificacao, String texto) que receba qualquer notificação e execute o envio sem saber a implementação concreta.
Conceitos: Polimorfismo aplicado a parâmetros de métodos, desacoplamento e extensão comportamental.
 */
public class ExNotificacao {
    static class Notificacao {
        private String destinatario;

        public Notificacao(String destinatario) {
            this.destinatario = destinatario;
        }

        public String getDestinatario() {
            return destinatario;
        }

        public void enviar(String mensagem) {
            System.out.println("Enviando notificação genérica para " + destinatario + ": " + mensagem);
        }
    }

    static class EmailNotificacao extends Notificacao {
        public EmailNotificacao(String destinatario) {
            super(destinatario);
        }

        @Override
        public void enviar(String mensagem) {
            System.out.println("Enviando E-mail para " + getDestinatario() + ": " + mensagem);
        }
    }

    static class SmsNotificacao extends Notificacao {
        public SmsNotificacao(String destinatario) {
            super(destinatario);
        }

        @Override
        public void enviar(String mensagem) {
            System.out.println("Enviando SMS para o número " + getDestinatario() + ": " + mensagem);
        }
    }

    static class PushNotificacao extends Notificacao {
        public PushNotificacao(String destinatario) {
            super(destinatario);
        }

        @Override
        public void enviar(String mensagem) {
            System.out.println("Enviando Push Notification para o dispositivo " + getDestinatario() + ": " + mensagem);
        }
    }

    public static void processarEnvio(Notificacao notificacao, String texto) {
        notificacao.enviar(texto);
    }

    public static void main(String[] args) {
        Notificacao email = new EmailNotificacao("joao@email.com");
        Notificacao sms = new SmsNotificacao("(21) 99999-8888");
        Notificacao push = new PushNotificacao("iPhone-de-Joao");

        System.out.println("=== CENTRAL DE NOTIFICAÇÕES ===\n");

        processarEnvio(email, "Sua fatura do cartão está disponível.");
        processarEnvio(sms, "Seu código de verificação é 48291.");
        processarEnvio(push, "Novo comentário na sua foto!");
    }
}