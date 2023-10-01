public class Main {
    public static void main(String[] args) {
        System.out.println("Lista encadeada!");
        System.out.println("Inserindo elementos no início da lista...");
        ListaEncadeada lista = new ListaEncadeada();
        lista.inserirNoInicio("A");
        lista.inserirNoInicio("B");
        System.out.println(lista.toString());
        //Removendo elementos do início da lista
        lista.removerDoInicio();
        System.out.println(lista.toString());
        //Inserindo elementos no fim da lista
        lista.inserirNoFim("C");
        //Inserindo elementos em uma posição específica da lista
        lista.inserirNaPosicao("D", 2);
        System.out.println(lista.toString());
        //Removendo elementos de uma posição específica da lista
        lista.removerDaPosicao(2);
        System.out.println(lista.toString());
    }
}