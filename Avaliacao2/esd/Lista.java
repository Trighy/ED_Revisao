package esd;

import java.security.InvalidParameterException;
import java.util.Random;

public class Lista <T> {
    class Node {
        T valor = null;
        Node proximo;
        Node antecessor;

        // operações de Node
        Node() {
            // este nodo deve inicialmente ser seu próprio sucessor e antecessor
            proximo = this;
            antecessor = this;
        }

        Node(T valor) {
            // inicializa o nodo, que deve inicialmente ser seu próprio sucessor e antecessor
            proximo = this;
            antecessor = this;
            this.valor = valor;
            // Node = valor;
        }

        void conecta(Node sucessor) {
            // insere este nodo antes de sucessor
            this.proximo = sucessor;
            this.antecessor = sucessor.antecessor;
            sucessor.antecessor.proximo = this;
            sucessor.antecessor = this;
        }

        void desconecta() {
            // desconecta este nodo, desfazendo as referências de seu antecessor e sucessor
            this.antecessor.proximo = this.proximo;
            this.proximo.antecessor = this.antecessor;
        }
    };

    Node guarda;
    int len = 0;

    // operações de Lista
    public Lista() {
        guarda = new Node();
    }

    public void adiciona(T valor) {
        Node nodo = new Node(valor);
        nodo.conecta(guarda);
        len++;
    }

    Node obtem_nodo(int indice) {
        Node nodo;

        if (indice < 0 || indice >= len) {
            throw new InvalidParameterException("índice inválido");
        }

        if (indice < len/2) {
            // procura direta
            nodo = guarda.proximo;
            while (indice-- > 0) {
                nodo = nodo.proximo;
            }
        } else {
            // procura reversa
            nodo = guarda;
            indice = len - indice;
            while (indice-- > 0) {
                nodo = nodo.antecessor;
            }
        }
        return nodo;
    }

    public void insere(int indice, T valor) {
        if (indice < 0 || indice > len) {
            throw new InvalidParameterException("indice invalido");
        }

        Node nodo = new Node(valor);
        Node sucessor = obtem_nodo(indice);
        nodo.conecta(sucessor);
        len++;
    }

    public void remove(int indice) {
        if (indice < 0 || indice > len) {
            throw new InvalidParameterException("indice invalido");
        }
        Node nodo = new Node();
        Node antecessor = obtem_nodo(indice);
        nodo.desconecta();
        len--;
    }

    public int comprimento() {
        // Retornar o comprimento/tamanho da Lista
        return len;
    }

    public T obtem(int indice) {
        if (indice < 0 || indice > len) {
            throw new InvalidParameterException("indice invalido");
        }

        // acessa o nodo que está na posição "indice"
        Node nodo = obtem_nodo(indice);

        // retorna o valor contido nese nodo
        return nodo.valor;
    }

    public void embaralha() {
        Random gerador = new Random();
        for (int i = n - 1; i < 1; i++) {
            int j = gerador.nextInt(0, i-1);
            v = v[j] - v[i];
        }
    }

    public void inverte() {
        // Define-se o Node como Guarda para o começo da váriavel ser possível.
        Node nodo = guarda;
        do {
            // Armazena-ze o valor do proximo nodo em uma váriavel Node sucessor para eventualmente percorrer a Lista.
            Node sucessor = nodo.proximo;
            // Armazena-ze o valor original do antecessor em uma váriavel Node temp para após inverter o valor entre o mesmo e proximo.
            Node temp = nodo.antecessor;
            nodo.antecessor = nodo.proximo;
            nodo.proximo = temp;
            // Define o Nodo anteriormente Guarda definido como Guarda, para o proximo, consequentemente permitindo repetição.
            nodo = sucessor;
        } while (nodo != guarda);
    }
}
