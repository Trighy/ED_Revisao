//package esd;
//
//public class ListaSequencialSimples <T> {
//
//    T[] area;
//    int len = 0;
//    final int defcap = 8;
//
//    @SuppressWarnings("unchecked")
//    public ListaSequencialSimples() {
//        area = (T[])new Object[defcap];
//    }
//
//    // TODO "Expande" Inacabado.
//    @SuppressWarnings("unchecked")
//    void expande(int len) {
//        // isto será usado quando for necessário expandir a capacidade da lista
//
//    }
//
//    public void expande() {
//        // expande a capacidade da lista: nova capacidade deve ser o dobro da atual
//        expande(2*area.length);
//    }
//
//    // TODO "Esta Vazia" Inacabado.
//    public boolean esta_vazia() {
//        if () {
//            throw new IndexOutOfBoundsException("Fila está vazia!");
//        } else {
//            throw new IndexOutOfBoundsException("Fila não está vazia!");
//        }
//    }
//
//    public int capacidade() {
//        return area.length;
//    }
//
//    // TODO "Adiciona" Inacabado.
//    public void adiciona(T elemento) {
//        // adiciona um valor ao final da lista
//
//    }
//
//    // TODO "Remove" Inacabado.
//    public void remove(int indice) {
//        // remove um valor da posição indicada pelo parâmetro "indice"
//        // move para essa posição o valor que está no final da lista
//        // disparar uma exceção IndexOutOfBoundsException caso posição seja inválida
//
//    }
//
//    // TODO "Remove Ultimo" Inacabado.
//    public void remove_ultimo(int indice) {
//        // remove o último valor da lista
//        // disparar uma exceção IndexOutOfBoundsException caso lista vazia.
//
//    }
//
//    // TODO "Procura" Inacabado.
//    public int procura(T valor) {
//        // retorna um inteiro que representa aposição onde valor foi encontrado pela primeira vez (contando do início da lista)
//        // retorna -1 se não o encontrar !
//        if (valor == ) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }
//
//    // TODO "Obtem" Inacabado.
//    public T obtem(int indice) {
//        // retorna o valor armazenado na posição indica pelo parâmetro "indice"
//        // disparar uma exceção IndexOutOfBoundsException caso posição seja inválida
//
//    }
//
//    // TODO "Substitui" Inacabado.
//    public void substitui(int indice, T valor) {
//        // armazena o valor na posição indicada por "indice", substituindo o valor lá armazenado atualmente
//        // disparar uma exceção IndexOutOfBoundsException caso posição seja inválida
//
//    }
//
//    public int comprimento() {
//        // retorna um inteiro que representa o comprimento da lista (quantos valores estão armazenados)
//        return len;
//    }
//
//    public void limpa() {
//        for (int i = 0; i < len; i++) {
//            int pos = (len + i) % area.length;
//            area[pos] = null;
//        }
//    }
//}
