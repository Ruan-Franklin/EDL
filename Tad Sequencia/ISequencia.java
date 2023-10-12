public interface ISequencia {
    /**
     * Retorna o número de elementos na sequência.
     * @return número de elementos na sequência.
     */
    public int tamanho();

    /**
     * Verifica se a sequência está vazia.
     * @return true se a sequência estiver vazia, false caso contrário.
     */
    public boolean estaVazia();

    /**
     * Retorna o elemento na posição especificada.
     * @param posicao posição do elemento a ser retornado.
     * @return elemento na posição especificada.
     */
    public Object elementoNaPosicao(int posicao);

    // Métodos relacionados à manipulação da sequência

    /**
     * Insere um elemento em uma posição específica.
     * @param posicao posição onde o elemento será inserido.
     * @param elemento elemento a ser inserido.
     */
    public void inserirNaPosicao(int posicao, Object elemento);

    /**
     * Remove o elemento em uma posição específica.
     * @param posicao posição do elemento a ser removido.
     */
    public void removerDaPosicao(int posicao);

    /**
     * Retorna o primeiro elemento da sequência.
     * @return o primeiro elemento.
     */
    public Object primeiro();

    /**
     * Retorna o último elemento da sequência.
     * @return o último elemento.
     */
    public Object ultimo();

    /**
     * Retorna o elemento que precede o elemento especificado.
     * @param elemento elemento de referência.
     * @return elemento que precede 'elemento'.
     */
    public Object antesDe(Object elemento);

    /**
     * Retorna o elemento que segue o elemento especificado.
     * @param elemento elemento de referência.
     * @return elemento que segue 'elemento'.
     */
    public Object depoisDe(Object elemento);

    /**
     * Substitui um elemento na sequência pelo novo elemento especificado.
     * @param antigoElemento elemento a ser substituído.
     * @param novoElemento novo elemento.
     */
    public void substituirElemento(Object antigoElemento, Object novoElemento);

    /**
     * Troca os elementos em duas posições da sequência.
     * @param primeiraPosicao elemento na primeira posição.
     * @param segundaPosicao elemento na segunda posição.
     */
    public void trocarElementos(Object primeiraPosicao, Object segundaPosicao);

    /**
     * Insere um elemento antes do elemento especificado.
     * @param elementoFrente elemento de referência.
     * @param elementoTras elemento a ser inserido.
     */
    public void inserirAntesDe(Object elementoFrente, Object elementoTras);

    /**
     * Insere um elemento após o elemento especificado.
     * @param elementoTras elemento de referência.
     * @param elementoFrente elemento a ser inserido.
     */
    public void inserirDepoisDe(Object elementoTras, Object elementoFrente);

    /**
     * Insere um elemento como o primeiro elemento da sequência.
     * @param elemento elemento a ser inserido.
     */
    public void inserirPrimeiro(Object elemento);

    /**
     * Insere um elemento como o último elemento da sequência.
     * @param elemento elemento a ser inserido.
     */
    public void inserirUltimo(Object elemento);

    /**
     * Remove o elemento especificado da sequência.
     * @param elemento elemento a ser removido.
     */
    public void remover(Object elemento);

    // Métodos "ponte"

    /**
     * Retorna o elemento na posição especificada.
     * @param posicao posição do elemento a ser retornado.
     * @return elemento na posição especificada.
     */
    public Object naPosicao(int posicao);

    /**
     * Retorna a posição de um elemento na sequência.
     * @param elemento elemento a ser encontrado.
     * @return a posição de 'elemento' na sequência.
     */
    public int posicaoDe(Object elemento);

    /**
     * Mostra os elementos da sequência
     * @return uma string com os elementos da sequência.
     */
    public String mostrar();
}
