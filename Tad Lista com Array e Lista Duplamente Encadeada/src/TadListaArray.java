public class TadListaArray implements ILista{
    private Object[] lista;
    private int tamanho;
    //Construtor da classe
    public TadListaArray(int capacidade){
        lista = new Object[capacidade];
        tamanho = 0;

    }
    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public boolean estaNaCabeca(Object elemento) {
        if(tamanho > 0 && lista[0].equals(elemento)){
            return true;
        }
        return false;
    }

    @Override
    public boolean estaNaCauda(Object elemento) {
        if(tamanho > 0 && lista[tamanho-1].equals(elemento)){
            return true;
        }
        return false;
    }

    @Override
    public Object antes(Object elemento) {
        for(int i = 1 ; i < tamanho ; i++){
            if(lista[i].equals(elemento)){
                return lista[i-1];
            }
        }
        return null;
    }

    @Override
    public Object depois(Object elemento) {
        for(int i = 0 ; i < tamanho-1 ; i++){
            if(lista[i].equals(elemento)){
                return lista[i+1];
            }
        }
        return null;
        }


    @Override
    public void insereCabeca(Object elemento) {
        if(tamanho

    }

    @Override
    public void insereCauda(Object elemento) {

    }

    @Override
    public Object substitui(Object elemento, Object novoElemento) {
        return null;
    }

    @Override
    public Object insereAntes(Object elemento, Object novoElemento) {
        return null;
    }

    @Override
    public Object insereDepois(Object elemento, Object novoElemento) {
        return null;
    }

    @Override
    public void troca(Object elemento1, Object elemento2) {

    }

    @Override
    public Object remove(Object elemento) {
        return null;
    }
}
