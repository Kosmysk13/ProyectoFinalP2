package org.example;

import javax.swing.*;
import java.awt.*;

public class PanelHorarios extends JPanel {
    public PanelHorarios(){
        this.setPreferredSize(new Dimension(400,400));
    }
    public void paint (Graphics g){
        super.paint(g);
        g.setColor(Color.black);
        g.drawRect(50,224, 300, 500);                               //Panel Horarios Borde
        g.drawLine(50,274,350,274);
    }
}