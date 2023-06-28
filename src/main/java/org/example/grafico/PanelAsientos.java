package org.example.grafico;

import javax.swing.*;
import java.awt.*;

public class PanelAsientos extends JPanel{
    private JPanel panelA;
    public PanelAsientos(){
        panelA = new JPanel();
        panelA.setBounds(500,224, 700, 50);
        panelA.setBackground(new Color(99, 132, 180));
        panelA.setVisible(true);
    }
    public void paint (Graphics g){
        super.paint(g);
        g.setColor(new Color(99, 132, 180));
        g.fillRect(500,224, 700, 50);
        g.setColor(Color.black);
        g.drawString("Asientos",800,254);
        g.drawRect(500,224, 700, 500);
        g.drawLine(500,274,1200,274);
    }
}
