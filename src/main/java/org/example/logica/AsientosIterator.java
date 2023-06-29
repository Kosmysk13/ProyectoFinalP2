package org.example.logica;

import java.util.Iterator;

/**
 * Se encarga de recorrer un array de Asientos.
 */
public class AsientosIterator implements Iterator<Asiento> {
    AsientosBus asB;
    private int aux;

    /**
     * Metodo que se encarga de revisar si es que existe una variable disponible despues de la ultima revision
     * @return Entrega un boolean para afirmar o negar si es que hay un siguiente.
     */
    @Override
    public boolean hasNext() {
        return aux < 53;
    }

    /**
     * Metodo que se encarga de avanzar de posicion en su revision del array
     * @return Entrega un asiento de la siguiente posicion
     */
    @Override
    public Asiento next() {
        asB = new AsientosBus();
        Asiento asiento = asB.getAsiento(aux);
        aux++;
        return asiento;
    }

    /**
     * Metodo que se encarga de iterar y crear instancias de si mismo.
     * @return una instancia recursiva de si mismo.
     */
    public Iterator<Asiento> iterator() {
        return new AsientosIterator();
    }
}

