package org.example.logica;

public class AsientoSalonCama implements Asiento{
    private int num;
    private boolean disponible;
    public AsientoSalonCama(int a){
        num = a;
    }
    public String getPosicion(){
        if (num<5){
            return "ventana";
        }else {
            return "pasillo";
        }
    }
    public int getNumAsiento(){
        return num;
    }
    public int getPrecio(){
        return (6000);
    }
    public String getTipoAsiento(){
        return "SalonCama";
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

