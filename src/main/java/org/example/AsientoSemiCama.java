package org.example;
public class AsientoSemiCama implements Asiento{
    private int num;
    public AsientoSemiCama(int a){
        num = a;
    }
    public int getNumAsiento(){
        return num;
    }
    public String getTipoAsiento(){
        return "SemiCama";
    }
}

