import java.util.Scanner;

public class ClassTriangulos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o lado A do triângulo: ");
        int ladoA = sc.nextInt();

        System.out.print("Digite o lado B do triângulo: ");
        int ladoB = sc.nextInt();

        System.out.print("Digite o lado C do triângulo: ");
        int ladoC = sc.nextInt();

        if(ladoA + ladoB > ladoC && ladoB + ladoC > ladoA && ladoC + ladoA > ladoB) {
            System.out.println("Triângulo válido");

        if(ladoA == ladoB && ladoA == ladoC) {
            System.out.println("Classificação: Triângulo Equilátero");
        }

        else if(ladoA != ladoB && ladoA != ladoC && ladoB != ladoC ) {
            System.out.print("Classificação: Triângulo Escaleno");
        }

        else {
            System.out.print("Classificação: Triângulo Isósceles");
        }

        }
        else {
            System.out.println("Erro: Medidas inválidas, triângulo inexistente.");
        }

        sc.close();
    }
}
