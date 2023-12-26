import java.util.Iterator;

public class Vetor<T> implements IVetor, Iterable<T> {
    private Object[] elementos; // Vetor de elementos
    private int tamanho; //  Tamanho atual do vetor

    // Construtor para inicializar o vetor
    public Vetor(int capacidade) {
        elementos = new Object[capacidade];
        tamanho = 0;

    }

    @Override
    public T elementoNaPosicao(int posicao) {
        // Verifica se a posição é válida
        //Se não estiver dentro do intervalo [0, tamanho-1], lança uma exceção
        if (posicao < 0 || posicao >= tamanho) {
            throw new PosicaoInvalidaExcecao("Posição fora do intervalo");
        }
        // Retorna o elemento na posição especificada
        return (T) elementos[posicao];
    }

    @Override
    public T substituirElementoNaPosicao(int posicao, Object elemento) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new PosicaoInvalidaExcecao("Posição fora do intervalo");
        }
        Object elementoAntigo = elementos[posicao];
        elementos[posicao] = elemento;
        return (T) elementoAntigo;
    }

    @Override
    public void inserirElementoNaPosicao(int posicao, Object elemento) {
        //Verifica se o vetor está cheio
        if (tamanho == elementos.length) {
            //Se estiver cheio, cria um novo vetor com o dobro do tamanho
            int novaCapacidade = elementos.length * 2;
            Object[] novoVetor = new Object[novaCapacidade];

            //Copia os elementos para o novo vetor
            for (int i = 0; i < tamanho; i++) {
                novoVetor[i] = elementos[i];
            }
            //Atualiza a referência para o novo vetor
            elementos = novoVetor;
        }
        //Desloca os elementos para a direita para abrir espaço para o novo elemento
        for (int i = tamanho - 1; i >= posicao; i--) {
            elementos[i + 1] = elementos[i];
        }
        //Insere o novo elemento na posição especificada
        elementos[posicao] = elemento;
        //Atualiza o tamanho do vetor
        tamanho++;
    }

    @Override
    public Object removerElementoNaPosicao(int posicao) {
        //Verifica se o vetor está vazio
        if (posicao == 0 || posicao >= tamanho - 1) {
            throw new PosicaoInvalidaExcecao("Posição fora do intervalo");
        }

        Object elementoRemovido = elementos[posicao]; //Guarda o elemento removido
        //Desloca os elementos a esquerda para preencher o espaço do elemento removido
        for (int i = posicao; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[tamanho - 1] = null; //Marca a última posição como vazia
        tamanho--; //Atualiza o tamanho do vetor
        return elementoRemovido;
    }

    public Object removerUltimoElemento() {
        // Verifica se o vetor está vazio
        if (tamanho == 0) {
            throw new PosicaoInvalidaExcecao("Vetor vazio, impossível remover");
        }

        // Obtém o último elemento
        Object elementoRemovido = elementos[tamanho - 1];

        // Remove o último elemento
        elementos[tamanho - 1] = null;
        tamanho--; // Atualiza o tamanho do vetor
        return elementoRemovido;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < tamanho; i++) {
            sb.append(elementos[i]);
            if (i < tamanho - 1) { // Correção aqui
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new VetorIterator();
    }

    private class VetorIterator implements Iterator<T> {
        private int posicaoAtual = 0;

        @Override
        public boolean hasNext() {
            return posicaoAtual < tamanho;
        }

        @Override
        public T next() {
            return (T) elementos[posicaoAtual++];
        }

    }
}

