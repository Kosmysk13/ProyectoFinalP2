package org.example.logica;

import java.util.Iterator;

public class AsientosIterator implements Iterator<Asiento> {
    AsientosBus asB;
    private int aux;
    @Override
    public boolean hasNext() {
        return aux < 53;
    }

    @Override
    public Asiento next() {
        asB = new AsientosBus();
        Asiento asiento = asB.getAsiento(aux);
        aux++;
        return asiento;
    }

    public Iterator<Asiento> iterator() {
        return new AsientosIterator();
    }
}

