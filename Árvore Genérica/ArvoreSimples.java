import java.util.Iterator;
import java.util.ArrayList;
public class ArvoreSimples
{
    //Atributos da Árvore
    No raiz;
    int tamanho;
    //Construtor
    public ArvoreSimples(Object o)
    {
        raiz = new No(null, o);
        tamanho = 1;
    }
    /** Retorna a raiz da Árvore */
    public No root()
    {
        return raiz;
    }
    /** Retorna o Nó pai de um No */
    public No parent(No v)
    {
        return (v.parent());
    }

    /** retorna os filhos de um No */
    public Iterator children(No v)
    {
        return v.children();
    }
    /** Testa se um No � interno */
    public boolean isInternal(No v)
    {
        return (v.childrenNumber() > 0);
    }
    /** Testa se um No � externo*/
    public boolean isExternal(No v)
    {
        return (v.childrenNumber() == 0);
    }
    /** Testa se um No � a raiz */
    public boolean isRoot(No v)
    {
        return v == raiz;
    }
    /**
     * Adiciona um filho a um No
     *
     * @return
     */
    public No addChild(No v, Object o)
    {
        No novo = new No(v, o);
        v.addChild(novo);
        tamanho++;
        return novo;
    }
    /** Remove um No
     *  S� pode remover Nos externos e que tenham um pai (n�o seja raiz)
     */
    public Object remove(No v) throws InvalidNoException
    {
        No pai = v.parent();
        if (pai != null || isExternal(v))
            pai.removeChild(v);
        else
            throw new InvalidNoException("Nó invalido");
        Object o = v.element();
        tamanho--;
        return o;
    }
    /** Troca dois elementos de posição */
    public void swapElements(No v, No w)
    {
        /*Método que serve de exercício
         * Este método deverá fazer com que o objeto
         * que estava na posição v fique na posição w
         * e fazer com que o objeto que estava na posição w
         * fique na posição v
         */
        Object temp = v.element();
        v.setElement(w.element());
        w.setElement(temp);


    }
    /** Retorna a profundidade de um No */
    public int depth(No v)
    {
        int profundidade = profundidade(v);
        return profundidade;
    }
    protected int profundidade(No v)
    {
        if (v == raiz)
            return 0;
        else
            return 1 + profundidade(v.parent());
    }
    /** Retorna a altura da �rvore */
    public int height(No v) {
        // Método que serve de exercício
        //O objetivo é retornar a altura da árvore genérica
        if(isExternal(v)){
            return 0;

        }
        else{
            int altura = 0;
            for(Iterator<No> child = v.children(); child.hasNext(); ) {
                No w = child.next();
                if(altura < height(w)){
                    altura = height(w);
                }
            }
            return altura + 1;

            }

    }
    /** Retorna um iterator com os elementos armazenados na �rvore */
    public Iterator <Object> elements() {
        // M�todo que serve de exerc�cio
        return listaElementos(raiz);
    }
    protected Iterator<Object> listaElementos(No v){
        ArrayList<Object> elements = new ArrayList<>();
        if(isRoot(v)){
            elements.add(v.element());

        }
        for(Iterator<No> child = v.children() ; child.hasNext();){
            No w = child.next();
            elements.add(w.element());
            listaElementos(w);
        }
        return elements.iterator();

    }

    /** Retorna um iterator com as posi��es (Nos) da �rvore */
    public Iterator <Object> Nos() {
        // M�todo que serve de exerc�cio
        return listaNos(raiz);
    }
    protected Iterator <Object> listaNos(No v){
        ArrayList<Object> nos = new ArrayList<>();
        if(isRoot(v)){
            nos.add(v);
        }
        for(Iterator<No> child = v.children() ; child.hasNext();){
            No w = child.next();
            nos.add(w);
            listaNos(w);
        }
        return nos.iterator();
        }

    /** Retorna o n�mero de Nos da �rvore
     */
    public int size() {
        // M�todo que serve de exerc�cio
        //Retorna o tamanho da árvore
        return tamanho;
    }
    /** Retorna se a �vore est� vazia. Sempre vai ser falso, pois n�o permitimos remover a raiz
     */
    public boolean isEmpty()
    {
        return false;
    }
    public Object replace(No v, Object o)
    {
        // M�todo que serve de exerc�cio
        Object item = v.element();
        v.setElement(o);
        return item;
    }

    class No
    {
        private Object o;
        private No pai;
        private ArrayList filhos = new ArrayList();
        public No(No pai, Object o)
        {
            this.pai = pai;
            this.o = o;
        }
        public Object element()
        {
            return o;
        }
        public No parent()
        {
            return pai;
        }
        public void setElement(Object o)
        {
            this.o = o;
        }
        public void addChild(No o)
        {
            filhos.add(o);
        }
        public void removeChild(No o)
        {
            filhos.remove(o);
        }
        public int childrenNumber()
        {
            return filhos.size();
        }
        public Iterator children()
        {
            return filhos.iterator();
        }
    }

    //Método para verificar se é externo ou interno
    public String externalOrInternal(No v){
        StringBuilder sb = new StringBuilder();
        String tipo = isExternal(v) ? "Externo" : "Interno";
        sb.append(v.element()).append(" é ").append(tipo).append("\n");

        Iterator<No> filhos = v.children();
        while (filhos.hasNext()) {
            No filho = filhos.next();
            sb.append(externalOrInternal(filho));
        }

        return sb.toString();

}
    }
