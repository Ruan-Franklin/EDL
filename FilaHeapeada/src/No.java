import java.util.LinkedList;
import java.util.Queue;

public class No {
    //Atributos
    private int chave;
    private Object elemento;
    private No filhoEsquerdo;
    private No filhoDireito;
    private No pai;
    private ItemPrioritarioNo item;
    //Construtor
    public No( ItemPrioritarioNo item){
        this.elemento = elemento;
        //Filhos inicialmente nulos
        this.filhoDireito = null;
        this.filhoEsquerdo = null;
        this.item = item;
    }
    //Métodos
    public int getChave() {
        return chave;
    }
    public Object getElemento() {
        return elemento;
    }
    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }
    public No getFilhoDireito() {
        return filhoDireito;
    }
    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }
    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }
    public void setChave(int chave) {
        this.chave = chave;
    }
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    public ItemPrioritarioNo getItem() {
        return item;
    }
    public void setItem(ItemPrioritarioNo item) {
        this.item = item;
    }

    public No getPai() {
        Queue<No> fila = new LinkedList<>();
        fila.add(this);

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            if ((atual.getFilhoEsquerdo() != null && atual.getFilhoEsquerdo().equals(this)) ||
                    (atual.getFilhoDireito() != null && atual.getFilhoDireito().equals(this))) {
                return atual;
            }

            if (atual.getFilhoEsquerdo() != null) {
                fila.add(atual.getFilhoEsquerdo());
            }

            if (atual.getFilhoDireito() != null) {
                fila.add(atual.getFilhoDireito());
            }
        }

        return null;
    }
    public void setPai(No pai){
        this.pai = pai;
    }


}
