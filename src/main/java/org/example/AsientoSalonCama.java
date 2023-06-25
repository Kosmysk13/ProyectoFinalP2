package org.example;

public class AsientoSalonCama implements Asiento{
    private int num;
    public AsientoSalonCama(int a){
        num = a;
    }
    public int getNumAsiento(){
        return num;
    }
    public String getTipoAsiento(){
        return "SalonCama";
    }
}

