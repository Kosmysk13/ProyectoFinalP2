package org.example.excepciones;
/**
 * Excepcion que se lanzara en caso de que el asiento de un metodo no sea valido.
 */
public class AsientoInvalidoException extends Exception{
    /**
     * Metodo constructor que se encarga de enviar el mensaje de la excepcion
     * @param errorMensaje Parametro tipo String que se entregara a la hora de lanzarse la excepcion
     */
    public AsientoInvalidoException (String errorMensaje){
        super(errorMensaje);
    }
}
