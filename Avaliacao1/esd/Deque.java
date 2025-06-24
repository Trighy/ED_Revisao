package esd;

// implements Iterator
public class Deque <T> {

    T[] dados;
    int inicio = 0;
    int fim = 0;
    int n = 0;

    @SuppressWarnings("unchecked")
    public Deque(int cap ) {dados = (T[])new Object[cap];}
    // coisas do construtor

    public int comprimento() {
        return n;
    }

    public int capacidade() {
        return dados.length;
    }

    public void insere(T algo) {
        if (n == capacidade()) {
            expande();
        }
    }

    public T extrai_final() {
        if (n == dados.length) {
            throw new IndexOutOfBoundsException(dados[fim].toString());
        }
        limpa();
        return null;
    }

    public T extrai_inicio() {
        if (n == 0) {
            throw new IndexOutOfBoundsException(dados[inicio].toString());
        }
        limpa();
        return null;
    }

    public T acessa_final() {
        if (n == dados.length) {
            throw new IndexOutOfBoundsException(dados[fim].toString());
        }
        return dados[fim];
    }

    public T acessa_inicio() {
        if (n == 0) {
            throw new IndexOutOfBoundsException(dados[inicio].toString());
        }
        return dados[inicio];
    }

//         TODO Fazer puxar e mostrar um valor aleatorio.
//    public void acessa() {
//        if (len == ) {
//            throw new IndexOutOfBoundsException(area[].toString());
//        }
//    }

    @SuppressWarnings("unchecked")
    void expande() {
        // alova um vetor com o dobro de capacidade do vetor atual
        T[] nova = (T[]) new Object[2 * dados.length];

        // Copia os objetos do vetor atual para o novo vetor
        // Cuidado: o primeiro objeto está na posição "inicio"
        // do vetor atual, mas deve ser colocado na posição 0
        // do novo vetor
        for (int j = 0; j < n; j++) {
            int pos_orig = (j + inicio) % dados.length;
            nova[j] = dados[pos_orig];
        }
        dados = nova;
        n = dados.length;
        inicio = 0;
        fim = n;
    }

    public void adiciona(T algo) {
        // expande área de armazenamento
        // se fila cheia
        if (n == dados.length) {
            expande();
        }

        dados[fim] = algo;
        fim = (fim +1) % dados.length;
        n++;
    }

    public void insere(T algo, int pos_orig) {
        if (n == dados.length) {
            expande();
        }

        dados[inicio] = algo;
        inicio = (inicio +1) % dados.length;
        n++;
    }

    public T remove() {
        if (n == 0) {
            throw new IndexOutOfBoundsException("Fila está vazia!");
        }
        T algo = dados[inicio];
        dados[inicio] = null;
        inicio = (inicio + 1) % dados.length;
        n--;

        return algo;
    }

    public T frente() {
        if (n == 0) {
            throw new IndexOutOfBoundsException("Fila está vazia!");
        }
        return dados[inicio];
    }

    public T tras() {
        if (n == 0) {
            throw new IndexOutOfBoundsException("Fila está vazia!");
        }

        int pos = fim - 1;
        if (pos < 0) {
            pos = dados.length - 1;
        }
        return dados[pos];
    }

    public boolean estaVazia() {
        return n == 0;
    }

    public void limpa() {
        return;
    }
    // demais métodos


}