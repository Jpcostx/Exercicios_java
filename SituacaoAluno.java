import java.util.Scanner;

public class SituacaoAluno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double nota1 = sc.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = sc.nextDouble();

        double media = (nota1 + nota2) / 2;

        System.out.println("Média: " + media);

        if(media >= 7.0 ) {
            System.out.println("Situação final: Aprovado");
        }
            else if(media >= 5.0 && media < 7) {
                System.out.println("Situação final: Em recuperação ");
            }
            else {
                System.out.println("Situação final: Reprovado");
            }

        sc.close();
    }
    
}
