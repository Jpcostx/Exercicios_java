/* Enunciado: Crie uma classe abstrata Forma que contenha:


Um atributo protegido cor (String) e seu respectivo construtor/getter.
O método abstrato double calcularArea().
O método concreto void exibirCor() que imprime "Cor da forma: " + cor.
Em seguida, crie as subclasses concretas Retangulo (com largura e altura) e Circulo (com raio), ambas implementando obrigatoriamente o método calcularArea().

Conceitos: Classes e métodos abstratos (abstract), construtores em classes abstratas e combinação de métodos concretos e abstratos
*/
public class ExForma {
    abstract static class Forma {
        protected String cor;

        public Forma(String cor) {
            this.cor = cor;
        }

        public String getCor() {
            return cor;
        }

        public abstract double calcularArea();

        public void exibirCor() {
            System.out.println("Cor da forma: " + this.cor);
        }
    }

    static class Retangulo extends Forma {
        private double largura;
        private double altura;

        public Retangulo(String cor, double largura, double altura) {
            super(cor); 
            this.largura = largura;
            this.altura = altura;
        }

        @Override
        public double calcularArea() {
            return this.largura * this.altura;
        }
    }

    static class Circulo extends Forma {
        private double raio;

        public Circulo(String cor, double raio) {
            super(cor); 
            this.raio = raio;
        }

        @Override
        public double calcularArea() {
            return Math.PI * Math.pow(this.raio, 2);
        }
    }

    // --- ÁREA DE TESTES ---
    public static void main(String[] args) {
        // Tentar fazer: Forma f = new Forma("Verde"); // ERRO: Forma é abstrata e não pode virar objeto diretamente!

        // Uso polimórfico guardando as subclasses concretas no tipo abstrato da superclasse
        Forma[] formas = new Forma[2];
        formas[0] = new Retangulo("Azul", 5.0, 3.0);
        formas[1] = new Circulo("Vermelho", 4.0);

        System.out.println("=== FORMAS GEOMÉTRICAS ===\n");

        for (Forma f : formas) {
            String tipoForma = f.getClass().getSimpleName();
            
            System.out.println("Tipo: " + tipoForma);
            f.exibirCor(); // Executa o método concreto herdado da classe abstrata
            System.out.println("Área calculada: " + String.format("%.2f", f.calcularArea())); // Executa a implementação específica
            System.out.println("----------------------------------------");
        }
    }
}