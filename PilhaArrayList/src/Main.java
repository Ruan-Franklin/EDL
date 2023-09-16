public class Main {
    public static void main(String[] args) {
        System.out.println("Pilha com ArrayList");
        PilhaArrayList pilha = new PilhaArrayList();
        pilha.empilhar(2);
        pilha.empilhar(4);
        pilha.empilhar(6);
        pilha.empilhar(8);
        pilha.empilhar(10);
        pilha.empilhar(23);
        System.out.println(pilha);
        System.out.println("Tamanho da pilha: " + pilha.tamanho());
        System.out.println("Topo da pilha: " + pilha.topo());
        System.out.println("Desempilhando: " + pilha.desempilhar());
        System.out.println("Topo da pilha: " + pilha.topo());
        System.out.println("Está vazia? " + pilha.vazia());
    }
}