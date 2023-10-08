public interface ILista {
    /**
     * Retorna o número de elementos da lista.
     * @return O tamanho da lista
     */
    public int tamanho();
    /**
     * Verifica se a lista está vazia.
     * @return true se a lista estiver vazia, false caso contrário
     */
    public boolean estaVazia();
    /**
     * Verifica se o elemento é o primeiro da lista.
     * @param elemento O elemento a ser verificado
     * @return true se o elemento for o primeiro da lista, false caso contrário
     */
    public boolean estaNaCabeca(Object elemento);
    /**
     * Verifica se o elemento é o último da lista.
     * @param elemento O elemento a ser verificado
     * @return true se o elemento for o último da lista, false caso contrário
     */
    public boolean estaNaCauda(Object elemento);
    /**
     * Retorna o elemento que fica antes do elemento passado como parâmetro.
     * @param elemento O elemento a ser verificado
     * @return O elemento que fica antes do elemento passado como parâmetro
     */
    public Object antes(Object elemento);
    /**
     * Retorna o elemento que fica depois do elemento passado como parâmetro.
     * @param elemento O elemento a ser verificado
     * @return O elemento que fica depois do elemento passado como parâmetro
     */
    public Object depois(Object elemento);
    /**
     * Insere um elemento no início da lista.
     * @param elemento O elemento a ser inserido
     */
    public void insereCabeca(Object elemento);
    /**
     * Insere um elemento no final da lista.
     * @param elemento O elemento a ser inserido
     */
    public void insereCauda(Object elemento);
    /**
     * Substitui o elemento indicado por outro.
     * @param elemento O elemento a ser substituído
     * @param novoElemento O elemento que substituirá o elemento indicado
     * pelo parâmetro elemento
     * @return O elemento que foi substituído
     */
    public Object substitui(Object elemento, Object novoElemento);
    /**
     * Insere um elemento antes de um elemento indicado.
     * @param elemento O elemento que será inserido antes do elemento indicado
     * @param novoElemento O elemento que indica onde o elemento será inserido antes
     * @return O elemento que foi inserido
     */
    public Object insereAntes(Object elemento, Object novoElemento);
    /**
     * Insere um elemento depois de um elemento indicado.
     * @param elemento O elemento que será inserido depois do elemento indicado
     * @param novoElemento O elemento que indica onde o elemento será inserido depois
     * @return O elemento que foi inserido
     */
    public Object insereDepois(Object elemento, Object novoElemento);
    /**
     * Troca dois elementos de posição.
     * @param elemento1 O primeiro elemento a ser trocado
     * (o elemento que ficará na posição do segundo elemento)
     *  @param elemento2 O segundo elemento a ser trocado
     * (o elemento que ficará na posição do primeiro elemento)
     *
     */
    public void troca(Object elemento1, Object elemento2);
    /**
     * Remove um elemento da lista.
     * @param elemento O elemento a ser removido
     * @return O elemento que foi removido
     */
    public Object remove(Object elemento);

    /**
     * Mostra os elementos da lista.
     * @return Uma String com os elementos da lista
     */
    public String mostrar();

}
