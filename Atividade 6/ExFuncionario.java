/*Enunciado: Desenvolva uma classe Funcionario com os atributos nome (String), cargo (String) e salarioBruto (double). Adicione os métodos:
aplicarAumento(double porcentagem): ajusta o salarioBruto somando o acréscimo percentual informado.
calcularSalarioLiquido(double descontoImposto): retorna o salário líquido após abater um valor fixo informado por parâmetro.
No método principal, instancie um funcionário, aplique um aumento de 10% e exiba os valores antes e após a alteração.
Conceitos: Mutação de atributos por métodos operacionais e cálculo percentual dentro do domínio do objeto. */
class Funcionario {
    String nome;
    String cargo;
    double salarioBruto;

    void aplicarAumento(double porcentagem) {
        double valorDoAumento = salarioBruto * (porcentagem / 100);
        salarioBruto += valorDoAumento; 
    }

    double calcularSalarioLiquido(double descontoImposto) {
        return salarioBruto - descontoImposto;
    }
}

public class ExFuncionario {
    public static void main(String[] args) {
        Funcionario func = new Funcionario();
        
        func.nome = "João Pedro";
        func.cargo = "Estagiário de Desenvolvimento";
        func.salarioBruto = 2000.00;

        System.out.println("--- Dados Iniciais ---");
        System.out.println("Nome: " + func.nome);
        System.out.println("Cargo: " + func.cargo);
        System.out.printf("Salário Bruto Inicial: R$ %.2f\n", func.salarioBruto);

        func.aplicarAumento(10);

        System.out.println("\n--- Após Aumento Salarial ---");
        System.out.printf("Novo Salário Bruto: R$ %.2f\n", func.salarioBruto);

        double desconto = 150.00;
        double salarioLiquido = func.calcularSalarioLiquido(desconto);
        
        System.out.println("\n--- Resumo de Pagamento ---");
        System.out.printf("Desconto Aplicado: R$ %.2f\n", desconto);
        System.out.printf("Salário Líquido a Receber: R$ %.2f\n", salarioLiquido);
    }
}