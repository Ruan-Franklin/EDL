public class Teste {
    public static void main(String[] args) {
        System.out.println(" Fila com lista encadeada!");
        FIlaEncadeada fila = new FIlaEncadeada();
       fila.enfileirar("Brasil");
       fila.enfileirar("Itália");
       fila.enfileirar("Alemanha");
       fila.enfileirar("Argentina");
       fila.enfileirar("França");
       fila.enfileirar("Espanha");
       System.out.println("Tamanho da fila: " + fila.tamanho() + " País da frente: " + fila.primeiro());
       fila.desenfileirar();
       System.out.println("Tamanho da fila: " + fila.tamanho() + " País da frente: " + fila.primeiro());
       System.out.println(fila.toString());
       System.out.println("Fila vazia? " + fila.vazia());
    }


}