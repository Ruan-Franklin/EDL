public class VetorArray implements IVetor {
    private Object[] vetor;
    private int tamanho;

    // Construtor para criar um vetor com uma capacidade inicial
    public VetorArray(int capacidade) {
        vetor = new Object[capacidade];
        tamanho = 0;
    }

    @Override
    public Object elementoNaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new PosicaoInvalidaExcecao("Posição fora dos limites do vetor");
        }
        return vetor[posicao];
    }

    @Override
    public Object substituirNaPosicao(int posicao, Object elemento) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new PosicaoInvalidaExcecao("Posição fora dos limites do vetor");
        }
        Object elementoAnterior = vetor[posicao];
        vetor[posicao] = elemento;
        return elementoAnterior;
    }

    @Override
    public void adicionarNaPosicao(int posicao, Object elemento) {
        if (posicao < 0 || posicao > tamanho) {
            throw new PosicaoInvalidaExcecao("Posição fora dos limites do vetor");
        }
        if (tamanho == vetor.length) {
            redimensionar();
        }
        for (int i = tamanho; i > posicao; i--) {
            vetor[i] = vetor[i - 1];
        }
        vetor[posicao] = elemento;
        tamanho++;

    }

    @Override
    public Object removerNaPosicao(int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new PosicaoInvalidaExcecao("Posição fora dos limites do vetor");
        }
        Object elementoRemovido = vetor[posicao];
        for (int i = posicao; i < tamanho - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        tamanho--;
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

    private void redimensionar() {
        int novaCapacidade = vetor.length * 2;
        Object novoVetor = new Object[novaCapacidade];
        System.arraycopy(vetor, 0, novoVetor, 0, vetor.length);
        vetor = (Object[]) novoVetor;
    }

    @Override
    public String toString(){
        if(tamanho == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < tamanho ; i++){
            sb.append(vetor[i]);
            if(i < tamanho - 1){
                sb.append(", ");
            }

        }
        sb.append("]");
        return sb.toString();


    }

}
