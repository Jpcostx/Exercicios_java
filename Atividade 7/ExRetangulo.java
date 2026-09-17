/*Enunciado: Desenvolva uma classe Retangulo com os atributos privados largura (double) e altura (double).
O construtor deve inicializar ambos os atributos utilizando os próprios métodos setters para garantir que as regras de validação sejam aplicadas desde a instanciação.
Nos setters de largura e altura, garanta que o valor atribuído seja estritamente maior que zero; se for $\le 0$, atribua um valor padrão de 1.0 e emita um aviso no console.
Implemente os métodos calcularArea() e calcularPerimetro().
Conceitos: Reutilização de regras de validação chamando setters dentro do construtor, consistência de objetos válidos.
 */
public class ExRetangulo {
    private double largura;
    private double altura;

    public ExRetangulo(double largura, double altura) {
        this.setLargura(largura);
        this.setAltura(altura);
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        if (largura > 0) {
            this.largura = largura;
        } else {
            System.out.println(" Aviso: Largura inválida (" + largura + "). Atribuindo valor padrão de 1.0");
            this.largura = 1.0;
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            System.out.println(" Aviso: Altura inválida (" + altura + "). Atribuindo valor padrão de 1.0");
            this.altura = 1.0;
        }
    }

    public double calcularArea() {
        return this.largura * this.altura;
    }

    public double calcularPerimetro() {
        return 2 * (this.largura + this.altura);
    }

    public static void main(String[] args) {
        System.out.println("=== Teste 1 com Valores Válidos ===");
        ExRetangulo retangulo1 = new ExRetangulo(5.0, 3.0);
        System.out.println("Largura: " + retangulo1.getLargura());
        System.out.println("Altura: " + retangulo1.getAltura());
        System.out.println("Área: " + retangulo1.calcularArea());
        System.out.println("Perímetro: " + retangulo1.calcularPerimetro());

        System.out.println("\n=== Teste 2 com Valores Inválidos ===");
        ExRetangulo retangulo2 = new ExRetangulo(0.0, -2.5);
        
        System.out.println("Largura corrigida: " + retangulo2.getLargura());
        System.out.println("Altura corrigida: " + retangulo2.getAltura());
        System.out.println("Área (1.0 * 1.0): " + retangulo2.calcularArea());

        System.out.println("\n=== Teste 3 tentando fraudar usando o Setter depois de criado ===");
        retangulo1.setLargura(-10.0);
        System.out.println("Largura final do Retângulo 1: " + retangulo1.getLargura());
    }
}