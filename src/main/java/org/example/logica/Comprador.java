package org.example.logica;

/**
 * Comprador utiliza el expendedor, entregando una moneda, eligiendo producto, quizas monedas como vuelto e indica que consumio
 */
public class Comprador{
    private String info=null;
    private Asiento as;

    /**
     *
     * @param
     * @throws
     */
    public Comprador (Bus b, int numAsiento) throws Exception{
        as = null;
        Bus bus = b;
        as = bus.asSelec(numAsiento);
        if (as == null){
            this.infoAsiento();
        }
    }

    /**
     * @return retorna la cantidad total del vuelto que se recibe, si es que es el caso
     */
    public void infoAsiento(){
        System.out.println("\nSe ha reservado el asiento numero: "+as.getNumAsiento());
        System.out.println("El tipo de asiento es: "+as.getTipoAsiento());
        System.out.println("Está posicionado en: "+as.getPosicion());
        System.out.println("El valor del asiento es: $"+as.getPrecio()+"\n");;
    }
}