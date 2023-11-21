package com.example.abpfx;
public class ComparadorABP {
    private ComparadorABP comparador;

    public int comparar(Object elemento1, Object elemento2){
        return ((Integer) elemento1).compareTo((Integer) elemento2);
    }

    public void setComparador(ComparadorABP comparador){
        this.comparador = comparador;
    }

    public ComparadorABP getComparador(){
        return comparador;
    }

}
