package Fila.TrabalhoFila.q3;

//Classe com um elemento genérico
public class Fila<E>{
    private ListaEncadeada <E> list = new ListaEncadeada<>();
    //Construtor de Fila vazio
    public Fila(){}

    //Função de verificar o tamanho
    public int tamanho(){
        return list.tamanho();  //
    }
    public boolean IsEmpty(){
        return list.IsEmpty();
    }
    public void Enfileirar(E elemento){
        //Método para inserir um elemento no final da lista encadeada
        list.adcUltimo(elemento);
    }
    public E Desinfileirar(){
        //Remove o primeiro elemento da lista encadeada
        return list.removePrimeiro();
        //"Primeiro a entrar, primeiro a sair"
    }
    public E first(){
        return list.First();
    }
    
    }



