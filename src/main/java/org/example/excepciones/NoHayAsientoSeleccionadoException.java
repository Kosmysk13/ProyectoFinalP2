package org.example.excepciones;

public class NoHayAsientoSeleccionadoException extends Exception{
    public NoHayAsientoSeleccionadoException(String errorMensaje){
        super(errorMensaje);
    }
}
