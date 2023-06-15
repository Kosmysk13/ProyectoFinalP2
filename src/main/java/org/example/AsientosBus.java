package org.example;
import java.util.ArrayList;


public class AsientosBus{
    Asiento a = null;
    ArrayList<Asiento> arrAs = new ArrayList<Asiento>();
    public AsientosBus(){
    }
    public void addBebida(Asiento as){
        arrAs.add(as);
    }
    public Asiento getAsiento(){
        if (arrAs.size()>0){
            Asiento as1 = arrAs.get(0);
            arrAs.remove(0);
            return as1;
        }else{
            return null;
        }
    }
}