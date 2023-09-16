import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class PilhaUniversal implements IPilha{
    private List<Object> pilha;
    public PilhaUniversal(){
        pilha = new ArrayList<>();
    }
    @Override
    public void empilhar(Object e){
        pilha.add(e);
    }
    @Override
    public Object desempilhar(){
        if(vazia()){
            throw new EmptyStackException();
        }
        Object valor = pilha.get(pilha.size()-1);
        pilha.remove(pilha.size()-1);
        return valor;
    }
    public Object topo(){
        if(vazia()) {
            throw new EmptyStackException();
        }
        return pilha.get(pilha.size()-1);

    }
    @Override
    public int tamanho(){
        return pilha.size();
    }

    public boolean vazia(){
        return pilha.isEmpty();
    }
    @Override
    public String toString() {
        if (vazia()) {
            return "Pilha vazia";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Pilha [ ");
        for (int i = 0; i < pilha.size(); i++) {
            sb.append(pilha.get(i));
            if (i < pilha.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

}
