public class PilhaDuasFilas implements IPilhaDuasFilas{

    private Fila fila1;
    private Fila fila2;

    public PilhaDuasFilas(int tamanhoMaximo, int incremento){
        fila1 = new Fila(tamanhoMaximo, incremento);
        fila2 = new Fila(tamanhoMaximo, incremento);
    }

    @Override
    public void empilhar(Object elemento) {
        fila2.enfileirar(elemento); //Adiciona o elemento na fila temporária
        //Move todos os elementos da fila1 para a fila2
        while(!fila1.estaVazia()){
            fila2.enfileirar(fila1.desenfileirar());
        }
        //Troca as filas, a fila2 agora é a fila1 e a fila1 agora é a fila2
        Fila temp = fila1;
        fila1 = fila2;
        fila2 = temp;
    }

    @Override
    public Object desempilhar() {
        if(estaVazia()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        return fila1.desenfileirar(); //Remove o elemento do topo da pilha
    }

    @Override
    public Object topo() {
        if(estaVazia()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        return fila1.primeiro(); //Retorna o elemento do topo da pilha (o primeiro da fila)
    }

    @Override
    public boolean estaVazia() {
        return fila1.estaVazia();
    }

    @Override
    public int tamanho() {
        return fila1.tamanho();
    }

    @Override
    public String toString(){
        if(estaVazia()){
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("Pilha: [");
        //Copia os elementos para uma fila temporária
        Fila temp = new Fila(fila1.tamanho(), 0);
        while(!fila1.estaVazia()){
            Object elemento = fila1.desenfileirar();
            temp.enfileirar(elemento);
            result.append(elemento);
            if(!fila1.estaVazia()){
                result.append(", ");
            }
        }
        //Copia os elementos de volta para a fila1
        while(!temp.estaVazia()){
            fila1.enfileirar(temp.desenfileirar());
        }
        result.append("]");
        return result.toString();


    }
}
