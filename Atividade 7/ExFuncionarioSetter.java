/* Enunciado: Desenvolva uma classe Funcionario com os atributos privados nome (String), matricula (String) e salario (double).
O construtor deve receber todos os 3 atributos.
O setSalario(double novoSalario) só deve permitir alterações se o novoSalario for estritamente maior que o salario atual (uma regra da empresa que impede redução salarial arbitrária por atribuição direta). Se for menor ou igual, exiba uma mensagem de erro e não altere o valor.
Implemente um método exibirDados() que imprima todos os dados formatados.
Conceitos: Aplicação prática de encapsulamento para garantir invariantes de regras de negócio complexas nos métodos modificadores.
*/
import java.util.Scanner;

public class ExFuncionarioSetter {
    private String nome;
    private String matricula;
    private double salario;

    public ExFuncionarioSetter(String nome, String matricula, double salario) {
        this.nome = nome;
        this.matricula = matricula;
        this.salario = salario; 
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalario() {
        return salario;
    }

    // Setters básicos
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setSalario(double novoSalario) {
        if (novoSalario > this.salario) {
            this.salario = novoSalario;
            System.out.println(" Sucesso: Salário atualizado para R$ " + this.salario);
        } else {
            System.out.println(" Erro de conformidade: O novo salário (R$ " + novoSalario + 
                               ") não pode ser menor ou igual ao salário atual (R$ " + this.salario + ").");
        }
    }

    public void exibirDados() {
        System.out.println("--- Dados do Funcionário ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Salário Atual: R$ " + this.salario);
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CADASTRO DE FUNCIONÁRIO ===");
        System.out.print("Digite o nome: ");
        String nomeDigitado = sc.nextLine();

        System.out.print("Digite a matrícula: ");
        String matriculaDigitada = sc.nextLine();

        System.out.print("Digite o salário inicial: R$ ");
        double salarioDigitado = sc.nextDouble();

        ExFuncionarioSetter funcionario = new ExFuncionarioSetter(nomeDigitado, matriculaDigitada, salarioDigitado);

        System.out.println("\n=== Sistema RH ===");
        funcionario.exibirDados();

        System.out.println("\n[Ação] RH tenta alterar o salário para R$ 1000.00...");
        funcionario.setSalario(1000.00); 

        System.out.println("\n[Ação] RH tenta definir o salário igual ao atual...");
        funcionario.setSalario(funcionario.getSalario()); 

        System.out.println("\n[Ação] RH aplica uma promoção, definindo salário para R$ 5500.00...");
        funcionario.setSalario(5500.00);

        System.out.println("\n=== Resumo Final ===");
        funcionario.exibirDados();

        sc.close();
    }
}
