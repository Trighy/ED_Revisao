import esd.Pilha;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Historico {
    public static void main(String[] args) {
        esd.Pilha<String> h = new esd.Pilha<>();
        Scanner programador = new Scanner(System.in);
        Historico hist = new Historico();
        // Aqui está o repetidor, onde possui o limite de 100 comandos.
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 1; j++) {
                // Aqui ele lé o teclado do usuário, nesse caso programador e adiciona o ">" no começo.
                System.out.print("> ");
                String comando = programador.next();

                // Essa fileira de "if's" detecta se oque o programador escreveu é equivalente á um possível comandos.
                if (Objects.equals(comando, "mostra") || Objects.equals(comando, "Mostra")) {
                    h.empilha("mostra");
                    System.out.println("comando executado");
                }
                // Aqui se encontra o primeiro problema professor
                // Fui obrigado a juntar as palavras com espaço "apaga algo" e "lista tudo" por não encontrar como
                // arrumar esse problema.
                if (Objects.equals(comando, "apagaalgo") || Objects.equals(comando, "Apagaalgo") || Objects.equals(comando, "ApagaAlgo")) {
                    h.empilha("apaga algo");
                    System.out.println("comando executado");
                }
                if (Objects.equals(comando, "listatudo") || Objects.equals(comando, "Listatudo") || Objects.equals(comando, "ListaTudo")) {
                    h.empilha("lista tudo");
                    System.out.println("comando executado");
                }
                if (Objects.equals(comando, "data") || Objects.equals(comando, "Data")) {
                    h.empilha("data");
                    System.out.println("comando executado");
                }
                // Diferente dos outros que apenas adiciona oque foi escrito a pilha e retornar "comando executado"
                // o comando "historico" mostra os últimos 5 comandos.
                if (Objects.equals(comando, "historico") || Objects.equals(comando, "Historico")) {
                    // Aqui se encontra o segundo problema professor
                    // Tentei e tentei, mas não achei como fazer o 'topo' voltar um para trás em cada um retornando os
                    // últimos cinco comandos, nesse caso fica mostrando o último comando cinco vezes.
                    System.out.println(h.topo());
                    System.out.println(h.topo());
                    System.out.println(h.topo());
                    System.out.println(h.topo());
                    System.out.println(h.topo());
                    h.empilha("historico");
                }
                // O comando sair, sai. Que nesse caso é encerrar o programa.
                if (Objects.equals(comando, "sair") || Objects.equals(comando, "Sair")) {
                    return;
                }
            }
        }
    }
}