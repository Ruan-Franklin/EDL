public class FIlaEncadeada implements IFilaEncadeada{
    No inicio;
    No fim;
    public FIlaEncadeada(){
        inicio = null;
        fim = null;
    }
    //Cria um novo nó da lista ligada
    //Método para enfileirar um elemento
    public void enfileirar(Object elemento){
        No novo = new No(elemento);
        if(vazia()){
            this.inicio = novo;
            this.fim = novo;
        }
        //Adiciona um novo nó no fim da lista ligada.
        this.fim.proximo = novo;
        this.fim = novo;
    }
    //Método para desenfileirar um elemento
    public void desenfileirar(){
        if(this.inicio == null){
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        No novo = this.inicio;
        this.inicio = this.inicio.proximo;
        if(this.inicio == null){
            this.fim = null;
        }
    }

    public boolean vazia(){
        return this.inicio == null;
    }

    public int tamanho() {
        int contador = 0;
        No atual = this.inicio; //Começa a contar do início da lista ligada
        while (atual != null) {
            contador++;
            atual = atual.proximo;
        }
        return contador;
    }
    public Object primeiro(){
        if(vazia()){
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        return this.inicio.elemento;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        No atual = this.inicio;
        result.append("[");
        while(atual != null){
            result.append(atual.elemento);
            if(atual.proximo != null){
                result.append(",");
            }
            atual = atual.proximo;
        }
        result.append("]");
        return result.toString();
    }

    
}
