package org.example.excepciones;
/**
 * Excepcion que se lanzara en caso de que el recorrido utilizado en un metodo no sea valido.
 */
public class RecorridoIncorrectoException extends Exception{
    /**
     * Metodo constructor que se encarga de enviar el mensaje de la excepcion
     * @param errorMensaje Parametro tipo String que se entregara a la hora de lanzarse la excepcion
     */
    public RecorridoIncorrectoException(String errorMensaje){
        super(errorMensaje);
    }
}
