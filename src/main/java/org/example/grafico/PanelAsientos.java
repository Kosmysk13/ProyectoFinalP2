package org.example.grafico;

import javax.swing.*;
import java.awt.*;
/**
 * Se encarga de crear el panel asientos, con su metodo paint.
 */
public class PanelAsientos extends JPanel{
    private JPanel panelA;

    /**
     * Metodo constructor que crea un sub panel en su interior.
     */
    public PanelAsientos(){
        panelA = new JPanel();
        panelA.setBounds(500,224, 700, 50);
        panelA.setBackground(new Color(99, 132, 180));
        panelA.setVisible(true);
    }
    /**
     * Metodo paint que dibuja el panel visualmente.
     * @param g  the <code>Graphics</code> context in which to paint
     */
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
