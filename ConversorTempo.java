import java.util.Scanner;

public class ConversorTempo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o tempo em segundos: ");
        int tempo = sc.nextInt();

        int horas = tempo / 3600;

        int minutos = (tempo % 3600) / 60;

        int segundos = tempo % 60;

        System.out.printf("Tempo decomposto:  %d horas, %d minutos e %d segundos", horas , minutos, segundos); 

       sc.close();

    }
    
}
