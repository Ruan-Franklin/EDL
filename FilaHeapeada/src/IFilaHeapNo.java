/**
 * Interface para a fila de prioridade usando a árvore binária heap, com nó.
 */
public interface IFilaHeapNo {
    /**
     * Insere um elemento na fila
     * @param item o item a ser inserido
     */
    public void inserir(ItemPrioritarioNo item);
    /**
     * Remove e retorna o elemento com menor chave da fila
     * @return o elemento com menor chave da fila
     */
    public Object removerMinimo();
    /**
     * Mostra a fila de prioridade
     */
    public void mostrarFila();
    /**
     * Troca dois itens de lugar
     * @param raiz o nó do primeiro item
     * @param novoNo o nó do segundo item
     */
    public void trocar(No primeiroNo, No novoNo);
    /**
     * Mostra se a fila está vazia ou não
     * @return true se a fila estiver vazia, false caso contrário
     */
    public boolean estaVazia();

    /**
     * Retorna o elemento com menor chave da fila
     * @return o elemento com menor chave da fila
     */
    public Object getMinimo();
}
