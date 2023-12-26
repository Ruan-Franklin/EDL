/**
 * Interface para a classe Hash - Tabela Hash
 */
public interface IHash <Chave, Valor>{
    /**
    * Insere um novo elemento na tabela
    * @param chave - chave do elemento a ser inserido
    * @param valor - valor do elemento a ser inserido
     */
    public void inserir(Chave chave, Valor valor);
    /**
     *Lista elemento
     * @param chave - chave do elemento a ser listado
     * @return valor - valor do elemento a ser listado
     */
    public Valor listar(Chave chave);
    /**
     * Remove elemento
     * @param chave - chave do elemento a ser removido
     */
    public void remover(Chave chave);
    /**
      * Verifica se contém a chave
      * @param chave - chave do elemento a ser verificado
      * @return true - se contém a chave
     */
    public boolean contemChave(Chave chave);
    /**
      * Verifica se a tabela está vazia
      * @return true - se a tabela estiver vazia
     */
    public boolean estaVazia();
    /**
      * Retorna o tamanho da tabela
      * @return tamanho - tamanho da tabela
     */
    public int tamanho();

    /**
     * Mostra a tabela
     */
    public void mostrarTabela();

}
