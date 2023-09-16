import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class PilhaArrayList implements IPilha{
    private List<Integer> pilha;
    public PilhaArrayList(){
        this.pilha = new ArrayList<>();
    }
    @Override
    public void empilhar(int valor){
        pilha.add(valor);
    }

    public int desempilhar(){
        if(vazia()){
            throw new EmptyStackException();
        }
        int valor = pilha.get(pilha.size()-1);
        pilha.remove(pilha.size()-1);
        return valor;
    }
    public int topo(){
        if(vazia()){
            throw new EmptyStackException();
        }
        return pilha.get(pilha.size()-1);
    }
    @Override
    public int tamanho(){
        return pilha.size();
    }

    @Override
    public boolean vazia(){
        return pilha.isEmpty();
    }
    @Override
    public String toString(){
        if (vazia()){
            return "Pilha vazia";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Pilha [ ");
        for(int i = 0 ; i < pilha.size() ; i++){
            sb.append(pilha.get(i));
            if(i < pilha.size()-1){
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();

    }

}
