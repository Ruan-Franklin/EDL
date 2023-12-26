public interface IVetor <T>{
    /**
     * Retorna o elemento na posição especificada.
     *
     * @param posicao A posição do elemento desejado.
     * @return O elemento na posição especificada.
     */
    public T elementoNaPosicao(int posicao);

    /**
     * Substitui o elemento na posição especificada pelo novo elemento e retorna o elemento antigo.
     *
     * @param posicao A posição do elemento a ser substituído.
     * @param elemento O novo elemento a ser inserido na posição.
     * @return O elemento antigo na posição especificada.
     */
    public T substituirElementoNaPosicao(int posicao, Object elemento);

    /**
     * Insere o elemento na posição especificada.
     *
     * @param posicao A posição onde o elemento será inserido.
     * @param elemento O elemento a ser inserido na posição.
     */
    public void inserirElementoNaPosicao(int posicao, Object elemento);

    /**
     * Remove o elemento na posição especificada e retorna o elemento removido.
     *
     * @param posicao A posição do elemento a ser removido.
     * @return O elemento removido na posição especificada.
     */
    public T removerElementoNaPosicao(int posicao);

    /**
     * Retorna o tamanho do vetor.
     *
     * @return O tamanho do vetor.
     */
    public int tamanho();

    /**
     * Retorna true se o vetor estiver vazio e false caso contrário.
     *
     * @return true se o vetor estiver vazio, false caso contrário.
     */
    public boolean estaVazio();
}