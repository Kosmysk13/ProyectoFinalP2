package org.example.logica;

import org.example.excepciones.AsientoInvalidoException;
import org.example.excepciones.RecorridoIncorrectoException;
import org.example.excepciones.TipodeAsientoInvalidoException;

public class Bus {
    private AsientosBus ab;
    private int recorrido;
    protected AsientoFactory af;
    public Bus(Recorridos r) throws TipodeAsientoInvalidoException, AsientoInvalidoException, RecorridoIncorrectoException {
        if (r==null){
            throw new RecorridoIncorrectoException("Recorrido null");
        }
        ab = new AsientosBus();
        switch (r.toString()){
            case "CHILLANCONCEPCION": recorrido=100;break;
            case "CHILLANLOS_ANGELES": recorrido=200;break;
            case "CONCEPCIONLOS_ANGELES": recorrido=300;break;
            case "CONCEPCIONCHILLAN": recorrido=400;break;
            case "LOS_ANGELESCONCEPCION": recorrido=500;break;
            case "LOS_ANGELESCHILLAN": recorrido=600;break;
        }
        af = new AsientoFactory();
        for (int i=0;i<5;i++){
            ab.addAsiento(af.obtenerAsiento(TipodeAsientos.PREMIUM,i));
        }
        for (int i=5;i<17;i++){
            ab.addAsiento(af.obtenerAsiento(TipodeAsientos.SALONCAMA,i));
        }
        for (int i=17;i<53;i++){
            ab.addAsiento(af.obtenerAsiento(TipodeAsientos.SEMICAMA,i));
        }
    }
    public Asiento asSelec(int cualAs){
        if (cualAs>52){
            try {
                throw new AsientoInvalidoException("Asiento invalido");
            } catch (AsientoInvalidoException e) {
                throw new RuntimeException(e);
            }
        }else {
            return ab.getAsiento(cualAs);
        }
    }
}
