package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * Crea la ventana que va a ver el Cliente, contiene el panel principal
 */
public class Ventana extends JFrame{
    private PanelPrincipal dp;

    /**
     * Metodo constructor que se encarga de instanciar el panel principal, definir los bordes y acciones basicas
     */
    public Ventana(){
        super("Sistema de reserva de asientos");
        this.setLayout(new BorderLayout());
        dp = new PanelPrincipal();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(dp);
        this.setSize(1280,1024);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}