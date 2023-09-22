public class Teste {
    public static void main(String[] args) {
        System.out.println("Pilha com duas filas");
        PilhaDuasFilas pilha = new PilhaDuasFilas(10, 2);
        pilha.empilhar(1);
        pilha.empilhar("Natal");
        pilha.empilhar("São Paulo");
        System.out.println(pilha);
        pilha.desempilhar();
        System.out.println(pilha);
        System.out.println("Topo: " + pilha.topo());


    }
}
