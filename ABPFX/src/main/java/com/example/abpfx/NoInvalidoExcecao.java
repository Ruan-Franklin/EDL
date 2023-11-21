package com.example.abpfx;
public class NoInvalidoExcecao extends RuntimeException{
    public NoInvalidoExcecao(String err){
        super(err);
    }
}
