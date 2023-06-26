package org.example.logica;
public class AsientoPremium implements Asiento{
    private int num;
    private boolean disponible;
    public AsientoPremium(int a){
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
        return "Premium";
    }
    public boolean getDisponibilidad(){
        return disponible;
    }
}

