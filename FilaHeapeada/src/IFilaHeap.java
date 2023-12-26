public interface IFilaHeap {
    /*
        * Mostra se a fila está vazia ou não
        * @return true se a fila estiver vazia, false caso contrário
     */
    public boolean estaVazia();

    /*
        *Retorna o elemento com menor chave da fila
        * @return o elemento com menor chave da fila
     */

    /*
       * Insere um elemento na fila
       * @param prioridade a prioridade a ser inserida
       * @param  elemento  a ser inserido

     */
    public void inserir(int prioridade, Object elemento);

    /**
     *  Troca dois itens de lugar
     *  @param indice1 o índice do primeiro item
     * @param indice2 o índice do segundo item
     */
    public void trocar(int indice1, int indice2);

    /**
       * Remove e retorna o elemento com menor chave da fila
     * @return o elemento com menor chave da fila
     */
    public Object removerMinimo();
    /**
     *Mostra a fila de prioridade
     */
    public void mostrarFila();
}


