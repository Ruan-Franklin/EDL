public interface IFlamengo {
    int pilhaTamanho(Boolean vermelho);
    boolean vazia(boolean vermelho);
    boolean cheia();
    Object topo(boolean vermelho);
    void empilhar(Object elemento, boolean vermelho);
    Object desempilhar(boolean vermelho);
    void imprimePilha(boolean vermelho);
    void imprimePilhaFlamengo();

}
