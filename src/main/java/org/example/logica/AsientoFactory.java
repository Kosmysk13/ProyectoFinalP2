package org.example.logica;

import org.example.excepciones.TipodeAsientoInvalidoException;

public class AsientoFactory {
    public Asiento obtenerAsiento(TipodeAsientos tipodeasiento,int rec) throws TipodeAsientoInvalidoException {
        if (tipodeasiento==null){
            throw new TipodeAsientoInvalidoException("El tipo de asiento es invalido");
        }else{
            return switch (tipodeasiento) {
                case SEMICAMA -> new AsientoSemiCama(rec);
                case SALONCAMA -> new AsientoSalonCama(rec);
                case PREMIUM -> new AsientoPremium(rec);
            };
        }


    }
}
