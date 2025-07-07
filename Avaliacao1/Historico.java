import esd.Pilha;

import java.util.Objects;
import java.util.Scanner;

public class Historico {
    public static void main(String[] args) {
        // Cria-se uma Pilha que usaremos para armazenar os comandos.
        Pilha<String> h = new Pilha<>();
        // Ira ser utiliza-do para detectar oque foi escrito pelo usuário/programador.
        Scanner programador = new Scanner(System.in);
        // Repete o programa infinitamente.
        for (int i = 0; i > -1; i++) {
            // Adicionar o "> " no começo do programa
            System.out.print("> ");
            // Detecta oque o usuário/programador de fato escreveu.
            String comando = programador.next();
            // Empilha oque foi escrito pelo usuário/programador.
            h.empilha(comando);
            // Confirma o comando do usuário ter sido executado.
            System.out.println("comando executado");
            // Se o comando que o usuário/programador escreveu for equivante á "historico" mostra-ra os últimos comandos escritos.
            if (Objects.equals(comando, "historico")) {
                System.out.println(h.desempilha());
                System.out.println(h.desempilha());
                System.out.println(h.desempilha());
                System.out.println(h.desempilha());
                System.out.println(h.desempilha());
                // Empilha o próprio comando "historico".
                h.empilha("historico");
                h.empilha(comando);
                h.empilha(comando);
                h.empilha(comando);
                h.empilha(comando);
            }
            // Se o comando que o usuário/programador escreveu for equivante á "sair" o programa é parado.
            if (Objects.equals(comando, "sair")) {
                return;
            }
        }
    }
}
