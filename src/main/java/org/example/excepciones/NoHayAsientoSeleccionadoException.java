package org.example.excepciones;
/**
 * Excepcion que se lanzara en caso de que no hayan asientos seleccionados a la hora de reservar.
 */
public class NoHayAsientoSeleccionadoException extends Exception{
    /**
     * Metodo constructor que se encarga de enviar el mensaje de la excepcion
     * @param errorMensaje Parametro tipo String que se entregara a la hora de lanzarse la excepcion
     */
    public NoHayAsientoSeleccionadoException(String errorMensaje){
        super(errorMensaje);
    }
}
