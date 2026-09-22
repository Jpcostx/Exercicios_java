/*Enunciado: Desenvolva uma classe FiguraGeometrica com o método calcularArea(), retornando 0.0. Crie três subclasses:
Quadrado: possui atributo lado (double).
Retangulo: possui atributos largura e altura (double).
Circulo: possui atributo raio (double).
Todas as subclasses devem sobrescrever calcularArea() com as fórmulas matemáticas corretas. Crie uma lista ou array de figuras geométricas e imprima a área individual de cada uma a partir de um único laço de repetição.
Conceitos: Sobrescrita matemática, polimorfismo em estruturas de dados e garantia de contrato comportamental
 */
public class ExFiguraGeometrica {

    static class FiguraGeometrica {
        public double calcularArea() {
            return 0.0;
        }
    }

    static class Quadrado extends FiguraGeometrica {
        private double lado;

        public Quadrado(double lado) {
            this.lado = lado;
        }

        @Override
        public double calcularArea() {
            return this.lado * this.lado;
        }
    }

    static class Retangulo extends FiguraGeometrica {
        private double largura;
        private double altura;

        public Retangulo(double largura, double altura) {
            this.largura = largura;
            this.altura = altura;
        }

        @Override
        public double calcularArea() {
            return this.largura * this.altura;
        }
    }

    static class Circulo extends FiguraGeometrica {
        private double raio;

        public Circulo(double raio) {
            this.raio = raio;
        }

        @Override
        public double calcularArea() {
            return Math.PI * Math.pow(this.raio, 2);
        }
    }

    public static void main(String[] args) {
        FiguraGeometrica[] figuras = new FiguraGeometrica[3];

        figuras[0] = new Quadrado(4.0);
        figuras[1] = new Retangulo(5.0, 3.0);
        figuras[2] = new Circulo(2.5);

        System.out.println("=== CÁLCULO DE ÁREAS INDIVIDUAIS ===\n");

        for (FiguraGeometrica f : figuras) {
            String nomeClasse = f.getClass().getSimpleName();
            double area = f.calcularArea();

            System.out.println("Forma: " + nomeClasse);
            System.out.println("Área calculada: " + String.format("%.2f", area));
            System.out.println("------------------------------------");
        }
    }
}