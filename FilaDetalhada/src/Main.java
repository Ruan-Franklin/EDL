public class Main {
    public static void main(String[] args) {
        System.out.println("Fila");
        Fila fila = new Fila(3, 0);
        fila.enfileirar(1);
        fila.enfileirar("Teste2");
        fila.enfileirar(3);
        System.out.println(fila);
        fila.desenfileirar();
        System.out.println(fila+ "Tamanho: "+fila.tamanho() + "Primeiro: " + fila.primeiro());
        fila.desenfileirar();
        fila.desenfileirar();
        fila.desenfileirar();



    }
}