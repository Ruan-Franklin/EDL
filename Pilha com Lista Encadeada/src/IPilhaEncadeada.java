public interface IPilhaEncadeada {
    public abstract void empilhar(Object elemento);
    public abstract void desempilhar();

    public abstract Object topo();
    public abstract boolean vazia();

    public abstract int tamanho();
    public abstract void mostrar();
}

