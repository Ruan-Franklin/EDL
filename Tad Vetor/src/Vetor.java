public class Vetor implements IVetor{
    private Object[] elementos; // Vetor de elementos
    private int tamanho; //  Tamanho atual do vetor

    // Construtor para inicializar o vetor
    public Vetor(int capacidade){
        elementos = new Object[capacidade];
        tamanho = 0;

    }
    @Override
    public Object elementoNaPosicao(int posicao) {
        // Verifica se a posição é válida
        //Se não estiver dentro do intervalo [0, tamanho-1], lança uma exceção
        if(posicao < 0 || posicao >= tamanho){
            throw new PosicaoInvalidaExcecao("Posição fora do intervalo");
        }
        // Retorna o elemento na posição especificada
        return elementos[posicao];
    }

    @Override
    public Object substituirElementoNaPosicao(int posicao, Object elemento) {
        if(posicao < 0 || posicao >= tamanho){
            throw new PosicaoInvalidaExcecao("Posição fora do intervalo");
        }
        Object elementoAntigo = elementos[posicao];
        elementos[posicao] = elemento;
        return elementoAntigo;
    }

    @Override
    public void inserirElementoNaPosicao(int posicao, Object elemento) {
        //Verifica se o vetor está cheio
        if(tamanho == elementos.length){
            //Se estiver cheio, cria um novo vetor com o dobro do tamanho
            int novaCapacidade = elementos.length * 2;
            Object[] novoVetor = new Object[novaCapacidade];

            //Copia os elementos para o novo vetor
            for(int i = 0 ; i< tamanho ; i++){
                novoVetor[i] = elementos[i];
            }
            //Atualiza a referência para o novo vetor
            elementos = novoVetor;
        }
        //Desloca os elementos para a direita para abrir espaço para o novo elemento
        for(int i = tamanho -1 ; i >= posicao ; i--){
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
        if (posicao == 0 || posicao >= tamanho -1 ) {
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

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int i = 0 ; i < tamanho ; i++){
            sb.append(elementos[i]);
            if(i < tamanho -i){
                sb.append(", ");

            }
        }
        sb.append("]");
        return sb.toString();
    }
}


