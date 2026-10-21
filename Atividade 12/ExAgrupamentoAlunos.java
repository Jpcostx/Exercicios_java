/*Enunciado: Crie uma classe Aluno com nome (String), curso (String) e notaFinal (double). Dada uma lista com diversos alunos de diferentes cursos:
Agrupe os alunos pelo nome do curso, gerando um Map<String, List<Aluno>> via Collectors.groupingBy.
Particione todos os alunos em dois grupos: os aprovados (nota > 7.0) e os reprovados (nota <= 7.0), gerando um Map<Boolean, List<Aluno>> via Collectors.partitioningBy.
Conceitos: Collectors.groupingBy, Collectors.partitioningBy, predicados booleanos e transformações em mapas estruturados.
 */
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExAgrupamentoAlunos {

    static class Aluno {
        private String nome;
        private String curso;
        private double notaFinal;

        public Aluno(String nome, String curso, double notaFinal) {
            this.nome = nome;
            this.curso = curso;
            this.notaFinal = notaFinal;
        }

        public String getNome() {
            return nome;
        }

        public String getCurso() {
            return curso;
        }

        public double getNotaFinal() {
            return notaFinal;
        }

        @Override
        public String toString() {
            return nome + " (Nota: " + notaFinal + ")";
        }
    }

    public static void main(String[] args) {
        List<Aluno> alunos = Arrays.asList(
            new Aluno("Joao", "Sistema de Informacao", 8.5),
            new Aluno("Maria", "Engenharia Civil", 9.0),
            new Aluno("Pedro", "Sistema de Informacao", 6.0),
            new Aluno("Ana", "Arquitetura", 7.5),
            new Aluno("Carlos", "Engenharia Civil", 5.5),
            new Aluno("Beatriz", "Arquitetura", 8.0)
        );

        Map<String, List<Aluno>> alunosPorCurso = alunos.stream()
            .collect(Collectors.groupingBy(Aluno::getCurso));

        System.out.println("=== ALUNOS AGRUPADOS POR CURSO ===");
        for (Map.Entry<String, List<Aluno>> entry : alunosPorCurso.entrySet()) {
            System.out.println("Curso: " + entry.getKey());
            for (Aluno a : entry.getValue()) {
                System.out.println("  - " + a.toString());
            }
        }

        Map<Boolean, List<Aluno>> alunosParticionados = alunos.stream()
            .collect(Collectors.partitioningBy(aluno -> aluno.getNotaFinal() > 7.0));

        System.out.println("\n=== ALUNOS PARTICIONADOS POR APROVACAO ===");
        
        System.out.println("Aprovados (Nota > 7.0):");
        for (Aluno a : alunosParticionados.get(true)) {
            System.out.println("  - " + a.toString());
        }

        System.out.println("\nReprovados (Nota <= 7.0):");
        for (Aluno a : alunosParticionados.get(false)) {
            System.out.println("  - " + a.toString());
        }
    }
}