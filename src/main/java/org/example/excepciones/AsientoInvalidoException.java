package org.example.excepciones;

public class AsientoInvalidoException extends Exception{
    public AsientoInvalidoException (String errorMensaje){
        super(errorMensaje);
    }
}
