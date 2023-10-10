public class TadListaArrayListaDuplamenteLigada implements ILista{
    private No cabeca;
    private No cauda;
    private int tamanho;
    //Construtor da classe
    public TadListaArrayListaDuplamenteLigada(){
        cabeca = null;
        cauda = null;
        tamanho = 0;
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
    public boolean estaNaCabeca(Object elemento) {
        if(cauda != null && cabeca.elemento.equals(elemento)){
            return true;
        }
        return false;
    }

    @Override
    public boolean estaNaCauda(Object elemento) {
        if (cauda != null && cauda.elemento.equals(elemento)) {
            return true;
        }
        return false;
    }
    @Override
    public Object antes(Object elemento) {
        No atual = cabeca;
        while(atual != null){
            if(atual.elemento.equals(elemento)){
                if(atual.anterior != null){
                    return atual.anterior.elemento;
                }
                else { //Não tem elemento antes
                    throw new ElementoNaoEncontradoExcecao("Não tem elemento antes");
                }
            }
            atual = atual.proximo; //Atualiza o atual
        }
        throw new ElementoNaoEncontradoExcecao("Elemento não encontrado");
    }

    @Override
    public Object depois(Object elemento) {
        No atual = cabeca;
        while(atual != null){
            if (atual.elemento.equals(elemento)) {
                if (atual.proximo != null){
                    //Retorna o elemento depois
                    return atual.proximo.elemento;
                } //Não tem elemento depois
                else {
                    throw new ElementoNaoEncontradoExcecao("Não tem elemento depois");
                }
            }
            atual = atual.proximo; //Atualiza o atual
        }
        throw new ElementoNaoEncontradoExcecao("Elemento não encontrado");
    }

    @Override
    public void insereCabeca(Object elemento) {
        No novoNo = new No(elemento);
        if(cabeca == null){
            cabeca = novoNo;
            cauda = novoNo;
        }
        else{
            novoNo.proximo = cabeca;
            cabeca.anterior = novoNo;
            cabeca = novoNo;
        }
        tamanho++;
    }
    @Override
    public void insereCauda(Object elemento) {
        No novoNo = new No(elemento);
        if(cauda == null){
            cabeca = novoNo;
            cauda = novoNo;
        }
        else{
            novoNo.anterior = cauda;
            cauda.proximo = novoNo;
            cauda = novoNo;
        }
        tamanho++;
    }
    @Override
    public Object substitui(Object elemento, Object novoElemento) {
        No atual = cabeca;
        while(atual != null){
            if (atual.elemento.equals(elemento)) {
                Object elementoAntigo = atual.elemento;
                atual.elemento = novoElemento;
                return elementoAntigo;
            }
            atual=atual.proximo;
        }
        throw new ElementoNaoEncontradoExcecao("Elemento não encontrado");
    }
    @Override
    public Object insereAntes(Object elemento, Object novoElemento) {
        No atual = cabeca;
        while(atual != null){
            if (atual.elemento.equals(elemento)) {
                //Cria o novo nó
                No novoNo = new No(novoElemento);
                //Atualiza os ponteiros.
                novoNo.anterior = atual.anterior;
                novoNo.proximo = atual;
                if(atual.anterior != null) {
                    atual.anterior.proximo = novoNo;
                }
                else{
                    cabeca = novoNo;
                }
                atual.anterior = novoNo;
                tamanho++;
                return novoElemento;
            }
            atual = atual.proximo;
        }
        throw new ElementoNaoEncontradoExcecao("Elemento não encontrado");
    }

    @Override
    public Object insereDepois(Object elemento, Object novoElemento) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.elemento.equals(elemento)) {
                No novoNo = new No(novoElemento);
                novoNo.anterior = atual;
                novoNo.proximo = atual.proximo;
                if (atual.proximo != null) {
                    atual.proximo.anterior = novoNo;
                } else {
                    cauda = novoNo;
                }
                atual.proximo = novoNo;
                tamanho++;
                return novoElemento;
            }
            atual = atual.proximo;
        }
        throw new ElementoNaoEncontradoExcecao("Elemento não encontrado");
    }

    @Override
    public void troca(Object elemento1, Object elemento2) {
        No primeiroNo = null;
        No segundoNo = null;
        No atual = cabeca; //Percorre a lista
        while(atual != null){
            if (atual.elemento.equals(elemento1)) {
                primeiroNo = atual;
            }
            else if (atual.elemento.equals(elemento2)) {
                segundoNo = atual;
            }
            if(primeiroNo != null && segundoNo != null){
                break;
            }
            atual = atual.proximo;
        }
        if(primeiroNo != null && segundoNo != null){
            //Troca os elementos
            Object elementoTemp = primeiroNo.elemento;
            primeiroNo.elemento = segundoNo.elemento;
            segundoNo.elemento = elementoTemp;
        }
    }

    @Override
    public Object remove(Object elemento) {
        No atual = cabeca;
        //Percorre a lista
        while(atual != null){
            if (atual.elemento.equals(elemento)) {
                //Atualiza os ponteiros
                if(atual.anterior != null){
                    atual.anterior.proximo = atual.proximo;
                }
                else{
                    cabeca = atual.proximo;
                }
                if(atual.proximo != null){
                    atual.proximo.anterior = atual.anterior;
                }
                else{
                    cauda = atual.anterior;
                }
                tamanho--;
                return atual.elemento;
            }
            atual = atual.proximo;
        }
        throw new ElementoNaoEncontradoExcecao("Elemento não encontrado");
    }

    @Override
    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        No atual = cabeca;
        while(atual != null){
            sb.append(atual.elemento);
            if(atual.proximo != null){
                sb.append(",");
            }
            atual = atual.proximo;
        }
        return sb.toString();
    }
}
