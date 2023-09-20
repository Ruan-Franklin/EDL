public class FilaArray implements IFila {
    private Object[] fila;
    private int tamanho;
    private int inicio;
    private int fim;

    public FilaArray(int capacidadeInicial) {
        fila = new Object[capacidadeInicial];
        tamanho = 0;
        inicio = 0;
        fim = -1;
    }


    @Override
    public void enfileirar(Object elemento) {
        if (tamanho() == fila.length) {
            // Duplica o tamanho do array quando a capacidade máxima é atingida
            Object[] filaMaior = new Object[fila.length * 2];
            for (int i = 0; i < tamanho(); i++) {
                filaMaior[i] = fila[(inicio + i) % fila.length];
            }
            fila = filaMaior;
            inicio = 0;
            fim = tamanho() - 1;
        }
        fim = (fim + 1) % fila.length;
        fila[fim] = elemento;
        tamanho++;
    }

    @Override
    public Object desenfileirar() {
        if (estaVazia()) {
            throw new FilaVaziaExcecao("Fila vazia");
        }
        Object elementoRemovido = fila[inicio];
        inicio = (inicio + 1) % fila.length;
        tamanho--;
        return elementoRemovido;
    }

    @Override
    public Object primeiro() {
        if (estaVazia()) {
            throw new FilaVaziaExcecao("Fila vazia");
        }
        return fila[inicio];
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "fila vazia";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Fila: [");
        for (int i = 0; i < tamanho(); i++) {
            builder.append(fila[(inicio + i) % fila.length]);
            if (i < tamanho() - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();


    }

}