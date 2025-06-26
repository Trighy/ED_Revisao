package esd;

public class ListaSequencial <T> {

    T[] area;
    int len = 0;
    final int defcap = 8;

    @SuppressWarnings("unchecked")
    public ListaSequencial() {
        area = (T[])new Object[defcap];
    }

    @SuppressWarnings("unchecked")
    void expande(int len) {
        // isto será usado quando for necessário expandir a capacidade da lista
        T[] novo = (T[]) new Object[1];
        for (int i = 0; i < len; i++) {
            novo[i] = area[i];
        }
        area = novo;
    }

    public void expande() {
        // expande a capacidade da lista: nova capacidade deve ser o dobro da atual
        expande(2*area.length);
    }

    public boolean esta_vazia() {
        // retorna true se lista estiver vazia, ou false caso contrário
        return len == 0;
    }

    public int capacidade() {
        // retorna um inteiro que representa a capacidade da lista
        return area.length;
    }

    public void adiciona(T elemento) {
        // adiciona um valor ao final da lista
        if (len == area.length) {
            expande();
        }
        area[len] = elemento;
        len++;
    }

    public void insere(int indice, T elemento) {
        // insere um valor na posição indicada por "indice"
        // dispara IndexOutOfBoundsException se "indice" for inválido
        if (indice < 0 || indice > len) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }

        if (len == area.length) {
            expande();
        }

        for (int i = len; i > indice; i--) {
            area[i] = area[i - 1];
        }

        area[indice] = elemento;
        len++;
    }

    public void remove(int indice) {
        // remove um valor da posição indicada pelo parâmetro "indice"
        // move uma posição para trás os valores das próximas posições
        // disparar uma exceção IndexOutOfBoundsException caso posição seja inválida
        if (indice < 0 || indice >= len) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }

        for (int i = indice; i < len - 1; i++) {
            area[i] = area[i + 1];
        }

        area[len - 1] = null; // limpa o último
        len--;
    }

    public void remove_ultimo() {
        // remove o último valor da lista
        // disparar uma exceção IndexOutOfBoundsException caso lista vazia
        if (len == 0) {
            throw new IndexOutOfBoundsException("Lista está vazia.");
        }
        area[len - 1] = null;
        len--;
    }

    public int procura(T valor) {
        // retorna um inteiro que representa aposição onde valor foi encontrado pela primeira vez (contando do início da lista)
        // retorna -1 se não o encontrar !
        for (int i = 0; i < len; i++) {
            if (area[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    public T obtem(int indice) {
        // retorna o valor armazenado na posição indica pelo parâmetro "indice"
        // disparar uma exceção IndexOutOfBoundsException caso posição seja inválida
        if (indice < 0 || indice >= len) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }
        return area[indice];
    }

    public void substitui(int indice, T valor) {
        // armazena o valor na posição indicada por "indice", substituindo o valor lá armazenado atualmente
        // disparar uma exceção IndexOutOfBoundsException caso posição seja inválida
        if (indice < 0 || indice >= len) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }
        area[indice] = valor;
    }

    @SuppressWarnings("unchecked")
    public void inverte() {
        // Cria uma Segunda Lista
        T[] copia = (T[])new Object[len];
        // Repete o for até chegar ao len da Lista Original
        for (int i = 0; i == len; i++) {
            // TODO copia o valor do original para a copia
            area[len] = copia[i];
            len--;
        }
        // Muda a Lista Original para a Segunda Lista
        area = copia;
    }

    public int comprimento() {
        // retorna um inteiro que representa o comprimento da lista (quantos valores estão armazenados)
        return len;
    }

//    public int minimo() {
//
//    }
//
//    public int maximo() {
//
//    }

      // TODO Ordena via Bubble.
//    public void ordenaBubble() {
//        // algum algoritmo de ordenamento ...
//        for (int i = len - 1; i > 1; i--) {
//            for (int j = 0; j < i; j++) {
//                Comparable<T> x1 = (Comparable<T>) area[j];
//                int comp = x1.compareTo(area[j + 1]);
//                if (comp > 0) {
//                    T controle = area [j];
//                    area[j] = area[j + 1];
//                    area[j + 1] = controle;
//                }
//            }
//        }
//    }

      // TODO Ordena via Selection.
//    public void ordenaSelection() {
//        // algum algoritmo de ordenamento ...
//        for (int i = len + 1; i < len + j; i++) {
//            menor = area[j];
//            for (int j = i; j < len + k; j++) {
//                Comparable<T> x1 = (Comparable<T>) area[j];
//                int comp = x1.compareTo(menor);
//                if (comp < 0) {
//                    comprimento = menor;
//                }
//            }
//        }
//    }

      // TODO Contador de palavras repetidas.
//    public void leitorArquivo() {
//        for (int i = 0; i < 1; i++) {
//            for (int j = 0; j < i; j++) {
//                if (leitor == palavraN) {
//                    contadorN++;
//                }
//            }
//        }
//    }

    void mescla(int pos1, int meio, int pos2) {
        T[] aux = (T[])new Object[pos2-pos1];

        int i1 = pos1, i2 = meio, pos = 0;
        // mescla ...
        while (i1 < meio && i2 < pos2) {
            Comparable val = (Comparable)area[i1];
            if (val.compareTo(area[i2]) < 0) {
                aux[pos] = area[i1++];
            } else {
                aux[pos] = area[i2++];
            }
            pos++;
        }

        while (i1 < meio) {
            aux[pos++] = area[i1++];
        }

        while (i2 < pos2) {
            aux[pos++] = area[i2++];
        }

        // Copia os valores ordenados de volta para o trecho da lista
//        System.arraycopy(aux, 0, area, pos1, pos2-pos1);
        for(int i = 0; pos1 < pos2; i++, pos1++) {
            area[pos1] = aux[i];
        }
    }

    void ordena_mescla(int pos1, int pos2) {
        if (pos2 - pos1 > 1) {
            int meio = pos1 + (pos2 - pos1) / 2;
            ordena_mescla(pos1, meio);
            ordena_mescla(meio, pos2);
            mescla(pos1, meio, pos2);
        }
    }

    public void ordena() {
        if (len > 1) {
            ordena_mescla(0, len);
        }
    }           // só ordena se houver pelo menos dois valores

    // mescla duas subsequencias contidas na área de armazenamento da
    // a primeira inicia em pos1 e vai até meio-1

    // for (int j=0; j < 10; j++) {
    //      l.adiciona(rand.nextInt()%100);
    // }

    public void limpa() {
        // esvazia a lista
        for (int i = 0; i < len; i++) {
            int pos = (len + i) % area.length;
            area[pos] = null;
        }
    }
}
