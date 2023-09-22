public class Teste {
    public static void main(String[] args) {
        FilaComDuasPilhas fila = new FilaComDuasPilhas();
        fila.enfileirar(1);
        fila.enfileirar(2);
        System.out.println(fila.toString());
        fila.desenfileirar();
        System.out.println(fila.toString());


    }
}
