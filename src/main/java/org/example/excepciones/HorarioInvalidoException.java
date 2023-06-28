package org.example.excepciones;

public class HorarioInvalidoException extends Exception{
    public HorarioInvalidoException(String errorMensaje){
        super(errorMensaje);
    }
}
