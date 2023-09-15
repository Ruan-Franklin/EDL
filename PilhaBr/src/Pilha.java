public class Pilha implements IPilha{
    private int tamanhoMaximo;
    private int[] pilha;
    private int topo;

    public Pilha(int tamanhoMaximo){
        this.tamanhoMaximo = tamanhoMaximo;
        this.pilha = new int[tamanhoMaximo];
        this.topo = -1;
    }
    @Override
    public int empilhar(int valor){
        if (cheia()){
            throw new RuntimeException("Pilha cheia");
        }
       return pilha[++topo] = valor;
    }

    public int desempilhar(){
        if(vazia()){
            throw new RuntimeException("Pilha vazia");
        }
        return pilha[topo--];
    }

    @Override
    public boolean vazia(){
        return topo == -1;
    }

    public boolean cheia(){
        return topo == tamanhoMaximo -1;
    }
    @Override
    public int tamanho(){
        return topo + 1;
    }

    public int topo(){
        if(vazia()){
            throw new RuntimeException(("Pilha vazia"));
        }
        return pilha[topo];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0 ; i <= topo; i++){
            sb.append(pilha[i]);
            if(i<topo){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
