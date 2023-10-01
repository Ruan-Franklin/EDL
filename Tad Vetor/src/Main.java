public class Main {
    public static void main(String[] args) {
        System.out.println("Classe TAD Vetor");
        //Cria um vetor com tamanho inicial de 5
        Vetor vetor = new Vetor(5);
        //Insere os elementos no vetor
        vetor.inserirElementoNaPosicao(0, "A");
        vetor.inserirElementoNaPosicao(1, "B");
        vetor.inserirElementoNaPosicao(2, "C");
        vetor.inserirElementoNaPosicao(3, "D");
        vetor.inserirElementoNaPosicao(4, "E");
        //Imprime o vetor
        System.out.println(vetor);
        //Testa alocação dinâmica
        vetor.inserirElementoNaPosicao(5, "F");
        System.out.println(vetor.toString());
        //Testa substituição de elemento
        vetor.substituirElementoNaPosicao(0, "G");
        System.out.println(vetor.toString());
        //Testa remoção de elemento
        vetor.removerElementoNaPosicao(0);
        System.out.println(vetor.toString());
    }
}