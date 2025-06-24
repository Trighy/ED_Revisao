package esd;

import java.security.InvalidParameterException;

public class ListaEncadadeada {
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
    };
}