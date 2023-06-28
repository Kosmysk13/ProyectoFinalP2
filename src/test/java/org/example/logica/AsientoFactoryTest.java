package org.example.logica;

import org.example.excepciones.TipodeAsientoInvalidoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsientoFactoryTest {
    private AsientoFactory af;

    @BeforeEach
    void setUp() {
        af = new AsientoFactory();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("NumerodeAsientoInvalido")
    void NumerodeAsientoInvalido() throws TipodeAsientoInvalidoException{
        System.out.println("Numero de Asiento Invalido");
        assertNull(af.obtenerAsiento(TipodeAsientos.SEMICAMA,54).getPosicion());
    }

    @Test
    void obtenerAsiento() throws TipodeAsientoInvalidoException {
        System.out.println("Tipo de Asiento Invalido");
        Exception exception = assertThrows(TipodeAsientoInvalidoException.class, ()->{
            af.obtenerAsiento(null,2);
        });

    }
}