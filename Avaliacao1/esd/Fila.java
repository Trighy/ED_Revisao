package esd;

public class Fila <T> {

    T[] area;
    int inicio = 0;
    int fim = 0;
    int len = 0;
    final int defcap = 8;

    @SuppressWarnings("unchecked")
    public Fila() {
        area = (T[])new Object[defcap];
    }

    public int comprimento() {
        return len;
    }

    public int capacidade() {
        return area.length;
    }

    /* este método NÃO faz parte da fila
    public void insere(T algo) {
        if (len == capacidade()) {
            expande();
        }
    }
    */

    @SuppressWarnings("unchecked")
    void expande() {
        // alova um vetor com o dobro de capacidade do vetor atual
        T[] nova = (T[])new Object[2*area.length];

        // Copia os objetos do vetor atual para o novo vetor
        // Cuidado: o primeiro objeto está na posição "inicio"
        // do vetor atual, mas deve ser colocado na posição 0
        // do novo vetor
        for (int j=0; j < len; j++) {
            int pos_orig = (j+inicio)%area.length;
            nova[j] = area[pos_orig];
        }
        area = nova;
        inicio = 0;
        fim = len;
//               Tentativa bem falha:
//        Object alguma = Object[inicio];
//        inicio = 2;
//        area[inicio] = alguma;
//        Object algum = Object[inicio];
//        fim = fim % area.length;
//        area[fim] = algum;
    }

    public void adiciona(T algo) {
        // expande área de armazenamento
        // se fila cheia
        if (len == area.length) {
            expande();
        }

        area[fim] = algo;
        fim = (fim +1) % area.length;
//        fim++;
//        if (fim ==area.length) {
//            fim = 0;
//        }
        len++;
    }

    public void adiciona_muitos(Fila<T> q2) {
        // Nesse caso obti oque foi feito no "expande" e apenas invertir a posição do 'pos_orig' e 'nova', fazendo
        // o pos_orig pegar oque está no nova e se adicionar...eu acho...
        T[] pos_orig = (T[])new Object[2*area.length];

        for (int j=0; j < len; j++) {
            int fila2 = (j+inicio)%area.length;
            pos_orig[j] = area[fila2];
        }
        area = pos_orig;
        inicio = 0;
        fim = len;
    }

    public T remove() {
        // dispara IndexOutOfBoundsException
        // se fila vazia
        if (len == 0) {
            throw new IndexOutOfBoundsException("Fila está vazia!");
        }
        // retira odado do inicio da fila
        T algo = area[inicio];
        area[inicio] = null;
        // incrementa inicio de forma circular
        inicio = (inicio + 1) % area.length;
//        inicio++;
//        if (inicio == area.length) {
//            inicio = 0;
//        }
        len--;

        return algo;
    }

    public T frente() {
        if (len == 0) {
            throw new IndexOutOfBoundsException("Fila está vazia!");
        }
        return area[inicio];
    }

    public T tras() {
        // dispara IndexOutofBoundsException;
        // se fila vazia
        if (len == 0) {
            throw new IndexOutOfBoundsException("Fila está vazia!");
        }

        int pos = fim - 1;
        if (pos < 0) {
            pos = area.length - 1;
        }
        return area[pos];
    }

    public boolean estaVazia() {
        return len == 0;
    }

    public void limpa() {
        for (int i = 0; i < len; i++) {
            int pos = (inicio + i) % area.length;
            area[pos] = null;
        }
        inicio = 0;
        fim = 0;
        len = 0;
    }
}