package org.example.logica;

/**
 * Reservador utiliza un Bus, entregando un numero entero, eligiendo un asiento e indica que las caracteristicas del asiento
 */
public class Reservador {
    /**
     * Variable local que sirve de auxiliar para guardar el asiento que se reservara
     */
    private Asiento as;

    /**
     * Metodo constructor que crea un reservador encargado de reservar un asiento en especifico de un bus en especifico.
     * @param b Variable ingresada por parametro que indica el Bus en donde se reservara un asiento
     * @param numAsiento Variable que especifica cual numero de asiento se va a intentar reservar
     */
    public Reservador(Bus b, int numAsiento){
        as = null;
        Bus bus = b;
        as = bus.asSelec(numAsiento);
        if (as == null){
            this.infoAsiento();
        }
    }

    /**
     * Metodo que se encargar de entregar toda la informacion respecto al asiento seleccionado para la reserva
     * esto incluye el numero, tipo, posicion y el precio
     */
    public void infoAsiento(){
        System.out.println("\nSe ha reservado el asiento numero: "+as.getNumAsiento());
        System.out.println("El tipo de asiento es: "+as.getTipoAsiento());
        System.out.println("Está posicionado en: "+as.getPosicion());
        System.out.println("El valor del asiento es: $"+as.getPrecio()+"\n");;
    }
}