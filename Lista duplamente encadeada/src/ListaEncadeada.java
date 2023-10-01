public class ListaEncadeada implements IListaDuplamenteEncadeada {
    No cabeca = null;
    No cauda = null;

    @Override
    public void percorrerParaFrente() {
        No atual = cabeca;
        while (atual != null) {
            // Faça algo com o elemento atual, por exemplo, imprimir
            System.out.println(atual.elemento);
            atual = atual.proximo;
        }
    }

    @Override
    public void percorrerParaTras() {
        No atual = cauda;
        while (atual != null) {
            // Faça algo com o elemento atual, por exemplo, imprimir
            System.out.println(atual.elemento);
            atual = atual.anterior;
        }
    }

    @Override
    public Object inserirNoInicio(Object elemento) {
        No novoNo = new No(elemento);
        if (cabeca == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            novoNo.proximo = cabeca;
            cabeca.anterior = novoNo;
            cabeca = novoNo;
        }
        return novoNo;
    }

    @Override
    public Object inserirNaPosicao(Object elemento, int posicao) {
        No novoNo = new No(elemento);
        if (posicao == 1) {
            return inserirNoInicio(elemento);
        } else {
            No atual = cabeca;
            int posicaoAtual = 1;
            while (atual != null && posicaoAtual < posicao) {
                atual = atual.proximo;
                posicaoAtual++;
            }
            if (atual == null) {
                return inserirNoFim(elemento);
            } else {
                novoNo.proximo = atual;
                novoNo.anterior = atual.anterior;
                atual.anterior.proximo = novoNo;
                atual.anterior = novoNo;
                return novoNo;
            }
        }
    }

    @Override
    public Object inserirNoFim(Object elemento) {
        No novoNo = new No(elemento);
        if (cauda == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            cauda.proximo = novoNo;
            novoNo.anterior = cauda;
            cauda = novoNo;
        }
        return novoNo;
    }

    @Override
    public Object removerDoInicio() {
        if (cabeca == null) {
            throw new ListaVaziaExcecao("Lista vazia");
        }
        if (cabeca == cauda) {
            cabeca = null;
            cauda = null;
        } else {
            No noRemovido = cabeca;
            cabeca = cabeca.proximo;
            cabeca.anterior = null;
            noRemovido.proximo = null;
        }
        return cabeca;
    }

    @Override
    public Object removerDaPosicao(int posicao) {
        if (cabeca == null) {
            return null;
        }
        if (posicao == 1) {
            return removerDoInicio();
        } else {
            No atual = cabeca;
            int contador = 1;
            while (atual != null && contador < posicao) {
                atual = atual.proximo;
                contador++;
            }
            if (atual == null) {
                System.out.println("Posição inválida");
                return null;
            } else if (atual == cauda) {
                return removerDoFim();
            } else {
                atual.anterior.proximo = atual.proximo;
                atual.proximo.anterior = atual.anterior;
                atual.anterior = null;
                atual.proximo = null;
                return atual;
            }
        }
    }

    @Override
    public Object removerDoFim() {
        if (cauda == null) {
            throw new ListaVaziaExcecao("Lista vazia");
        }
        if (cabeca == cauda) {
            cabeca = null;
            cauda = null;
        } else {
            No noRemovido = cauda;
            cauda = cauda.anterior;
            cauda.proximo = null;
            noRemovido.anterior = null;
        }
        return cauda;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        No atual = cabeca;
        sb.append("{");
        while(atual != null){
            sb.append(atual.elemento);
            if(atual.proximo != null){
                sb.append(", ");
            }
            atual = atual.proximo;
        }
        sb.append("}");
        return sb.toString();
    }
}
