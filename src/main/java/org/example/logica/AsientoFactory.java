package org.example.logica;

public class AsientoFactory {
    public Asiento obtenerAsiento(TipodeAsientos tipodeasiento,int rec){
        return switch (tipodeasiento) {
            case SEMICAMA -> new AsientoSemiCama(rec);
            case SALONCAMA -> new AsientoSalonCama(rec);
            case PREMIUM -> new AsientoPremium(rec);
        };
    }
}
