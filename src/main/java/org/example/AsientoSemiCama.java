package org.example;
public class AsientoSemiCama implements Asiento{
    private int num;
    private boolean disponible;
    public AsientoSemiCama(int a){
        num = a;
    }
    public String getPosicion(){
        if ((num%2)==0){
            return "ventana";
        }else {
            return "pasillo";
        }
    }
    public int getNumAsiento(){
        return num;
    }
    public String getTipoAsiento(){
        return "SemiCama";
    }
    public boolean getDisponibilidad(){
        return disponible;
    }
}

