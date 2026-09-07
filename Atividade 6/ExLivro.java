/*Enunciado: Crie uma classe chamada Livro com os atributos titulo (String), autor (String) e numeroPaginas (int). Implemente um método exibirInformacoes() que imprima no console todos os dados formatados. Na classe principal (Main), instancie dois objetos do tipo Livro, atribua valores a seus atributos e chame o método de exibição para ambos.
Conceitos: Definição de classe, atributos, instanciação de objetos com new, atribuição via operador ponto (.) e invocação de métodos. */
class Livro {
    String titulo;
    String autor;
    int numeroPaginas;

    void exibirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Páginas: " + numeroPaginas);
        System.out.println("-----------------------------");
    }
}

public class ExLivro {
    public static void main(String[] args) {
        
        Livro livro1 = new Livro();
        
        livro1.titulo = "Dom Casmurro";
        livro1.autor = "Machado de Assis";
        livro1.numeroPaginas = 256;

        Livro livro2 = new Livro();
        livro2.titulo = "O Senhor dos Anéis";
        livro2.autor = "J.R.R. Tolkien";
        livro2.numeroPaginas = 1200;

        System.out.println("--- Catálogo da Biblioteca ---\n");
        
        livro1.exibirInformacoes();
        livro2.exibirInformacoes();
    }
}