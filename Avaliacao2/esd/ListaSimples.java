package esd;

public class ListaSimples<T> {
    class Node {
        T valor;
        Node proximo;

        // operações de Node
        Node (T valor) {
            this.valor = valor;
            proximo = null;
        }
    }

    Node primeiro = null;
    Node ultimo = null;
    int len = 0;

    public ListaSimples() {
    }

    // adiciona no fim
    public void adiciona(T valor) {
        Node nodo = new Node(valor);

        if (primeiro != null) { // (len > 0) se não está vazia
            ultimo.proximo = nodo;
        } else { // lista vazia
            primeiro = nodo;
        }

        ultimo = nodo;
        len++;
    }

    // obtém o valor que está na posição dada por "indice"
    // se "indice" >= comprimento da lista, dispara exceção
    // IndexOUtofBoundException
    Node obtem_nodo(int indice) {
        if (indice >= len) {
            throw new IndexOutOfBoundsException("indice inválido");
        }

        Node atual = primeiro;

        while (indice-- > 0) {
            atual = atual.proximo;
        }
        return atual;
//        // salta "indice nodos para chegar até
//        // a posição desejada
//        // while (indice-- > 0) {
//        //      nodo = nodo.proximo;
//        //}
//
//        for (int i = 0; i < indice; i++) {
//            nodo = nodo.proximo;
//        }
//        return nodo.valor;
    }

    // insere valor na posição dada por "indice"
    // se "indice" >= comprimento da lista, dispara exceção
    // IndexOUtofBoundException
    public void insere(int indice, T valor) {
        if (indice >= len) {
            throw new IndexOutOfBoundsException("indice inválido");
        }

        if (indice == len) {
            // mais simples se for para inserir após último nodo
            adiciona(valor);
        } else {
            Node novo = new Node(valor);
            len++;

            if (indice == 0) {
                novo.proximo = primeiro;
                primeiro = novo;
            } else {
                // encontra o nodo antecessor da posição
                // onde quer inserir novo nodo
                Node anterior = obtem_nodo(indice -1);

                //insere o novo nodo
                novo.proximo = anterior.proximo;
                anterior.proximo = novo;
            }
        }
    }

    public boolean esta_vazia() {
        return len == 0;
    }

    public int comprimento() {
        return len;
    }

    public void remove(int indice, T valor) {
        if (indice >= len) {
            throw new IndexOutOfBoundsException("indice inválido");
        }

        len--;
        if (indice == 0) { // se vai remover o primeiro ...
            primeiro = primeiro.proximo;
        } else {
            // encontra o nodo antecessor da posição
            // onde quer inserir o novo nodo
            Node anterior = obtem_nodo(indice - 1);

            // remove o nodo
            anterior.proximo = anterior.proximo.proximo;
            // Node novo_a_remover = anterior.proximo;
            // anterior.proximo = nodo_a_remover.proximo;

            // verifica se removeu último nodo !
            if (anterior.proximo == null) {
                ultimo = anterior;
            }

        }
    }

    public void substitui(int indice, T valor) {

    }

    public void inverte() {

    }
}