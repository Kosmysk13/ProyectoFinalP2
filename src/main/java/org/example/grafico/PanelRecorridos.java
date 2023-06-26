package org.example.grafico;

import javax.swing.*;
import java.awt.*;

public class PanelRecorridos extends JPanel {
    public PanelRecorridos(){
        this.setPreferredSize(new Dimension(400,400));
    }
    public void paint (Graphics g){
        super.paint(g);
        g.setColor(Color.black);
        g.drawRect(50,25, 1150, 150);                               //Panel Recorrido Borde
        g.drawString("Origen",130,60);
        g.drawString("Destino",580,60);
    }
}