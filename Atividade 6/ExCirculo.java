/*Enunciado: Crie uma classe Circulo que possua o atributo raio (double). Defina dois métodos com retorno:
calcularArea(): retorna pi * raio^2 (use Math.PI e Math.pow()).
calcularPerimetro(): retorna 2 * pi * raio.
Na classe Main, leia o valor do raio digitado pelo usuário, instancie o círculo e exiba a área e o perímetro calculados com duas casas decimais.
Conceitos: Métodos com tipo de retorno (double), uso da classe utilitária Math e passagem de estado interno. */
import java.util.Scanner;

class Circulo {
    double raio;

    double calcularArea() {
        // Usa a constante PI e a função de potência (raio elevado a 2)
        return Math.PI * Math.pow(raio, 2);
    }

    double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}

public class ExCirculo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor do raio do círculo: ");
        double valorDigitado = sc.nextDouble();

        Circulo meuCirculo = new Circulo();
        
        meuCirculo.raio = valorDigitado;

        double areaCalculada = meuCirculo.calcularArea();
        double perimetroCalculado = meuCirculo.calcularPerimetro();

        System.out.println("\n--- Propriedades do Círculo ---");
        
        System.out.printf("Área: %.2f\n", areaCalculada);
        System.out.printf("Perímetro: %.2f\n", perimetroCalculado);

        sc.close();
    }
}