package org.example.logica;

import org.example.excepciones.TipodeAsientoInvalidoException;

/**
 * Clase del patron Factory Method, que se encarga de la creacion masiva de diferentes tipos de asientos para un bus.
 */
public class AsientoFactory {
    /**
     * Metodo que se encarga de entregar una instancia del asiento creado.
     * @param tipodeasiento parametro que determina el tipo de asiento que se creara.
     * @param numAs parametro que indica el numero de asiento mediante un numero entero.
     * @return Retorna una instancia del asiento creado.
     * @throws TipodeAsientoInvalidoException Si el tipo de asiento ingresado como parametro no es valido, se entrega el mensaje de error.
     */
    public Asiento obtenerAsiento(TipodeAsientos tipodeasiento,int numAs) throws TipodeAsientoInvalidoException {
        if (tipodeasiento==null){
            throw new TipodeAsientoInvalidoException("El tipo de asiento es invalido");
        }else{
            return switch (tipodeasiento) {
                case SEMICAMA -> new AsientoSemiCama(numAs);
                case SALONCAMA -> new AsientoSalonCama(numAs);
                case PREMIUM -> new AsientoPremium(numAs);
            };
        }
    }
}
