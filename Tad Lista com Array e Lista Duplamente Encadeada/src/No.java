public class No {
    //Ponteiros para o próximo e o anterior
    No anterior;
    Object elemento;
    No proximo;
    //Construtor
    public No(Object elemento){
        this.elemento = elemento;
        this.anterior = null;
        this.proximo = null;
    }
}
