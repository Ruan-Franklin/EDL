public class PilhaEncadeada implements IPilhaEncadeada{
    //Classe interna para ter a lista encadeada
    class No{
        Object dado;
        No ligacao; //Referencia para o proximo elemento
    }
    //Cria uma referencia para o topo da pilha global
    No topo;
    //Construtor
    public PilhaEncadeada(){
        topo = null;
    }
    @Override
    public void empilhar(Object elemento) {
        No novoNo = new No();
        if (novoNo == null){
            System.out.println("Estouro de pilha");
        }
        novoNo.dado = elemento;
        novoNo.ligacao = topo;
        topo = novoNo;
    }

    @Override
    public void desempilhar() {
        if(vazia()){
            throw new PilhaVaziaExcecao("Pilha vazia");
        }
        topo = topo.ligacao;
    }

    @Override
    public Object topo() {
        if(vazia()){
            throw new PilhaVaziaExcecao("Pilha vazia");
        }
        return topo.dado;
    }
    @Override
    public int tamanho() {
        int tamanho = 0;
        No temp = topo;
        while(temp != null){
            tamanho++;
            temp = temp.ligacao;
        }
        return tamanho;
    }

    @Override
    public boolean vazia() {
        return topo == null;
    }

    @Override
    public void mostrar() {
        if(topo == null){
            System.out.println("Estouro de pilha");
        }
        No temp = topo;
        while(temp != null){
            System.out.println(temp.dado);
            temp = temp.ligacao;
            if(temp != null){
                System.out.println("->");

            }
        }

    }
}
