package org.example.excepciones;
/**
 * Excepcion que se lanzara en caso de que el horario no haya sido seleccionado o no sea valido.
 */
public class HorarioInvalidoException extends Exception{
    /**
     * Metodo constructor que se encarga de enviar el mensaje de la excepcion
     * @param errorMensaje Parametro tipo String que se entregara a la hora de lanzarse la excepcion
     */
    public HorarioInvalidoException(String errorMensaje){
        super(errorMensaje);
    }
}
