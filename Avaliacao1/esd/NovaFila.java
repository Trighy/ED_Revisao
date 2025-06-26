public class NovaFila <T> {
  Pilha<T> p1 = new Pilha<>();
  Pilha<T> p2 = new Pìlha<>();

  public NovaFila() {
      p1 = (T[])new Object[defcap];
      p2 = (T[])new Object[defcap];
  }

  public int comprimento() {
      return len;
  }

  public int capacidade() {
      return mem.length;
  }

  public T remove() {
       T algo = area[inicio];
        area[inicio] = null;
       inicio = (inicio + 1) % area.length;
       len--;
       return algo;
  }

  public T frente() {
        if (len == 0) {
            throw new IndexOutOfBoundsException("Fila está vazia!");
        }
        return area[inicio];
  }

  public void adiciona(T val) {
      area[fim] = algo;
        fim = (fim +1) % area.length;
      len++;
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
