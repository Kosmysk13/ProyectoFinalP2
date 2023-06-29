package org.example.logica;

/**
 * Interface que se encarga de crear el molde con todos los metodos que deben tener las otras clases que lo implementen.
 */
public interface Asiento{
    /**
     * Metodo que se encarga de definir y entregar la posicion dentro del bus que tendra el asiento que se creara, ya sea pasillo o ventana
     * @return Retorna un String que indica si el asiento se encuentra en el pasillo o la ventana.
     */
    public String getPosicion();
    /**
     * Metodo que se encarga de entregar el numero de asiento, del asiento creado.
     * @return Entrega un numero entero indicando el numero de este asiento.
     */
    public int getNumAsiento();
    /**
     * Metodo que se encarga de indicar el tipo de asiento que tendra el asiento
     * @return Retorna un String indicando el tipo de asiento que es.
     */
    public String getTipoAsiento();
    /**
     * Metodo que se encarga de definir o cambiar la disponibilidad de un asiento, mediante un parametro
     * @param aux Parametro booleano que sera asignado a la variable disponible del asiento.
     */
    public void setDisponibilidad(boolean aux);
    /**
     * Metodo que se encarga de indicar si el asiento esta disponible u ocupado mediante un string
     * @return Entrega un String con la disponibilidad del asiento.
     */
    public String getDisponibilidad();
    /**
     * Metodo que se encarga de definir y entregar el valor monetario del asiento.
     * @return Retorna un numero entero que indica el valor de este asiento.
     */
    public int getPrecio();
}