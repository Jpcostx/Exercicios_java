import java.util.Scanner;

public class MaiorNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
         int numero1 = sc.nextInt();

        System.out.print("Digite o segundo número: ");
        int numero2 = sc.nextInt();

        System.out.print("Digite o terceiro número: ");
        int numero3 = sc.nextInt();

        if(numero1 > numero2 && numero1 > numero3) {
            System.out.print("O maior número é: " + numero1);
        }

            else if(numero2 > numero1 && numero2 > numero3) {
                System.out.print("O maior número é: " + numero2);
            } 

            else {
            System.out.print("O maior número é: " + numero3);
            }

        sc.close();
    }
    
}
