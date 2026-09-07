/*Enunciado: Crie uma classe Aluno contendo os atributos nome (String), matricula (String), nota1 (double) e nota2 (double). Implemente os métodos:
calcularMedia(): retorna a média aritmética simples das duas notas.
verificarAprovacao(): retorna uma String ("Aprovado" se média > 7, caso contrário "Reprovado").
imprimirBoletim(): exibe o nome, a matrícula, a média final e a situação do aluno.
Na classe Main, crie um objeto Aluno, preencha suas notas e acione o método imprimirBoletim().
Conceitos: Chamada de métodos dentro de outros métodos da mesma classe (this.calcularMedia()) e abstração de regras de negócio. */
class Aluno {
    String nome;
    String matricula;
    double nota1;
    double nota2;

    double calcularMedia() {
        return (nota1 + nota2) / 2.0;
    }

    String verificarAprovacao() {
        double media = this.calcularMedia();
        
        if (media >= 6.0) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }

    void imprimirBoletim() {
        System.out.println("--- Boletim Escolar ---");
        System.out.println("Aluno: " + this.nome);
        System.out.println("Matrícula: " + this.matricula);
        
        System.out.printf("Média Final: %.2f\n", this.calcularMedia());
        System.out.println("Situação: " + this.verificarAprovacao());
        System.out.println("-----------------------");
    }
}

public class ExAluno {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        
        aluno.nome = "João Pedro";
        aluno.matricula = "ADS-FAETERJ-02";
        aluno.nota1 = 8.5;
        aluno.nota2 = 9.0;

        aluno.imprimirBoletim();
    }
}