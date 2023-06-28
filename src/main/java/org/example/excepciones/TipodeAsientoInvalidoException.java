package org.example.excepciones;

public class TipodeAsientoInvalidoException extends Exception{
    public TipodeAsientoInvalidoException(String errorMensaje){
        super(errorMensaje);
    }
}
