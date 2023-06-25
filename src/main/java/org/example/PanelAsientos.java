package org.example;

import javax.swing.*;
import java.awt.*;

public class PanelAsientos extends JPanel{
    public PanelAsientos(){
        this.setPreferredSize(new Dimension(700,500));
    }
    public void paint (Graphics g){
        super.paint(g);
        //g.setColor(Color.white);
        //g.fillRect(500,349, 700, 375);                               //Panel Asientos
        g.setColor(Color.black);
        g.drawRect(500,224, 700, 500);                               //Panel asientos Borde
        g.drawLine(500,274,1200,274);
    }
}
