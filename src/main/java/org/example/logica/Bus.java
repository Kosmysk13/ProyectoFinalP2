package org.example.logica;

public class Bus {
    private AsientosBus ab;
    private int recorrido;
    private AsientoFactory af;
    public Bus(String rec){
        ab = new AsientosBus();
        switch (rec){
            case "CHILLANCONCEPCION": recorrido=100;break;
            case "CHILLANLOS_ANGELES": recorrido=200;break;
            case "CONCEPCIONLOS_ANGELES": recorrido=300;break;
            case "CONCEPCIONCHILLAN": recorrido=400;break;
            case "LOS_ANGELESCONCEPCION": recorrido=500;break;
            case "LOS_ANGELESCHILLAN": recorrido=600;break;
        }
        af = new AsientoFactory();
        for (int i=0;i<5;i++){
            ab.addAsiento(af.obtenerAsiento(TipodeAsientos.PREMIUM,recorrido+i));
        }
        for (int i=5;i<17;i++){
            ab.addAsiento(af.obtenerAsiento(TipodeAsientos.SALONCAMA,recorrido+i));
        }
        for (int i=17;i<53;i++){
            ab.addAsiento(af.obtenerAsiento(TipodeAsientos.SEMICAMA,recorrido+i));
        }
    }
    public Asiento asSelec(int cualAs){
        return ab.getAsiento(cualAs);
    }
}
