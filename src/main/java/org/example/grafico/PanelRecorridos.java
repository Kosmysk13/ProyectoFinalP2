package org.example.grafico;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que contiene el paint que dibuja a este mismo.
 */
public class PanelRecorridos extends JPanel {
    /**
     * Metodo constructor vacio de la clase
     */
    public PanelRecorridos(){
    }

    /**
     * Metodo paint que se encarga de dibujar graficamente el panel
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void paint (Graphics g){
        super.paint(g);
        g.setColor(Color.black);
        g.drawRect(50,25, 1150, 150);
        g.drawString("Origen",130,60);
        g.drawString("Destino",580,60);
    }
}