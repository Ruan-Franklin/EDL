import java.util.LinkedList;
import java.util.Queue;
public class FilaHeapNo implements IFilaHeapNo {
    // Atributos
    private No raiz;
    // Construtor
    public FilaHeapNo() {
        this.raiz = null;
    }
    @Override
    public void inserir(ItemPrioritarioNo item) {
        No novoNo = new No(item);
        raiz = adicionarNo(raiz, novoNo);
    }
    private No adicionarNo(No raiz, No novoNo) {
        if (raiz == null) {
            return novoNo;
        }
        //Se a chave do novo nó for menor que a chave do nó raiz, então o novo nó deve ser adicionado à esquerda.
        if (novoNo.getItem().compareTo(raiz.getItem()) < 0) {
            //Adicionar o novo nó.
            raiz.setFilhoEsquerdo(adicionarNo(raiz.getFilhoEsquerdo(), novoNo));
        } else {
            if (raiz.getFilhoDireito() == null) {
                //Adicionar o novo nó.
                raiz.setFilhoDireito(novoNo);
            } else {
                raiz.setFilhoDireito(adicionarNo(raiz.getFilhoDireito(), novoNo));
            }
        }
        return raiz;
    }
    @Override
    public void trocar(No primeiroNo, No novoNo) {
        ItemPrioritarioNo itemTemp = primeiroNo.getItem();
        primeiroNo.setItem(novoNo.getItem());
        novoNo.setItem(itemTemp);
    }
    public ItemPrioritarioNo removerMinimo() {
        if (estaVazia()) {
            throw new ElementoNaoEncontradoExcecao("Heap está vazia.");
        }
        // Recupera o item com menor chave (que está na raiz)
        ItemPrioritarioNo minimo = raiz.getItem();
        // Recupera o último item da fila
        No ultimoNo = atualizarUltimoNoRemocao();
        if(ultimoNo != null){
            trocar(raiz, ultimoNo);
            // Remove o último nó (antiga raiz)
            if (ultimoNo.getPai() != null) {
                // Se o último nó tem um pai, ajusta as referências do pai
                if (ultimoNo.getPai().getFilhoEsquerdo() == ultimoNo) {
                    ultimoNo.getPai().setFilhoEsquerdo(null);
                } else {
                    ultimoNo.getPai().setFilhoDireito(null);
                }
            } else {
                // Se o último nó é a raiz, atualiza a raiz para null (fila vazia)
                raiz = null;
            }
        }
        // Aplica a operação de afundar a partir da nova raiz, se a raiz não for nula
        if (raiz != null) {
            afundar(raiz);
        }
        return minimo;
    }

    private No atualizarUltimoNoRemocao() {
        if (raiz == null) {
            return null;
        }

        No noAtual = raiz;
        while (noAtual.getFilhoEsquerdo() != null || noAtual.getFilhoDireito() != null) {
            // Se o nó atual tem um filho à direita, vá para o filho à direita.
            if (noAtual.getFilhoDireito() != null) {
                noAtual = noAtual.getFilhoDireito();
            } else {
                // Se o nó atual não tem filho à direita, vá para o filho à esquerda.
                noAtual = noAtual.getFilhoEsquerdo();
            }
        }
        return noAtual;
    }
    public ItemPrioritarioNo listarMinimo() {
        if (estaVazia()) {
            throw new ElementoNaoEncontradoExcecao("Heap está vazia.");
        }

        // Retorna o item com menor chave (que está na raiz)
        return raiz.getItem();
    }

