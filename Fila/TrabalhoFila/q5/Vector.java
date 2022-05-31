import java.util.Vector;
package Fila.TrabalhoFila.q5;

//Objetivo: utilizar a classe Vector para armazenar elementos da fila internamente
public class Vector implements FilaInterface{
    private Vector fila;
  private int avançadoIndice;
  private int RetornoIndice;

  private boolean initialized=false;
  private static final int DEFAULT_CAPACITY= 50;
  private static final int MAX_CAPACITY= 1000;

  public Vector()
  {
    fila=new Vector<>();
    avançadoIndice=RetornoIndice=0;

  }
  public void fila(T entradaRenovada)
  {
    RetornoIndice++;
    fila.add(RetornoIndice, entradaRenovada);

    if(avançadoIndice==0)
      avançadoIndice++;
  }
    public T desinfileirar()
  {
    if(avançadoIndice!=0)
    {
      T rEntrada=fila.elementoEm(avançadoIndice);
      for (int i =avançadoIndice; i<=avançadoIndice ; i++  ){
             fila.add(avançadoIndice, fila.elementoEm(avançadoIndice+1));
           fila.remove(RetornoIndice);
           RetornoIndice--;
           if(RetornoIndice==0){
             avançadoIndice=0;}
           return rEntrada;
    }

    return null;
}
    }
    public T getAvançada()
    {
      if(avançadoIndice!=0)
        return fila.elementEm(avançadoIndice);
      return null;
    }
    public boolean isEmpty()
    {
      if(RetornoIndice==0)
        return true;
      return false;
    }
    public void direct()
    {
      int indice=RetornoIndice;
      for(int i=avançadoIndice;i<=RetornoIndice;i++)
        fila.removeElementoEm(indice--);
      avançadoIndice=RetornoIndice=0;
    }
  }

