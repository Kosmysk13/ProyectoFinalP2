package org.example.logica;
public class AsientoSemiCama implements Asiento{
    private int num;
    private boolean disponible;
    public AsientoSemiCama(int a){
        disponible=true;
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
    public int getPrecio(){
        return (5000);
    }
    public String getTipoAsiento(){
        return "SemiCama";
    }
    public void setDisponibilidad(boolean aux){
        disponible = aux;
    }
    public String getDisponibilidad(){
        if (disponible==true){
            return "disponible";
        }else{
            return "ocupado";
        }
    }
}

