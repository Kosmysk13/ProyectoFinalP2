package org.example.logica;
import java.util.ArrayList;


public class AsientosBus{
    ArrayList<Asiento> arrAs = new ArrayList<Asiento>();
    public AsientosBus(){
    }
    public void addAsiento(Asiento as){
        arrAs.add(as);
    }
    public Asiento getAsiento(int cualAs){
        if (arrAs.size()>0){
            Asiento as1 = arrAs.get(cualAs);
            Asiento auxAs = as1;
            as1.setDisponibilidad(false);
            arrAs.set(cualAs,as1);
            return auxAs;
        }else{
            return null;
        }
    }
}