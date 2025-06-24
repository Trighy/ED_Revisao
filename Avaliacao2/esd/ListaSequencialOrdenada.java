package esd;

public class ListaSequencialOrdenada <T extends Comparable> {

    final int MinSubseqLen = 31;

    Comparable[] area;
    int len = 0;
    final int defcap = 8;

    @SuppressWarnings("unchecked")
    public ListaSequencialOrdenada() {
        area = new Comparable[defcap];
    }

    // TODO "Expande" Inacabado.
    @SuppressWarnings("unchecked")
    public void expande(int len) {
        if (newCapacity < area.length) return;

        Comparable<T>[] newArea = new Comparable[newCapacity];
        System.arraycopy(area, 0, newArea, 0, len);
        area = newArea;
    }

    void expande() {
        expande(2*area.length);
    }

    public boolean esta_vazia() {
        return len == 0;
    }

    public int capacidade() {
        return area.length;
    }

    public void remove(T valor) {
        // remove o valor, porém preservando o ordenamento da lista
        for (int i = 0; i < comprimento(); i++) {
            if (valor.compareTo(area[i]) == 0) {
                for (int j = 0; j < len; j++) {
                    area[i] = area[i + j];
                }
            }
            area[len -1] = null;
            len--;
            return;
        }
    }

    @SuppressWarnings("unchecked")
    public T obtem(int indice) {
        if (indice < 0 || indice >= len) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
        return (T) area[indice];
    }

    public int comprimento() {
        return len;
    }

    public void limpa() {
        for (int i = 0; i < len; i++) {
            int pos = (len + i) % area.length;
            area[pos] = null;
        }
    }

    public void insere(T elemento) {
        // insere o valor na lista, preservando seu ordenamento
        if (len == area.length) {
            expande();
        }
        for (int i = 0; i < comprimento(); i++) {
            if (elemento.compareTo(area[i]) > 0) {
                for (int j = 0; j <= len; j++) {
                    area[len - 1] = area[len - 1 - j];
                }
            }
            area[i] = elemento;
            len++;
            return;
        }
    }

    public int procura(T valor) {
        // procura o valor dentro da lista usando busca binária
        // retorna a posição onde se encontra, ou -1 caso não exista
        int inicio = 0;
        int fim = len;
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio)/2;
            if (area[meio].compareTo(valor) == 0) {
                return meio;
            } else if (area[meio].compareTo(valor) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
}