package org.example.logica;

import org.example.excepciones.AsientoInvalidoException;
import org.example.excepciones.AsientoOcupadoException;
import org.example.excepciones.RecorridoIncorrectoException;
import org.example.excepciones.TipodeAsientoInvalidoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservadorTest {
    private Reservador res,res2;
    private Bus bus;

    @BeforeEach
    void setUp(){
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void infoAsiento() {
    }

    @Test
    @DisplayName("Reserva un asiento")
    public void ReservaunAsiento() throws Exception {
        System.out.println("UnaReserva");
        bus = new Bus(Recorridos.CONCEPCIONCHILLAN);
        res=new Reservador(bus,2);
    }
    @Test
    @DisplayName("Reserva tres asientos")
    public void ReservatresAsientos() throws Exception {
        System.out.println("TresReservas");
        bus = new Bus(Recorridos.CONCEPCIONCHILLAN);
        assertNotNull(res=new Reservador(bus,2));
        assertNotNull(res=new Reservador(bus,3));
        assertNotNull(res=new Reservador(bus,4));
    }
}