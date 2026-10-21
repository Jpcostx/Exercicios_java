/*Enunciado: Defina uma interface funcional chamada TransformadorTexto com a anotação @FunctionalInterface e um único método abstrato: String transformar(String entrada). Em seguida:
Crie um método utilitário public static List<String> processarLista(List<String> lista, TransformadorTexto regra).
Na classe principal, execute esse método passando diferentes implementações via Expressões Lambda e Method References (ex: inverter a string, colocar entre colchetes [texto] e transformar em caixa alta String::toUpperCase).
Conceitos: Anotação @FunctionalInterface, contratos funcionais customizados, closures/lambdas de alta ordem e Method References (::).
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExTransformadorTexto {

    @FunctionalInterface
    public interface TransformadorTexto {
        String transformar(String entrada);
    }

    public static List<String> processarLista(List<String> lista, TransformadorTexto regra) {
        List<String> resultado = new ArrayList<>();
        for (String texto : lista) {
            resultado.add(regra.transformar(texto));
        }
        return resultado;
    }

    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "interface", "lambda", "codigo");

        System.out.println("Lista original: " + palavras);

        List<String> caixaAlta = processarLista(palavras, String::toUpperCase);
        System.out.println("Caixa alta: " + caixaAlta);

        List<String> entreColchetes = processarLista(palavras, texto -> "[" + texto + "]");
        System.out.println("Entre colchetes: " + entreColchetes);

        List<String> invertido = processarLista(palavras, texto -> new StringBuilder(texto).reverse().toString());
        System.out.println("Invertido: " + invertido);
    }
}