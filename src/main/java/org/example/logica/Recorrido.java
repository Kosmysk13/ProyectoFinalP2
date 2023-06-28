package org.example.logica;

public class Recorrido {
    private String recorrido;
    private Recorridos r;
    public Recorrido(Recorridos rec1, Recorridos rec2){
        recorrido = rec1.toString()+rec2.toString();
    }
    public Recorridos getRecorrido(){
        switch (recorrido){
            case "CHILLANCONCEPCION": r = Recorridos.CHILLANCONCEPCION;break;
            case "CHILLANLOS_ANGELES": r = Recorridos.CHILLANLOS_ANGELES;break;
            case "CONCEPCIONLOS_ANGELES": r = Recorridos.CONCEPCIONLOS_ANGELES;break;
            case "CONCEPCIONCHILLAN": r = Recorridos.CONCEPCIONCHILLAN;break;
            case "LOS_ANGELESCONCEPCION": r = Recorridos.LOS_ANGELESCONCEPCION;break;
            case "LOS_ANGELESCHILLAN": r = Recorridos.LOS_ANGELESCHILLAN;break;
        }
        return r;
    }
}
