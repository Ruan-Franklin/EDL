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
        lista1.insereCauda("Dunga");
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
    }
}
