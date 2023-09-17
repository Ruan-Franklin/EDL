public class Main {
    public static void main(String[] args) {

        //Cria uma lista encadada
        ListaEncadeada lista = new ListaEncadeada();
        lista.inserirNo(1);
        lista.inserirNo(2);
        lista.inserirNo(3);
        lista.inserirNo(4);
        lista.inserirNo("Cinco");
        lista.exibirLista();
    }
}