package org.example;

public abstract class Asiento{
    private int numAsiento;
    public Asiento(int num){
        numAsiento = num;
    }
    public int getNumAsiento(){
        return numAsiento;
    }
    public abstract String getTipoAsiento();
}