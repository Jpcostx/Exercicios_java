/*Enunciado: Desenvolva um programa que leia uma sequência de códigos de matrícula de alunos (inteiros) de duas turmas diferentes (Turma A e Turma B). Armazene cada turma em um HashSet<Integer> para eliminar registros duplicados de cada chamada. Em seguida, realize e exiba:
Todos os alunos matriculados nas duas turmas sem repetição (União: addAll()).
Apenas os alunos matriculados simultaneamente em ambas as turmas (Interseção: retainAll()).
Conceitos: Interface Set, unicidade de elementos, tabela hash e operações matemáticas de conjuntos.
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExOperacoesConjuntos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> turmaA = new HashSet<>();
        Set<Integer> turmaB = new HashSet<>();

        System.out.println("=== CADASTRO TURMA A ===");
        System.out.print("Quantos alunos deseja cadastrar na Turma A? ");
        int qtdA = sc.nextInt();
        for (int i = 0; i < qtdA; i++) {
            System.out.print("Digite o codigo da matricula do aluno " + (i + 1) + ": ");
            turmaA.add(sc.nextInt());
        }

        System.out.println("\n=== CADASTRO TURMA B ===");
        System.out.print("Quantos alunos deseja cadastrar na Turma B? ");
        int qtdB = sc.nextInt();
        for (int i = 0; i < qtdB; i++) {
            System.out.print("Digite o codigo da matricula do aluno " + (i + 1) + ": ");
            turmaB.add(sc.nextInt());
        }

        Set<Integer> uniao = new HashSet<>(turmaA);
        uniao.addAll(turmaB);

        Set<Integer> intersecao = new HashSet<>(turmaA);
        intersecao.retainAll(turmaB);

        System.out.println("\n=== RESULTADOS DA ANALISE DE CONJUNTOS ===");
        System.out.println("Turma A: " + turmaA);
        System.out.println("Turma B: " + turmaB);
        System.out.println("Uniao (Todos os alunos sem repeticao): " + uniao);
        System.out.println("Intersecao (Alumnos matriculados em ambas): " + intersecao);

        sc.close();
    }
}