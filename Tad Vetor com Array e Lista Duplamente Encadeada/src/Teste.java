public class Teste {
    public static void main(String[] args) {
        System.out.println("Tad vetor com Array e com Lista duplamente encadeada!");
        //Array (inserindo elementos)
        System.out.println("Tad vetor com Array");
        VetorArray vetor1 = new VetorArray(5);
        vetor1.adicionarNaPosicao(0, "A");
        vetor1.adicionarNaPosicao(1, "B");
        vetor1.adicionarNaPosicao(2, "C");
        System.out.println("Vetor com array: " + vetor1.toString());
        //Array (removendo elementos)
      //  vetor1.removerNaPosicao(1);
      //  System.out.println(vetor1.toString());
        //Array (substituindo elementos)
       // vetor1.substituirNaPosicao(0, "D");
       // System.out.println(vetor1.toString());
        System.out.println("Tad vetor com a lista encadeada");
        VetorListaDuplamenteLigada vetor2 = new VetorListaDuplamenteLigada();
        vetor2.adicionarNaPosicao(0, "A");
        vetor2.adicionarNaPosicao(1, "B");
        System.out.println(vetor2.toString());
        vetor2.removerNaPosicao(1);
        System.out.println(vetor2.toString());
        vetor2.substituirNaPosicao(0, "C");
        System.out.println(vetor2.toString());


    }
}