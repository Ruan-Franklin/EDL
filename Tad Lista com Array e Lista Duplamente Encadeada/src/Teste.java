public class Teste {
    public static void main(String[] args) {
        System.out.println("Tad Lista com Array e Lista Duplamente encadeada!!");
        TadListaArray lista1 = new TadListaArray(5);
        System.out.println("Seleção Brasileira de 1994 montada usando Tad Lista com Array");
        lista1.insereCabeca("Taffarel");
        lista1.insereCauda("Aldair");
        lista1.insereCauda("Márcio Santos");
        lista1.insereCauda("Branco");
        lista1.insereCauda("Jorginho");
        lista1.insereCauda("Dunga (Capitão)");
        lista1.insereCauda("Mauro Silva");
        lista1.insereCauda("Zinho");
        lista1.insereCauda("Mazinho");
        lista1.insereCauda("Bebeto");
        lista1.insereCauda("Romário");
        lista1.insereCabeca("Téc: Parreira");
        lista1.insereAntes("Branco", "Rai");
        lista1.insereDepois("Branco", "Leonardo");
        lista1.remove("Rai");
        lista1.remove("Leonardo");
        //Testando a exceção
       // lista1.remove("Ronaldo");
        System.out.println(lista1.mostrar());
        //Com a lista duplamente Ligada
        TadListaArrayListaDuplamenteLigada lista2 = new TadListaArrayListaDuplamenteLigada();
        lista2.insereCabeca("Marcos");
        lista2.insereCabeca("Felipão (Técnico)");
        lista2.insereDepois("Marcos", "Lúcio");
        lista2.insereAntes("Lúcio", "Roque Júnior");
        lista2.insereDepois("Roque Júnior", "Edmílson");
        lista2.insereDepois("Edmílson", "Cafu (Capitão)");
        lista2.insereDepois("Cafu (Capitão)", "Roberto Carlos");
        lista2.insereDepois("Roberto Carlos", "Gilberto Silva");
        lista2.insereDepois("Gilberto Silva", "Kléberson");
        lista2.insereDepois("Kléberson", "Rivaldo");
        lista2.insereDepois("Rivaldo", "Ronaldinho Gaúcho");
        lista2.insereCauda("Ronaldo");
        System.out.println("Lista 2: " + lista2.mostrar());
        lista2.substitui("Felipão (Técnico)", "Luiz Felipe Scolari (Técnico)");
        System.out.println("Lista 2: " + lista2.mostrar());
        lista2.remove("Luiz Felipe Scolari (Técnico)");
        System.out.println("Lista 2: " + lista2.mostrar());
        System.out.println("Antes do Ronaldo vem o " + lista2.antes("Ronaldo"));
        System.out.println("Depois do Marcos vem o " + lista2.depois("Marcos"));
        System.out.println("Ronaldo está no final da lista? " + lista2.estaNaCauda("Ronaldo"));
        System.out.println("Marcos está no início da lista? " + lista2.estaNaCabeca("Marcos"));
        System.out.println("Marcos está no final da lista? " + lista2.estaNaCauda("Marcos"));
        System.out.println("Ronaldo está no início da lista? " + lista2.estaNaCabeca("Ronaldo"));
        System.out.println("A lista da seleção brasileira campeã do mundo em 2002 possui " + lista2.tamanho() + " jogadores");


    }
}
