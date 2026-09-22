/*Enunciado: Crie duas interfaces distintas:

Autenticavel: método boolean autenticar(String senha).
ExportavelJSON: método String exportarJSON().
Crie a classe Usuario (com login e senha) que implemente apenas Autenticavel. Crie a classe Administrador (com login, senha e nivelAcesso) que implemente ambas as interfaces (implements Autenticavel, ExportavelJSON).

Conceitos: Múltipla implementação de interfaces em Java e segregação de responsabilidades (Interface Segregation Principle).
 */
public class ExUsuarioAdmin {

    public interface Autenticavel {
        boolean autenticar(String senha);
    }

    public interface ExportavelJSON {
        String exportarJSON();
    }

    static class Usuario implements Autenticavel {
        private String login;
        private String senha;

        public Usuario(String login, String senha) {
            this.login = login;
            this.senha = senha;
        }

        public String getLogin() {
            return login;
        }

        @Override
        public boolean autenticar(String senhaDigitada) {
            return this.senha.equals(senhaDigitada);
        }
    }

    static class Administrador implements Autenticavel, ExportavelJSON {
        private String login;
        private String senha;
        private String nivelAcesso;

        public Administrador(String login, String senha, String nivelAcesso) {
            this.login = login;
            this.senha = senha;
            this.nivelAcesso = nivelAcesso;
        }

        public String getLogin() {
            return login;
        }

        public String getNivelAcesso() {
            return nivelAcesso;
        }

        @Override
        public boolean autenticar(String senhaDigitada) {
            return this.senha.equals(senhaDigitada);
        }

        @Override
        public String exportarJSON() {
            return "{\n" +
                   "  \"login\": \"" + this.login + "\",\n" +
                   "  \"nivelAcesso\": \"" + this.nivelAcesso + "\"\n" +
                   "}";
        }
    }

    public static void main(String[] args) {
        Usuario usuarioComum = new Usuario("joao.pedro", "senha123");
        Administrador admin = new Administrador("admin.master", "root2026", "TOTAL");

        System.out.println("=== TESTE AUTENTICAÇÃO ===");
        
        boolean authUsuario = usuarioComum.autenticar("senha123");
        System.out.println("Usuário 'joao.pedro' autenticado? " + authUsuario);

        boolean authAdmin = admin.autenticar("senhaErrada");
        System.out.println("Admin 'admin.master' autenticado com senha errada? " + authAdmin);

        System.out.println("\n=== TESTE JSON ===");
        
        System.out.println("JSON do Administrador:");
        System.out.println(admin.exportarJSON());

        System.out.println("\n=== POLIMORFISMO ===");
        
        Autenticavel[] contas = new Autenticavel[]{ usuarioComum, admin };

        for (Autenticavel conta : contas) {
            System.out.println("Testando acesso para conta: " + conta.autenticar("senha123"));
        }
    }
}