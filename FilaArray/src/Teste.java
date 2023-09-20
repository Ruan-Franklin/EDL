public class Teste {
    public static void main(String[] args) {
        System.out.println("Fila com array");
        IFila fila = new FilaArray(3);
        fila.enfileirar("Robinson");
        fila.enfileirar("Dina");
        fila.enfileirar("Ruan");
        System.out.println(fila);
        fila.enfileirar("Jorgiano");
        System.out.println(fila);
        System.out.println(fila.tamanho());
        System.out.println(fila.primeiro());
        //Desinfileirando
        fila.desenfileirar();
        System.out.println(fila);
        fila.desenfileirar();
        System.out.println(fila);
        fila.desenfileirar();
        System.out.println(fila);
        fila.desenfileirar();
        System.out.println(fila);
    }
}