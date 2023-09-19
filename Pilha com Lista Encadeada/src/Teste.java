
public class Teste {
    public static void main(String[] args) {
        System.out.println("Pilha com Lista encadeada!");
        PilhaEncadeada pilha = new PilhaEncadeada();
        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);
        pilha.empilhar("Natal");
        pilha.empilhar("Rio Grande do Norte");
        pilha.empilhar("Brasil");
        System.out.println("Topo: "+ pilha.topo());
        System.out.println("Tamanho: "+ pilha.tamanho());
        pilha.mostrar();
        //Removendo
        pilha.desempilhar();
        pilha.desempilhar();
        System.out.println("Novo topo: " + pilha.topo());

        //Testando exceção
    //    pilha.desempilhar();
       // pilha.desempilhar();
      //  pilha.desempilhar();
       // pilha.desempilhar();
       // System.out.println("Está vazia?" + pilha.vazia());
}
}