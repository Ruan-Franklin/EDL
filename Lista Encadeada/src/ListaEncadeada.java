public class ListaEncadeada implements IListaEncadeada{
    //Classe interna para representar um nó da lista
    class No {
        Object dado;
        No proximo;

        //Construtor para criar um novo nó com o dado especificado
        public No(Object dado){
            this.dado = dado;
            this.proximo = null;
        }
    }
    public No cabeca = null;
    public No cauda = null;
    @Override
    public void inserirNo(Object dado){
        No novoNo = new No(dado);
        //Se a lista estiver vazia
        if(cabeca == null){
            //Nó não foi criado ainda
            cabeca = novoNo;
            cauda = novoNo;
        }
        //Se já tiver um nó na lista
        else{
            //Adiciona o novo nó no final da lista
            cauda.proximo = novoNo;
            //Atualiza a cauda
            cauda = novoNo;
        }
    }
    @Override
    public void exibirLista(){
        //O nó atual começa no primeiro nó da lista
        No noAtual = cabeca;
        //Se a lista estiver vazia
        if(cabeca == null){
            System.out.println("Lista vazia");
            return;
        }
        //Se a lista não estiver vazia
        System.out.println("Os nós da lista são: ");
        //Enquanto não chegar no final da lista
        while(noAtual != null){
            //Imprime o dado do nó atual
            System.out.println(noAtual.dado + " ");
            //Atualiza o nó atual para o próximo nó da lista
            noAtual = noAtual.proximo;
        }
        System.out.println();

    }
}
