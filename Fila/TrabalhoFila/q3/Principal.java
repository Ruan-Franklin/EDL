package Fila.TrabalhoFila.q3;

public class Principal {
    public static void main (String [] args){
     
       Fila<String> AFila = new Fila<String>();
       Pilha<String> APilha = new Pilha<String>();
       //Inserindo os elementos
       APilha.push("Pessoa 1");
       APilha.push("Pessoa 2");
       APilha.push("Pessoa 3");
       AFila.Inserir("Pessoa 4");
       APilha.pop();
       APilha.pop();
       APilha.pop();
       

    }
    
}

