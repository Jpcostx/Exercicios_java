/*Enunciado: Faça um programa que leia a base e a altura de um retângulo. Em seguida, calcule e mostre:
A área (base * altura)
O perímetro (2  * (base + altura))
Conceitos: Atribuição de múltiplas saídas a partir dos mesmos dados de entrada.
Exemplo de Entrada: Base: 5.0, Altura: 3.0 Saída esperada: Área: 15.0, Perímetro: 16.0
*/

import java.util.Scanner;

public class Area_Perimetro {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a base do retângulo: ");
        double base = sc.nextDouble();  

        System.out.print("Digite a altura do retângulo: ");
        double altura = sc.nextDouble();

        double area = base * altura;
        double perimetro = 2 * (base + altura);

        System.out.println("área do retângulo: " + area);
        System.out.print("perímetro do retângulo: " + perimetro);

        sc.close();
    }
    
}
