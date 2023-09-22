public interface IPilha {
    public abstract void empilhar(Object elemento);
    public abstract Object desempilhar();
    public abstract Object topo();
    public abstract boolean vazia();
    public abstract int tamanho();

}