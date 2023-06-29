package org.example.excepciones;
/**
 * Excepcion que se lanzara en caso de que el asiento asiento que se intenta seleccionar este ocupado.
 */
public class AsientoOcupadoException extends Exception{
    /**
     * Metodo constructor que se encarga de enviar el mensaje de la excepcion
     * @param errorMensaje Parametro tipo String que se entregara a la hora de lanzarse la excepcion
     */
    public AsientoOcupadoException(String errorMensaje){
        super(errorMensaje);
    }
}
