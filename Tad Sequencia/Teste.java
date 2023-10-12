public class Teste {
    public static void main(String[] args) {
        SequenciaDuplamenteEncadeada sequencia = new SequenciaDuplamenteEncadeada();
        sequencia.inserirPrimeiro("Chicago Fire");
        sequencia.inserirPrimeiro("Chicago PD");
        sequencia.inserirUltimo("Chicago Med");
        sequencia.inserirNaPosicao(2, "Chicago Justice");
        System.out.println(sequencia.antesDe("Chicago Med"));
        System.out.println("Posição 2: " + sequencia.elementoNaPosicao(2));
        sequencia.substituirElemento("Chicago Fire", "Chicago Fire: Temporada 1");
        sequencia.inserirUltimo("Law & Order: SVU");
        sequencia.inserirUltimo("Law & Order: Organized Crime");
        sequencia.removerDaPosicao(4);
        sequencia.remover("Chicago Justice");



        System.out.println(sequencia.mostrar());
    }

}