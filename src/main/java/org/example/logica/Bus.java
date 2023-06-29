package org.example.logica;

import org.example.excepciones.AsientoInvalidoException;
import org.example.excepciones.RecorridoIncorrectoException;
import org.example.excepciones.TipodeAsientoInvalidoException;

/**
 * Esta clase se encarga de crear Buses, con sus respectivos asientos dentro.
 */
public class Bus {
    private AsientosBus ab;
    protected AsientoFactory af;

    /**
     * Metodo constructor que se encarga de construir el Bus, con un recorrido como parametro y los asientos dentro, creados por una factory y guardados en un arraylist.
     * @param r Variable que especifica el recorrido del bus
     * @throws TipodeAsientoInvalidoException Si el tipo de asiento no existe en el Enum o es null, entrega el mensaje de error.
     * @throws AsientoInvalidoException Si el numero de asiento elegido no esta disponible o esta fuera de los limites del bus, entrega el mensaje de error.
     * @throws RecorridoIncorrectoException Si el recorrido no es valido o es null, entrega el mensaje de error.
     */
    public Bus(Recorridos r) throws TipodeAsientoInvalidoException, AsientoInvalidoException, RecorridoIncorrectoException {
        if (r==null){
            throw new RecorridoIncorrectoException("Recorrido null");
        }
        ab = new AsientosBus();
        af = new AsientoFactory();
        for (int i=0;i<5;i++){
            ab.addAsiento(af.obtenerAsiento(TipodeAsientos.PREMIUM,i));
        }
        for (int i=5;i<17;i++){
            ab.addAsiento(af.obtenerAsiento(TipodeAsientos.SALONCAMA,i));
        }
        for (int i=17;i<53;i++){
            ab.addAsiento(af.obtenerAsiento(TipodeAsientos.SEMICAMA,i));
        }
    }

    /**
     * Metodo que se encarga de seleccionar, si es posible, el asiento que se quiere reservar.
     * @param cualAs Parametro que indica el numero de asiento que se quiere seleccionar
     * @return Entrega el asiento que se solicito, si es que este existe y esta disponible
     */
    public Asiento asSelec(int cualAs){
        if (cualAs>52){
            try {
                throw new AsientoInvalidoException("Asiento invalido");
            } catch (AsientoInvalidoException e) {
                throw new RuntimeException(e);
            }
        }else {
            return ab.getAsiento(cualAs);
        }
    }
}
