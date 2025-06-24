package esd;

public class Pilha <T> {

    T[] mem; // a área de armazenamento
    int len = 0; // a quantidade de dados armazenados
    final int defcap = 8; // capacidade inicial

    @SuppressWarnings("unchecked")
    public Pilha() {
        mem = (T[])new Object[defcap];
    }

    public int comprimento() {
        return len;
    }

    public int capacidade() {
        return mem.length;
    }

    void expande() {
        T[] nova = (T[]) new Object[2 * mem.length];
        for (int i = 0; i < len; i++) {
            nova[i] = mem[i];
        }
        mem = nova;
    }

    public void empilha(T algo) {
        if (len == mem.length) {
            expande();
        }
        mem[len] = algo;
        len++;
    }

    public T desempilha() {
        if (len == 0) {
            throw new IndexOutOfBoundsException("Fila está vazia!");
        }
        T elemento = mem[len - 1];
        mem[len - 1] = null;
        len--;
        return elemento;
    }

    public T topo() {
        if (len == 0) {
            throw new IndexOutOfBoundsException("Fila está vazia!");
        }
        return mem[len - 1];
    }

    public boolean estaVazia() {
        return len == 0;
    }

    public void limpa() {
        for (int i = 0; i < len; i++) {
            mem[i] = null;
        }
        len = 0;
    }
}