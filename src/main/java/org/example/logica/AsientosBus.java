package org.example.logica;
import java.util.ArrayList;

/**
 * Se encarga de crear un ArrayList unicamente de Asientos.
 */
public class AsientosBus{
    /**
     * Variable principal que almacena todos los asientos.
     */
    ArrayList<Asiento> arrAs = new ArrayList<Asiento>();

    /**
     * Metodo constructor vacio de la clase.
     */
    public AsientosBus(){
    }

    /**
     * Metodo que se encarga de agregar un asiento al ArrayList.
     * @param as Parametro que entrega el asiento que se agregara al ArrayList.
     */
    public void addAsiento(Asiento as){
        arrAs.add(as);
    }

    /**
     * Metodo que se encarga de recibir un asiento, sin quitarlo del ArrayList, pero si cambiando su disponibilidad.
     * @param cualAs Parametro que se utiliza como indice para elegir el asiento que se desea reservar.
     * @return Entrega el asiento elegido.
     */
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