public class No {
    Object elemento;
    No proximo;
    No anterior;

    public No(Object elemento){
        this.elemento = elemento;
        this.anterior = null;
        this.proximo = null;

    }

    public No getProximo(){
        return proximo;
    }

    public No getAnterior() {
        return anterior;
    }
}
