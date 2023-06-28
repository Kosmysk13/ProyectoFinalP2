package org.example.grafico;

import javax.swing.*;
import java.awt.*;

public class PanelHorarios extends JPanel {
    public PanelHorarios(){
    }
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