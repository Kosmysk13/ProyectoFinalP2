package org.example.logica;

import org.example.excepciones.AsientoInvalidoException;
import org.example.excepciones.RecorridoIncorrectoException;
import org.example.excepciones.TipodeAsientoInvalidoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {
    private Bus bus1,bus2;
    @BeforeEach
    void setUp() {
        try {
            bus1 = new Bus(Recorridos.CONCEPCIONCHILLAN);
        } catch (TipodeAsientoInvalidoException | AsientoInvalidoException | RecorridoIncorrectoException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @DisplayName("Test Recorrido null")
    public void testCrearBusSinRecorrido() throws RecorridoIncorrectoException{
        System.out.println("BusSinRecorrido");
        Exception exception = assertThrows(RecorridoIncorrectoException.class, ()->{
            bus2 = new Bus(null);
        });
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Seleccion Asiento Numero Incorrecto")
    void asSelecSinNumero(){
        System.out.println("Asiento con Numero incorrecto");
        Exception exception = assertThrows(RuntimeException.class, ()->{
            bus1.asSelec(60);
        });
    }
}