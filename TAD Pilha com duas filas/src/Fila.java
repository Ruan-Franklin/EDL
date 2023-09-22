public class Fila implements IFila{
    int inicio = 0;
    int fim = 0;
    int tamanhoMaximo, incremento;
    Object fila[];

    public Fila(int tamanhoMaximo, int incremento){
        fila= new Object[tamanhoMaximo];
        this.tamanhoMaximo = tamanhoMaximo;
        this.incremento = incremento;
    }
    @Override
    public void enfileirar(Object elemento){
        if(tamanho() == tamanhoMaximo-1){ //Se a fila stiver cheia
            int novoTamanho;
            if(incremento == 0){
                novoTamanho = tamanhoMaximo*2;
            }
            else{
                novoTamanho = tamanhoMaximo+incremento;
            }
            //Cria um novo array com o novo tamanho
            Object[] novoArray = new Object[novoTamanho];


            //Copia os elementos do array antigo para o novo
            int indiceInicio = inicio;
            for(int i = 0 ; i < tamanho() ; i++){
                novoArray[i] = fila[indiceInicio];
                indiceInicio = (indiceInicio+1)%tamanhoMaximo;
            }
            //Define o novo final e inicio da fila
            fim = tamanho(); //O fim é o tamanho da fila
            inicio = 0; //O inicio é o primeiro elemento do array
            tamanhoMaximo = novoTamanho; //O tamanho máximo é o novo tamanho
            fila = novoArray; //A fila é o novo array
        }
        fila[fim] = elemento;
        fim = (fim+1)%tamanhoMaximo;
    }
    public Object desenfileirar(){
        if(estaVazia()){
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        Object temp = fila[inicio];
        inicio = (inicio+1)%tamanhoMaximo;
        return temp;
    }
    @Override
    public Object primeiro(){
        if(estaVazia()){
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        return fila[inicio];
    }
    @Override
    public int tamanho(){
        return (tamanhoMaximo-inicio+fim)%tamanhoMaximo;
    }
    @Override
    public boolean estaVazia(){
        return inicio == fim;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int count = tamanho();
        int indiceAtual = inicio;

        for (int i = 0; i < count; i++) {
            sb.append(fila[indiceAtual]);
            if (i < count - 1) {
                sb.append(", ");
            }
            indiceAtual = (indiceAtual + 1) % tamanhoMaximo;
        }

        sb.append("]");
        return sb.toString();
    }


}