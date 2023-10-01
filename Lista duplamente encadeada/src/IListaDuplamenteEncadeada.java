public interface IListaDuplamenteEncadeada {
    /**
     * Percorre a lista para frente.
     */
    public void percorrerParaFrente();

    /**
     * Percorre a lista para trás.
     */
    public void percorrerParaTras();

    /**
     * Insere um elemento no início da lista.
     *
     * @param elemento
     */
    public Object inserirNoInicio(Object elemento);

    /**
     * Insere um elemento em uma posição específica da lista.
     *
     * @param elemento, posicao
     * @return elemento inserido
     */
    public Object inserirNaPosicao(Object elemento, int posicao);

    /**
     * Insere um elemento no final da lista.
     *
     * @param elemento
     * @return elemento inserido
     */
    public Object inserirNoFim(Object elemento);

    /**
     * Remove um elemento do início da lista.
     *
     * @return elemento removido
     */
    public Object removerDoInicio();

    /**
     * Remove um elemento de uma posição específica da lista.
     *
     * @param posicao
     * @return elemento removido
     */

    public Object removerDaPosicao(int posicao);

    /**
     * Remove um elemento do final da lista.
     *
     * @return elemento removido
     */
    public Object removerDoFim();


}
