/*Enunciado: Crie uma classe base Funcionario com nome (String) e salarioBase (double), contendo o método calcularSalario(), que retorna apenas o salarioBase. Crie duas subclasses:
Gerente: adiciona um bonusFixo (double) e sobrescreve calcularSalario() somando o bônus ao salário base.
Vendedor: adiciona totalVendas (double) e comissaoPercentual (double), sobrescrevendo calcularSalario() para somar a comissão ao salário base.
Na classe Main, armazene diferentes funcionários em um vetor do tipo Funcionario[] e percorra o vetor calculando a folha total de forma polimórfica.
Conceitos: Polimorfismo de inclusão, array de referências do tipo da superclasse e ligação dinâmica (dynamic binding).
 */
public class ExPolimorfismo {

    static class Funcionario {
        private String nome;
        private double salarioBase;

        public Funcionario(String nome, double salarioBase) {
            this.nome = nome;
            this.salarioBase = salarioBase;
        }

        public String getNome() {
            return nome;
        }

        public double getSalarioBase() {
            return salarioBase;
        }

        public double calcularSalario() {
            return this.salarioBase;
        }
    }

    static class Gerente extends Funcionario {
        private double bonusFixo;

        public Gerente(String nome, double salarioBase, double bonusFixo) {
            super(nome, salarioBase);
            this.bonusFixo = bonusFixo;
        }

        @Override
        public double calcularSalario() {
            return super.getSalarioBase() + this.bonusFixo;
        }
    }

    static class Vendedor extends Funcionario {
        private double totalVendas;
        private double comissaoPercentual;

        public Vendedor(String nome, double salarioBase, double totalVendas, double comissaoPercentual) {
            super(nome, salarioBase);
            this.totalVendas = totalVendas;
            this.comissaoPercentual = comissaoPercentual;
        }

        @Override
        public double calcularSalario() {
            double comissao = this.totalVendas * (this.comissaoPercentual / 100.0);
            return super.getSalarioBase() + comissao;
        }
    }

    public static void main(String[] args) {
        Funcionario[] equipe = new Funcionario[3];

        equipe[0] = new Funcionario("Carlos (Operacional)", 2500.00);
        equipe[1] = new Gerente("Ana (Gerente)", 6000.00, 2500.00);
        equipe[2] = new Vendedor("Roberto (Vendedor)", 2000.00, 50000.00, 5.0);

        double folhaTotal = 0.0;

        System.out.println("=== FOLHA DE PAGAMENTO - PROCESSAMENTO POLIMÓRFICO ===\n");

        for (Funcionario f : equipe) {
            double salarioCalculado = f.calcularSalario();
            folhaTotal += salarioCalculado;

            System.out.println("Funcionário: " + f.getNome());
            System.out.println("Salário Final: R$ " + String.format("%.2f", salarioCalculado));
            System.out.println("--------------------------------------------------");
        }

        System.out.println("\nFOLHA TOTAL DA EMPRESA: R$ " + String.format("%.2f", folhaTotal));
    }
}