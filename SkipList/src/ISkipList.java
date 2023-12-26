/**
 * Interface para a classe SkipList
 */
public interface ISkipList {
    /**
     * Busca um elemento na SkipList
     * @param chave
     * @return No
     */
    public Object buscar(Object chave);
    /**
     * Insere um elemento na SkipList
     * @param chave
     */
    public void inserir(Object chave);
    /**
     * * Remove um elemento na SkipList
     * @param chave
     */
    public Object remover(Object chave);

    /**
     * Imprime a SkipList
     */
    public void imprimir();

}
