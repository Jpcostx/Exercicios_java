/*
Enunciado: Projete um sistema para um parque eletrônico:


Crie a interface Tributavel com o método double calcularTributo().
Crie a classe abstrata Item com atributos codigo (int) e precoBase (double).
Crie a classe Eletronico, que herda de Item (extends Item) e implementa a interface Tributavel (implements Tributavel). A taxa de tributo é de 15% sobre o precoBase.
Crie a classe Alimento, que herda de Item, mas não é tributável (não implementa a interface).
Na classe principal, crie uma função calcularTotalImpostos(List<Tributavel> itensTributaveis) e processe uma lista de itens sujeitos a tributação.

Conceitos: Combinação simultânea de herança simples (extends) com implementação de contratos (implements) e filtragem por tipo de interface.

 */
import java.util.ArrayList;
import java.util.List;

interface Tributavel {
    double calcularTributo();
}

abstract class Item {
    protected int codigo;
    protected double precoBase;

    public Item(int codigo, double precoBase) {
        this.codigo = codigo;
        this.precoBase = precoBase;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecoBase() {
        return precoBase;
    }
}

class Eletronico extends Item implements Tributavel {
    private static final double TAXA_TRIBUTO = 0.15; // 15%

    public Eletronico(int codigo, double precoBase) {
        super(codigo, precoBase);
    }

    @Override
    public double calcularTributo() {
        return precoBase * TAXA_TRIBUTO;
    }

    @Override
    public String toString() {
        return "Eletronico{codigo=" + codigo + ", precoBase=" + precoBase +
               ", tributo=" + calcularTributo() + "}";
    }
}

class Alimento extends Item {
    public Alimento(int codigo, double precoBase) {
        super(codigo, precoBase);
    }

    @Override
    public String toString() {
        return "Alimento{codigo=" + codigo + ", precoBase=" + precoBase + "}";
    }
}

public class ExParqueEletronico {

    public static double calcularTotalImpostos(List<Tributavel> itensTributaveis) {
        double total = 0.0;
        for (Tributavel item : itensTributaveis) {
            total += item.calcularTributo();
        }
        return total;
    }

    public static void main(String[] args) {
        List<Item> itens = new ArrayList<>();
        itens.add(new Eletronico(1, 1500.0));  
        itens.add(new Eletronico(2, 300.0));   
        itens.add(new Alimento(3, 25.0));      
        itens.add(new Alimento(4, 12.0));     

        List<Tributavel> itensTributaveis = new ArrayList<>();
        for (Item item : itens) {
            if (item instanceof Tributavel) {
                itensTributaveis.add((Tributavel) item);
            }
        }

        double totalImpostos = calcularTotalImpostos(itensTributaveis);

        System.out.println("Itens do parque:");
        for (Item item : itens) {
            System.out.println(" - " + item);
        }

        System.out.printf("%nTotal de impostos arrecadados: R$ %.2f%n", totalImpostos);
    }
}