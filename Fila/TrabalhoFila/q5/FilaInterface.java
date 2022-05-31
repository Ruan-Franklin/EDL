package Fila.TrabalhoFila.q5;

public interface FilaInterface<T> {
    public void enfileirar(T newEntry);

  public T desinfileirar();

  public T getAvançado();

  public boolean isEmpty();

  public void direct();
    
}
