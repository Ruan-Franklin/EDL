package Fila.TrabalhoFila.q3;

public class ListaEncadeada<T> {
    //Implementando um nó
    private static class No<T>{
        private T elemento;
        private No<T> proximo;
        //Construtor
        public No(T e, No<T> p){ //Criando um ponteiro, para um novo tipo de nó chamado p.
            elemento=e;
            //Nosso próximo nó será igual a p
            proximo=p;
        }
        //Função para recuperar um elemento de volta do nó
        public T GetElemento(){
            return elemento;
        }
        //Função para retornar o próximo nó
        public No<T> getProximo(){
            return proximo;
        }
        //Função para definir o próximo elemento
        //Como parâmetro, recebe o ponteiro para o novo tipo de nó.
        public void SetProximo(No <T> p){
            proximo = p;


        }

    }
    //Implementação da lista
    //A primeira coisa que temos é um ponteiro para o primeiro e para o último elemento dentro da lista
    //Na fase de inicialialização, ambos estarão vazios.
    private No <T> cabeça = null;
    private No <T> calda = null;
    private int tamanho = 0; //Na inicialização do objeto, o tamanho será 0.
    public ListaEncadeada() {} //É o inicializador vazio inicial
    //Função para recuperar o tamanho

    public int tamanho(){
        return tamanho;

    }
    //Função para verificar se está vazio
    public boolean IsEmpty(){
        return tamanho == 0;
        //Se não tiver elemento na lista, retorna verdadeiro, se tiver, retorna falso.

    }
    public T First(){
        //Se a lista estiver vazia, retorna nulo. Se não, retorna o elemento da cabeça
        if(IsEmpty()){
            return null;
        }
        return cabeça.GetElemento();
    }
    public T Last(){
        //Se estiver vazia, retorna nulo. Se não, retorna o elemento da calda.
        if(IsEmpty()){
            return null;
        }
        return calda.GetElemento();
    }
    //A próxima função permite adicionar um elemento na lista
    public void adcPrimeiro(T e){
        //Como boa parte do código é composto por genéricos, é possível adicionar qualquer tipo de elementos, como int, string, etc...
        cabeça = new No<>(e, cabeça);
        //Se o tamanho for igual a zero, o último elemento é igual ao primeiro.
         if(tamanho==0){
             calda=cabeça;
         }
         tamanho++;
         System.out.println("Nó principal adicionado com '"+cabeça.GetElemento() +"'Elemento.");
    }
    //Função para adicionar no final
    public void adcUltimo(T e){
        //Criando um novo nó
        No<T> newNo = new No<>(e,null);
        if(IsEmpty()){
            //Se estiver vazio, a cabeça é igual ao novo nó
            cabeça = newNo;
        }else{
            //Caso não, chama o set para retornar o próximo nó
            calda.SetProximo(newNo);        }
            //Após isso, teremos que nos certificar que o final será igual ao novo nó e que o tamanho aumente.
            calda = newNo;
            tamanho++;
            System.out.println("Nó final adicionado com '"+calda.GetElemento() +"'Elemento.");
        }
        public T removePrimeiro(){
            //Se estiver vazia, não será possível remover e retornará nulo
            if(IsEmpty()){
                return null;
            }
            T responda = cabeça.GetElemento();
            //Agora, é necessário decrementar o tamanho
            tamanho--;
            if(tamanho==0){
                calda = null;
            }
            System.out.println("Nó da cabeça removido '"+ responda + "' elemento.'");
            return responda;
//Parei o vídeo em 15 min
    }
    public void reverseList(){
        if(tamanho<=1){
        }
        else if(tamanho == 2){
            calda.SetProximo(cabeça);
            cabeça=calda;
            calda=cabeça.getProximo();
            calda.SetProximo(null);
        }
        else{
            No<T> atual = cabeça;
            No<T>proximoAtual=cabeça.getProximo();
            No<T> proximoproximoAtual=proximoAtual.getProximo(); 
            calda=cabeça;
            while(proximoAtual != null ){
                proximoAtual.SetProximo(atual);
                atual=proximoAtual;
                proximoAtual=proximoproximoAtual;
                if(proximoproximoAtual != null){
                    proximoproximoAtual=proximoproximoAtual.getProximo();
                }
            }
            calda.SetProximo(null);
            cabeça=atual;
        }


        }
        public T  RemoveElemento(T e){
            No<T> atual = cabeça;
            No<T> anterior = cabeça;
            int posição = 0;
            while(atual != null && atual.GetElemento() != e){
                anterior=atual;
                atual = atual.getProximo();
                posição++;
            }
            if(atual==null){
                return null;
            }else{
                if(cabeça == atual){
                    cabeça=atual.getProximo();
                }
                else if(calda == atual){
                    calda=anterior;
                    calda.SetProximo(null);
                }else{
                    anterior.SetProximo(atual.getProximo());
                }
                System.out.println("Localizar e remover nó na posição"+posição);
                tamanho--;
                return atual.GetElemento();
            }
        }
    }


