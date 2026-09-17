/*Enunciado: Crie uma classe Carro com os atributos privados: modelo (String), ano (int) e velocidadeAtual (int, iniciando em 0). Implemente:
Construtor que receba modelo e ano.
Métodos getters para todos os atributos, mas setters apenas para modelo.
Métodos operacionais acelerar(int incremento) e frear(int decremento). A velocidade nunca pode ficar abaixo de 0 km/h.
Um método booleano de consulta/leitura isEmMovimento() que retorne true se velocidadeAtual > 0 e false caso contrário.
Conceitos: Métodos getters do tipo booleano (is...), encapsulamento de comportamento de transição de estado e bloqueio de acesso de escrita externo a variáveis dinâmicas.
 */
import java.util.Scanner;

public class ExCarro {
    private String modelo;
    private int ano;
    private int velocidadeAtual; 

    public ExCarro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
        this.velocidadeAtual = 0; 
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void acelerar(int incremento) {
        if (incremento > 0) {
            this.velocidadeAtual += incremento;
            System.out.println("Acelerando... Velocidade: " + this.velocidadeAtual + " km/h");
        }
    }

    public void frear(int decremento) {
        if (decremento > 0) {
            this.velocidadeAtual -= decremento;
            
            if (this.velocidadeAtual < 0) {
                this.velocidadeAtual = 0;
            }
            System.out.println("Freando... Velocidade: " + this.velocidadeAtual + " km/h");
        }
    }

    public boolean isEmMovimento() {
        return this.velocidadeAtual > 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== MONTAGEM DO VEÍCULO ===");
        System.out.print("Digite o modelo do carro: ");
        String modeloDigitado = sc.nextLine();

        System.out.print("Digite o ano do carro: ");
        int anoDigitado = sc.nextInt();

        ExCarro meuCarro = new ExCarro(modeloDigitado, anoDigitado);

        System.out.println("\n=== Painel do Veículo ===");
        System.out.println("Modelo: " + meuCarro.getModelo());
        System.out.println("Ano: " + meuCarro.getAno());
        System.out.println("Status Inicial: Em movimento? " + meuCarro.isEmMovimento());

        System.out.println("\n=== Teste de Pista ===");
        meuCarro.acelerar(60);
        System.out.println("Status Atual: Em movimento? " + meuCarro.isEmMovimento());

        meuCarro.frear(100);
        System.out.println("Status Final: Em movimento? " + meuCarro.isEmMovimento());

        sc.close();
    }
}