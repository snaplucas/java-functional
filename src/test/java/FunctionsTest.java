import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionsTest {

    @Test
    public void testFunciton() {
        Function<String, Integer> tamanhoMaisUm = a -> a.length() + 1;
        System.out.println(tamanhoMaisUm.apply("aaaa"));

        Predicate<String> predicate = a -> a.length() == 1;
        System.out.println(predicate.test("a"));
        System.out.println(predicate.test("aa"));

        List<String> palavras = Arrays.asList("rodrigo", "paulo", "caelum");
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        palavras.sort(comparator);
        System.out.println(palavras);

        Instrumento instrumento1 = new Instrumento(5452, "Guitarra");
        Instrumento instrumento2 = new Instrumento(1234, "Baixo");
        Instrumento instrumento3 = new Instrumento(3145, "Bateria");

        List<Instrumento> lista = new ArrayList<>();
        lista.add(instrumento1);
        lista.add(instrumento2);
        lista.add(instrumento3);

        Comparator<Instrumento> contaComparator = Comparator.comparingInt(Instrumento::getValor);
        lista.sort(contaComparator);

        System.out.println(lista.stream().map(Instrumento::getValor).collect(Collectors.toList()));

        Comparator<Instrumento> comparatorConta = Comparator.comparingInt(c -> c.getTipo().length());
        lista.sort(comparatorConta);

        lista.sort(Comparator.comparingInt(Instrumento::getValor));

        System.out.println(lista.stream().map(Instrumento::getTipo).collect(Collectors.toList()));

        lista.sort(Comparator.comparing(Instrumento::getValor));

        System.out.println(lista.stream().map(Instrumento::getTipo).collect(Collectors.toList()));


//        Comparator<String> comparador = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(),o2.length());
//            }
//        };
    }

    class Instrumento {
        private int valor;
        private String tipo;

        Instrumento(int valor, String tipo) {
            this.valor = valor;
            this.tipo = tipo;
        }

        int getValor() {
            return valor;
        }

        String getTipo() {
            return tipo;
        }
    }

}
