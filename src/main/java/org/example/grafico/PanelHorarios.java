package org.example.grafico;

import javax.swing.*;
import java.awt.*;

/**
 * Se encarga de crear el panel horarios, con su metodo paint.
 */
public class PanelHorarios extends JPanel {
    /**
     * Metodo constructor vacio de la clase.
     */
    public PanelHorarios(){
    }

    /**
     * Metodo paint que dibuja el panel visualmente.
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void paint (Graphics g){
        super.paint(g);
        g.setColor(new Color(99, 132, 180));
        g.fillRect(50,224, 300, 50);
        g.setColor(Color.black);
        g.drawString("Horarios",175,254);
        g.drawRect(50,224, 300, 500);
        g.drawLine(50,274,350,274);
    }
}