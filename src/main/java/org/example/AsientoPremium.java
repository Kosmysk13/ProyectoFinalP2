package org.example;
public class AsientoPremium implements Asiento{
    private int num;
    public AsientoPremium(int a){
        num = a;
    }
    public int getNumAsiento(){
        return num;
    }
    public String getTipoAsiento(){
        return "Premium";
    }
}

