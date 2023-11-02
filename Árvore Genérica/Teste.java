public class Teste {
    public static void main(String[] args) {
        // Cria uma árvore com a raiz "Raiz"
        ArvoreSimples arvore = new ArvoreSimples("Raiz");

        // Obtendo a raiz da árvore
        ArvoreSimples.No no1 = arvore.root();

        // Adicionando um filho a raiz
        ArvoreSimples.No filho1 = arvore.addChild(no1, "Filho 1");
        ArvoreSimples.No filho2 = arvore.addChild(no1, "Filho 2");

        // Verificando a natureza dos filhos do nó raiz
        String verificaFilho1 = arvore.externalOrInternal(filho1);
        String verificaFilho2 = arvore.externalOrInternal(filho2);

        System.out.println(verificaFilho1);
        System.out.println(verificaFilho2);

        // Adicionando filhos para "Filho 1" e "Filho 2"
        ArvoreSimples.No neto1 = arvore.addChild(filho1, "Neto 1");
        ArvoreSimples.No neto2 = arvore.addChild(filho1, "Neto 2");
        ArvoreSimples.No neto3 = arvore.addChild(filho2, "Neto 3");
        ArvoreSimples.No neto4 = arvore.addChild(filho2, "Neto 4");

        // Verificando a natureza dos filhos do nó raiz novamente
        verificaFilho1 = arvore.externalOrInternal(filho1);
        verificaFilho2 = arvore.externalOrInternal(filho2);

        System.out.println(verificaFilho1);
        System.out.println(verificaFilho2);

        //Trocando os elementos dos nós "Filho 1" e "Filho 2"
        arvore.swapElements(filho1, filho2);
        // Obtendo o elemento do nó "Filho 1"
        verificaFilho1 = arvore.externalOrInternal(filho1);
        // Obtendo o elemento do nó "Filho 2"
        verificaFilho2 = arvore.externalOrInternal(filho2);
        System.out.println("Após a troca:");
        System.out.println(verificaFilho1);
        System.out.println(verificaFilho2);


        // Profundidade da raiz
        System.out.println("Profundidade da raiz: " + arvore.depth(no1));
        //Profundidade do nó "Filho 1"
        int profundidadeFilho1 = arvore.depth(filho1);
        //Profundidade do nó "Filho 2"
        int profundidadeFilho2 = arvore.depth(filho2);
        System.out.println("Profundidade do nó \"Filho 1\": " + profundidadeFilho1);
        System.out.println("Profundidade do nó \"Filho 2\": " + profundidadeFilho2);
        //Profundidade do nó "Neto 1"
        int profundidadeNeto1 = arvore.depth(neto1);
        //Profundidade do nó "Neto 2"
        int profundidadeNeto2 = arvore.depth(neto2);
        //Profundidade do nó "Neto 3"
        int profundidadeNeto3 = arvore.depth(neto3);
        //Profundidade do nó "Neto 4"
        int profundidadeNeto4 = arvore.depth(neto4);
        System.out.println("Profundidade do nó \"Neto 1\": " + profundidadeNeto1);
        System.out.println("Profundidade do nó \"Neto 2\": " + profundidadeNeto2);
        System.out.println("Profundidade do nó \"Neto 3\": " + profundidadeNeto3);
        System.out.println("Profundidade do nó \"Neto 4\": " + profundidadeNeto4);

        System.out.println("Altura da árvore: " + arvore.height(no1));


    }
}