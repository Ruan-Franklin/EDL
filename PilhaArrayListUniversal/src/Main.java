public class Main {
    public static void main(String[] args) {
        System.out.println("Uma pilha que aceita qualquer tipo de dado");
        PilhaUniversal pilha = new PilhaUniversal();
        pilha.empilhar(1);
        pilha.empilhar("Dois");
        pilha.empilhar(3.0);
        pilha.empilhar(true);
        pilha.empilhar(false);
        System.out.println(pilha);
        System.out.println("Tamanho da pilha: " + pilha.tamanho());
        System.out.println("Desempilhando: " + pilha.desempilhar());
        System.out.println("Topo: "+ pilha.topo());
        System.out.println("Tamanho da pilha: " + pilha.tamanho());
        pilha.desempilhar();
        pilha.desempilhar();
        pilha.desempilhar();
        pilha.desempilhar();
        System.out.println("Tamanho da pilha: " + pilha.tamanho());
        System.out.println("Está vazia?"+ pilha.vazia());
    }
}