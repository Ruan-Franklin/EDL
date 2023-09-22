import java.util.EmptyStackException;

public class FilaComDuasPilhas {
    private PilhaUniversal pilhaEntrada;
    private PilhaUniversal pilhaSaida;

    public FilaComDuasPilhas() {
        pilhaEntrada = new PilhaUniversal();
        pilhaSaida = new PilhaUniversal();
    }

    public void enfileirar(Object elemento) {
        pilhaEntrada.empilhar(elemento); // Adiciona o elemento na pilha de entrada

    }

    public Object desenfileirar() {
        if (estaVazia()) {
            throw new FilaVaziaExcecao("Fila vazia");
        }
        if (pilhaSaida.vazia()) {
            // Transfere os elementos da pilha de entrada para a pilha de saída
            while (!pilhaEntrada.vazia()) {
                pilhaSaida.empilhar(pilhaEntrada.desempilhar());
            }
        }
        //Remove e retorna o elemento do topo da pilha de saída
        return pilhaSaida.desempilhar();
    }

    public Object primeiro() {
        if (estaVazia()) {
            throw new FilaVaziaExcecao("Fila vazia");
        }
        if (pilhaSaida.vazia()) {
            // Transfere os elementos da pilha de entrada para a pilha de saída
            while (!pilhaEntrada.vazia()) {
                pilhaSaida.empilhar(pilhaEntrada.desempilhar());
            }
        }
        // Retorna o elemento do topo da pilha de saída
        return pilhaSaida.topo();
    }

    public boolean estaVazia() {
        return pilhaEntrada.vazia() && pilhaSaida.vazia();
    }

    public int tamanho() {
        return pilhaEntrada.tamanho() + pilhaSaida.tamanho();

    }
    public String toString(){
        if(estaVazia()){
            return "Fila vazia";
        }
        //Cria uma cópia de entrada, porque desenfileirar remove os elementos originais
        PilhaUniversal copiaPilhaEntrada = new PilhaUniversal();
        StringBuilder sb = new StringBuilder();
        sb.append("Fila [ ");

        //Transfere os elementos da pilha de entrada para a pilha de saída
        while(!pilhaEntrada.vazia()){
            Object elemento = pilhaEntrada.desempilhar();
            copiaPilhaEntrada.empilhar(elemento);
            sb.append(elemento);
            if(!pilhaEntrada.vazia()){
                sb.append(", ");
            }
        }
        //Restaura os elementos da pilha de entrada
        while(!copiaPilhaEntrada.vazia()){
            pilhaEntrada.empilhar(copiaPilhaEntrada.desempilhar());
        }
        sb.append(" ]");
        return sb.toString();
    }
}
