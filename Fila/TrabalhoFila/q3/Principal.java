package Fila.TrabalhoFila.q3;

public class Principal {
    public static void main (String [] args){
       ListaEncadeada<String> ALista = new ListaEncadeada<String>();
       ALista.adcPrimeiro("1");
       ALista.adcPrimeiro("2");
       ALista.adcUltimo("3");
       while(!ALista.IsEmpty()){
           ALista.removePrimeiro();
       }
       Fila<String> AFila = new Fila<String>();
       Pilha<String> APilha = new Pilha<String>();
       //Inserindo os elementos
       APilha.push("Pessoa 1");
       APilha.push("Pessoa 2");
      // APilha.push("Pessoa 3");
       AFila.Enfileirar("Pessoa 4");
       APilha.pop();
      // APilha.pop();
      // APilha.pop();
       

    }
    
}

