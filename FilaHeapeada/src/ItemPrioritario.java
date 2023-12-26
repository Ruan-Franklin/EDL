public class ItemPrioritario implements IItemPrioritario, Comparable<ItemPrioritario>{

    //Atributos
    private int chave;
    private Object valor;
    //Construtor
    public ItemPrioritario(int chave, Object valor){
        this.chave = chave;
        this.valor = valor;
    }
    @Override
    public int getChave() {
        return chave;
    }

    @Override
    public Object getValor() {
        return valor;
    }

    @Override
    public int compareTo(ItemPrioritario outroItem) {
        return Integer.compare(this.chave, outroItem.chave);
    }
}
