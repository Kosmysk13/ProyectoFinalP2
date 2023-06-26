package org.example.logica;

public class AsientoFactory {
    public Asiento obtenerAsiento(TipodeAsientos tipodeasiento,int rec){
        return switch (tipodeasiento) {
            case SEMICAMA -> new AsientoSemiCama(1000+rec);
            case SALONCAMA -> new AsientoSalonCama(2000+rec);
            case PREMIUM -> new AsientoPremium(3000+rec);
        };
    }
}
