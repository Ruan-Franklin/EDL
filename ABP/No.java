public class No {
    private Object elemento;
    private No filhoEsquerdo;
    private No filhoDireito;
    private No pai;
    //Construtor da classe No
    public No(Object elemento){
        //Elemento do nó recebe  o elemento passado como parâmetro
        this.elemento = elemento;
        //Filhos do nó recebem null como padrão na criação do nó
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        //Pai do nó recebe null como padrão na criação do nó
        this.pai = null;
    }
    public Object getElemento(){
        return elemento;
    }
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    public No getPai(){
        return pai;
    }
    public void setPai(No pai){
        this.pai = pai;
    }
    public No getFilhoDireito(){
        return filhoDireito;
    }
    public void setFilhoDireito(No filhoDireito){
        this.filhoDireito = filhoDireito;
    }
    public No getFilhoEsquerdo(){
        return filhoEsquerdo;
    }
    public void setFilhoEsquerdo(No filhoEsquerdo){
        this.filhoEsquerdo = filhoEsquerdo;
    }

}
