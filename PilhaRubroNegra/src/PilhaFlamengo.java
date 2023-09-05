public class PilhaFlamengo implements IFlamengo {
    private int topoVermelho = -1;
    private int topoPreto;
    private Object[] pilha;
    private int capacidade;

    public PilhaFlamengo(int tamanho) {
        pilha = new Object[tamanho];
        capacidade = tamanho;
        topoPreto = capacidade;
    }

    public int pilhaTamanho(Boolean vermelho) {
        if (vermelho)
            return topoVermelho + 1;
        else
            return capacidade - topoPreto;
    }

    public boolean vazia(boolean vermelho) {
        if (vermelho)
            return topoVermelho == -1;
        else
            return topoPreto == capacidade;
    }

    public boolean cheia() {
        return topoVermelho + 1 == topoPreto;
    }

    public Object topo(boolean vermelho) {
        if (vermelho) {
            if (vazia(vermelho)) throw new PilhaVaziaExcecao("Pilha vazia");
            else
                return pilha[topoVermelho];
        } else {
            if (vazia(vermelho)) throw new PilhaVaziaExcecao("Pilha vazia");
            else
                return pilha[topoPreto];
        }
    }
    public void empilhar(Object elemento, boolean vermelho){
        if(cheia()){
            int antigaCapacidade = capacidade;
            capacidade *= 2;
            Object[] temp = new Object[capacidade];
            for(int i = 0; i<= topoVermelho ; i++){
                temp[i] = pilha[i];
            }
            int j = capacidade -1;
            for(int i = antigaCapacidade -1; i>= topoPreto; i--){
                temp[j--] = pilha[i];
            }
            topoPreto = j+1;
            pilha = temp;
        }
        if(vermelho){
            pilha[++topoVermelho] = elemento;
        }
        else{
            pilha[--topoPreto] = elemento;
        }
    }
    public Object desempilhar(boolean vermelho){
        if(vermelho){
            if (vazia(vermelho)) throw new PilhaVaziaExcecao("Pilha vazia");
            else{
                Object temp = pilha[topoVermelho];
                pilha[topoVermelho--] = null;
                return temp;
            }
        }
        else{
            if (vazia(vermelho)) throw new PilhaVaziaExcecao("Pilha vazia");
            else{
                Object temp = pilha[topoPreto];
                pilha[topoPreto++] = null;
                return temp;
            }
        }

    }
    public void imprimePilha(boolean vermelha){
        if(vermelha) {
            if (vazia(vermelha)) System.out.println("");
            else {
                for (int i = 0; i < topoVermelho + 1; i++) {
                    if (pilha[i] != null)
                        System.out.print(pilha[i]);
                    else
                        System.out.print(" ");
                    if (i < topoVermelho)
                        System.out.print(", ");
                }
                System.out.println("}");
            }
        }
        else{
            if (vazia(vermelha)) System.out.println("");
            else {
                System.out.print("{");
                for (int i = capacidade - 1 ; i > topoPreto - 1 ; i--){
                    if (pilha[i] != null)
                        System.out.print(pilha[i]);
                    else
                        System.out.print(" ");
                    if (i > topoPreto)
                        System.out.print(", ");
                }
                System.out.println("}");
            }

        }
    }
    public void imprimePilhaFlamengo(){
        System.out.print("{");
        for(int i = 0; i < capacidade ; i++){
            if(pilha[i] != null)
                System.out.print(pilha[i]);
            else
                System.out.print(" ");
            if( i < capacidade -1)
                System.out.print(", ");
        }
        System.out.println("}");
    }



}