    public No atualizarUltimoNo(){
        No noAtual = raiz;
        while(true) {
            //Se o nó atual tem um filho à direita, vai para o filho à direita
            if (noAtual.getFilhoDireito() != null) {
                noAtual = noAtual.getFilhoDireito();
            }
            // Se o nó atual é um filho à esquerda ou a raiz, vai para o filho à esquerda.
            else if (noAtual.getFilhoEsquerdo() != null) {
                noAtual = noAtual.getFilhoEsquerdo();
            }
            // Se o nó atual não tem filhos, então é o último nó
            else {
                break;
            }
        }
        return noAtual;

    }
    public No procurarNo(ItemPrioritarioNo item) {
        return procurarNoRecursivo(raiz, item);
    }
    private No procurarNoRecursivo(No noAtual, ItemPrioritarioNo item) {
        if (noAtual == null) {
            return null; // Não encontrou o item na árvore
        }
        if (noAtual.getItem().equals(item)) {
            return noAtual; // Encontrou o nó com o item desejado
        }
        // Recursivamente procura nos filhos
        No noNaEsquerda = procurarNoRecursivo(noAtual.getFilhoEsquerdo(), item);
        No noNaDireita = procurarNoRecursivo(noAtual.getFilhoDireito(), item);
        // Retorna o nó encontrado (se existir) ou null
        return (noNaEsquerda != null) ? noNaEsquerda : noNaDireita;
    }
    public ItemPrioritarioNo getMenor(){
        if(estaVazia()){
            throw new ElementoNaoEncontradoExcecao("Fila vazia");
        }
        return raiz.getItem();
    }
    private void afundar(No no) {
        while (true) {
            No filhoEsquerdo = no.getFilhoEsquerdo();
            No filhoDireito = no.getFilhoDireito();
            No menorFilho = null;
            // Se o nó não tiver filhos, então não é necessário continuar
            if (filhoEsquerdo != null || filhoDireito != null) {
                if (filhoEsquerdo != null && filhoDireito != null) {
                    menorFilho = (filhoEsquerdo.getItem().compareTo(filhoDireito.getItem()) < 0) ? filhoEsquerdo : filhoDireito;
                } else if (filhoEsquerdo != null) {
                    menorFilho = filhoEsquerdo;
                } else {
                    menorFilho = filhoDireito;
                }

                if (menorFilho != null && menorFilho.getItem().compareTo(no.getItem()) < 0) {
                    trocar(no, menorFilho);
                    no = menorFilho;
                } else {
                    break;
                }
            } else {
                // Se o nó não tiver filhos, não há necessidade de continuar afundando
                break;
            }
        }
    }
    private No getUltimoNo() {
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        No ultimoNo = null;
        while (!fila.isEmpty()) {
            ultimoNo = fila.poll();
            if (ultimoNo.getFilhoEsquerdo() != null) {
                fila.add(ultimoNo.getFilhoEsquerdo());
            }
            if (ultimoNo.getFilhoDireito() != null) {
                fila.add(ultimoNo.getFilhoDireito());
            }
        }
        return ultimoNo;
    }
    private No getPai(No no){
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            if ((atual.getFilhoEsquerdo() != null && atual.getFilhoEsquerdo().equals(no)) ||
                    (atual.getFilhoDireito() != null && atual.getFilhoDireito().equals(no))) {
                return atual;
            }
            //[
            if (atual.getFilhoEsquerdo() != null) {
                fila.add(atual.getFilhoEsquerdo());
            }
            if (atual.getFilhoDireito() != null) {
                fila.add(atual.getFilhoDireito());
            }
        }
        return null; // Retorna null se o nó não tiver pai (ou seja, se for a raiz) ou se o nó não for encontrado na heap.
    }
    @Override
    public boolean equals(Object obj){
        return this == obj;
    }
    @Override
    public int hashCode(){
        return System.identityHashCode(this);
    }
    private No trocarComUltimo(No raiz) {
        // Encontrar o último nó folha à direita
        No ultimo = raiz;
        No paiDoUltimo = null;
        while (ultimo.getFilhoDireito() != null) {
            paiDoUltimo = ultimo;
            ultimo = ultimo.getFilhoDireito();
        }
        // Trocar os nós entre o nó raiz e o último nó folha à direita
        trocar(raiz, ultimo);
        // Remover o último nó folha à direita
        if (paiDoUltimo != null) {
            paiDoUltimo.setFilhoDireito(null);
        }
        return raiz;
    }
    public No getMinimo(No raiz) {
        if (raiz == null) {
            return null;
        }
        // Encontrar o nó com a menor chave na subárvore da esquerda
        No menor = getMinimo(raiz.getFilhoEsquerdo());
        // Se a subárvore da esquerda não tem um nó menor, então o próprio nó atual é o menor
        if (menor == null) {
            return raiz;
        }

        return menor;
    }

    @Override
    public boolean estaVazia() {
        return raiz == null;
    }
    @Override
    public Object getMinimo() {
        if (estaVazia()) {
            return null;
        }
        //É necessário percorrer a árvore até o último nó folha à esquerda
        No noAtual = raiz;
        while (noAtual.getFilhoEsquerdo() != null) {
            noAtual = noAtual.getFilhoEsquerdo();
        }
        return noAtual.getItem().getElemento();
    }

    public void mostrarFila() {
        if (estaVazia()) {
            System.out.println("Fila vazia!");
        }
        System.out.println("Fila de Prioridade:");
        mostrarFilaRecursivo(raiz, 0);
        System.out.println();
    }
    private void mostrarFilaRecursivo(No raiz, int nivel) {
        if (raiz != null) {
            mostrarFilaRecursivo(raiz.getFilhoDireito(), nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }
            System.out.println(raiz.getItem().getElemento());
            mostrarFilaRecursivo(raiz.getFilhoEsquerdo(), nivel + 1);
        }
    }
}

