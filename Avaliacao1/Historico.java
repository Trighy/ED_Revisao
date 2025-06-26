import esd.Pilha;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Historico {
    public static void main(String[] args) {
        esd.Pilha<String> h = new esd.Pilha<>();
        Scanner programador = new Scanner(System.in);
        Historico hist = new Historico();
        for (int i = 0; i < 101; i++) {
            System.out.print("> ");
            String comando = programador.next();
            h.empilha(comando);
            System.out.println("comando executado");
            if (Objects.equalsIgnoreCase(comando, "historico")) {
                System.out.println(h.desempilha());
                System.out.println(h.desempilha());
                System.out.println(h.desempilha());
                System.out.println(h.desempilha());
                System.out.println(h.desempilha());
                h.empilha("historico");
            }
            if (Objects.equalsIgnoreCase(comando, "sair")) {
                return;
            }
        }
    }
}
