/*Enunciado: Crie uma superclasse Veiculo com os atributos marca (String) e modelo (String), além de um método exibirDetalhes(). Em seguida, crie duas subclasses:
Carro: adiciona o atributo quantidadePortas (int) e sobrescreve exibirDetalhes().
Moto: adiciona o atributo cilindradas (int) e sobrescreve exibirDetalhes().
Utilize a palavra-chave super nos construtores das subclasses para reaproveitar a inicialização da classe base e no método sobrescrito.
Conceitos: Herança (extends), construtor da superclasse (super()) e sobrescrita de métodos (@Override).
 */
class Veiculo {
    private String marca;
    private String modelo;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void exibirDetalhes() {
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
    }
}

class Carro extends Veiculo {
    private int quantidadePortas;

    public Carro(String marca, String modelo, int quantidadePortas) {
        super(marca, modelo); 
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--- Detalhes do Carro ---");
        super.exibirDetalhes(); 
        System.out.println("Quantidade de Portas: " + this.quantidadePortas);
    }
}

class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, int cilindradas) {
        super(marca, modelo);
        this.cilindradas = cilindradas;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--- Detalhes da Moto ---");
        super.exibirDetalhes(); 
        System.out.println("Cilindradas: " + this.cilindradas + "cc");
    }
}

public class ExVeiculo {
    public static void main(String[] args) {
        
        Carro meuCarro = new Carro("Toyota", "Corolla", 4);
        Moto minhaMoto = new Moto("Honda", "CB 500F", 500);

        meuCarro.exibirDetalhes();
        
        System.out.println(); 
        
        minhaMoto.exibirDetalhes();
    }
}