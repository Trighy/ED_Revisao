package Avaliacao2;

import esd.ListaSequencial;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TesteInverteListaSequencial {

    ListaSequencial gera_lista(int n) {
        ListaSequencial<Integer> q = new ListaSequencial<>();

        for (int j=0; j < n; j++) {
            var val = Integer.valueOf(j);
            q.adiciona(val);
        }

        return q;
    }

    ListaSequencial gera_lista_rand(int n) {
        ListaSequencial<Integer> q = new ListaSequencial<>();
        Random rand = new Random();

        for (int j=0; j < n; j++) {
            q.adiciona(rand.nextInt());
        }

        return q;
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testa inverter lista vazia")
    void invertevazia() throws InterruptedException, IOException {
        ListaSequencial<Integer> q = new ListaSequencial<>();

        assertDoesNotThrow(() ->q.inverte());
        assert(q.esta_vazia());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testa inverter lista com apenas um valor")
    void inverteSimples() throws InterruptedException, IOException {
        ListaSequencial<Integer> q = new ListaSequencial<>();

        q.adiciona(123);
        assertDoesNotThrow(() ->q.inverte());
        assert(q.comprimento() == 1);
        assert(q.obtem(0).equals(123));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testa inverter lista com alguns valores")
    void inverte() throws InterruptedException, IOException {
        ListaSequencial<Integer> q = gera_lista(17);

        assertDoesNotThrow(() ->q.inverte());
        assert(q.comprimento() == 17);
        for (int j=0; j < 17; j++){
            assert(q.obtem(j).equals(16 - j));
        }
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testa inverter lista com alguns valores aleatórios")
    void inverteRandom() throws InterruptedException, IOException {
        final int len = 13;
        ListaSequencial<Integer> q = gera_lista_rand(len);
        ArrayList<Integer> v = new ArrayList<>();

        for (int j=0; j < len; j++) {
            v.add(q.obtem(j));
        }
        Collections.reverse(v);

        assertDoesNotThrow(() ->q.inverte());
        assert(q.comprimento() == len);
        for (int j=0; j < len; j++){
            assert(q.obtem(j).equals(v.get(j)));
        }
    }

}