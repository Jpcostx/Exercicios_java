/*Enunciado: Crie um fluxo de processamento de funcionários (Funcionario: nome, departamento, salario) combinando explicitamente as interfaces funcionais nativas do pacote java.util.function:
Defina um Predicate<Funcionario> para filtrar funcionários do departamento "TI".
Defina uma Function<Funcionario, Double> para extrair o salário com um reajuste projetado de 10%.
Defina um Consumer<Double> para imprimir o valor projetado formatado no console.
Encadeie essas três interfaces funcionais em um pipeline único de Stream sobre uma lista de funcionários.
Conceitos: Interfaces funcionais padrão (java.util.function.Predicate, Function, Consumer), composição funcional e desacoplamento de pipelines.
 */
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExInterfacesFuncionaisNativas {

    static class Funcionario {
        private String nome;
        private String departamento;
        private double salario;

        public Funcionario(String nome, String departamento, double salario) {
            this.nome = nome;
            this.departamento = departamento;
            this.salario = salario;
        }

        public String getNome() {
            return nome;
        }

        public String getDepartamento() {
            return departamento;
        }

        public double getSalario() {
            return salario;
        }
    }

    public static void main(String[] args) {
        List<Funcionario> funcionarios = Arrays.asList(
            new Funcionario("Ana", "TI", 5000.00),
            new Funcionario("Carlos", "RH", 4000.00),
            new Funcionario("Pedro", "TI", 7000.00),
            new Funcionario("Maria", "Financeiro", 6000.00)
        );

        Predicate<Funcionario> filtroTI = f -> f.getDepartamento().equalsIgnoreCase("TI");

        Function<Funcionario, Double> projetarReajuste = f -> f.getSalario() * 1.10;

        Consumer<Double> exibirSalario = salarioProjetado -> 
            System.out.println("Salario projetado (com 10% de reajuste): R$ " + String.format("%.2f", salarioProjetado));

        System.out.println("=== PROJECAO DE SALARIOS (DEPARTAMENTO DE TI) ===");
        
        funcionarios.stream()
            .filter(filtroTI)
            .map(projetarReajuste)
            .forEach(exibirSalario);
    }
}