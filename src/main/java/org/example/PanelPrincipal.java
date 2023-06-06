package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * Crea el panel que contendra al panel comprador y panel expendedor en su interior, se encarga de juntar ambos
 * paneles para mostrarse en uno solo para la Ventana
 */
public class PanelPrincipal extends JPanel {

    /**
     * Metodo constructor que crea instancias del panel comprador y panel expendedor
     * Ademas define los limites del panel
     */
    public PanelPrincipal(){
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(188,227,255));
        this.setVisible(true);
    }

    /**
     * Metodo que se encarga de la parte visual del panel
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void paint (Graphics g){
        super.paint(g);
        g.setColor(Color.white);
        g.fillRect(500,324, 700, 600);                               //Expendedor
        g.setColor(Color.black);
        g.drawRect(500,324, 700, 600);                               //Expendedor
    }
}
