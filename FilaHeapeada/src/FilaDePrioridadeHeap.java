import java.util.ArrayList;
public class FilaDePrioridadeHeap implements IFilaHeap {
    //Usa arraylist para armazenar os itens  da fila
    private ArrayList<ItemPrioritario> heap;

    //Construtor
    public FilaDePrioridadeHeap() {
        heap = new ArrayList<ItemPrioritario>();
    }

    @Override
    public void inserir(int chave, Object elemento) {
        //Cria um novo item prioritário
        ItemPrioritario novoItem = new ItemPrioritario(chave, elemento);
        //Adiciona o item no final do arraylist
        heap.add(novoItem);
        //Subir o item para a posição correta
        subirHeap(heap.size() - 1);
    }

    @Override
    public void trocar(int indice1, int indice2) {
        //Armazena o item do índice 1 em uma variável auxiliar
        ItemPrioritario temp = heap.get(indice1);
        //Armazena o item do índice 2 no índice 1
        heap.set(indice1, heap.get(indice2));
        //Armazena o item do índice 1 no índice 2
        heap.set(indice2, temp);
    }

    @Override
    public Object removerMinimo() {
        //Verifica se a fila está vazia
        if (estaVazia()) {
            return null;
        }
        //Recupera o item com menor chave
        ItemPrioritario minimo = heap.get(0);
        //Recupera o último item da fila
        int ultimoIndice = heap.size() - 1;
        ItemPrioritario ultimo = heap.remove(ultimoIndice); // remove o último elemento
        //Verifica se a fila tem mais de um item
        if (ultimoIndice > 0) {
            //Armazena o último item no índice 0
            heap.set(0, ultimo);
            //Descer para manter a proriedade de min-heap
            descerHeap(0);
        }
        //Retorna o item com menor chave
        return minimo;
    }



    //Método para descer o item do índice i
    //Desce o item do índice i para a posição correta
    private void descerHeap(int indice) {
        //Declara variáveis para armazenar os índices dos filhos
        int filhoEsquerdoIndice, filhoDireitoIndice, indiceMinimo;
        //Recupera o índice do filho esquerdo;
        filhoEsquerdoIndice = 2 * indice + 1;
        //Enquanto o indice do filho esquerdo for menor que o tamanho do heap
        while (filhoEsquerdoIndice < heap.size()) {
            //Recupera o indice do filho direito

            filhoDireitoIndice = filhoEsquerdoIndice + 1;
            indiceMinimo = (filhoDireitoIndice < heap.size() && heap.get(filhoDireitoIndice).compareTo(heap.get(filhoEsquerdoIndice)) < 0) ? filhoDireitoIndice : filhoEsquerdoIndice;

            //Verifica se o item do índice é maior que o item do índice do filho
            if (heap.get(indice).compareTo(heap.get(indiceMinimo)) > 0) {
                //Troca os itens
                trocar(indice, indiceMinimo);
                //Atualiza o índice
                indice = indiceMinimo;
                //Recupera o índice do filho esquerdo
                filhoEsquerdoIndice = 2 * indice + 1;
            } else {
                break;
            }
        }

    }

    private void subirHeap(int indice) {
        int paiIndice = (indice - 1) / 2;
        while (indice > 0 && heap.get(indice).compareTo(heap.get(paiIndice)) < 0) {
            trocar(indice, paiIndice);
            indice = paiIndice;
            paiIndice = (indice - 1) / 2;
        }
    }


    @Override
    public boolean estaVazia() {
        return heap.isEmpty();
    }

    @Override
    public void mostrarFila() {
        while (!heap.isEmpty()) {
            ItemPrioritario minimo = (ItemPrioritario) removerMinimo();
            System.out.println("Chave: " + minimo.getChave() + " Elemento: " + minimo.getValor());
        }
    }
}