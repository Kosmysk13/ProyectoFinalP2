package org.example.logica;

public interface Asiento{
    public String getPosicion();
    public int getNumAsiento();
    public String getTipoAsiento();
    public void setDisponibilidad(boolean aux);
    public String getDisponibilidad();
    public int getPrecio();
}