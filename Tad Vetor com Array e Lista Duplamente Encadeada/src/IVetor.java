public interface IVetor {
    /**
     * retorna o elemento na posição especificada.
     *
     * @param posicao a posição do elemento a ser retornado.
     * @return o elemento na posição especificada.
     *
     */
    public Object elementoNaPosicao(int posicao);

    /**
     * Substitui o elemento na posição especificada por um novo elemento.
     *
     * @param posicao a posição do elemento a ser substituído.
     * @param elemento o elemento a ser adicionado na posição especificada.
     * @return o elemento anterior na posição especificada.
     */
    public Object substituirNaPosicao(int posicao, Object elemento);

    /**
     * Adiciona um novo elemento na posição especificada.
     *
     * @param posicao a posição do elemento a ser adicionado.
     * @param elemento o elemento a ser adicionado na posição especificada.
     */
    public void adicionarNaPosicao(int posicao, Object elemento);

    /**
     * Remove o elemento na posição especificada.
     * @param posicao a posição do elemento a ser removido.
     *
     * @return o elemento removido.
     */
    public Object removerNaPosicao(int posicao);

    /**
     * Retorna o tamanho do vetor.
     * @return o tamanho do vetor.
     */
    public int tamanho();

    /**
     * Retorna se o vetor está vazio.
     * @return true se o vetor estiver vazio, false caso contrário.
     */
    public boolean estaVazio();

    /**
     * Mostra o vetor.
     * @return uma string com os elementos do vetor.
     */
    public String toString();


}
