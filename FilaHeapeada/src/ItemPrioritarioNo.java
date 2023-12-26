import java.util.Comparator;
public class ItemPrioritarioNo implements Comparable<ItemPrioritarioNo>{
    private int chave;
    private Object elemento;
    //Construtor
    public ItemPrioritarioNo(int chave, Object elemento){
        this.chave = chave;
        this.elemento = elemento;
    }
    public int getChave() {
        return chave;
    }
    public Object getElemento() {
        return elemento;
    }
    public void setChave(int chave) {
        this.chave = chave;
    }
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    @Override
    public int compareTo(ItemPrioritarioNo outroItem) {
        return Integer.compare(this.chave, outroItem.chave);
    }

    @Override
    public String toString() {
        return "(" + chave + ", " + elemento + ")";
    }
}

