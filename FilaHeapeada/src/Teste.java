public class Teste {
    public static void main(String[] args) {
        //Heap com fila de prioridade usando array
        FilaDePrioridadeHeap fila1 = new FilaDePrioridadeHeap();
        fila1.inserir(10, "A");
        fila1.inserir(5, "B");
        fila1.inserir(7, "C");
        //Mostra a fila
        //Remove o item com menor chave
        System.out.println("Removendo o item com menor chave");
        fila1.removerMinimo();
        fila1.mostrarFila();

        //Heap com fila de prioridade usando nó

        FilaHeapNo fila2 = new FilaHeapNo();
        System.out.println("Criando a fila de prioridade usando nó");
        fila2.inserir(new ItemPrioritarioNo(10, "A"));
        fila2.inserir(new ItemPrioritarioNo(5, "B"));
        fila2.inserir(new ItemPrioritarioNo(7, "C"));
        fila2.inserir(new ItemPrioritarioNo(1, "D"));
        //Mostra a fila
        fila2.mostrarFila();
        //Remove o item com menor chave
        System.out.println("Removendo o item com menor chave");

        fila2.mostrarFila();
        Object menorChave = fila2.listarMinimo();
        System.out.println("O item com menor chave é: " + menorChave);
        System.out.println("Removendo o item com menor chave");
        fila2.removerMinimo();




    }
}