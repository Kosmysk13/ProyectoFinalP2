package org.example.logica;
/**
 * Se encarga de crear un tipo de asiento en especifico, el tipo SemiCama, con su informacion respectiva.
 */
public class AsientoSalonCama implements Asiento{
    private int num;
    private boolean disponible;
    /**
     * Metodo constructor que recibe como parametro un numero entero y crea un asiento con ese numero.
     * @param a Variable que define el numero de asiento que tendra el asiento creado.
     */
    public AsientoSalonCama(int a){
        num = a;
    }
    /**
     * Metodo que se encarga de definir y entregar la posicion dentro del bus que tendra el asiento que se creara, ya sea pasillo o ventana
     * @return Retorna un String que indica si el asiento se encuentra en el pasillo o la ventana.
     */
    public String getPosicion(){
        if (num<11){
            return "pasillo";
        }else if (num<17){
            return "ventana";
        }else{
            return null;
        }
    }
    /**
     * Metodo que se encarga de entregar el numero de asiento, del asiento creado.
     * @return Entrega un numero entero indicando el numero de este asiento.
     */
    public int getNumAsiento(){
        return num;
    }
    /**
     * Metodo que se encarga de definir y entregar el valor monetario del asiento.
     * @return Retorna un numero entero que indica el valor de este asiento.
     */
    public int getPrecio(){
        return (6000);
    }
    /**
     * Metodo que se encarga de indicar el tipo de asiento que tendra el asiento
     * @return Retorna un String indicando que es tipo SalonCama.
     */
    public String getTipoAsiento(){
        return "SalonCama";
    }
    /**
     * Metodo que se encarga de definir o cambiar la disponibilidad de un asiento, mediante un parametro
     * @param aux Parametro booleano que sera asignado a la variable disponible del asiento.
     */
    public void setDisponibilidad(boolean aux){
        disponible = aux;
    }
    /**
     * Metodo que se encarga de indicar si el asiento esta disponible u ocupado mediante un string
     * @return Entrega un String con la disponibilidad del asiento.
     */
    public String getDisponibilidad(){
        if (disponible==true){
            return "disponible";
        }else{
            return "ocupado";
        }
    }
}

