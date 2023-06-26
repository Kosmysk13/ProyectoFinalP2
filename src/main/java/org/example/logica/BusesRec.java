package org.example.logica;

import java.util.ArrayList;

public class BusesRec {
    ArrayList<Bus> arrBus = new ArrayList<Bus>();
    public BusesRec(){
    }
    public void addBus(Bus bus){
        arrBus.add(bus);
    }
    public Bus getBus(){
        if (arrBus.size()>0){
            Bus bus1 = arrBus.get(0);
            arrBus.remove(0);
            return bus1;
        }else{
            return null;
        }
    }
}