public class SequenciaDuplamenteEncadeada implements ISequencia{
    private No cabeca;
    private No cauda;
    private int tamanho;

    public SequenciaDuplamenteEncadeada(){
        cabeca = new No(null);
        cauda = new No(null);
        cabeca.proximo = cauda;
        cauda.anterior = cabeca;
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
    public Object elementoNaPosicao(int posicao) {
        if(!posicaoValida(posicao)){
            throw new PosicaoInvalidaExcecao("Posição inválida: " + posicao);
        }
        No novoNo = percorrerLista(posicao);
        return novoNo.elemento;
    }

    @Override
    public void inserirNaPosicao(int posicao, Object elemento) {
        // Verifica se a posição é válida no intervalo [0, tamanho]
        if (!posicaoValida(posicao)){
            throw new PosicaoInvalidaExcecao("Posição inválida: " + posicao);
        }
        // Cria um novo nó com o elemento a ser inserido
        No novoNo = new No(elemento);

        // Se a posição for 0, insere na cabeça
        if(posicao == 0){
            inserirPrimeiro(elemento);
        }
        else if(posicao == tamanho){
            // Se a posição for o tamanho da lista, insere na cauda
            inserirUltimo(elemento);
        }
        else{
            // Se a posicao for no meio da lista, insere na posição
            No anterior = percorrerLista(posicao - 1);
            No proximo = anterior.proximo;
            novoNo.proximo = proximo;
            novoNo.anterior = anterior;
            anterior.proximo = novoNo;
            proximo.anterior = novoNo;
            tamanho++;
        }

    }

    @Override
    public void removerDaPosicao(int posicao) {
        if(!posicaoValida(posicao)){
            throw new PosicaoInvalidaExcecao("Posição inválida: " + posicao);
        }
        //Obtém o nó a ser removido na posição especificada
        No noRemovido = percorrerLista(posicao);
        //Atualiza os nós vizinhos para remover o nó
        No anterior = noRemovido.anterior;
        No proximo = noRemovido.proximo;
        anterior.proximo = proximo;
        proximo.anterior = anterior;
        tamanho--;
    }

    @Override
    public Object primeiro() {
        if(estaVazia()){
            throw new ListaVaziaExcecao("Lista vazia");
        }
        return cabeca.proximo.elemento;
    }

    @Override
    public Object ultimo() {

        if(estaVazia()){
            throw new ListaVaziaExcecao("Lista vazia");
        }
        return cauda.anterior.elemento;
    }

    @Override
    public Object antesDe(Object elemento) {
        No atual = cabeca.proximo;
        Boolean elementoEncontrado = false;
        while(atual != cauda){
            if(atual.proximo != null && atual.proximo.elemento.equals(elemento)){
                // O elemento foi encontrado, então retorna o elemento anterior
                elementoEncontrado = true;
                return atual.elemento;
            }
            // Avança para o próximo nó
            atual = atual.proximo;
        }
        if(!elementoEncontrado){
            throw new PosicaoInvalidaExcecao("Elemento não encontrado: " + elemento);
        }
        return null;
    }


    @Override
    public Object depoisDe(Object elemento) {
        No atual = cabeca.proximo;
        Boolean elementoEncontrado = false;
        while (atual != cauda) {
            if (atual.anterior != null && atual.anterior.elemento.equals(elemento)) {
                // O elemento foi encontrado, então retorna o elemento posterior
                if (atual.proximo != null) {
                    return atual.proximo.elemento;
                } else {
                    throw new PosicaoInvalidaExcecao("Não há elemento posterior a: " + elemento);
                }
            }
            // Avança para o próximo nó
            atual = atual.proximo;
        }
        // Se o elemento não for encontrado, lançar a exceção
        throw new PosicaoInvalidaExcecao("Elemento não encontrado: " + elemento);
    }



    @Override
    public void substituirElemento(Object antigoElemento, Object novoElemento) {
        No atual = cabeca.proximo;
        boolean elementoEncontrado = false;
        while(atual != cauda){
            if (atual.elemento.equals(antigoElemento)) {
                // O elemento foi encontrado, então substitui
                atual.elemento = novoElemento;
                elementoEncontrado = true;
                break;
            }
            // Avança para o próximo nó
            atual = atual.proximo;
        }
        if(!elementoEncontrado){
            throw new PosicaoInvalidaExcecao("Elemento não encontrado: " + antigoElemento);
        }
    }

    @Override
    public void trocarElementos(Object primeiraPosicao, Object segundaPosicao) {
        int posicaoPrimeiro = posicaoDe(primeiraPosicao);
        int posicaoSegundo = posicaoDe(segundaPosicao);
        if(posicaoPrimeiro == -1 || posicaoSegundo == -1){
            throw new PosicaoInvalidaExcecao("Elemento não encontrado: " + primeiraPosicao + " ou " + segundaPosicao);
        }
        //Obtém os nós a serem trocados
        No primeiroNo = percorrerLista(posicaoPrimeiro);
        No segundoNo = percorrerLista(posicaoSegundo);

        //Troca os elementos dos nós
        Object temp = primeiroNo.elemento;
        primeiroNo.elemento = segundoNo.elemento;
        segundoNo.elemento = temp;
    }

    @Override
    public void inserirAntesDe(Object elementoFrente, Object elementoTras) {
        No atual = cabeca.proximo;
        while(atual != cauda){
            if(atual.elemento.equals(elementoFrente)){
                // Elemento encontrado
                No novoNo = new No(elementoTras);
                No anterior = atual.anterior;
                novoNo.anterior = anterior;
                novoNo.proximo = atual;
                anterior.proximo = novoNo;
                atual.anterior = novoNo;
                tamanho++;
            }
            // Avança para o proximo nó
            atual = atual.proximo;
        }
        throw new PosicaoInvalidaExcecao("Elemento não encontrado: " + elementoFrente);

    }

    @Override
    public void inserirDepoisDe(Object elementoTras, Object elementoFrente) {
        No atual = cabeca.proximo;
        while(atual != cauda){
            if (atual.elemento.equals(elementoFrente)) {
                //Elemento encontrado
                No novoNo = new No(elementoTras);
                No proximo = atual.proximo;
                novoNo.anterior = atual;
                novoNo.proximo = proximo;
                atual.proximo = novoNo;
                proximo.anterior = novoNo;
                tamanho++;
            }
            //Avança para o próximo nó
            atual = atual.proximo;
        }
        throw new PosicaoInvalidaExcecao("Elemento não encontrado: " + elementoFrente);

    }

    @Override
    public void inserirPrimeiro(Object elemento) {
        // Cria um novo nó com o elemento a ser inserido
        No novoNo = new No(elemento);
        // Se a lista estiver vazia, a cabeça e a cauda apontam para o novo nó
        if(estaVazia()) {
            cabeca.proximo = novoNo;
            novoNo.anterior = cabeca;
            cauda.anterior = novoNo;
            novoNo.proximo = cauda;
        }
        else{
            // Se a lista não estiver vazia, insere o novo nó na cabeça
            No primeiroNo = cabeca.proximo;
            novoNo.proximo = primeiroNo;
            primeiroNo.anterior = novoNo;
            cabeca.proximo = novoNo;
            novoNo.anterior = cabeca;
        }
        tamanho++;

    }

    @Override
    public void inserirUltimo(Object elemento) {
        No novoNo = new No(elemento);
        if(estaVazia()){
            // Se a lista estiver vazia, insere o novo nó na cabeça, que também é a cauda
            cabeca.proximo = novoNo;
            novoNo.anterior = cabeca;
            cauda.anterior = novoNo;
            novoNo.proximo = cauda;
        }
        else{
            //Se a lista não estiver vazia, insere o novo nó na cauda
            No ultimoNo = cauda.anterior;
            novoNo.proximo = cauda;
            novoNo.anterior = ultimoNo;
            cauda.anterior = novoNo;
            ultimoNo.proximo = novoNo;
        }
        tamanho++;

    }

    @Override
    public void remover(Object elemento) {
        //Inicia a busca do elemento a ser removido a partir do primeiro nó após a cabeça
        No atual = cabeca.proximo;
        while(atual != cauda){
            if(atual.elemento.equals(elemento)){
                //O elemento foi encontrado, então remove
                No anterior = atual.anterior;
                No proximo = atual.proximo;
                anterior.proximo = proximo;
                proximo.anterior = anterior;
                tamanho--;
                return;
            }
            //Avança para o próximo nó
            atual=atual.proximo;
        }
        throw new PosicaoInvalidaExcecao("Elemento não encontrado: " + elemento);
    }

    @Override
    public Object naPosicao(int posicao) {
        if (!posicaoValida(posicao)) {
            throw new PosicaoInvalidaExcecao("Posição inválida: " + posicao);
        }
        No novoNo = percorrerLista(posicao);
        return novoNo.elemento;
    }

    @Override
    public int posicaoDe(Object elemento) {
        No novoNo = cabeca.getProximo(); // Começa do primeiro elemento após a cabeça
        int posicao = 0;
        // Percorre a lista até encontrar o elemento ou chegar na cauda
        while(novoNo != cauda && !novoNo.elemento.equals(elemento)){
            novoNo = novoNo.proximo;
            posicao++;
        }
        if(novoNo == cauda){
            // Se chegou na cauda, o elemento não está na lista
            return -1;
        }
        else{
            // Se encontrou o elemento, retorna a posição
            return posicao;
        }
    }

    private No percorrerLista(int posicao){
        No novoNo;
        if(posicao <= tamanho/2){
            novoNo = cabeca;
            // Percorre a lista da cabeça para a cauda
            for(int i = 0 ; i < posicao ; i++){
                novoNo = novoNo.proximo;
            }
        }else{
            novoNo = cauda;
            // Percorre a lista da cauda para a cabeça
            for(int i = tamanho -1 ; i > posicao ; i--){
                novoNo = novoNo.anterior;
            }
        }
        return novoNo;
    }
    private boolean posicaoValida(int posicao){
        // Verifica se a posição é válida no intervalo [0, tamanho[
        return posicao >= 0 && posicao < tamanho;
    }
    @Override
    public String mostrar(){
        StringBuilder sb = new StringBuilder();

        //Quantidade de elementos na sequência
        sb.append("Tamanho: " ).append(tamanho).append("\n");
        //Está vazia?
        sb.append("Vazia? ").append(estaVazia()).append("\n");

        //Primeiro elemento
        if(!estaVazia()){
            sb.append("Primeiro: ").append(primeiro()).append("\n");
        }
        //Último elemento
        if(!estaVazia()){
            sb.append("Último: ").append(ultimo()).append("\n");
        }
        //Elementos na lista
        sb.append("Elementos: \n");
        No atual = cabeca.proximo;
        while(atual != cauda){
            sb.append(atual.elemento).append("\n");
            atual = atual.proximo;
        }
        return sb.toString();
    }

}
