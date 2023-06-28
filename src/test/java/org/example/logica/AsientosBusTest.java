package org.example.logica;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AsientosBusTest {
    private AsientosBus asBus;
    ArrayList<Asiento> arrAs = new ArrayList<Asiento>();
    @BeforeEach
    void setUp() {
        asBus = new AsientosBus();
    }
    @Test
    @DisplayName("Test Agrega un Asiento")
    void addAsiento() {
        Asiento as1 = new AsientoPremium(3);
        asBus.addAsiento(as1);
    }
    @Test
    @DisplayName("Test Agrega tres Asiento")
    void addTresAsientos() {
        for (int i=0;i<3;i++){
            Asiento as1 = new AsientoPremium(i);
            asBus.addAsiento(as1);
        }
    }
    @Test
    @DisplayName("Test Se Eligen Dos Asientos")
    void getDosAsientos(){
        Asiento as1 = new AsientoPremium(0);
        asBus.addAsiento(as1);
        Asiento as2 = new AsientoPremium(1);
        asBus.addAsiento(as2);
        Asiento as3 = new AsientoPremium(2);
        asBus.addAsiento(as3);
        assertNotNull(asBus.getAsiento(0));
        assertNotNull(asBus.getAsiento(1));
    }
}