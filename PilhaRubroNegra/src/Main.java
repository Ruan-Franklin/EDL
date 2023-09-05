public class Main {
    public static void main(String[] args) {
        PilhaFlamengo pilhaFlamengo = new PilhaFlamengo(5);

        //Empilhando elementos da pilha vermelha
        pilhaFlamengo.empilhar("Elemento 1 (Vermelho)", true);
        pilhaFlamengo.empilhar("Elemento 2 (Vermelho)", true);
        pilhaFlamengo.empilhar("Elemento 3 (Vermelho)", true);
        //Empilhando elementos da pilha preta
        pilhaFlamengo.empilhar("Elemento 1 (Preto)", false);
        pilhaFlamengo.empilhar("Elemento 2 (Preto)", false);
        pilhaFlamengo.empilhar("Elemento 3 (Preto)", false);
        pilhaFlamengo.empilhar("Elemento 4 (Preto)", false);
        pilhaFlamengo.empilhar("Elemento 5 (Preto)", false);
        pilhaFlamengo.empilhar("Elemento 6 (Preto)", false);
        //Imprimindo as pilhas
        System.out.println("Pilha Vermelha:");
        pilhaFlamengo.imprimePilha(true);
        System.out.println("Pilha Preta:");
        pilhaFlamengo.imprimePilha(false);
        System.out.println("Array inteiro:");
        pilhaFlamengo.imprimePilhaFlamengo();



    }
}