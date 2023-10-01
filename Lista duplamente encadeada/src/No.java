public class No {
    // Ponteiros para o elemento anterior e próximo
    No anterior;
    Object elemento;
    No proximo;

    // Construtor
    No(Object elemento) {
        this.elemento = elemento;
        anterior = null;
        proximo = null;
    }
}
