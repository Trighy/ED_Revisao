package Avaliacao2;

import com.sun.jdi.ArrayReference;
import esd.Lista;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TesteEmbaralhaListaEncadeada {

    Lista gera_lista(int n) {
        Lista<Integer> q = new Lista<>();

        for (int j=0; j < n; j++) {
            var val = Integer.valueOf(j);
            q.adiciona(val);
        }

        return q;
    }

    void conta_frequencias(int len, int repeticoes) {
        int[] v = new int[len];
        Lista<Integer> q = gera_lista(len);

        for (int pos=0; pos < len; pos++) {
            for (int k=0; k < repeticoes; k++) {
                assertDoesNotThrow(() -> q.embaralha());
                if (q.obtem(pos) == pos) {
                    v[pos]++;
                }
            }
        }

        double p = repeticoes;
        p /= len;
        for (var x: v) {
            assert(Math.abs(x-p) <= p/10);
        }
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testa embaralhar lista vazia")
    void embaralhaVazia() throws InterruptedException, IOException {
        Lista<Integer> q = new Lista<>();

        assertDoesNotThrow(() ->q.embaralha());
        assert(q.esta_vazia());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testa embaralhar lista com apenas um valor")
    void embaralhaSimples() throws InterruptedException, IOException {
        Lista<Integer> q = new Lista<>();

        q.adiciona(123);
        assertDoesNotThrow(() ->q.embaralha());
        assert(q.comprimento() == 1);
        assert(q.obtem(0).equals(123));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testa embaralhar lista com alguns valores")
    void embaralhaNormal() throws InterruptedException, IOException {
        conta_frequencias(17, 10000);
    }
}
