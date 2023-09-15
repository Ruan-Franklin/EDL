public class Main {
    public static void main(String[] args) {
        System.out.println("Pilha simples!");
        Pilha pilha = new Pilha(10);
        pilha.empilhar(2);
        pilha.empilhar(4);
        pilha.empilhar(6);
        pilha.empilhar(8);
        pilha.empilhar(10);
        pilha.empilhar(12);
        pilha.empilhar(14);
        pilha.empilhar(16);
        pilha.empilhar(18);
        pilha.empilhar(20);

        System.out.println("Está cheia? " + pilha.cheia());
        System.out.println("Está vazia? " + pilha.vazia());
        System.out.println("Topo: " + pilha.topo());
        System.out.println(pilha.toString());

    }
}