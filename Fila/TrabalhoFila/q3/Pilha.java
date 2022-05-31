package Fila.TrabalhoFila.q3;

//Classe com um elemento genérico
public class Pilha <E> {
    //É necessário atingir o nível da lista encadeada individualmente
    private ListaEncadeada<E> list = new ListaEncadeada<>();
    //Construtor vazio para a pilha
    public Pilha(){}
    //Função de tamanho da pilha
    public int tamanho(){
        return list.tamanho();

    }
    public boolean IsEmpty(){
        return list.IsEmpty();
    }
    //Função para inserir na pilha
    public void push(E elemento){
        list.adcPrimeiro(elemento);
    }
    //Função para remover um elemento da pilha
    public E pop(){
        return list.removePrimeiro();

    }
    public E top(){
        return list.First();
        
    }

    
}
