public class VetorListaDuplamenteLigada implements IVetor{
    //Atributos
    private No cabeca;
    private No cauda;
    private int tamanho;
    //Construtor
    public VetorListaDuplamenteLigada(){
        cabeca = null;
        cauda = null;
        tamanho = 0;
    }
    @Override
    public Object elementoNaPosicao(int posicao) {
        if(posicao < 0 || posicao >= tamanho){
            throw new PosicaoInvalidaExcecao("Posição inválida!");
        }
        No atual = cabeca;
        for(int i = 0 ; i < posicao ; i++){
            atual = atual.proximo;
        }
        return atual.elemento;
    }

    @Override
    public Object substituirNaPosicao(int posicao, Object elemento) {
        if(posicao < 0 || posicao >= tamanho){
            throw new PosicaoInvalidaExcecao("Posição inválida!");
        }
        No atual = cabeca;
        for(int i = 0 ; i < posicao ; i++){
            atual = atual.proximo;
        }
        Object elementoAnterior = atual.elemento;
        atual.elemento = elemento;
        return elementoAnterior;
    }

    @Override
    public void adicionarNaPosicao(int posicao, Object elemento) {
        if (posicao < 0 || posicao > tamanho) {
            throw new PosicaoInvalidaExcecao("Posição inválida!");
        }
            No novoNo = new No(elemento);
        if(estaVazio()){
            cabeca= novoNo;
            cauda = novoNo;
        }
        else if(posicao == 0){
            novoNo.proximo = cabeca;
            cabeca.anterior = novoNo;
            cabeca = novoNo;
        }
        else if(posicao == tamanho){
            novoNo.anterior = cauda;
            cauda.proximo = novoNo;
            cauda = novoNo;
        }
        else{
            No atual = cabeca;
            for(int i = 0; i < posicao ; i++){
                atual = atual.proximo;
            }
            novoNo.anterior = atual.anterior;
            novoNo.proximo = atual;
            atual.anterior.proximo = novoNo;
            atual.anterior = novoNo;
        }
        tamanho++;
    }

    @Override
    public Object removerNaPosicao(int posicao) {
        if(posicao < 0 || posicao >= tamanho){
            throw new PosicaoInvalidaExcecao("Posição inválida!");
        }
        No noRemovido;
        if(tamanho == 1) {
            noRemovido = cabeca;
            cabeca = null;
            cauda = null;
        }
        else if(posicao == 0) {
            noRemovido = cabeca;
            cabeca = cabeca.proximo;
            cabeca.anterior = null;
        }
        else if(posicao == tamanho - 1) {
            noRemovido = cauda;
            cauda = cauda.anterior;
            cauda.proximo = null;
        }
        else{
            No atual = cabeca;
            for(int i = 0 ; i < posicao ; i++){
                atual = atual.proximo;
            }
            noRemovido = atual;
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
        }
        tamanho--;
        return noRemovido.elemento;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }

    public void verificarIntervaloDePosicoes(int posicao){
        if(posicao < 0 || posicao >= tamanho){
            throw new PosicaoInvalidaExcecao("Posição inválida!");
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        No atual = cabeca;
        while(atual != null){
            sb.append(atual.elemento).append(" ");
            atual = atual.proximo;
        }
        sb.append("]");
        return sb.toString();
    }
}
