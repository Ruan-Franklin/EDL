public class No {
    private Object chave;
    private No proximo;
    private No anterior;
    private No inferior;
    private No superior;


    public No(Object chave) {
        this.chave = chave;
        this.proximo = null;
        this.inferior = null;
        this.superior = null;
    }

    /**
     * Retorna a chave do no
     *
     * @return
     */

    public Object getChave() {
        return this.chave;
    }

    /**
     * Altera a chave do no
     *
     * @param chave
     */

    public void setChave(Object chave) {
        this.chave = chave;
    }

    /**
     * Retorna o no proximo
     *
     * @return
     */
    public No getProximo() {
        return this.proximo;
    }

    /**
     * Altera o no proximo
     *
     * @param proximo
     */
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    /**
     * Retorna o no inferior
     *
     * @return
     */
    public No getInferior() {
        return this.inferior;
    }

    /**
     * Altera o no inferior
     *
     * @param inferior
     */

    public void setInferior(No inferior) {
        this.inferior = inferior;
    }

    /**
     * Retorna o no superior
     */
    public No getSuperior() {
        return superior;
    }

    /**
     * Altera o no superior
     *
     * @param superior
     */
    public void setSuperior(No superior) {
        this.superior = superior;
    }
    /**
     * Retorna o no anterior
     */
    public No getAnterior(){
        return anterior;
    }
    /**
     * Altera o no anterior
     * @param anterior
     */
    public void setAnterior(No anterior){
        this.anterior = anterior;
    }

}
